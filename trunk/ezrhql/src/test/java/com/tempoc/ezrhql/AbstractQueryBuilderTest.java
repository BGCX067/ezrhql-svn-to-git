package com.tempoc.ezrhql;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Extend this class to test an implementation of a query builder.
 *
 * @author tempoc
 */
public abstract class AbstractQueryBuilderTest {

    private QueryBuilder qb;

    public AbstractQueryBuilderTest(QueryBuilder qb) {
        this.qb = qb;
    }

    @Test
    public void testSelectFrom() {
        final String result0 = "SELECT * FROM Person p";
        String q0 = qb.select("*").from("Person p").render();
        Assert.assertEquals(result0, q0);
    }

    @Test
    public void testSelectFromWhereEquals() {
        final String result0 = "SELECT * FROM Person p WHERE p.name=\'Gabriel\'";
        String q0 =
               qb.select("*").from("Person p").where("p.name").eq("\'Gabriel\'").render();
        Assert.assertEquals(result0, q0);
    }

    @Test
    public void testSelectFromWhereEqualsAndEquals() {
        final String result0 =
                     "SELECT * FROM Person p WHERE p.name=\'Gabriel\' AND p.age=27";
        String q0 =
               qb.select("*").from("Person p").where("p.name").eq("\'Gabriel\'").and(
            "p.age").eq("27").render();
        Assert.assertEquals(result0, q0);
    }

    @Test
    public void testSelectFromWhereEqualsAndEqualsAndEquals() {
        final String result0 =
                     "SELECT * FROM Person p WHERE p.name=\'Gabriel\' AND p.age=27 AND p.lastName=\'Rodriguez\'";
        String q0 =
               qb.select("*").from("Person p").where("p.name").eq("\'Gabriel\'").and(
            "p.age").eq("27").and("p.lastName").eq("\'Rodriguez\'").render();
        Assert.assertEquals(result0, q0);
    }

    @Test
    public void testSelectFromWhereEqualsAndEqualsOrEquals() {
        final String result0 =
                     "SELECT * FROM Person p WHERE p.name=\'Gabriel\' AND p.age=27 OR p.lastName=\'Rodriguez\'";
        String q0 =
               qb.select("*").from("Person p").where("p.name").eq("\'Gabriel\'").and(
            "p.age").eq("27").or("p.lastName").eq("\'Rodriguez\'").render();
        Assert.assertEquals(result0, q0);
    }

    @Test
    public void testSelectFromWhereEqualsAndGreaterThan() {
        final String result0 =
                     "SELECT * FROM Person p WHERE p.name=\'Gabriel\' AND p.age>27";
        String q0 =
               qb.select("*").from("Person p").where("p.name").eq("\'Gabriel\'").and(
            "p.age").greaterThan("27").render();
        Assert.assertEquals(result0, q0);
    }

    @Test
    public void testSelectFromWhereEqualsAndGreaterThanAndEquals() {
        final String result0 =
                     "SELECT * FROM Person p WHERE p.name=\'Gabriel\' AND p.age>27 AND p.lastName=\'Rodriguez\'";
        String q0 =
               qb.select("*").from("Person p").where("p.name").eq("\'Gabriel\'").and(
            "p.age").greaterThan("27").and("p.lastName").eq("\'Rodriguez\'").render();
        Assert.assertEquals(result0, q0);
    }

    @Test
    public void testSelectFromWhereEqualsAndGreaterThanOrEquals() {
        final String result0 =
                     "SELECT * FROM Person p WHERE p.name=\'Gabriel\' AND p.age>27 OR p.lastName=\'Rodriguez\'";
        String q0 =
               qb.select("*").from("Person p").where("p.name").eq("\'Gabriel\'").and(
            "p.age").greaterThan("27").or("p.lastName").eq("\'Rodriguez\'").render();
        Assert.assertEquals(result0, q0);
    }

    @Test
    public void testSelectFromWhereEqualsAndLessThan() {
        final String result0 =
                     "SELECT * FROM Person p WHERE p.name=\'Gabriel\' AND p.age<27";
        String q0 =
               qb.select("*").from("Person p").where("p.name").eq("\'Gabriel\'").and(
            "p.age").lessThan("27").render();
        Assert.assertEquals(result0, q0);
    }

    @Test
    public void testSelectFromWhereEqualsAndLessThanAndEquals() {
        final String result0 =
                     "SELECT * FROM Person p WHERE p.name=\'Gabriel\' AND p.age<27 AND p.lastName=\'Rodriguez\'";
        String q0 =
               qb.select("*").from("Person p").where("p.name").eq("\'Gabriel\'").and(
            "p.age").lessThan("27").and("p.lastName").eq("\'Rodriguez\'").render();
        Assert.assertEquals(result0, q0);
    }

