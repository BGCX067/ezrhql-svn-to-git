package com.tempoc.ezrsql4j.impl;

import com.tempoc.ezrsql4j.syntax.expression.Expression;
import com.tempoc.ezrsql4j.syntax.FlashbackClause;
import com.tempoc.ezrsql4j.syntax.types.FlashbackUnit;

import static com.tempoc.ezrsql4j.syntax.types.KeyWords.*;
import static com.tempoc.ezrsql4j.syntax.types.Symbols.*;

/**
 *
 * @author tempoc
 */
public class FlashbackClauseImpl implements FlashbackClause {
    private FlashbackUnit flashbackUnit;
    private Expression expression;

    public FlashbackClauseImpl(FlashbackUnit flashbackUnit,
                               Expression expression) {
        this.flashbackUnit = flashbackUnit;
        this.expression = expression;
    }

    @Override
    public String toString() {
        return AS + SP + OF + SP + flashbackUnit + SP + expression;
    }



}
