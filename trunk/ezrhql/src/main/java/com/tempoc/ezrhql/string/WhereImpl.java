package com.tempoc.ezrhql.string;

import com.tempoc.ezrhql.Equals;
import com.tempoc.ezrhql.GreaterThan;
import com.tempoc.ezrhql.Is;
import com.tempoc.ezrhql.LessThan;
import com.tempoc.ezrhql.Where;

/**
 *
 * @author tempoc
 */
public class WhereImpl extends SimpleAbstractNode implements Where {

    private String value;

    WhereImpl(String value) {
        this.value = value;
    }

    @Override
    public Equals eq(Object value) {
        EqualsImpl eq = new EqualsImpl(this.value, (String)value);
        eq.setParent(this);
        setChild(eq);
        return eq;
    }

    @Override
    public GreaterThan greaterThan(Object value) {
        GreaterThanImpl gt = new GreaterThanImpl(this.value, (String) value);
        gt.setParent(this);
        setChild(gt);
        return gt;
    }

    @Override
    public LessThan lessThan(Object value) {
        LessThanImpl lt = new LessThanImpl(this.value, (String) value);
        lt.setParent(this);
        setChild(lt);
        return lt;
    }

    @Override
    public Is is(Object value) {
        IsImpl is = new IsImpl(this.value, (String) value);
        is.setParent(this);
        setChild(is);
        return is;
    }

    @Override
    public String toString() {
        return "WHERE";
    }

}
