package com.tempoc.ezrsql4j.impl;

import com.tempoc.ezrsql4j.syntax.expression.Expression;
import com.tempoc.ezrsql4j.syntax.ExpressionList;
import java.util.List;

import static com.tempoc.ezrsql4j.syntax.types.Symbols.*;

/**
 *
 * @author tempoc
 */
public class ExpressionListImpl implements ExpressionList {
    private List<Expression> expressions;
    private boolean useParenthesis;

    public ExpressionListImpl(List<Expression> expressions) {
        this.expressions = expressions;
    }

    public ExpressionListImpl(List<Expression> expressions,
                              boolean useParenthesis) {
        this.expressions = expressions;
        this.useParenthesis = useParenthesis;
    }

    @Override
    public String toString() {
        String result = "";
        for(Expression e : expressions) {
            if(!result.equals("")) {
                result += COMMA + SP;
            }
            result += e;
        }
        if(useParenthesis) {
            result = L_PAREN + result + R_PAREN;
        }
        return result;
    }

}
