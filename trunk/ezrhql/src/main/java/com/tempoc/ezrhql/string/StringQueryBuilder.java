package com.tempoc.ezrhql.string;

import com.tempoc.ezrhql.QueryBuilder;
import com.tempoc.ezrhql.Select;

/**
 *
 * @author tempoc
 */
public class StringQueryBuilder implements QueryBuilder {

    @Override
    public Select select(Object what) {
        return new SelectImpl((String) what);
    }
}
