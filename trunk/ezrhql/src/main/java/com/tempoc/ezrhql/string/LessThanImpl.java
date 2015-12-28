package com.tempoc.ezrhql.string;

import com.tempoc.ezrhql.LessThan;

/**
 *
 * @author tempoc
 */
public class LessThanImpl extends SimpleAbstractBooleanOperator implements LessThan {

    LessThanImpl(String value1, String value2) {
        super("<", value1, value2);
    }

}
