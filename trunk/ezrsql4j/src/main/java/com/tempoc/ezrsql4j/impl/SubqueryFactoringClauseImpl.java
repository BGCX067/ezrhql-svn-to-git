package com.tempoc.ezrsql4j.impl;

import com.tempoc.ezrsql4j.syntax.SubqueryFactoringClause;
import com.tempoc.ezrsql4j.syntax.helper.QueryNameSubquery;
import java.util.List;

import static com.tempoc.ezrsql4j.syntax.types.Symbols.*;

/**
 *
 * @author tempoc
 */
public class SubqueryFactoringClauseImpl implements SubqueryFactoringClause {
    private List<QueryNameSubquery> queryNameSubqueries;

    public SubqueryFactoringClauseImpl(List<QueryNameSubquery> queryNameSubqueries) {
        this.queryNameSubqueries = queryNameSubqueries;
    }

    @Override
    public String toString() {
        String result = "";
        for(QueryNameSubquery qns : queryNameSubqueries) {
            if(!result.equals("")) {
                result += COMMA + SP;
            }
            result += qns;
        }
        return super.toString();
    }
}
