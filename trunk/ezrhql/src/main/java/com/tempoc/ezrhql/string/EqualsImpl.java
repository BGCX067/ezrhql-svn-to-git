package com.tempoc.ezrhql.string;

import com.tempoc.ezrhql.Equals;

/**
 *
 * @author tempoc
 */
public class EqualsImpl extends SimpleAbstractBooleanOperator implements Equals {

    EqualsImpl(String value1, String value2) {
        super("=", value1, value2);
    }
}
