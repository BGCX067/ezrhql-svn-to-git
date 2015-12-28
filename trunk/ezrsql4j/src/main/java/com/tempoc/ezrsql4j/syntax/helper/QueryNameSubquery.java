package com.tempoc.ezrsql4j.syntax.helper;

import com.tempoc.ezrsql4j.syntax.QueryName;
import com.tempoc.ezrsql4j.syntax.Subquery;

import static com.tempoc.ezrsql4j.syntax.types.KeyWords.*;
import static com.tempoc.ezrsql4j.syntax.types.Symbols.*;

/**
 *
 * @author tempoc
 */
public class QueryNameSubquery {
    private QueryName queryName;
    private Subquery subquery;

    public QueryNameSubquery(QueryName queryName, Subquery subquery) {
        this.queryName = queryName;
        this.subquery = subquery;
    }

    @Override
    public String toString() {
        return queryName + SP + AS + SP + L_PAREN + subquery + R_PAREN;
    }
}
