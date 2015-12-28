package com.tempoc.ezrhql.string;

import com.tempoc.ezrhql.From;
import com.tempoc.ezrhql.Renderable;
import com.tempoc.ezrhql.Where;

/**
 *
 * @author tempoc
 */
public class FromImpl extends SimpleAbstractNode implements From, Renderable {
    private String value;

    FromImpl(String value) {
        this.value = value;
    }

    @Override
    public Where where(Object value) {
        WhereImpl result = new WhereImpl((String)value);
        result.setParent(this);
        setChild(result);
        return result;
    }

    @Override
    public String render() {
        return getRootNode().recursiveRender();
    }

    @Override
    public String toString() {
        return "FROM " + value;
    }

}
