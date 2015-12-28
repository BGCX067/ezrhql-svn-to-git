package com.tempoc.ezrsql4j.impl;

import com.tempoc.ezrsql4j.syntax.Column;
import com.tempoc.ezrsql4j.syntax.JoinType;
import com.tempoc.ezrsql4j.syntax.JoinedTable;
import com.tempoc.ezrsql4j.syntax.TableReference;
import java.util.List;
import java.util.concurrent.locks.Condition;

import static com.tempoc.ezrsql4j.syntax.types.KeyWords.*;
import static com.tempoc.ezrsql4j.syntax.types.Symbols.*;

/**
 *
 * @author tempoc
 */
public class JoinedTableImpl implements JoinedTable {
    private TableReference tableReference1;
    private JoinType joinType;
    private TableReference tableReference2;
    private Condition condition;
    private List<Column> columns;
    private CrossOrNatural crossOrNatural;
    private int type;

    public JoinedTableImpl(TableReference tableReference1,
                           TableReference tableReference2, Condition condition) {
        this.tableReference1 = tableReference1;
        this.tableReference2 = tableReference2;
        this.condition = condition;
        type = 0;
    }

    public JoinedTableImpl(TableReference tableReference1,
                           TableReference tableReference2,
                           List<Column> columns) {
        this.tableReference1 = tableReference1;
        this.tableReference2 = tableReference2;
        this.columns = columns;
        type = 1;
    }

    public JoinedTableImpl(TableReference tableReference1, JoinType joinType,
                           TableReference tableReference2, Condition condition) {
        this.tableReference1 = tableReference1;
        this.joinType = joinType;
        this.tableReference2 = tableReference2;
        this.condition = condition;
        type = 2;
    }

    public JoinedTableImpl(TableReference tableReference1, JoinType joinType,
                           TableReference tableReference2,
                           List<Column> columns) {
        this.tableReference1 = tableReference1;
        this.joinType = joinType;
        this.tableReference2 = tableReference2;
        this.columns = columns;
        type = 3;
    }

    public JoinedTableImpl(TableReference tableReference1,
                           TableReference tableReference2, CrossOrNatural crossOrNatural) {
        this.tableReference1 = tableReference1;
        this.tableReference2 = tableReference2;
        this.crossOrNatural = crossOrNatural;
        type = 4;
    }

    public JoinedTableImpl(TableReference tableReference1, JoinType joinType,
                           TableReference tableReference2) {
        this.tableReference1 = tableReference1;
        this.joinType = joinType;
        this.tableReference2 = tableReference2;
        type = 5;
    }

    @Override
    public String toString() {
        String result = tableReference1 + SP;
        String joinTableReference = JOIN + SP + tableReference2;
        switch(type) {
            case 2:
                result += joinType + SP;
            case 0:
                result += joinTableReference + SP + ON + SP + condition;
                break;
            case 1:
                result += joinTableReference + SP + L_PAREN;
                result += buildColumnString() + R_PAREN;
                break;
            case 3:
                result += joinType + SP;
                result += joinTableReference + SP + L_PAREN;
                result += buildColumnString() + R_PAREN;
                break;
            case 4:
                result += crossOrNatural + SP + joinTableReference;
                break;
            case 5:
            default:
                result += NATURAL + SP + joinType + SP + joinTableReference;
        }

        return result;
    }

    private String buildColumnString() {
        String result = "";
        for(Column c : columns) {
            if(!result.equals("")) {
                result += COMMA + SP;
            }
            result += c;
        }
        return result;
    }

    public enum CrossOrNatural {
        NATURAL,
        CROSS
    }

}
