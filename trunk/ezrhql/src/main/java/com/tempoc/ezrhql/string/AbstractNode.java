package com.tempoc.ezrhql.string;

/**
 *
 * @author tempoc
 */
public abstract class AbstractNode {
    private AbstractNode parent;

    protected AbstractNode getParent() {
        return parent;
    }

    protected void setParent(AbstractNode parent) {
        this.parent = parent;
    }

    protected AbstractNode getRootNode() {
        AbstractNode root = this;
        while(root.getParent()!=null) {
            root = root.getParent();
        }
        return root;
    }

    protected abstract String recursiveRender();
}
