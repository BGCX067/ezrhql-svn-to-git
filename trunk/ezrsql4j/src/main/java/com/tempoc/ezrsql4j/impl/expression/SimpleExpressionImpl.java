package com.tempoc.ezrsql4j.impl.expression;

import com.tempoc.ezrsql4j.syntax.Column;
import com.tempoc.ezrsql4j.syntax.QueryName;
import com.tempoc.ezrsql4j.syntax.Schema;
import com.tempoc.ezrsql4j.syntax.expression.SimpleExpression;
import com.tempoc.ezrsql4j.syntax.helper.Grid;

import static com.tempoc.ezrsql4j.syntax.types.KeyWords.*;
import static com.tempoc.ezrsql4j.syntax.types.Symbols.*;

/**
 *
 * @author tempoc
 */
public class SimpleExpressionImpl implements SimpleExpression {
    private QueryName queryName;
    private Schema schema;
    private Grid grid;
    private Column column;
    private SimpleExpressionType type;
    private String text;
    private Number number;
    // TODO: Implement Sequence

    public SimpleExpressionImpl(Column column) {
        this.column = column;
    }

    public SimpleExpressionImpl(Grid grid, Column column) {
        this.grid = grid;
        this.column = column;
    }

    public SimpleExpressionImpl(Schema schema, Grid grid, Column column) {
        this.schema = schema;
        this.grid = grid;
        this.column = column;
    }

    public SimpleExpressionImpl(QueryName queryName, Column column) {
        this.queryName = queryName;
        this.column = column;
    }

    public SimpleExpressionImpl(SimpleExpressionType type) {
        this.type = type;
    }

    public SimpleExpressionImpl(Grid grid, SimpleExpressionType type) {
        if(!type.equals(SimpleExpressionType.ROWID)) {
            throw new IllegalArgumentException("Type must be ROWID");
        }
        this.grid = grid;
        this.type = type;
    }

    public SimpleExpressionImpl(Schema schema, Grid grid,
                                SimpleExpressionType type) {
        if (!type.equals(SimpleExpressionType.ROWID)) {
            throw new IllegalArgumentException("Type must be ROWID");
        }
        this.schema = schema;
        this.grid = grid;
        this.type = type;
    }

    public SimpleExpressionImpl(QueryName queryName, SimpleExpressionType type) {
        if (!type.equals(SimpleExpressionType.ROWID)) {
            throw new IllegalArgumentException("Type must be ROWID");
        }
        this.queryName = queryName;
        this.type = type;
    }

    public SimpleExpressionImpl(String text) {
        this.text = text;
    }

    public SimpleExpressionImpl(Number number) {
        this.number = number;
    }

    @Override
    public String toString() {
        String result = "";

        if(queryName!=null) {
            result += queryName + DOT;
        }

        if(schema!=null) {
            result += schema + DOT;
        }

        if(grid!=null) {
            result += grid + DOT;
        }

        if(column!=null) {
            result += column;
        }

        if(type!=null) {
            result += type;
        }

        if(text!=null) {
            result += text;
        }

        if(number!=null) {
            result += number;
        }

        return result;
    }

    public enum SimpleExpressionType {
        NULL,
        ROWID,
        ROWNUM
    }
}
