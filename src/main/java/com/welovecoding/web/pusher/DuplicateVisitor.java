/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.welovecoding.web.pusher;

import com.foundationdb.sql.StandardException;
import com.foundationdb.sql.parser.*;

/**
 *
 * @author MacYser
 */
public class DuplicateVisitor implements Visitor {

	private String unique;

	@Override
	public Visitable visit(Visitable vstbl) throws StandardException {
		QueryTreeNode node = (QueryTreeNode) vstbl;
		unique = calculateUnique(node);
		return vstbl;
	}

	private String calculateUnique(QueryTreeNode node) {
		String temp = unique + "" + node.getClass().getCanonicalName() + "" + node.toString();
		return temp.hashCode() + "";
	}

	public String getUnique() {
		return unique;
	}

	public void setUnique(String unique) {
		this.unique = unique;
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
