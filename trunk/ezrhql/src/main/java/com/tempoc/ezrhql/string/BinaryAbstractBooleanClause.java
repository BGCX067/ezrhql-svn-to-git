package com.tempoc.ezrhql.string;

import com.tempoc.ezrhql.BooleanClause;
import com.tempoc.ezrhql.Equals;
import com.tempoc.ezrhql.GreaterThan;
import com.tempoc.ezrhql.Is;
import com.tempoc.ezrhql.LessThan;

/**
 *
 * @author tempoc
 */
public abstract class BinaryAbstractBooleanClause extends BinaryAbstractNode
    implements BooleanClause{
    private String value;

    BinaryAbstractBooleanClause(String operator) {
        super(operator);
    }

    void setValue(String value) {
        this.value = value;
    }

    @Override
    public Equals eq(Object value) {
        EqualsImpl eq = new EqualsImpl(this.value, (String)value);
        eq.setParent(this);
        setChild2(eq);
        return eq;
    }

    @Override
    public LessThan lessThan(Object value) {
        LessThanImpl lt = new LessThanImpl(this.value, (String)value);
        lt.setParent(this);
        setChild2(lt);
        return lt;
    }

    @Override
    public GreaterThan greaterThan(Object value) {
        GreaterThanImpl gt = new GreaterThanImpl(this.value, (String)value);
        gt.setParent(this);
        setChild2(gt);
        return gt;
    }

    @Override
    public Is is(Object value) {
        IsImpl is = new IsImpl(this.value, (String) value);
        is.setParent(this);
        setChild2(is);
        return is;
    }
}
