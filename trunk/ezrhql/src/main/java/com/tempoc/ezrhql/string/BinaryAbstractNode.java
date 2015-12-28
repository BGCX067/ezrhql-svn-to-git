package com.tempoc.ezrhql.string;

/**
 *
 * @author tempoc
 */
public abstract class BinaryAbstractNode extends AbstractNode {
    private String operator;
    private AbstractNode child1;
    private AbstractNode child2;

    protected BinaryAbstractNode(String operator) {
        this.operator = operator;
    }

    protected String getOperator() {
        return operator;
    }

    protected void setOperator(String operator) {
        this.operator = operator;
    }

    protected AbstractNode getChild1() {
        return child1;
    }

    protected void setChild1(AbstractNode child1) {
        this.child1 = child1;
    }

    protected AbstractNode getChild2() {
        return child2;
    }

    protected void setChild2(AbstractNode child2) {
        this.child2 = child2;
    }

    @Override
    protected String recursiveRender() {
        return getChild1().recursiveRender() + getOperator() + getChild2().recursiveRender();
    }
}
