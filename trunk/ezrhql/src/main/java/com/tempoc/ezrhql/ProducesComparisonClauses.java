package com.tempoc.ezrhql;

/**
 * Represents any clause that can be followed by a comparison clause.
 *
 * (ie: {@code ... WHERE a=b ...})
 *
 * @author tempoc
 */
public interface ProducesComparisonClauses {

    /**
     * Produces an equals clause ({@code a=b})
     * @param value The left hand operand
     * @return An {@link Equals} clause
     */
    Equals eq(Object value);

    /**
     * Produces a greater-than clause ({@code a>b})
     * @param value The left hand operand
     * @return A {@link GreaterThan} clause
     */
    GreaterThan greaterThan(Object value);

    /**
     * Produces a less-than clause ({@code a<b})
     * @param value The left hand operand
     * @return A {@link LessThan} clause
     */
    LessThan lessThan(Object value);

    /**
     * Produces an is clause ({@code a IS b})
     * @param value The left hand operand
     * @return An {@link Is} clause
     */
    Is is(Object value);
}
