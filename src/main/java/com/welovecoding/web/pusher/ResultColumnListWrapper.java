/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.welovecoding.web.pusher;

import com.foundationdb.sql.StandardException;
import com.foundationdb.sql.parser.ResultColumnList;
import java.util.Objects;

/**
 *
 * @author Michael Koppen
 */
public class ResultColumnListWrapper {

	private final String unique;
	private final ResultColumnList rcl;

	public ResultColumnListWrapper(ResultColumnList rcl) throws StandardException {
		this.rcl = rcl;
		DuplicateVisitor duplicateVisitor = new DuplicateVisitor();
		rcl.accept(duplicateVisitor);
		this.unique = duplicateVisitor.getUnique();
	}

	public ResultColumnList getResultColumnList() {
		return rcl;
	}

	@Override
	public int hashCode() {
		int hash = 3;
		hash = 23 * hash + Objects.hashCode(this.unique);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final ResultColumnListWrapper other = (ResultColumnListWrapper) obj;
		if (!Objects.equals(this.unique, other.unique)) {
			return false;
		}
		return true;
	}

}
