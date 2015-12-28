package com.tempoc.ezrhql;

/**
 * Represents any clause that can be followed by a boolean clause.
 * 
 * (ie: {@code ... WHERE a=b AND ...})
 *
 * @author tempoc
 */
public interface ProducesBooleanClauses {

    /**
     * Produces and AND clause.
     * @param value The left side operand
     * @return An {@link And} clause
     */
    And and(Object value);

    /**
     * Produces and OR clause.
     * @param value The left side operand
     * @return An {@link Or} clause
     */
    Or or(Object value);

}
