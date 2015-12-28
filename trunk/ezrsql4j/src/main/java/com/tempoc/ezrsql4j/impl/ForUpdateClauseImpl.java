package com.tempoc.ezrsql4j.impl;

import com.tempoc.ezrsql4j.syntax.ForUpdateClause;
import java.util.List;

import static com.tempoc.ezrsql4j.syntax.types.KeyWords.*;
import static com.tempoc.ezrsql4j.syntax.types.Symbols.*;

/**
 *
 * @author tempoc
 */
public class ForUpdateClauseImpl implements ForUpdateClause {
    private List<ForUpdateClauseItem> items;
    private Integer wait;
    private boolean noWait;

    public ForUpdateClauseImpl() {
    }

    public ForUpdateClauseImpl(List<ForUpdateClauseItem> items) {
        this.items = items;
    }

    public ForUpdateClauseImpl(List<ForUpdateClauseItem> items, Integer wait) {
        this.items = items;
        this.wait = wait;
    }

    public ForUpdateClauseImpl(List<ForUpdateClauseItem> items, boolean noWait) {
        this.items = items;
        this.noWait = noWait;
    }

    public ForUpdateClauseImpl(Integer wait) {
        this.wait = wait;
    }

    public ForUpdateClauseImpl(boolean noWait) {
        this.noWait = noWait;
    }

    @Override
    public String toString() {
        String result = FOR + SP + UPDATE;

        if(items!=null && !items.isEmpty()) {
            String listString = "";
            for(ForUpdateClauseItem item : items) {
                if(!listString.equals("")) {
                    listString += COMMA + SP;
                }
                listString += SP + OF + SP + item;
            }
            result += listString;
        }

        if(wait!=null) {
            result += SP + WAIT + wait;
        } else if(noWait) {
            result += SP + NOWAIT;
        }

        return result;
    }



}
