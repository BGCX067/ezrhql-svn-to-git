package com.tempoc.ezrsql4j.impl;

import com.tempoc.ezrsql4j.syntax.OrderByClause;
import com.tempoc.ezrsql4j.syntax.OrderByItem;
import java.util.List;

import static com.tempoc.ezrsql4j.syntax.types.KeyWords.*;
import static com.tempoc.ezrsql4j.syntax.types.Symbols.*;

/**
 *
 * @author tempoc
 */
public class OrderByClauseImpl implements OrderByClause {
    private boolean siblings;
    private List<OrderByItem> orderByItems;

    public OrderByClauseImpl(List<OrderByItem> orderByItems) {
        this.orderByItems = orderByItems;
    }

    public OrderByClauseImpl(boolean siblings,
                             List<OrderByItem> orderByItems) {
        this.siblings = siblings;
        this.orderByItems = orderByItems;
    }

    @Override
    public String toString() {
        String result = ORDER + SP;
        if(siblings) {
            result += siblings + SP;
        }
        result += BY + SP;

        String listString = "";
        for(OrderByItem item : orderByItems) {
            if(!listString.equals("")) {
                listString += COMMA + SP;
            }
            listString += item;
        }
        
        return result + listString;
    }


}
