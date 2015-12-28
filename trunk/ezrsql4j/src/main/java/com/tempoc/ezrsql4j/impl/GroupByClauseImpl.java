package com.tempoc.ezrsql4j.impl;

import com.tempoc.ezrsql4j.syntax.condition.Condition;
import com.tempoc.ezrsql4j.syntax.GroupByClause;
import com.tempoc.ezrsql4j.syntax.helper.GroupByItem;
import java.util.List;

import static com.tempoc.ezrsql4j.syntax.types.KeyWords.*;
import static com.tempoc.ezrsql4j.syntax.types.Symbols.*;

/**
 *
 * @author tempoc
 */
public class GroupByClauseImpl implements GroupByClause {
    private List<GroupByItem> groupByItems;
    private Condition condition;

    public GroupByClauseImpl(List<GroupByItem> groupByItems) {
        this.groupByItems = groupByItems;
    }

    public GroupByClauseImpl(List<GroupByItem> groupByItems, Condition condition) {
        this.groupByItems = groupByItems;
        this.condition = condition;
    }

    @Override
    public String toString() {
        String result = GROUP + SP + BY + SP;
        String listString = "";
        for(GroupByItem item : groupByItems) {
            if(!listString.equals("")) {
                listString += COMMA + SP;
            }
            listString += item;
        }
        result += listString;
        if(condition!=null) {
            result += SP + HAVING + SP + condition;
        }
        return result;
    }

}
