/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.welovecoding.web.pusher;

import com.foundationdb.sql.StandardException;
import com.foundationdb.sql.parser.*;
import com.welovecoding.web.pusher.domain.BaseEntity;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Michael Koppen
 */
public class ObjectVisitor<T> implements Visitor {

	private static final Logger LOG = Logger.getLogger(ObjectVisitor.class.getName());

	private List<String> attributes = new LinkedList<>();
	private List<Object> values = new LinkedList<>();
	private Class<T> entityClass;

	public ObjectVisitor(Class<T> entityClass, List<String> attributes) {
		this.entityClass = entityClass;
		this.attributes = attributes;
	}

	@Override
	public Visitable visit(Visitable vstbl) throws StandardException {
		QueryTreeNode node = (QueryTreeNode) vstbl;

		if (node instanceof ConstantNode) {
			values.add(((ConstantNode) node).getValue());
		}
		if (node instanceof CurrentDatetimeOperatorNode) {
			values.add(new Date());
		}

		return vstbl;
	}

	private Map<String, Object> mapAttributesAndValues() {
		Map<String, Object> map = new HashMap<>();
		for (int i = 0; i < attributes.size(); i++) {
			String attribute = attributes.get(i);
			Object value = null;
			if (values.size() > i) {
				value = values.get(i);
				map.put(attribute, value);
			}

		}
		return map;
	}

	public T getObject() throws IllegalAccessException, InstantiationException {
		T object = entityClass.newInstance();
		if (values.isEmpty()) {
			return null;
		}
		Map<String, Object> sqlAttributes = mapAttributesAndValues();
		List<Field> objectFields = getAllFieldsOfClass(entityClass);

		for (Map.Entry<String, Object> sqlEntry : sqlAttributes.entrySet()) {
			boolean match = false;
			String attribute = sqlEntry.getKey();
			Object value = sqlEntry.getValue();
			for (Field field : objectFields) {
				// remove '_ID'
				attribute = attribute.replaceAll("_ID", "");
				if (attribute.equalsIgnoreCase(field.getName())) {
					match = true;
					if (isJavaLang(field.getType())) {
						LOG.log(Level.FINEST, "Field isJavaLang");
						try {
							invokeSetter(object, field, value, field.getType());
						} catch (NoSuchMethodException ex) {
							LOG.log(Level.SEVERE, "No Setter found for attribute ''{0}'' with paramType ''{1}''", new Object[]{attribute, field.getType()});
						}
					} else if (isDomainType(field.getType()) && value != null) {
						LOG.log(Level.FINEST, "Field isDomainType");
						if (field.getType().isEnum()) {
							LOG.log(Level.FINEST, "### GOT ENUM OF TYPE: {0}", field.getType());
							for (Field aEnum : field.getType().getDeclaredFields()) {
								LOG.log(Level.FINEST, "########### Field: {0}", aEnum.getName());
								LOG.log(Level.FINEST, "########### Value: {0}", value);
								if (aEnum.getName().equalsIgnoreCase(value.toString())) {
									aEnum.setAccessible(true);
									Object y = aEnum.get(value);
									try {
										invokeSetter(object, field, y, field.getType());
									} catch (NoSuchMethodException ex) {
										LOG.log(Level.SEVERE, "No Setter found for attribute ''{0}'' with paramType ''{1}''", new Object[]{attribute, field.getType()});
									}
									break;
								}
							}
						} else {
							try {
								BaseEntity domainField = null;
								Object tempField = field.getType().newInstance();
								if (tempField instanceof BaseEntity) {
									domainField = (BaseEntity) tempField;
									domainField.setId(Long.parseLong(value.toString()));
									invokeSetter(object, field, domainField, domainField.getClass());
								} else {
									LOG.log(Level.SEVERE, "Cannot instantiate DomainType!");
								}
							} catch (NoSuchMethodException ex) {
								LOG.log(Level.SEVERE, "No Setter found for attribute ''{0}'' with paramType ''{1}''", new Object[]{attribute, field.getType()});
							} catch (InstantiationException ex) {
								Logger.getLogger(ObjectVisitor.class.getName()).log(Level.SEVERE, null, ex);
							}
						}

					}
					break;
				}
			}
			if (!match) {
				LOG.log(Level.SEVERE, "No matching attribute in object found for ''{0}''", attribute);
			}
		}

		return object;
	}

