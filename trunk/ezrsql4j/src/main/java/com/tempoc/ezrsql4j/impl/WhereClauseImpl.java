package com.tempoc.ezrsql4j.impl;

import com.tempoc.ezrsql4j.syntax.condition.Condition;
import com.tempoc.ezrsql4j.syntax.WhereClause;

import static com.tempoc.ezrsql4j.syntax.types.KeyWords.*;
import static com.tempoc.ezrsql4j.syntax.types.Symbols.*;

/**
 *
 * @author tempoc
 */
public class WhereClauseImpl implements WhereClause {
    private Condition condition;

    public WhereClauseImpl(Condition condition) {
        this.condition = condition;
    }

    @Override
    public String toString() {
        return WHERE + SP + condition;
    }
}
