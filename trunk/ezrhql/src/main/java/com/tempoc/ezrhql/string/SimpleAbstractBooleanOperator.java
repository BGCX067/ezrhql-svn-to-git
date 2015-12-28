package com.tempoc.ezrhql.string;

import com.tempoc.ezrhql.And;
import com.tempoc.ezrhql.ComparisonClause;
import com.tempoc.ezrhql.Or;

/**
 *
 * @author tempoc
 */
public abstract class SimpleAbstractBooleanOperator extends SimpleAbstractNode implements
    ComparisonClause {
    private final String operator;

    private String value1;

    private String value2;

    SimpleAbstractBooleanOperator(String operator, String value1,
                                         String value2) {
        this.operator = operator;
        this.value1 = value1;
        this.value2 = value2;
    }

    @Override
    public And and(Object value) {
        AndImpl and = new AndImpl(this, (String)value);
        resolveParentForBinaryNode(and);
        return and;
    }

    @Override
    public Or or(Object value) {
        OrImpl or = new OrImpl(this, (String)value);
        resolveParentForBinaryNode(or);
        return or;
    }

    @Override
    public String render() {
        return getRootNode().recursiveRender();
    }

    private void resolveParentForBinaryNode(BinaryAbstractNode ban) throws UnsupportedOperationException {
        ban.setParent(getParent());
        if (getParent() instanceof SimpleAbstractNode) {
            ((SimpleAbstractNode) getParent()).setChild(ban);
        } else if (getParent() instanceof BinaryAbstractNode) {
            BinaryAbstractNode binaryParent = (BinaryAbstractNode) getParent();
            if (binaryParent.getChild1() == this) {
                binaryParent.setChild1(ban);
            } else {
                binaryParent.setChild2(ban);
            }
        } else {
            throw new UnsupportedOperationException("Not supported yet.");
        }
        setParent(ban);
    }

    @Override
    public String toString() {
        return value1 + operator + value2;
    }

}
