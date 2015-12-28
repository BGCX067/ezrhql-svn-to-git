package com.tempoc.ezrsql4j.impl;

import com.tempoc.ezrsql4j.syntax.GroupingExpressionList;
import com.tempoc.ezrsql4j.syntax.GroupingSetsClause;
import com.tempoc.ezrsql4j.syntax.RollupCubeClause;

import static com.tempoc.ezrsql4j.syntax.types.KeyWords.*;
import static com.tempoc.ezrsql4j.syntax.types.Symbols.*;

/**
 *
 * @author tempoc
 */
public class GroupingSetsClauseImpl implements GroupingSetsClause {
    private RollupCubeClause rollupCubeClause;
    private GroupingExpressionList groupingExpressionList;

    public GroupingSetsClauseImpl(RollupCubeClause rollupCubeClause) {
        this.rollupCubeClause = rollupCubeClause;
    }

    public GroupingSetsClauseImpl(GroupingExpressionList groupingExpressionList) {
        this.groupingExpressionList = groupingExpressionList;
    }

    @Override
    public String toString() {
        String result = GROUPING + SP + SETS + SP + L_PAREN;
        if(rollupCubeClause != null) {
            result += rollupCubeClause;
        } else {
            result += groupingExpressionList;
        }
        result += R_PAREN;
        return result;
    }


}
