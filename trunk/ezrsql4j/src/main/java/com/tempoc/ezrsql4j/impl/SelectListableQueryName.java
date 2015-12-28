package com.tempoc.ezrsql4j.impl;

import com.tempoc.ezrsql4j.syntax.QueryName;
import com.tempoc.ezrsql4j.syntax.Schema;
import com.tempoc.ezrsql4j.syntax.helper.Grid;
import com.tempoc.ezrsql4j.syntax.helper.SelectListable;

import static com.tempoc.ezrsql4j.syntax.types.Symbols.*;

/**
 *
 * @author tempoc
 */
public class SelectListableQueryName implements SelectListable, QueryName {
    private Schema schema;
    private Grid grid;

    public SelectListableQueryName(Grid grid) {
        this.grid = grid;
    }

    public SelectListableQueryName(Schema schema, Grid grid) {
        this.schema = schema;
        this.grid = grid;
    }

    @Override
    public String toString() {
        String result = grid.toString() + DOT + ASTERISK;
        if(schema != null) {
            result = schema.toString() + DOT + result;
        }
        return result;
    }
}