    @Test
    public void testSelectFromWhereEqualsAndLessThanOrEquals() {
        final String result0 =
                     "SELECT * FROM Person p WHERE p.name=\'Gabriel\' AND p.age<27 OR p.lastName=\'Rodriguez\'";
        String q0 =
               qb.select("*").from("Person p").where("p.name").eq("\'Gabriel\'").and(
            "p.age").lessThan("27").or("p.lastName").eq("\'Rodriguez\'").render();
        Assert.assertEquals(result0, q0);
    }

    @Test
    public void testSelectFromWhereEqualsOrEquals() {
        final String result0 =
                     "SELECT * FROM Person p WHERE p.name=\'Gabriel\' OR p.age=27";
        String q0 =
               qb.select("*").from("Person p").where("p.name").eq("\'Gabriel\'").or(
            "p.age").eq("27").render();
        Assert.assertEquals(result0, q0);
    }

    @Test
    public void testSelectFromWhereEqualsOrEqualsAndEquals() {
        final String result0 =
                     "SELECT * FROM Person p WHERE p.name=\'Gabriel\' OR p.age=27 AND p.lastName=\'Rodriguez\'";
        String q0 =
               qb.select("*").from("Person p").where("p.name").eq("\'Gabriel\'").or(
            "p.age").eq("27").and("p.lastName").eq("\'Rodriguez\'").render();
        Assert.assertEquals(result0, q0);
    }

    @Test
    public void testSelectFromWhereEqualsOrEqualsOrEquals() {
        final String result0 =
                     "SELECT * FROM Person p WHERE p.name=\'Gabriel\' OR p.age=27 OR p.lastName=\'Rodriguez\'";
        String q0 =
               qb.select("*").from("Person p").where("p.name").eq("\'Gabriel\'").or(
            "p.age").eq("27").or("p.lastName").eq("\'Rodriguez\'").render();
        Assert.assertEquals(result0, q0);
    }

    @Test
    public void testSelectFromWhereEqualsOrGreaterThan() {
        final String result0 =
                     "SELECT * FROM Person p WHERE p.name=\'Gabriel\' OR p.age>27";
        String q0 =
               qb.select("*").from("Person p").where("p.name").eq("\'Gabriel\'").or(
            "p.age").greaterThan("27").render();
        Assert.assertEquals(result0, q0);
    }

    @Test
    public void testSelectFromWhereEqualsOrGreaterThanAndEquals() {
        final String result0 =
                     "SELECT * FROM Person p WHERE p.name=\'Gabriel\' OR p.age>27 AND p.lastName=\'Rodriguez\'";
        String q0 =
               qb.select("*").from("Person p").where("p.name").eq("\'Gabriel\'").or(
            "p.age").greaterThan("27").and("p.lastName").eq("\'Rodriguez\'").render();
        Assert.assertEquals(result0, q0);
    }

    @Test
    public void testSelectFromWhereEqualsOrGreaterThanOrEquals() {
        final String result0 =
                     "SELECT * FROM Person p WHERE p.name=\'Gabriel\' OR p.age>27 OR p.lastName=\'Rodriguez\'";
        String q0 =
               qb.select("*").from("Person p").where("p.name").eq("\'Gabriel\'").or(
            "p.age").greaterThan("27").or("p.lastName").eq("\'Rodriguez\'").render();
        Assert.assertEquals(result0, q0);
    }

    @Test
    public void testSelectFromWhereEqualsOrLessThan() {
        final String result0 =
                     "SELECT * FROM Person p WHERE p.name=\'Gabriel\' OR p.age<27";
        String q0 =
               qb.select("*").from("Person p").where("p.name").eq("\'Gabriel\'").or(
            "p.age").lessThan("27").render();
        Assert.assertEquals(result0, q0);
    }

    @Test
    public void testSelectFromWhereEqualsOrLessThanAndEquals() {
        final String result0 =
                     "SELECT * FROM Person p WHERE p.name=\'Gabriel\' OR p.age<27 AND p.lastName=\'Rodriguez\'";
        String q0 =
               qb.select("*").from("Person p").where("p.name").eq("\'Gabriel\'").or(
            "p.age").lessThan("27").and("p.lastName").eq("\'Rodriguez\'").render();
        Assert.assertEquals(result0, q0);
    }

    @Test
    public void testSelectFromWhereEqualsOrLessThanOrEquals() {
        final String result0 =
                     "SELECT * FROM Person p WHERE p.name=\'Gabriel\' OR p.age<27 OR p.lastName=\'Rodriguez\'";
        String q0 =
               qb.select("*").from("Person p").where("p.name").eq("\'Gabriel\'").or(
            "p.age").lessThan("27").or("p.lastName").eq("\'Rodriguez\'").render();
        Assert.assertEquals(result0, q0);
    }

    @Test
    public void testSelectFromWhereIsNull() {
        final String result0 = "SELECT * FROM Person p WHERE p.name IS null";
        String q0 = qb.select("*").from("Person p").where("p.name").is(null).render();
        Assert.assertEquals(result0, q0);
    }
}
