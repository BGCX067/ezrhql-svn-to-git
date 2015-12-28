package com.tempoc.ezrsql4j.impl;

import com.tempoc.ezrsql4j.syntax.ForUpdateClause;
import com.tempoc.ezrsql4j.syntax.Select;
import com.tempoc.ezrsql4j.syntax.Subquery;

import static com.tempoc.ezrsql4j.syntax.types.Symbols.*;

/**
 *
 * @author tempoc
 */
public class SelectImpl implements Select {
    private Subquery subquery;
    private ForUpdateClause forUpdateClause;

    public SelectImpl(Subquery subquery) {
        this.subquery = subquery;
    }

    public ForUpdateClause getForUpdateClause() {
        return forUpdateClause;
    }

    public void setForUpdateClause(ForUpdateClause forUpdateClause) {
        this.forUpdateClause = forUpdateClause;
    }

    public Subquery getSubquery() {
        return subquery;
    }

    public void setSubquery(Subquery subquery) {
        this.subquery = subquery;
    }

    @Override
    public String toString() {
        String result = subquery.toString();
        if(forUpdateClause != null) {
            result += SP + forUpdateClause + SP;
        }
        return result + SEMICOLON;
    }


}
