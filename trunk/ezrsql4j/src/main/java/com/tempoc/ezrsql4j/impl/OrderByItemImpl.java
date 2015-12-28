package com.tempoc.ezrsql4j.impl;

import com.tempoc.ezrsql4j.syntax.CAlias;
import com.tempoc.ezrsql4j.syntax.expression.Expression;
import com.tempoc.ezrsql4j.syntax.OrderByItem;
import com.tempoc.ezrsql4j.syntax.Position;
import com.tempoc.ezrsql4j.syntax.types.NullsWhatType;
import com.tempoc.ezrsql4j.syntax.types.OrderDirection;

import static com.tempoc.ezrsql4j.syntax.types.KeyWords.*;
import static com.tempoc.ezrsql4j.syntax.types.Symbols.*;

/**
 *
 * @author tempoc
 */
public class OrderByItemImpl implements OrderByItem {
    private Expression expression;
    private Position position;
    private CAlias cAlias;
    private OrderDirection direction;
    private NullsWhatType nullsWhat;

    public OrderByItemImpl(Expression expression) {
        this.expression = expression;
    }

    public OrderByItemImpl(Position position) {
        this.position = position;
    }

    public OrderByItemImpl(CAlias cAlias) {
        this.cAlias = cAlias;
    }

    public OrderByItemImpl(Expression expression, OrderDirection direction) {
        this.expression = expression;
        this.direction = direction;
    }

    public OrderByItemImpl(Expression expression, NullsWhatType nullsWhat) {
        this.expression = expression;
        this.nullsWhat = nullsWhat;
    }

    public OrderByItemImpl(Expression expression, OrderDirection direction,
                           NullsWhatType nullsWhat) {
        this.expression = expression;
        this.direction = direction;
        this.nullsWhat = nullsWhat;
    }

    public OrderByItemImpl(Position position, OrderDirection direction) {
        this.position = position;
        this.direction = direction;
    }

    public OrderByItemImpl(Position position, NullsWhatType nullsWhat) {
        this.position = position;
        this.nullsWhat = nullsWhat;
    }

    public OrderByItemImpl(Position position, OrderDirection direction,
                           NullsWhatType nullsWhat) {
        this.position = position;
        this.direction = direction;
        this.nullsWhat = nullsWhat;
    }

    public OrderByItemImpl(CAlias cAlias, OrderDirection direction) {
        this.cAlias = cAlias;
        this.direction = direction;
    }

    public OrderByItemImpl(CAlias cAlias, NullsWhatType nullsWhat) {
        this.cAlias = cAlias;
        this.nullsWhat = nullsWhat;
    }

    public OrderByItemImpl(CAlias cAlias, OrderDirection direction,
                           NullsWhatType nullsWhat) {
        this.cAlias = cAlias;
        this.direction = direction;
        this.nullsWhat = nullsWhat;
    }

    @Override
    public String toString() {
        String result = "";
        if(expression!=null) {
            result += expression;
        } else if(position!=null) {
            result += position;
        } else if(cAlias!=null) {
            result += cAlias;
        }

        if(direction!=null) {
            result += SP + direction;
        }
        if(nullsWhat!=null) {
            result += SP + NULLS + SP + nullsWhat;
        }

        return result;
    }


}
