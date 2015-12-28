package com.tempoc.ezrhql.string;

import com.tempoc.ezrhql.And;

/**
 *
 * @author tempoc
 */
public class AndImpl extends BinaryAbstractBooleanClause implements And {

    AndImpl(AbstractNode child1, String value) {
        super(" AND ");
        setChild1(child1);
        setValue(value);
    }

}
