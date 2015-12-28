package com.tempoc.ezrhql.string;

import com.tempoc.ezrhql.Or;

/**
 *
 * @author tempoc
 */
public class OrImpl extends BinaryAbstractBooleanClause implements Or {

    OrImpl(AbstractNode child1, String value) {
        super(" OR ");
        setChild1(child1);
        setValue(value);
    }
}
