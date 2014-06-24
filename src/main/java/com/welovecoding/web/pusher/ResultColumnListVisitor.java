/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.welovecoding.web.pusher;

import com.foundationdb.sql.StandardException;
import com.foundationdb.sql.parser.*;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author MacYser
 */
public class ResultColumnListVisitor implements Visitor {

	private List<ResultColumnList> resultColumnList = new LinkedList<>();
	private List<String> attributes = new LinkedList<>();

	@Override
	public Visitable visit(Visitable vstbl) throws StandardException {
		QueryTreeNode node = (QueryTreeNode) vstbl;

		if (node instanceof ResultColumnList) {
			resultColumnList.add(((ResultColumnList) node));
		}
		if (node instanceof ColumnReference) {
			attributes.add(((ColumnReference) node).getColumnName());
		}

		return vstbl;
	}

	public List<ResultColumnList> getResultColumnList() {
		return resultColumnList;
	}

	public void setResultColumnList(List<ResultColumnList> resultColumnList) {
		this.resultColumnList = resultColumnList;
	}

	public List<String> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<String> attributes) {
		this.attributes = attributes;
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
