package com.tempoc.ezrsql4j.impl;

import com.tempoc.ezrsql4j.syntax.Column;
import com.tempoc.ezrsql4j.syntax.Schema;
import com.tempoc.ezrsql4j.syntax.Table;
import com.tempoc.ezrsql4j.syntax.View;

import static com.tempoc.ezrsql4j.syntax.types.Symbols.*;

/**
 *
 * @author tempoc
 */
public class ForUpdateClauseItem {
    private Schema schema;
    private Table table;
    private View view;
    private Column column;

    public ForUpdateClauseItem(Column column) {
        this.column = column;
    }

    public ForUpdateClauseItem(Table table, Column column) {
        this.table = table;
        this.column = column;
    }

    public ForUpdateClauseItem(View view, Column column) {
        this.view = view;
        this.column = column;
    }

    public ForUpdateClauseItem(Schema schema, Table table, Column column) {
        this.schema = schema;
        this.table = table;
        this.column = column;
    }

    public ForUpdateClauseItem(Schema schema, View view, Column column) {
        this.schema = schema;
        this.view = view;
        this.column = column;
    }

    @Override
    public String toString() {
        String result = column.toString();
        if(table!=null) {
            result = table + DOT + result;
            appendSchemaIfNotNull(result);
        } else if(view != null) {
            result = view + DOT + result;
            appendSchemaIfNotNull(result);
        }
        return result;
    }

    private void appendSchemaIfNotNull(String result) {
        if (schema != null) {
            result = schema + DOT + result;
        }
    }
}
