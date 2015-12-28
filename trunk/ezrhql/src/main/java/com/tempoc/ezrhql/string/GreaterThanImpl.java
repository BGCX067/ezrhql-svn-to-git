package com.tempoc.ezrhql.string;

import com.tempoc.ezrhql.GreaterThan;

/**
 *
 * @author tempoc
 */
public class GreaterThanImpl extends SimpleAbstractBooleanOperator implements GreaterThan{

    GreaterThanImpl(String value1, String value2) {
        super(">", value1, value2);
    }
}