	private List<Field> getAllFieldsOfClass(Class<?> clazz) {
		List<Field> fields = new ArrayList<>();
		Class<?> actualClazz = clazz;

		while (actualClazz != null) {
			fields.addAll(Arrays.asList(actualClazz.getDeclaredFields()));
			actualClazz = actualClazz.getSuperclass();
		}
		return fields;
	}

	private void invokeSetter(Object invokeInObject, Field field, Object val, Class<?> paramType) throws NoSuchMethodException {
		LOG.log(Level.FINEST, "Invoking setter for field ''{0}'' with value ''{1}''", new Object[]{field.getName(), val});
		Method setter = null;
		Class<?> actualClazz = invokeInObject.getClass();

		while (actualClazz != null && setter == null) {
			try {
				setter = actualClazz.getDeclaredMethod("set" + StringUtils.capitalize(field.getName()), new Class<?>[]{paramType});
			} catch (NoSuchMethodException | SecurityException ex) {
			}

			actualClazz = actualClazz.getSuperclass();
		}
		if (setter != null) {
			try {
				// Caster
				Object castedVal = null;
				if (val != null) {
					castedVal = optimisticCast(val.getClass(), paramType, val);
				}

				setter.invoke(invokeInObject, new Object[]{castedVal});
			} catch (IllegalAccessException | IllegalArgumentException | ClassCastException | InvocationTargetException ex) {
				LOG.log(Level.SEVERE, null, ex);
			} catch (java.text.ParseException ex) {
				Logger.getLogger(ObjectVisitor.class.getName()).log(Level.SEVERE, null, ex);
			}
		} else {
			throw new NoSuchMethodException("No such method found!");
		}

	}

	private Object optimisticCast(Class<?> from, Class<?> to, Object val) throws java.text.ParseException {
		Object castedObject = val;
		if (isJavaLang(from) && isJavaLang(to) && val != null) {
			LOG.log(Level.FINEST, "TO Conancical Name: {0}", to.getCanonicalName());
			LOG.log(Level.FINEST, "FROM Conancical Name: {0}", from.getCanonicalName());
			switch (to.getCanonicalName()) {
				case "java.util.Date":
					SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
					switch (from.getCanonicalName()) {
						case "java.lang.String":
							castedObject = sdf.parse(val.toString());
							break;
					}
					break;
				case "java.lang.Long":
					switch (from.getCanonicalName()) {
						case "java.lang.Integer":
							castedObject = new Long(val.toString());
							break;
					}
					break;
				case "boolean":
					switch (from.getCanonicalName()) {
						case "java.lang.Boolean":
							System.out.println("### " + val.toString());
							castedObject = Boolean.parseBoolean(val.toString());
							break;
						case "java.lang.Integer":
							if (((Integer) val) >= 1) {
								castedObject = Boolean.parseBoolean("true");
							} else {
								castedObject = Boolean.parseBoolean("false");
							}
							break;
					}
					break;
				default:
					castedObject = to.cast(castedObject);
			}
		}
		return castedObject;
	}

	private boolean isJavaLang(Class<?> type) {
		if (type.isPrimitive()) {
			return true;
		} else {
			return type.getPackage().getName().startsWith("java.");
		}
	}

	/**
	 * TODO: Display dropdown with all possible values from the domain type. TODO: Instead string comparision of package
	 * name, we should check if the type is an extension of "BaseEntity"
	 * <p>
	 * @param type <p>
	 * @return
	 */
	private boolean isDomainType(Class<?> type) {
		String itemPackage = type.getPackage().getName();
		//TODO HERES THE BUG...THE ENTITIES ARE NO LONGER IN THE SAME PACKAGE AS THE BASEENTITY!!!
		// Quickfix: Assume that all entities with e.g. com.welovecoding are entities of the project (call me if u have a better and easier idea ;P)
		String[] packages = BaseEntity.class.getPackage().getName().split("\\.");
		String domainPackage = packages[0] + "." + packages[1];

		return itemPackage.startsWith(domainPackage);
	}

	public List<String> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<String> attributes) {
		this.attributes = attributes;
	}

	public List<Object> getValues() {
		return values;
	}

	public void setValues(List<Object> values) {
		this.values = values;
	}

	@Override
	public boolean visitChildrenFirst(Visitable vstbl) {
		return false;
	}

	@Override
	public boolean stopTraversal() {
		return false;
	}

	@Override
	public boolean skipChildren(Visitable vstbl) throws StandardException {
		return false;
	}

}
