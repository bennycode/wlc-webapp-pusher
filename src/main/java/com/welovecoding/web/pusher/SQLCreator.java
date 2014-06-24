/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.welovecoding.web.pusher;

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
public class SQLCreator<T> {

	private static final Logger LOG = Logger.getLogger(SQLCreator.class.getName());

	private final int SPLIT_BY_LINE = 400;
	private final Class<T> entityClass;
	private List<Field> fields;

	public SQLCreator(Class<T> entityClass) {
		this.entityClass = entityClass;
		this.fields = getAllFieldsOfClass(entityClass);
	}

	public String parseObjectToSQL(List<? extends T> objects, String... values) throws NoSuchMethodException {
		Header<T> header = new Header(entityClass, values);
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
		StringBuilder sql = new StringBuilder();
		sql.append(header.toString());
		for (int i = 0; i < objects.size(); i++) {
			T object = objects.get(i);
			sql.append("(");
			for (int j = 0; j < values.length; j++) {
				String value = values[j];
				Object returnVal = null;
				if (value.contains("_ID")) {
					// is a reference
					for (Field field : fields) {
						if (field.getName().equalsIgnoreCase(value.replaceAll("_ID", ""))) {
							returnVal = invokeGetter(object, field);
							if (returnVal instanceof BaseEntity) {
								returnVal = ((BaseEntity) returnVal).getId();
							}
						}
					}
				} else {
					// is a value
					for (Field field : fields) {
						if (field.getName().equalsIgnoreCase(value)) {

							returnVal = invokeGetter(object, field);
						}
					}
				}

				if (returnVal instanceof String) {
					sql.append("'").append(returnVal).append("'");
				} else if (returnVal instanceof Date) {
					sql.append("'").append(sdf.format(returnVal)).append("'");
				} else if (returnVal instanceof Enum) {

					sql.append("'").append(((Enum) returnVal).name()).append("'");
				} else {
					sql.append(returnVal);
				}
				if ((j + 1) < values.length) {
					sql.append(", ");
				}
			}
			sql.append(")");
			if (i != 0 && i % SPLIT_BY_LINE == 0) {
				sql.append(";\n");
				sql.append(header.toString());
			} else {
				if ((i + 1) < objects.size()) {
					sql.append(",\n");
				}
			}

		}
		sql.append(";\n");
		return sql.toString();
	}

	private boolean checkGetterPresent(Class<?> clazz, Field field) {
		Class<?>[] emptyParamObjects = new Class<?>[]{};
		boolean isPresent = false;
		try {
			clazz.getDeclaredMethod("get" + StringUtils.capitalize(field.getName()), emptyParamObjects);
			isPresent = true;
		} catch (NoSuchMethodException ex) {
			try {
				clazz.getDeclaredMethod("is" + StringUtils.capitalize(field.getName()), emptyParamObjects);
				isPresent = true;
			} catch (NoSuchMethodException ex2) {
				// NO-OP ignore the field
			}
		}

		return isPresent;
	}

	private Object invokeGetter(Object invokeInObject, Field field) throws NoSuchMethodException {
		LOG.log(Level.FINEST, "Invoking getter for field ''{0}''", new Object[]{field.getName()});
		Class<?>[] emptyParamObjects = new Class<?>[]{};
		Method getter = null;
		Object returnVal = null;
		Class<?> actualClazz = invokeInObject.getClass();

		while (actualClazz != null && getter == null) {
			try {
				getter = actualClazz.getDeclaredMethod("get" + StringUtils.capitalize(field.getName()), emptyParamObjects);
			} catch (NoSuchMethodException | SecurityException ex) {
				try {
					getter = actualClazz.getDeclaredMethod("is" + StringUtils.capitalize(field.getName()), emptyParamObjects);
				} catch (NoSuchMethodException | SecurityException ex1) {
				}
			}

			actualClazz = actualClazz.getSuperclass();
		}
		if (getter != null) {
			try {
				returnVal = getter.invoke(invokeInObject, emptyParamObjects);
			} catch (IllegalAccessException | IllegalArgumentException | ClassCastException | InvocationTargetException ex) {
				LOG.log(Level.SEVERE, null, ex);
			}
		} else {
			throw new NoSuchMethodException("No such method found!");
		}
		return returnVal;
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

	public class Header<T> {

		private Class<T> entityClass;
		private List<String> values = new LinkedList<>();

		public Header(Class<T> entityClass, String... values) {
			this.values = Arrays.asList(values);
			this.entityClass = entityClass;
		}

		public List<String> getValues() {
			return values;
		}

		public void setValues(List<String> values) {
			this.values = values;
		}

		@Override
		public String toString() {
			StringBuilder header = new StringBuilder("INSERT INTO `" + entityClass.getSimpleName().toUpperCase() + "` ");
			header.append("(");
			for (int i = 0; i < values.size(); i++) {
				String value = values.get(i);
				header.append('`');
				header.append(value);
				header.append('`');
				if ((i + 1) < values.size()) {
					header.append(", ");
				}

			}
			header.append(") VALUES\n");
			return header.toString();
		}

	}

}
