package com.tempoc.ezrsql4j.impl;

import com.tempoc.ezrsql4j.syntax.Constraint;
import com.tempoc.ezrsql4j.syntax.SubqueryRestrictionClause;
import com.tempoc.ezrsql4j.syntax.types.SubqueryRestrictionClauseType;

import static com.tempoc.ezrsql4j.syntax.types.KeyWords.*;
import static com.tempoc.ezrsql4j.syntax.types.Symbols.*;

/**
 *
 * @author tempoc
 */
public class SubqueryRestrictionClauseImpl implements SubqueryRestrictionClause {
    private SubqueryRestrictionClauseType type;
    private Constraint constraint;

    public SubqueryRestrictionClauseImpl(SubqueryRestrictionClauseType type) {
        this.type = type;
    }

    /**
     * By specifying a constraint the CHECK OPTION type is implicitly used.
     * @param constraint
     */
    public SubqueryRestrictionClauseImpl(Constraint constraint) {
        this.type = SubqueryRestrictionClauseType.CHECK_OPTION;
        this.constraint = constraint;
    }

    @Override
    public String toString() {
        String result = WITH.toString() + SP;

        switch(type) {
            case READ_ONLY:
                result += READ + SP + ONLY;
                break;
            default:
                result += CHECK + SP + OPTION;
                if(constraint!=null) {
                    result += SP + CONSTRAINT + constraint;
                }
        }

        return result;
    }



}
