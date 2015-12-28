package com.tempoc.ezrsql4j.impl;

import com.tempoc.ezrsql4j.syntax.GroupingExpressionList;
import com.tempoc.ezrsql4j.syntax.RollupCubeClause;

import static com.tempoc.ezrsql4j.syntax.types.Symbols.*;

/**
 *
 * @author tempoc
 */
public class RollupCubeClauseImpl implements RollupCubeClause {
    private RollupOrCube rollupOrCube;
    private GroupingExpressionList groupingExpressionList;

    public RollupCubeClauseImpl(RollupOrCube rollupOrCube,
                                GroupingExpressionList groupingExpressionList) {
        this.rollupOrCube = rollupOrCube;
        this.groupingExpressionList = groupingExpressionList;
    }

    @Override
    public String toString() {
        return rollupOrCube + SP + L_PAREN + groupingExpressionList + R_PAREN;
    }
    public enum RollupOrCube {
        ROLLUP,
        CUBE
    }
}
