package com.tempoc.ezrsql4j.impl;

import com.tempoc.ezrsql4j.syntax.FlashbackClause;
import com.tempoc.ezrsql4j.syntax.QueryTableExpression;
import com.tempoc.ezrsql4j.syntax.TAlias;

import static com.tempoc.ezrsql4j.syntax.types.Symbols.*;
import static com.tempoc.ezrsql4j.syntax.types.KeyWords.*;

/**
 *
 * @author tempoc
 */
public class OnlyQueryTableExpressionTableReference extends QueryTableExpressionTableReference{

    public OnlyQueryTableExpressionTableReference(QueryTableExpression queryTableExpression,
                                                  FlashbackClause flashBackClause,
                                                  TAlias t_alias) {
        super(queryTableExpression, flashBackClause, t_alias);
    }

    public OnlyQueryTableExpressionTableReference(QueryTableExpression queryTableExpression,
                                                  TAlias t_alias) {
        super(queryTableExpression, t_alias);
    }

    public OnlyQueryTableExpressionTableReference(QueryTableExpression queryTableExpression,
                                                  FlashbackClause flashBackClause) {
        super(queryTableExpression, flashBackClause);
    }

    public OnlyQueryTableExpressionTableReference(QueryTableExpression queryTableExpression) {
        super(queryTableExpression);
    }

    @Override
    public String toString() {
        String result = ONLY + SP + L_PAREN + queryTableExpression + R_PAREN;
        if (flashBackClause != null) {
            result += SP + flashBackClause;
        }
        if (t_alias != null) {
            result += SP + t_alias;
        }
        return result;
    }
}
