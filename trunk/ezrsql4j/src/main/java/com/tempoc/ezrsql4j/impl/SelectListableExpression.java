package com.tempoc.ezrsql4j.impl;

import com.tempoc.ezrsql4j.syntax.CAlias;
import com.tempoc.ezrsql4j.syntax.expression.Expression;
import com.tempoc.ezrsql4j.syntax.helper.SelectListable;

import static com.tempoc.ezrsql4j.syntax.types.KeyWords.*;
import static com.tempoc.ezrsql4j.syntax.types.Symbols.*;

/**
 *
 * @author tempoc
 */
public class SelectListableExpression implements SelectListable {
    private Expression expression;
    private CAlias c_alias;

    public SelectListableExpression(Expression expr) {
        this.expression = expr;
    }

    public SelectListableExpression(Expression expr, CAlias c_alias) {
        this.expression = expr;
        this.c_alias = c_alias;
    }

    @Override
    public String toString() {
        String result = expression.toString();
        if(c_alias != null) {
            result += SP + AS + SP + c_alias;
        }
        return result;
    }
}
