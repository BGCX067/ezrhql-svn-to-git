package com.tempoc.ezrsql4j.impl;

import com.tempoc.ezrsql4j.syntax.ExpressionList;
import com.tempoc.ezrsql4j.syntax.GroupingExpressionList;
import java.util.List;

import static com.tempoc.ezrsql4j.syntax.types.Symbols.*;

/**
 *
 * @author tempoc
 */
public class GroupingExpressionListImpl implements GroupingExpressionList{
    private List<ExpressionList> expressionLists;

    public GroupingExpressionListImpl(List<ExpressionList> expressionLists) {
        this.expressionLists = expressionLists;
    }

    @Override
    public String toString() {
        String result = "";
        for(ExpressionList el : expressionLists) {
            if(!result.equals("")) {
                result += COMMA + SP;
            }
            result += el;
        }
        return result;
    }

}
