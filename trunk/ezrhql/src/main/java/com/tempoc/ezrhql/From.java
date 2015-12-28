package com.tempoc.ezrhql;

/**
 * Represents the FROM clause
 *
 * @author tempoc
 */
public interface From extends Renderable {

    /**
     * Returns a where clause that starts with
     * the value provided.
     *
     * For the query
     * {@code SELECT * FROM Cat WHERE name='John'}
     * run
     * {@code ... .where("name"). ...}
     *
     * @param value The first value to be evaluated
     *              after the {@code WHERE} keyword.
     * @return A {@link Where} clause beginning with {@code value}.
     */
    Where where(Object value);
}
