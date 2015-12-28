package com.tempoc.ezrsql4j.impl;

import com.tempoc.ezrsql4j.syntax.condition.Condition;
import com.tempoc.ezrsql4j.syntax.GroupByClause;
import com.tempoc.ezrsql4j.syntax.HierarchicalQueryClause;
import com.tempoc.ezrsql4j.syntax.Hint;
import com.tempoc.ezrsql4j.syntax.OrderByClause;
import com.tempoc.ezrsql4j.syntax.SelectList;
import com.tempoc.ezrsql4j.syntax.Subquery;
import com.tempoc.ezrsql4j.syntax.SubqueryFactoringClause;
import com.tempoc.ezrsql4j.syntax.TableReference;
import com.tempoc.ezrsql4j.syntax.WhereClause;
import com.tempoc.ezrsql4j.syntax.types.DuplicateHandlingMethod;
import com.tempoc.ezrsql4j.syntax.types.SetOperation;
import java.util.List;

import static com.tempoc.ezrsql4j.syntax.types.KeyWords.*;
import static com.tempoc.ezrsql4j.syntax.types.Symbols.*;

/**
 *
 * @author tempoc
 */
public class SubqueryImpl implements Subquery {
    private SubqueryFactoringClause subqueryFactoringClause;
    private Hint hint;
    private DuplicateHandlingMethod duplicateHandlingMethod;
    private SelectList selectList;
    private List<TableReference> tableReferences;
    private WhereClause whereClause;
    private HierarchicalQueryClause hierarchicalQueryClause;
    private GroupByClause groupByClause;
    private Condition condition;
    private SetOperation setOperation;
    private Subquery subquery;
    private OrderByClause orderByClause;

    public SubqueryImpl(SelectList selectList,
                        List<TableReference> tableReferences) {
        this.selectList = selectList;
        this.tableReferences = tableReferences;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public DuplicateHandlingMethod getDuplicateHandlingMethod() {
        return duplicateHandlingMethod;
    }

    public void setDuplicateHandlingMethod(DuplicateHandlingMethod duplicateHandlingMethod) {
        this.duplicateHandlingMethod = duplicateHandlingMethod;
    }

    public GroupByClause getGroupByClause() {
        return groupByClause;
    }

    public void setGroupByClause(GroupByClause groupByClause) {
        this.groupByClause = groupByClause;
    }

    public HierarchicalQueryClause getHierarchicalQueryClause() {
        return hierarchicalQueryClause;
    }

    public void setHierarchicalQueryClause(HierarchicalQueryClause hierarchicalQueryClause) {
        this.hierarchicalQueryClause = hierarchicalQueryClause;
    }

    public Hint getHint() {
        return hint;
    }

    public void setHint(Hint hint) {
        this.hint = hint;
    }

    public OrderByClause getOrderByClause() {
        return orderByClause;
    }

    public void setOrderByClause(OrderByClause orderByClause) {
        this.orderByClause = orderByClause;
    }

    public SelectList getSelectList() {
        return selectList;
    }

    public void setSelectList(SelectList selectList) {
        this.selectList = selectList;
    }

    public SetOperation getSetOperation() {
        return setOperation;
    }

    public void setSetOperation(SetOperation setOperation) {
        this.setOperation = setOperation;
    }

    public Subquery getSubquery() {
        return subquery;
    }

    public void setSubquery(Subquery subquery) {
        this.subquery = subquery;
    }

    public SubqueryFactoringClause getSubqueryFactoringClause() {
        return subqueryFactoringClause;
    }

    public void setSubqueryFactoringClause(SubqueryFactoringClause subqueryFactoringClause) {
        this.subqueryFactoringClause = subqueryFactoringClause;
    }

    public List<TableReference> getTableReferences() {
        return tableReferences;
    }

    public void setTableReferences(List<TableReference> tableReferences) {
        this.tableReferences = tableReferences;
    }

    public WhereClause getWhereClause() {
        return whereClause;
    }

    public void setWhereClause(WhereClause whereClause) {
        this.whereClause = whereClause;
    }

    @Override
    public String toString() {
        String result = "";
        result = spacePrepend(result, subqueryFactoringClause) + result;
        result += SELECT;
        result += spaceAppend(hint);
        result += spaceAppend(duplicateHandlingMethod);
        result += SP + selectList + SP + FROM;
        int i = 0;
        for(TableReference tr : tableReferences) {
            if(i > 0) {
                result += COMMA;
            }
            result += SP + tr;
            i++;
        }
        result += spaceAppend(whereClause);
        result += spaceAppend(hierarchicalQueryClause);
        result += spaceAppend(groupByClause);
        if(condition!=null) {
            result += SP + HAVING + SP + condition;
        }
        if(subquery!=null) {
            result += SP + setOperation + SP + L_PAREN + subquery + R_PAREN;
        }
        result += spaceAppend(orderByClause);
        return result;
    }

    private String spaceAppend(Object appendage) {
        if(appendage != null) {
            return SP + appendage;
        }
        return "";
    }

    private String spacePrepend(String original, Object appendage) {
        if(appendage != null) {
            return appendage + SP;
        }
        return "";
    }

}
