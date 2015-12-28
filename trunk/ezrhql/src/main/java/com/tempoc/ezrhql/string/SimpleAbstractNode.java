package com.tempoc.ezrhql.string;

/**
 *
 * @author tempoc
 */
public abstract class SimpleAbstractNode extends AbstractNode {
    private AbstractNode child;

    protected AbstractNode getChild() {
        return child;
    }

    protected void setChild(AbstractNode child) {
        this.child = child;
    }

    @Override
    protected String recursiveRender() {
        String result = toString();
        if(getChild()!=null) {
            result += " " + getChild().recursiveRender();
        }
        return result;
    }
}
