package com.tempoc.ezrsql4j.impl;

import com.tempoc.ezrsql4j.syntax.condition.Condition;
import com.tempoc.ezrsql4j.syntax.HierarchicalQueryClause;

import static com.tempoc.ezrsql4j.syntax.types.KeyWords.*;
import static com.tempoc.ezrsql4j.syntax.types.Symbols.*;

/**
 *
 * @author tempoc
 */
public class HierarchicalQueryClauseImpl implements HierarchicalQueryClause {
    private Condition startCondition;
    private Condition connectCondition;

    public HierarchicalQueryClauseImpl(Condition connectCondition) {
        this.connectCondition = connectCondition;
    }

    public HierarchicalQueryClauseImpl(Condition startCondition,
                                       Condition connectCondition) {
        this.startCondition = startCondition;
        this.connectCondition = connectCondition;
    }

    @Override
    public String toString() {
        String result = CONNECT + SP + BY + connectCondition;
        if(startCondition != null) {
            result = START + SP + WITH + startCondition + SP + result;
        }
        return result;
    }


}
