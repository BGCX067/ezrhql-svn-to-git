package com.tempoc.ezrsql4j.impl;

import com.tempoc.ezrsql4j.syntax.FlashbackClause;
import com.tempoc.ezrsql4j.syntax.QueryTableExpression;
import com.tempoc.ezrsql4j.syntax.TAlias;
import com.tempoc.ezrsql4j.syntax.TableReference;

import static com.tempoc.ezrsql4j.syntax.types.Symbols.*;

/**
 *
 * @author tempoc
 */
public class QueryTableExpressionTableReference implements TableReference {
    protected QueryTableExpression queryTableExpression;
    protected FlashbackClause flashBackClause;
    protected TAlias t_alias;

    public QueryTableExpressionTableReference(QueryTableExpression queryTableExpression) {
        this.queryTableExpression = queryTableExpression;
    }

    public QueryTableExpressionTableReference(QueryTableExpression queryTableExpression,
                                              FlashbackClause flashBackClause) {
        this.queryTableExpression = queryTableExpression;
        this.flashBackClause = flashBackClause;
    }

    public QueryTableExpressionTableReference(QueryTableExpression queryTableExpression,
                                              TAlias t_alias) {
        this.queryTableExpression = queryTableExpression;
        this.t_alias = t_alias;
    }

    public QueryTableExpressionTableReference(QueryTableExpression queryTableExpression,
                                              FlashbackClause flashBackClause,
                                              TAlias t_alias) {
        this.queryTableExpression = queryTableExpression;
        this.flashBackClause = flashBackClause;
        this.t_alias = t_alias;
    }

    @Override
    public String toString() {
        String result = queryTableExpression.toString();
        if(flashBackClause!=null) {
            result += SP + flashBackClause;
        }
        if(t_alias!=null) {
            result += SP + t_alias;
        }
        return result;
    }

    

}
