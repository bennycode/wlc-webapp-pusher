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
public class QueryVisitor implements Visitor {

	private boolean onFirst = true;
	private boolean didPrint = false;
	private int stage = 0;

	private static String qualify(String s) {
		return (s != null) ? s + "." : "";
	}

	@Override
	public Visitable visit(Visitable vstbl) throws StandardException {
		QueryTreeNode node = (QueryTreeNode) vstbl;

		if (node.getNodeType() == NodeTypes.TEST_CONSTRAINT_NODE/*
			 * = 1
			 */) {
			System.out.println(getStageTabs() + "TEST_CONSTRAINT_NODE");
		}
		if (node.getNodeType() == NodeTypes.CURRENT_ROW_LOCATION_NODE/*
			 * = 2
			 */) {
			System.out.println(getStageTabs() + "CURRENT_ROW_LOCATION_NODE");
		}
		if (node.getNodeType() == NodeTypes.GROUP_BY_LIST/*
			 * = 3
			 */) {
			System.out.println(getStageTabs() + "GROUP_BY_LIST");
		}
		if (node.getNodeType() == NodeTypes.CURRENT_ISOLATION_NODE/*
			 * = 4
			 */) {
			System.out.println(getStageTabs() + "CURRENT_ISOLATION_NODE");
		}
		if (node.getNodeType() == NodeTypes.IDENTITY_VAL_NODE/*
			 * = 5
			 */) {
			System.out.println(getStageTabs() + "IDENTITY_VAL_NODE");
		}
		if (node.getNodeType() == NodeTypes.CURRENT_SCHEMA_NODE/*
			 * = 6
			 */) {
			System.out.println(getStageTabs() + "CURRENT_SCHEMA_NODE");
		}
		if (node.getNodeType() == NodeTypes.ORDER_BY_LIST/*
			 * = 7
			 */) {
			System.out.println(getStageTabs() + "ORDER_BY_LIST");
		}
		if (node.getNodeType() == NodeTypes.PREDICATE_LIST/*
			 * = 8
			 */) {
			System.out.println(getStageTabs() + "PREDICATE_LIST");
		}
		if (node.getNodeType() == NodeTypes.RESULT_COLUMN_LIST/*
			 * = 9
			 */) {
			System.out.println(getStageTabs() + "RESULT_COLUMN_LIST");
		}
		if (node.getNodeType() == NodeTypes.INDEX_COLUMN/*
			 * = 10
			 */) {
			System.out.println(getStageTabs() + "INDEX_COLUMN");
		}
		if (node.getNodeType() == NodeTypes.SUBQUERY_LIST/*
			 * = 11
			 */) {
			System.out.println(getStageTabs() + "SUBQUERY_LIST");
		}
		if (node.getNodeType() == NodeTypes.TABLE_ELEMENT_LIST/*
			 * = 12
			 */) {
			System.out.println(getStageTabs() + "TABLE_ELEMENT_LIST");
		}
		if (node.getNodeType() == NodeTypes.UNTYPED_NULL_CONSTANT_NODE/*
			 * = 13
			 */) {
			System.out.println(getStageTabs() + "UNTYPED_NULL_CONSTANT_NODE");
		}
		if (node.getNodeType() == NodeTypes.TABLE_ELEMENT_NODE/*
			 * = 14
			 */) {
			System.out.println(getStageTabs() + "TABLE_ELEMENT_NODE");
		}
		if (node.getNodeType() == NodeTypes.VALUE_NODE_LIST/*
			 * = 15
			 */) {
			System.out.println(getStageTabs() + "VALUE_NODE_LIST");
		}
		if (node.getNodeType() == NodeTypes.ALL_RESULT_COLUMN/*
			 * = 16
			 */) {
			System.out.println(getStageTabs() + "ALL_RESULT_COLUMN");
		}
		if (node.getNodeType() == NodeTypes.INDEX_COLUMN_LIST/*
			 * = 17
			 */) {
			System.out.println(getStageTabs() + "INDEX_COLUMN_LIST");
		}
		if (node.getNodeType() == NodeTypes.GET_CURRENT_CONNECTION_NODE/*
			 * = 18
			 */) {
			System.out.println(getStageTabs() + "GET_CURRENT_CONNECTION_NODE");
		}
		if (node.getNodeType() == NodeTypes.NOP_STATEMENT_NODE/*
			 * = 19
			 */) {
			System.out.println(getStageTabs() + "NOP_STATEMENT_NODE");
		}
		if (node.getNodeType() == NodeTypes.OCTET_LENGTH_OPERATOR_NODE/*
			 * = 20
			 */) {
			System.out.println(getStageTabs() + "OCTET_LENGTH_OPERATOR_NODE");
		}
		if (node.getNodeType() == NodeTypes.SET_TRANSACTION_ISOLATION_NODE/*
			 * = 21
			 */) {
			System.out.println(getStageTabs() + "SET_TRANSACTION_ISOLATION_NODE");
		}
		if (node.getNodeType() == NodeTypes.SET_TRANSACTION_ACCESS_NODE/*
			 * = 22
			 */) {
			System.out.println(getStageTabs() + "SET_TRANSACTION_ACCESS_NODE");
		}
		if (node.getNodeType() == NodeTypes.CHAR_LENGTH_OPERATOR_NODE/*
			 * = 23
			 */) {
			System.out.println(getStageTabs() + "CHAR_LENGTH_OPERATOR_NODE");
		}
		if (node.getNodeType() == NodeTypes.IS_NOT_NULL_NODE/*
			 * = 24
			 */) {
			System.out.println(getStageTabs() + "IS_NOT_NULL_NODE");
		}
		if (node.getNodeType() == NodeTypes.IS_NULL_NODE/*
			 * = 25
			 */) {
			System.out.println(getStageTabs() + "IS_NULL_NODE");
		}
		if (node.getNodeType() == NodeTypes.NOT_NODE/*
			 * = 26
			 */) {
			System.out.println(getStageTabs() + "NOT_NODE");
		}
		if (node.getNodeType() == NodeTypes.SET_CONFIGURATION_NODE/*
			 * = 27
			 */) {
			System.out.println(getStageTabs() + "SET_CONFIGURATION_NODE");
		}
		if (node.getNodeType() == NodeTypes.SQL_TO_JAVA_VALUE_NODE/*
			 * = 28
			 */) {
			System.out.println(getStageTabs() + "SQL_TO_JAVA_VALUE_NODE");
		}
		if (node.getNodeType() == NodeTypes.UNARY_MINUS_OPERATOR_NODE/*
			 * = 29
			 */) {
			System.out.println(getStageTabs() + "UNARY_MINUS_OPERATOR_NODE");
		}
		if (node.getNodeType() == NodeTypes.UNARY_PLUS_OPERATOR_NODE/*
			 * = 30
			 */) {
			System.out.println(getStageTabs() + "UNARY_PLUS_OPERATOR_NODE");
		}
		if (node.getNodeType() == NodeTypes.SQL_BOOLEAN_CONSTANT_NODE/*
			 * = 31
			 */) {
			System.out.println(getStageTabs() + "SQL_BOOLEAN_CONSTANT_NODE");
		}
		if (node.getNodeType() == NodeTypes.UNARY_DATE_TIMESTAMP_OPERATOR_NODE/*
			 * = 32
			 */) {
			System.out.println(getStageTabs() + "UNARY_DATE_TIMESTAMP_OPERATOR_NODE");
		}
		if (node.getNodeType() == NodeTypes.TIMESTAMP_OPERATOR_NODE/*
			 * = 33
			 */) {
			System.out.println(getStageTabs() + "TIMESTAMP_OPERATOR_NODE");
		}
		if (node.getNodeType() == NodeTypes.TABLE_NAME/*
			 * = 34
			 */) {
			System.out.println(getStageTabs() + "TABLE_NAME");
		}
		if (node.getNodeType() == NodeTypes.GROUP_BY_COLUMN/*
			 * = 35
			 */) {
			System.out.println(getStageTabs() + "GROUP_BY_COLUMN");
		}
		if (node.getNodeType() == NodeTypes.JAVA_TO_SQL_VALUE_NODE/*
			 * = 36
			 */) {
			System.out.println(getStageTabs() + "JAVA_TO_SQL_VALUE_NODE");
		}
		if (node.getNodeType() == NodeTypes.FROM_LIST/*
			 * = 37
			 */) {
			System.out.println(getStageTabs() + "FROM_LIST");
		}
		if (node.getNodeType() == NodeTypes.BOOLEAN_CONSTANT_NODE/*
			 * = 38
			 */) {
			System.out.println(getStageTabs() + "BOOLEAN_CONSTANT_NODE");
		}
		if (node.getNodeType() == NodeTypes.AND_NODE/*
			 * = 39
			 */) {
			System.out.println(getStageTabs() + "AND_NODE");
		}
		if (node.getNodeType() == NodeTypes.BINARY_DIVIDE_OPERATOR_NODE/*
			 * = 40
			 */) {
			System.out.println(getStageTabs() + "BINARY_DIVIDE_OPERATOR_NODE");
		}
		if (node.getNodeType() == NodeTypes.BINARY_EQUALS_OPERATOR_NODE/*
			 * = 41
			 */) {
			System.out.println(getStageTabs() + "BINARY_EQUALS_OPERATOR_NODE");
		}
		if (node.getNodeType() == NodeTypes.BINARY_GREATER_EQUALS_OPERATOR_NODE/*
			 * = 42
			 */) {
			System.out.println(getStageTabs() + "BINARY_GREATER_EQUALS_OPERATOR_NODE");
		}
		if (node.getNodeType() == NodeTypes.BINARY_GREATER_THAN_OPERATOR_NODE/*
			 * = 43
			 */) {
			System.out.println(getStageTabs() + "BINARY_GREATER_THAN_OPERATOR_NODE");
		}
		if (node.getNodeType() == NodeTypes.BINARY_LESS_EQUALS_OPERATOR_NODE/*
			 * = 44
			 */) {
			System.out.println(getStageTabs() + "BINARY_LESS_EQUALS_OPERATOR_NODE");
		}
		if (node.getNodeType() == NodeTypes.BINARY_LESS_THAN_OPERATOR_NODE/*
			 * = 45
			 */) {
			System.out.println(getStageTabs() + "BINARY_LESS_THAN_OPERATOR_NODE");
		}
		if (node.getNodeType() == NodeTypes.BINARY_MINUS_OPERATOR_NODE/*
			 * = 46
			 */) {
			System.out.println(getStageTabs() + "BINARY_MINUS_OPERATOR_NODE");
		}
		if (node.getNodeType() == NodeTypes.BINARY_NOT_EQUALS_OPERATOR_NODE/*
			 * = 47
			 */) {
			System.out.println(getStageTabs() + "BINARY_NOT_EQUALS_OPERATOR_NODE");
		}
		if (node.getNodeType() == NodeTypes.BINARY_PLUS_OPERATOR_NODE/*
			 * = 48
			 */) {
			System.out.println(getStageTabs() + "BINARY_PLUS_OPERATOR_NODE");
		}
		if (node.getNodeType() == NodeTypes.BINARY_TIMES_OPERATOR_NODE/*
			 * = 49
			 */) {
			System.out.println(getStageTabs() + "BINARY_TIMES_OPERATOR_NODE");
		}
		if (node.getNodeType() == NodeTypes.CONCATENATION_OPERATOR_NODE/*
			 * = 50
			 */) {
			System.out.println(getStageTabs() + "CONCATENATION_OPERATOR_NODE");
		}
		if (node.getNodeType() == NodeTypes.LIKE_OPERATOR_NODE/*
			 * = 51
			 */) {
			System.out.println(getStageTabs() + "LIKE_OPERATOR_NODE");
		}
		if (node.getNodeType() == NodeTypes.OR_NODE/*
			 * = 52
			 */) {
			System.out.println(getStageTabs() + "OR_NODE");
		}
		if (node.getNodeType() == NodeTypes.BETWEEN_OPERATOR_NODE/*
			 * = 53
			 */) {
			System.out.println(getStageTabs() + "BETWEEN_OPERATOR_NODE");
		}
		if (node.getNodeType() == NodeTypes.CONDITIONAL_NODE/*
			 * = 54
			 */) {
			System.out.println(getStageTabs() + "CONDITIONAL_NODE");
		}
		if (node.getNodeType() == NodeTypes.IN_LIST_OPERATOR_NODE/*
			 * = 55
			 */) {
			System.out.println(getStageTabs() + "IN_LIST_OPERATOR_NODE");
		}
		if (node.getNodeType() == NodeTypes.NOT_BETWEEN_OPERATOR_NODE/*
			 * = 56
			 */) {
			System.out.println(getStageTabs() + "NOT_BETWEEN_OPERATOR_NODE");
		}
		if (node.getNodeType() == NodeTypes.NOT_IN_LIST_OPERATOR_NODE/*
			 * = 57
			 */) {
			System.out.println(getStageTabs() + "NOT_IN_LIST_OPERATOR_NODE");
		}
		if (node.getNodeType() == NodeTypes.BIT_CONSTANT_NODE/*
			 * = 58
			 */) {
			System.out.println(getStageTabs() + "BIT_CONSTANT_NODE");
		}
		if (node.getNodeType() == NodeTypes.VARBIT_CONSTANT_NODE/*
			 * = 59
			 */) {
			System.out.println(getStageTabs() + "VARBIT_CONSTANT_NODE");
		}
		if (node.getNodeType() == NodeTypes.CAST_NODE/*
			 * = 60
			 */) {
			System.out.println(getStageTabs() + "CAST_NODE");
		}
		if (node.getNodeType() == NodeTypes.CHAR_CONSTANT_NODE/*
			 * = 61
			 */) {
			System.out.println(getStageTabs() + "CHAR_CONSTANT_NODE");
		}
		if (node.getNodeType() == NodeTypes.COLUMN_REFERENCE/*
			 * = 62
			 */) {
			System.out.println(getStageTabs() + "COLUMN_REFERENCE");
		}
		if (node.getNodeType() == NodeTypes.DROP_INDEX_NODE/*
			 * = 63
			 */) {
			System.out.println(getStageTabs() + "DROP_INDEX_NODE");
		}
		if (node.getNodeType() == NodeTypes.UNARY_BITNOT_OPERATOR_NODE/*
			 * = 64
			 */) {
			System.out.println(getStageTabs() + "UNARY_BITNOT_OPERATOR_NODE");
		}
		if (node.getNodeType() == NodeTypes.DROP_TRIGGER_NODE/*
			 * = 65
			 */) {
			System.out.println(getStageTabs() + "DROP_TRIGGER_NODE");
		}
		if (node.getNodeType() == NodeTypes.BINARY_BIT_OPERATOR_NODE/*
			 * = 66
			 */) {
			System.out.println(getStageTabs() + "BINARY_BIT_OPERATOR_NODE");
		}
		if (node.getNodeType() == NodeTypes.DECIMAL_CONSTANT_NODE/*
			 * = 67
			 */) {
			System.out.println(getStageTabs() + "DECIMAL_CONSTANT_NODE");
		}
		if (node.getNodeType() == NodeTypes.DOUBLE_CONSTANT_NODE/*
			 * = 68
			 */) {
			System.out.println(getStageTabs() + "DOUBLE_CONSTANT_NODE");
		}
		if (node.getNodeType() == NodeTypes.FLOAT_CONSTANT_NODE/*
			 * = 69
			 */) {
			System.out.println(getStageTabs() + "FLOAT_CONSTANT_NODE");
		}
		if (node.getNodeType() == NodeTypes.INT_CONSTANT_NODE/*
			 * = 70
			 */) {
			System.out.println(getStageTabs() + "INT_CONSTANT_NODE");

			NumericConstantNode val = (NumericConstantNode) node;
			System.out.println(getStageTabs() + "VAL: " + val.getValue());
		}
		if (node.getNodeType() == NodeTypes.LONGINT_CONSTANT_NODE/*
			 * = 71
			 */) {
			System.out.println(getStageTabs() + "LONGINT_CONSTANT_NODE");
		}
		if (node.getNodeType() == NodeTypes.LONGVARBIT_CONSTANT_NODE/*
			 * = 72
			 */) {
			System.out.println(getStageTabs() + "LONGVARBIT_CONSTANT_NODE");
		}
		if (node.getNodeType() == NodeTypes.LONGVARCHAR_CONSTANT_NODE/*
			 * = 73
			 */) {
			System.out.println(getStageTabs() + "LONGVARCHAR_CONSTANT_NODE");
		}
		if (node.getNodeType() == NodeTypes.SMALLINT_CONSTANT_NODE/*
			 * = 74
			 */) {
			System.out.println(getStageTabs() + "SMALLINT_CONSTANT_NODE");
		}
		if (node.getNodeType() == NodeTypes.TINYINT_CONSTANT_NODE/*
			 * = 75
			 */) {
			System.out.println(getStageTabs() + "TINYINT_CONSTANT_NODE");
		}
		if (node.getNodeType() == NodeTypes.USERTYPE_CONSTANT_NODE/*
			 * = 76
			 */) {
			System.out.println(getStageTabs() + "USERTYPE_CONSTANT_NODE");
		}
		if (node.getNodeType() == NodeTypes.VARCHAR_CONSTANT_NODE/*
			 * = 77
			 */) {
			System.out.println(getStageTabs() + "VARCHAR_CONSTANT_NODE");
		}
		if (node.getNodeType() == NodeTypes.PREDICATE/*
			 * = 78
			 */) {
			System.out.println(getStageTabs() + "PREDICATE");
		}
		if (node.getNodeType() == NodeTypes.BINARY_DIV_OPERATOR_NODE/*
			 * = 79
			 */) {
			System.out.println(getStageTabs() + "BINARY_DIV_OPERATOR_NODE");
		}
		if (node.getNodeType() == NodeTypes.RESULT_COLUMN/*
			 * = 80
			 */) {
			System.out.println(getStageTabs() + "RESULT_COLUMN");
//			ResultColumn res = (ResultColumn) node;
//			System.out.println(getStageTabs() + "##### Name: " + res.getName());
		}
		if (node.getNodeType() == NodeTypes.SET_SCHEMA_NODE/*
			 * = 81
			 */) {
			System.out.println(getStageTabs() + "SET_SCHEMA_NODE");
		}
		if (node.getNodeType() == NodeTypes.UPDATE_COLUMN/*
			 * = 82
			 */) {
			System.out.println(getStageTabs() + "UPDATE_COLUMN");
		}
		if (node.getNodeType() == NodeTypes.SIMPLE_STRING_OPERATOR_NODE/*
			 * = 83
			 */) {
			System.out.println(getStageTabs() + "SIMPLE_STRING_OPERATOR_NODE");
		}
		if (node.getNodeType() == NodeTypes.STATIC_CLASS_FIELD_REFERENCE_NODE/*
			 * = 84
			 */) {
			System.out.println(getStageTabs() + "STATIC_CLASS_FIELD_REFERENCE_NODE");
		}
		if (node.getNodeType() == NodeTypes.STATIC_METHOD_CALL_NODE/*
			 * = 85
			 */) {
			System.out.println(getStageTabs() + "STATIC_METHOD_CALL_NODE");
		}
		if (node.getNodeType() == NodeTypes.REVOKE_NODE/*
			 * = 86
			 */) {
			System.out.println(getStageTabs() + "REVOKE_NODE");
		}
		if (node.getNodeType() == NodeTypes.EXTRACT_OPERATOR_NODE/*
			 * = 87
			 */) {
			System.out.println(getStageTabs() + "EXTRACT_OPERATOR_NODE");
		}
		if (node.getNodeType() == NodeTypes.PARAMETER_NODE/*
			 * = 88
			 */) {
			System.out.println(getStageTabs() + "PARAMETER_NODE");
		}
		if (node.getNodeType() == NodeTypes.GRANT_NODE/*
			 * = 89
			 */) {
			System.out.println(getStageTabs() + "GRANT_NODE");
		}
		if (node.getNodeType() == NodeTypes.DROP_SCHEMA_NODE/*
			 * = 90
			 */) {
			System.out.println(getStageTabs() + "DROP_SCHEMA_NODE");
		}
		if (node.getNodeType() == NodeTypes.DROP_TABLE_NODE/*
			 * = 91
			 */) {
			System.out.println(getStageTabs() + "DROP_TABLE_NODE");
		}
		if (node.getNodeType() == NodeTypes.DROP_VIEW_NODE/*
			 * = 92
			 */) {
			System.out.println(getStageTabs() + "DROP_VIEW_NODE");
		}
		if (node.getNodeType() == NodeTypes.SUBQUERY_NODE/*
			 * = 93
			 */) {
			System.out.println(getStageTabs() + "SUBQUERY_NODE");
		}
		if (node.getNodeType() == NodeTypes.BASE_COLUMN_NODE/*
			 * = 94
			 */) {
			System.out.println(getStageTabs() + "BASE_COLUMN_NODE");
		}
		if (node.getNodeType() == NodeTypes.CALL_STATEMENT_NODE/*
			 * = 95
			 */) {
			System.out.println(getStageTabs() + "CALL_STATEMENT_NODE");
		}
		if (node.getNodeType() == NodeTypes.MODIFY_COLUMN_DEFAULT_NODE/*
			 * = 97
			 */) {
			System.out.println(getStageTabs() + "MODIFY_COLUMN_DEFAULT_NODE");
		}
		if (node.getNodeType() == NodeTypes.NON_STATIC_METHOD_CALL_NODE/*
			 * = 98
			 */) {
			System.out.println(getStageTabs() + "NON_STATIC_METHOD_CALL_NODE");
		}
		if (node.getNodeType() == NodeTypes.CURRENT_OF_NODE/*
			 * = 99
			 */) {
			System.out.println(getStageTabs() + "CURRENT_OF_NODE");
		}
		if (node.getNodeType() == NodeTypes.DEFAULT_NODE/*
			 * = 100
			 */) {
			System.out.println(getStageTabs() + "DEFAULT_NODE");
		}
		if (node.getNodeType() == NodeTypes.DELETE_NODE/*
			 * = 101
			 */) {
			System.out.println(getStageTabs() + "DELETE_NODE");
		}
		if (node.getNodeType() == NodeTypes.UPDATE_NODE/*
			 * = 102
			 */) {
			System.out.println(getStageTabs() + "UPDATE_NODE");
		}
		if (node.getNodeType() == NodeTypes.PRIVILEGE_NODE/*
			 * = 103
			 */) {
			System.out.println(getStageTabs() + "PRIVILEGE_NODE");
		}
		if (node.getNodeType() == NodeTypes.ORDER_BY_COLUMN/*
			 * = 104
			 */) {
			System.out.println(getStageTabs() + "ORDER_BY_COLUMN");
		}
		if (node.getNodeType() == NodeTypes.ROW_RESULT_SET_NODE/*
			 * = 105
			 */) {
			System.out.println(getStageTabs() + "ROW_RESULT_SET_NODE");
		}
		if (node.getNodeType() == NodeTypes.TABLE_PRIVILEGES_NODE/*
			 * = 106
			 */) {
			System.out.println(getStageTabs() + "TABLE_PRIVILEGES_NODE");
		}
		if (node.getNodeType() == NodeTypes.VIRTUAL_COLUMN_NODE/*
			 * = 107
			 */) {
			System.out.println(getStageTabs() + "VIRTUAL_COLUMN_NODE");
		}
		if (node.getNodeType() == NodeTypes.CURRENT_DATETIME_OPERATOR_NODE/*
			 * = 108
			 */) {
			System.out.println(getStageTabs() + "CURRENT_DATETIME_OPERATOR_NODE");
		}
		if (node.getNodeType() == NodeTypes.CURRENT_USER_NODE/*
			 * = 109
			 */) {
			System.out.println(getStageTabs() + "CURRENT_USER_NODE");
		}
		if (node.getNodeType() == NodeTypes.USER_NODE/*
			 * = 110
			 */) {
			System.out.println(getStageTabs() + "USER_NODE");
		}
		if (node.getNodeType() == NodeTypes.IS_NODE/*
			 * = 111
			 */) {
			System.out.println(getStageTabs() + "IS_NODE");
		}
		if (node.getNodeType() == NodeTypes.LOCK_TABLE_NODE/*
			 * = 112
			 */) {
			System.out.println(getStageTabs() + "LOCK_TABLE_NODE");
		}
		if (node.getNodeType() == NodeTypes.DROP_COLUMN_NODE/*
			 * = 113
			 */) {
			System.out.println(getStageTabs() + "DROP_COLUMN_NODE");
		}
		if (node.getNodeType() == NodeTypes.ALTER_TABLE_NODE/*
			 * = 114
			 */) {
			System.out.println(getStageTabs() + "ALTER_TABLE_NODE");
		}
		if (node.getNodeType() == NodeTypes.AGGREGATE_NODE/*
			 * = 115
			 */) {
			System.out.println(getStageTabs() + "AGGREGATE_NODE");
		}
		if (node.getNodeType() == NodeTypes.COLUMN_DEFINITION_NODE/*
			 * = 116
			 */) {
			System.out.println(getStageTabs() + "COLUMN_DEFINITION_NODE");
		}
		if (node.getNodeType() == NodeTypes.EXPLAIN_STATEMENT_NODE/*
			 * = 117
			 */) {
			System.out.println(getStageTabs() + "EXPLAIN_STATEMENT_NODE");
		}
		if (node.getNodeType() == NodeTypes.COPY_STATEMENT_NODE/*
			 * = 118
			 */) {
			System.out.println(getStageTabs() + "COPY_STATEMENT_NODE");
		}
		if (node.getNodeType() == NodeTypes.FK_CONSTRAINT_DEFINITION_NODE/*
			 * = 119
			 */) {
			System.out.println(getStageTabs() + "FK_CONSTRAINT_DEFINITION_NODE");
		}
		if (node.getNodeType() == NodeTypes.FROM_VTI/*
			 * = 120
			 */) {
			System.out.println(getStageTabs() + "FROM_VTI");
		}
		if (node.getNodeType() == NodeTypes.MATERIALIZE_RESULT_SET_NODE/*
			 * = 121
			 */) {
			System.out.println(getStageTabs() + "MATERIALIZE_RESULT_SET_NODE");
		}
		if (node.getNodeType() == NodeTypes.NORMALIZE_RESULT_SET_NODE/*
			 * = 122
			 */) {
			System.out.println(getStageTabs() + "NORMALIZE_RESULT_SET_NODE");
		}
		if (node.getNodeType() == NodeTypes.SCROLL_INSENSITIVE_RESULT_SET_NODE/*
			 * = 123
			 */) {
			System.out.println(getStageTabs() + "SCROLL_INSENSITIVE_RESULT_SET_NODE");
		}
		if (node.getNodeType() == NodeTypes.DISTINCT_NODE/*
			 * = 124
			 */) {
			System.out.println(getStageTabs() + "DISTINCT_NODE");
		}
		if (node.getNodeType() == NodeTypes.SESSION_USER_NODE/*
			 * = 125
			 */) {
			System.out.println(getStageTabs() + "SESSION_USER_NODE");
		}
		if (node.getNodeType() == NodeTypes.SYSTEM_USER_NODE/*
			 * = 126
			 */) {
			System.out.println(getStageTabs() + "SYSTEM_USER_NODE");
		}
		if (node.getNodeType() == NodeTypes.TRIM_OPERATOR_NODE/*
			 * = 127
			 */) {
			System.out.println(getStageTabs() + "TRIM_OPERATOR_NODE");
		}
		if (node.getNodeType() == NodeTypes.INDEX_HINT_NODE/*
			 * = 128
			 */) {
			System.out.println(getStageTabs() + "INDEX_HINT_NODE");
		}
		if (node.getNodeType() == NodeTypes.SELECT_NODE/*
			 * = 129
			 */) {
			System.out.println(getStageTabs() + "SELECT_NODE");
		}
		if (node.getNodeType() == NodeTypes.CREATE_VIEW_NODE/*
			 * = 130
			 */) {
			System.out.println(getStageTabs() + "CREATE_VIEW_NODE");
		}
		if (node.getNodeType() == NodeTypes.CONSTRAINT_DEFINITION_NODE/*
			 * = 131
			 */) {
			System.out.println(getStageTabs() + "CONSTRAINT_DEFINITION_NODE");
		}
		if (node.getNodeType() == NodeTypes.INDEX_HINT_LIST/*
			 * = 132
			 */) {
			System.out.println(getStageTabs() + "INDEX_HINT_LIST");
		}
		if (node.getNodeType() == NodeTypes.NEW_INVOCATION_NODE/*
			 * = 133
			 */) {
			System.out.println(getStageTabs() + "NEW_INVOCATION_NODE");
		}
		if (node.getNodeType() == NodeTypes.CREATE_SCHEMA_NODE/*
			 * = 134
			 */) {
			System.out.println(getStageTabs() + "CREATE_SCHEMA_NODE");
		}
		if (node.getNodeType() == NodeTypes.FROM_BASE_TABLE/*
			 * = 135
			 */) {
			System.out.println(getStageTabs() + "FROM_BASE_TABLE");
		}
		if (node.getNodeType() == NodeTypes.FROM_SUBQUERY/*
			 * = 136
			 */) {
			System.out.println(getStageTabs() + "FROM_SUBQUERY");
		}
		if (node.getNodeType() == NodeTypes.GROUP_BY_NODE/*
			 * = 137
			 */) {
			System.out.println(getStageTabs() + "GROUP_BY_NODE");
		}
		if (node.getNodeType() == NodeTypes.INSERT_NODE/*
			 * = 138
			 */) {
			System.out.println(getStageTabs() + "INSERT_NODE");
		}
		if (node.getNodeType() == NodeTypes.JOIN_NODE/*
			 * = 139
			 */) {
			System.out.println(getStageTabs() + "JOIN_NODE");
		}
		if (node.getNodeType() == NodeTypes.ORDER_BY_NODE/*
			 * = 140
			 */) {
			System.out.println(getStageTabs() + "ORDER_BY_NODE");
		}
		if (node.getNodeType() == NodeTypes.CREATE_TABLE_NODE/*
			 * = 141
			 */) {
			System.out.println(getStageTabs() + "CREATE_TABLE_NODE");
		}
		if (node.getNodeType() == NodeTypes.UNION_NODE/*
			 * = 142
			 */) {
			System.out.println(getStageTabs() + "UNION_NODE");
		}
		if (node.getNodeType() == NodeTypes.CREATE_TRIGGER_NODE/*
			 * = 143
			 */) {
			System.out.println(getStageTabs() + "CREATE_TRIGGER_NODE");
		}
		if (node.getNodeType() == NodeTypes.HALF_OUTER_JOIN_NODE/*
			 * = 144
			 */) {
			System.out.println(getStageTabs() + "HALF_OUTER_JOIN_NODE");
		}
		if (node.getNodeType() == NodeTypes.EXPLICIT_COLLATE_NODE/*
			 * = 145
			 */) {
			System.out.println(getStageTabs() + "EXPLICIT_COLLATE_NODE");
		}
		if (node.getNodeType() == NodeTypes.CREATE_INDEX_NODE/*
			 * = 146
			 */) {
			System.out.println(getStageTabs() + "CREATE_INDEX_NODE");
		}
		if (node.getNodeType() == NodeTypes.CURSOR_NODE/*
			 * = 147
			 */) {
			System.out.println(getStageTabs() + "CURSOR_NODE");
		}
		if (node.getNodeType() == NodeTypes.HASH_TABLE_NODE/*
			 * = 148
			 */) {
			System.out.println(getStageTabs() + "HASH_TABLE_NODE");
		}
		if (node.getNodeType() == NodeTypes.INDEX_TO_BASE_ROW_NODE/*
			 * = 149
			 */) {
			System.out.println(getStageTabs() + "INDEX_TO_BASE_ROW_NODE");
		}
		if (node.getNodeType() == NodeTypes.CREATE_ALIAS_NODE/*
			 * = 150
			 */) {
			System.out.println(getStageTabs() + "CREATE_ALIAS_NODE");
		}
		if (node.getNodeType() == NodeTypes.PROJECT_RESTRICT_NODE/*
			 * = 151
			 */) {
			System.out.println(getStageTabs() + "PROJECT_RESTRICT_NODE");
		}
		if (node.getNodeType() == NodeTypes.SUBSTRING_OPERATOR_NODE/*
			 * = 154
			 */) {
			System.out.println(getStageTabs() + "SUBSTRING_OPERATOR_NODE");
		}
		if (node.getNodeType() == NodeTypes.DROP_ALIAS_NODE/*
			 * = 156
			 */) {
			System.out.println(getStageTabs() + "DROP_ALIAS_NODE");
		}
		if (node.getNodeType() == NodeTypes.INTERSECT_OR_EXCEPT_NODE/*
			 * = 157
			 */) {
			System.out.println(getStageTabs() + "INTERSECT_OR_EXCEPT_NODE");
		}
		if (node.getNodeType() == NodeTypes.LEFT_FN_NODE/*
			 * = 158
			 */) {
			System.out.println(getStageTabs() + "LEFT_FN_NODE");
		}
		if (node.getNodeType() == NodeTypes.RIGHT_FN_NODE/*
			 * = 159
			 */) {
			System.out.println(getStageTabs() + "RIGHT_FN_NODE");
		}
		if (node.getNodeType() == NodeTypes.ROWS_RESULT_SET_NODE/*
			 * = 160
			 */) {
			System.out.println(getStageTabs() + "ROWS_RESULT_SET_NODE");
		}
		if (node.getNodeType() == NodeTypes.AT_DROP_INDEX_NODE/*
			 * = 162
			 */) {
			System.out.println(getStageTabs() + "AT_DROP_INDEX_NODE");
		}
		if (node.getNodeType() == NodeTypes.AT_ADD_INDEX_NODE/*
			 * = 163
			 */) {
			System.out.println(getStageTabs() + "AT_ADD_INDEX_NODE");
		}
		if (node.getNodeType() == NodeTypes.INDEX_CONSTRAINT_NODE/*
			 * = 164
			 */) {
			System.out.println(getStageTabs() + "INDEX_CONSTRAINT_NODE");
		}
		if (node.getNodeType() == NodeTypes.DROP_GROUP_NODE/*
			 * = 165
			 */) {
			System.out.println(getStageTabs() + "DROP_GROUP_NODE");
		}
		if (node.getNodeType() == NodeTypes.ROW_CTOR_NODE/*
			 * = 166
			 */) {
			System.out.println(getStageTabs() + "ROW_CTOR_NODE");
		}
		if (node.getNodeType() == NodeTypes.GROUP_CONCAT_NODE/*
			 * = 167
			 */) {
			System.out.println(getStageTabs() + "GROUP_CONCAT_NODE");
		}
		if (node.getNodeType() == NodeTypes.AT_RENAME_NODE/*
			 * = 168
			 */) {
			System.out.println(getStageTabs() + "AT_RENAME_NODE");
		}
		if (node.getNodeType() == NodeTypes.AT_RENAME_COLUMN_NODE/*
			 * = 169
			 */) {
			System.out.println(getStageTabs() + "AT_RENAME_COLUMN_NODE");
		}
		if (node.getNodeType() == NodeTypes.SIMPLE_CASE_NODE/*
			 * = 170
			 */) {
			System.out.println(getStageTabs() + "SIMPLE_CASE_NODE");
		}
		if (node.getNodeType() == NodeTypes.PARTITION_BY_LIST/*
			 * = 171
			 */) {
			System.out.println(getStageTabs() + "PARTITION_BY_LIST");
		}
		if (node.getNodeType() == NodeTypes.PARTITION_BY_COLUMN/*
			 * = 172
			 */) {
			System.out.println(getStageTabs() + "PARTITION_BY_COLUMN");
		}
		if (node.getNodeType() == NodeTypes.FULL_OUTER_JOIN_NODE/*
			 * = 173
			 */) {
			System.out.println(getStageTabs() + "FULL_OUTER_JOIN_NODE");
		}
		if (node.getNodeType() == NodeTypes.SHOW_CONFIGURATION_NODE/*
			 * = 174
			 */) {
			System.out.println(getStageTabs() + "SHOW_CONFIGURATION_NODE");
		}
		if (node.getNodeType() == NodeTypes.STORAGE_FORMAT_NODE/*
			 * = 175
			 */) {
			System.out.println(getStageTabs() + "STORAGE_FORMAT_NODE");
		}
		if (node.getNodeType() == NodeTypes.TABLE_NAME_LIST/*
			 * = 176
			 */) {
			System.out.println(getStageTabs() + "TABLE_NAME_LIST");
		}
		if (node.getNodeType() == NodeTypes.SET_CONSTRAINTS_NODE/*
			 * = 177
			 */) {
			System.out.println(getStageTabs() + "SET_CONSTRAINTS_NODE");
		}
		if (node.getNodeType() == NodeTypes.ALTER_SERVER_NODE/*
			 * = 183
			 */) {
			System.out.println(getStageTabs() + "ALTER_SERVER_NODE");
		}
		if (node.getNodeType() == NodeTypes.TIMESTAMP_ADD_FN_NODE/*
			 * = 184
			 */) {
			System.out.println(getStageTabs() + "TIMESTAMP_ADD_FN_NODE");
		}
		if (node.getNodeType() == NodeTypes.TIMESTAMP_DIFF_FN_NODE/*
			 * = 185
			 */) {
			System.out.println(getStageTabs() + "TIMESTAMP_DIFF_FN_NODE");
		}
		if (node.getNodeType() == NodeTypes.MODIFY_COLUMN_TYPE_NODE/*
			 * = 186
			 */) {
			System.out.println(getStageTabs() + "MODIFY_COLUMN_TYPE_NODE");
		}
		if (node.getNodeType() == NodeTypes.MODIFY_COLUMN_CONSTRAINT_NODE/*
			 * = 187
			 */) {
			System.out.println(getStageTabs() + "MODIFY_COLUMN_CONSTRAINT_NODE");
		}
		if (node.getNodeType() == NodeTypes.ABSOLUTE_OPERATOR_NODE/*
			 * = 188
			 */) {
			System.out.println(getStageTabs() + "ABSOLUTE_OPERATOR_NODE");
		}
		if (node.getNodeType() == NodeTypes.SQRT_OPERATOR_NODE/*
			 * = 189
			 */) {
			System.out.println(getStageTabs() + "SQRT_OPERATOR_NODE");
		}
		if (node.getNodeType() == NodeTypes.LOCATE_FUNCTION_NODE/*
			 * = 190
			 */) {
			System.out.println(getStageTabs() + "LOCATE_FUNCTION_NODE");
		}
		if (node.getNodeType() == NodeTypes.RENAME_NODE/*
			 * = 191
			 */) {
			System.out.println(getStageTabs() + "RENAME_NODE");
		}
		if (node.getNodeType() == NodeTypes.COALESCE_FUNCTION_NODE/*
			 * = 192
			 */) {
			System.out.println(getStageTabs() + "COALESCE_FUNCTION_NODE");
		}
		if (node.getNodeType() == NodeTypes.MODIFY_COLUMN_CONSTRAINT_NOT_NULL_NODE/*
			 * = 193
			 */) {
			System.out.println(getStageTabs() + "MODIFY_COLUMN_CONSTRAINT_NOT_NULL_NODE");
		}
		if (node.getNodeType() == NodeTypes.MOD_OPERATOR_NODE/*
			 * = 194
			 */) {
			System.out.println(getStageTabs() + "MOD_OPERATOR_NODE");
		}
		if (node.getNodeType() == NodeTypes.BLOB_CONSTANT_NODE/*
			 * = 195
			 */) {
			System.out.println(getStageTabs() + "BLOB_CONSTANT_NODE");
		}
		if (node.getNodeType() == NodeTypes.CLOB_CONSTANT_NODE/*
			 * = 196
			 */) {
			System.out.println(getStageTabs() + "CLOB_CONSTANT_NODE");
		}
		if (node.getNodeType() == NodeTypes.TRANSACTION_CONTROL_NODE/*
			 * = 197
			 */) {
			System.out.println(getStageTabs() + "TRANSACTION_CONTROL_NODE");
		}
		if (node.getNodeType() == NodeTypes.SAVEPOINT_NODE/*
			 * = 198
			 */) {
			System.out.println(getStageTabs() + "SAVEPOINT_NODE");
		}
		if (node.getNodeType() == NodeTypes.XML_CONSTANT_NODE/*
			 * = 199
			 */) {
			System.out.println(getStageTabs() + "XML_CONSTANT_NODE");
		}
		if (node.getNodeType() == NodeTypes.XML_PARSE_OPERATOR_NODE/*
			 * = 200
			 */) {
			System.out.println(getStageTabs() + "XML_PARSE_OPERATOR_NODE");
		}
		if (node.getNodeType() == NodeTypes.XML_SERIALIZE_OPERATOR_NODE/*
			 * = 201
			 */) {
			System.out.println(getStageTabs() + "XML_SERIALIZE_OPERATOR_NODE");
		}
		if (node.getNodeType() == NodeTypes.XML_EXISTS_OPERATOR_NODE/*
			 * = 202
			 */) {
			System.out.println(getStageTabs() + "XML_EXISTS_OPERATOR_NODE");
		}
		if (node.getNodeType() == NodeTypes.XML_QUERY_OPERATOR_NODE/*
			 * = 203
			 */) {
			System.out.println(getStageTabs() + "XML_QUERY_OPERATOR_NODE");
		}
		if (node.getNodeType() == NodeTypes.CURRENT_ROLE_NODE/*
			 * = 210
			 */) {
			System.out.println(getStageTabs() + "CURRENT_ROLE_NODE");
		}
		if (node.getNodeType() == NodeTypes.CREATE_ROLE_NODE/*
			 * = 211
			 */) {
			System.out.println(getStageTabs() + "CREATE_ROLE_NODE");
		}
		if (node.getNodeType() == NodeTypes.SET_ROLE_NODE/*
			 * = 212
			 */) {
			System.out.println(getStageTabs() + "SET_ROLE_NODE");
		}
		if (node.getNodeType() == NodeTypes.SET_ROLE_DYNAMIC/*
			 * = 213
			 */) {
			System.out.println(getStageTabs() + "SET_ROLE_DYNAMIC");
		}
		if (node.getNodeType() == NodeTypes.DROP_ROLE_NODE/*
			 * = 214
			 */) {
			System.out.println(getStageTabs() + "DROP_ROLE_NODE");
		}
		if (node.getNodeType() == NodeTypes.GRANT_ROLE_NODE/*
			 * = 215
			 */) {
			System.out.println(getStageTabs() + "GRANT_ROLE_NODE");
		}
		if (node.getNodeType() == NodeTypes.REVOKE_ROLE_NODE/*
			 * = 216
			 */) {
			System.out.println(getStageTabs() + "REVOKE_ROLE_NODE");
		}
		if (node.getNodeType() == NodeTypes.GENERATION_CLAUSE_NODE/*
			 * = 222
			 */) {
			System.out.println(getStageTabs() + "GENERATION_CLAUSE_NODE");
		}
		if (node.getNodeType() == NodeTypes.ROW_COUNT_NODE/*
			 * = 223
			 */) {
			System.out.println(getStageTabs() + "ROW_COUNT_NODE");
		}
		if (node.getNodeType() == NodeTypes.CREATE_SEQUENCE_NODE/*
			 * = 224
			 */) {
			System.out.println(getStageTabs() + "CREATE_SEQUENCE_NODE");
		}
		if (node.getNodeType() == NodeTypes.DROP_SEQUENCE_NODE/*
			 * = 225
			 */) {
			System.out.println(getStageTabs() + "DROP_SEQUENCE_NODE");
		}
		if (node.getNodeType() == NodeTypes.NEXT_SEQUENCE_NODE/*
			 * = 231
			 */) {
			System.out.println(getStageTabs() + "NEXT_SEQUENCE_NODE");
		}
		if (node.getNodeType() == NodeTypes.CURRENT_SEQUENCE_NODE/*
			 * = 232
			 */) {
			System.out.println(getStageTabs() + "CURRENT_SEQUENCE_NODE");
		}
		if (node.getNodeType() == NodeTypes.AGGREGATE_WINDOW_FUNCTION_NODE/*
			 * = 226
			 */) {
			System.out.println(getStageTabs() + "AGGREGATE_WINDOW_FUNCTION_NODE");
		}
		if (node.getNodeType() == NodeTypes.ROW_NUMBER_FUNCTION_NODE/*
			 * = 227
			 */) {
			System.out.println(getStageTabs() + "ROW_NUMBER_FUNCTION_NODE");
		}
		if (node.getNodeType() == NodeTypes.WINDOW_DEFINITION_NODE/*
			 * = 228
			 */) {
			System.out.println(getStageTabs() + "WINDOW_DEFINITION_NODE");
		}
		if (node.getNodeType() == NodeTypes.WINDOW_REFERENCE_NODE/*
			 * = 229
			 */) {
			System.out.println(getStageTabs() + "WINDOW_REFERENCE_NODE");
		}
		if (node.getNodeType() == NodeTypes.WINDOW_RESULTSET_NODE/*
			 * = 230
			 */) {
			System.out.println(getStageTabs() + "WINDOW_RESULTSET_NODE");
		}
		if (node.getNodeType() == NodeTypes.DECLARE_STATEMENT_NODE/*
			 * = 233
			 */) {
			System.out.println(getStageTabs() + "DECLARE_STATEMENT_NODE");
		}
		if (node.getNodeType() == NodeTypes.FETCH_STATEMENT_NODE/*
			 * = 234
			 */) {
			System.out.println(getStageTabs() + "FETCH_STATEMENT_NODE");
		}
		if (node.getNodeType() == NodeTypes.CLOSE_STATEMENT_NODE/*
			 * = 235
			 */) {
			System.out.println(getStageTabs() + "CLOSE_STATEMENT_NODE");
		}
		if (node.getNodeType() == NodeTypes.PREPARE_STATEMENT_NODE/*
			 * = 236
			 */) {
			System.out.println(getStageTabs() + "PREPARE_STATEMENT_NODE");
		}
		if (node.getNodeType() == NodeTypes.EXECUTE_STATEMENT_NODE/*
			 * = 237
			 */) {
			System.out.println(getStageTabs() + "EXECUTE_STATEMENT_NODE");
		}
		if (node.getNodeType() == NodeTypes.DEALLOCATE_STATEMENT_NODE/*
			 * = 238
			 */) {
			System.out.println(getStageTabs() + "DEALLOCATE_STATEMENT_NODE");
		}
		if (node.getNodeType() == NodeTypes.FINAL_VALUE/*
			 * = 238
			 */) {
			System.out.println(getStageTabs() + "FINAL_VALUE");
		}
		if (node.getNodeType() == NodeTypes.MAX_NODE_TYPE/*
			 * = 999
			 */) {
			System.out.println(getStageTabs() + "MAX_NODE_TYPE");
		}

//		String column = null;
//		if (node.getNodeType() == NodeTypes.COLUMN_REFERENCE) {
//			ColumnReference ref = (ColumnReference) node;
//			column = qualify(ref.getSchemaName()) + qualify(ref.getTableName()) + ref.getColumnName();
//		} else if (node.getNodeType() == NodeTypes.ALL_RESULT_COLUMN) {
//			column = "*";
//		}
//
//		if (column != null) {
//			System.out.print(didPrint ? ", " : "  ");
//			System.out.println(getStageTabs() + column);
//			didPrint = true;
//		}
		System.out.println(getStageTabs() + "");
		System.out.println(getStageTabs() + "Class: " + node.getClass().getSimpleName());
		System.out.println(getStageTabs() + node.toString().replaceAll("\n", "\n" + getStageTabs()));

		stage++;

		return vstbl;
	}

	private String getStageTabs() {
		StringBuilder tabs = new StringBuilder();
		for (int i = 0; i < stage; i++) {
			tabs.append("| ");
		}
		return tabs.toString();
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
