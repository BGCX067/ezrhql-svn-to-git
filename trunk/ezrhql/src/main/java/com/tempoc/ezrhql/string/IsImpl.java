package com.tempoc.ezrhql.string;

import com.tempoc.ezrhql.Is;

/**
 * String implementation of the IS clause
 *
 * @author tempoc
 */
public class IsImpl extends SimpleAbstractBooleanOperator implements Is {

    public IsImpl(String value1, String value2) {
        super(" IS ", value1, value2);
    }
}
