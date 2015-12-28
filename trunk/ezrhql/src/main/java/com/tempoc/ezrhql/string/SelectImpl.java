package com.tempoc.ezrhql.string;

import com.tempoc.ezrhql.From;
import com.tempoc.ezrhql.Renderable;
import com.tempoc.ezrhql.Select;

/**
 *
 * @author tempoc
 */
public class SelectImpl extends SimpleAbstractNode implements Select, Renderable {
    private String value;

    SelectImpl(String value) {
        this.value = value;
    }

    @Override
    public From from(Object value) {
        FromImpl result = new FromImpl((String)value);
        result.setParent(this);
        setChild(result);
        return result;
    }

    @Override
    public String toString() {
        return "SELECT " + value;
    }

    @Override
    public String render() {
        return getRootNode().recursiveRender();
    }


}
