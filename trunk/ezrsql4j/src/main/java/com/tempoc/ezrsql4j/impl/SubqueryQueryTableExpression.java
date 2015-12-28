package com.tempoc.ezrsql4j.impl;

import com.tempoc.ezrsql4j.syntax.QueryTableExpression;
import com.tempoc.ezrsql4j.syntax.Subquery;
import com.tempoc.ezrsql4j.syntax.SubqueryRestrictionClause;

import static com.tempoc.ezrsql4j.syntax.types.Symbols.*;

/**
 *
 * @author tempoc
 */
public class SubqueryQueryTableExpression implements QueryTableExpression {
    private Subquery subquery;
    private SubqueryRestrictionClause restrictionClause;

    public SubqueryQueryTableExpression(Subquery subquery) {
        this.subquery = subquery;
    }

    public SubqueryQueryTableExpression(Subquery subquery,
                                        SubqueryRestrictionClause restrictionClause) {
        this.subquery = subquery;
        this.restrictionClause = restrictionClause;
    }

    @Override
    public String toString() {
        String result = L_PAREN + subquery.toString();
        if(restrictionClause!=null) {
            result += restrictionClause + SP;
        }
        result += R_PAREN;
        return result;
    }


}
