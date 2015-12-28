package com.tempoc.ezrsql4j.impl;

import com.tempoc.ezrsql4j.syntax.SampleClause;
import com.tempoc.ezrsql4j.syntax.SamplePercent;

import static com.tempoc.ezrsql4j.syntax.types.KeyWords.*;
import static com.tempoc.ezrsql4j.syntax.types.Symbols.*;

/**
 *
 * @author tempoc
 */
public class SampleClauseImpl implements SampleClause {

    private boolean block;

    private SamplePercent samplePercent;

    /**
     * Constructs without BLOCK (set BLOCK to false)
     * @param samplePercent
     */
    public SampleClauseImpl(SamplePercent samplePercent) {
        this.samplePercent = samplePercent;
    }

    /**
     * Provides the option of specifying to use or not use block
     * @param block Whether BLOCK will be used
     * @param samplePercent
     */
    public SampleClauseImpl(boolean block, SamplePercent samplePercent) {
        this.block = block;
        this.samplePercent = samplePercent;
    }

    @Override
    public String toString() {
        return SAMPLE + (block ? SP + BLOCK : "") + SP + L_PAREN + samplePercent
               + R_PAREN;
    }
}
