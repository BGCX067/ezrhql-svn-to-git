package com.tempoc.ezrsql4j.impl;

import com.tempoc.ezrsql4j.impl.expression.SimpleExpressionImpl;
import com.tempoc.ezrsql4j.syntax.CAlias;
import com.tempoc.ezrsql4j.syntax.Column;
import com.tempoc.ezrsql4j.syntax.JoinType;
import com.tempoc.ezrsql4j.syntax.JoinedTable;
import com.tempoc.ezrsql4j.syntax.QueryTableExpression;
import com.tempoc.ezrsql4j.syntax.Select;
import com.tempoc.ezrsql4j.syntax.SelectList;
import com.tempoc.ezrsql4j.syntax.Subquery;
import com.tempoc.ezrsql4j.syntax.TAlias;
import com.tempoc.ezrsql4j.syntax.Table;
import com.tempoc.ezrsql4j.syntax.TableReference;
import com.tempoc.ezrsql4j.syntax.expression.SimpleExpression;
import com.tempoc.ezrsql4j.syntax.helper.SelectListable;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author tempoc
 */
public class GenericTest {
    @Test
    public void testSelectEverythingFromTable() {
        SelectList selectList = new SelectListImpl();
        selectList.add(new SelectListableAsterisk());

        List<TableReference> tableReferences = new ArrayList<TableReference>();
        Table pTable = new MyTable("Person");
        QueryTableExpression queryTableExpression = new GridQueryTableExpression(pTable);
        TableReference tableReference = new QueryTableExpressionTableReference(
            queryTableExpression);
        tableReferences.add(tableReference);

        Subquery subquery = new SubqueryImpl(selectList, tableReferences);
        
        Select select = new SelectImpl(subquery);
        System.out.println(select.toString());

        String expectedResult = "SELECT * FROM Person;";
        Assert.assertEquals(expectedResult, select.toString());
    }

    @Test
    public void testSelectSomethingFromTable() {
        CAlias c_alias = new MyCAlias("person_age");
        SimpleExpression pAgeExpression = new SimpleExpressionImpl("age");
        SelectListable sl = new SelectListableExpression(pAgeExpression, c_alias);

        SimpleExpression pNameExpression = new SimpleExpressionImpl("name");
        SelectListable sl2 = new SelectListableExpression(pNameExpression);

        SelectList selectList = new SelectListImpl();
        selectList.add(sl);
        selectList.add(sl2);

        List<TableReference> tableReferences = new ArrayList<TableReference>();
        Table pTable = new MyTable("Person");
        QueryTableExpression qte = new GridQueryTableExpression(pTable);
        TableReference tableReference = new QueryTableExpressionTableReference(
            qte);
        tableReferences.add(tableReference);

        Subquery subquery = new SubqueryImpl(selectList, tableReferences);

        Select select = new SelectImpl(subquery);
        System.out.println(select.toString());

        String expectedResult = "SELECT age AS person_age, name FROM Person;";
        Assert.assertEquals(expectedResult, select.toString());
    }

    @Test
    public void testSelectSomethingFromTables() {
        CAlias c_alias = new MyCAlias("person_age");
        SimpleExpression pAgeExpression = new SimpleExpressionImpl("p.age");
        SelectListable sl =
                       new SelectListableExpression(pAgeExpression, c_alias);

        SimpleExpression pNameExpression = new SimpleExpressionImpl("c.name");
        SelectListable sl2 = new SelectListableExpression(pNameExpression);

        SelectList selectList = new SelectListImpl();
        selectList.add(sl);
        selectList.add(sl2);

        Table table = new MyTable("Person");
        TAlias ta = new MyTAlias("p");
        QueryTableExpression qte = new GridQueryTableExpression(table);
        TableReference tr = new QueryTableExpressionTableReference(qte, ta);
        
        Table table1 = new MyTable("Car");
        TAlias ta1 = new MyTAlias("c");
        QueryTableExpression qte1 = new GridQueryTableExpression(table1);
        TableReference tr1 = new QueryTableExpressionTableReference(qte1, ta1);
        List<TableReference> tableReferences = new ArrayList<TableReference>();
        tableReferences.add(tr);
        tableReferences.add(tr1);

        Subquery subquery = new SubqueryImpl(selectList, tableReferences);

        Select select = new SelectImpl(subquery);
        System.out.println(select.toString());

        String expectedResult = "SELECT p.age AS person_age, c.name FROM Person p, Car c;";
        Assert.assertEquals(expectedResult, select.toString());
    }

    @Test
    public void testSelectSomethingFromJoinedTables() {
        CAlias c_alias = new MyCAlias("person_age");
        SimpleExpression pAgeExpression = new SimpleExpressionImpl("p.age");
        SelectListable sl =
                       new SelectListableExpression(pAgeExpression, c_alias);

        SimpleExpression pNameExpression = new SimpleExpressionImpl("c.name");
        SelectListable sl2 = new SelectListableExpression(pNameExpression);

        SelectList selectList = new SelectListImpl();
        selectList.add(sl);
        selectList.add(sl2);

        Table table = new MyTable("Person");
        TAlias ta = new MyTAlias("p");
        QueryTableExpression qte = new GridQueryTableExpression(table);
        TableReference tr = new QueryTableExpressionTableReference(qte, ta);

        Table table1 = new MyTable("Car");
        TAlias ta1 = new MyTAlias("c");
        QueryTableExpression qte1 = new GridQueryTableExpression(table1);
        TableReference tr1 = new QueryTableExpressionTableReference(qte1, ta1);
        JoinType jType = new JoinTypeImpl(JoinTypeImpl.Type.LEFT_OUTER);
        JoinedTable jt = new JoinedTableImpl(tr, jType, tr1);
        TableReference jttr = new JoinedTableTableReference(jt);
        List<TableReference> tableReferences = new ArrayList<TableReference>();
        tableReferences.add(jttr);

        Subquery subquery = new SubqueryImpl(selectList, tableReferences);

        Select select = new SelectImpl(subquery);
        System.out.println(select.toString());

        String expectedResult =
               "SELECT p.age AS person_age, c.name FROM (Person p NATURAL LEFT OUTER JOIN Car c);";
        Assert.assertEquals(expectedResult, select.toString());
    }

    private class MyTable implements Table {
        private Object tObject;

        public MyTable(Object tObject) {
            this.tObject = tObject;
        }

        @Override
        public String toString() {
            return tObject.toString();
        }
    }

    private class MyTAlias implements TAlias {

        private String name;

        public MyTAlias(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name.toString();
        }
    }

    private class MyColumn implements Column {

        private Object cObject;

        public MyColumn(Object cObject) {
            this.cObject = cObject;
        }

        @Override
        public String toString() {
            return cObject.toString();
        }
    }

    private class MyCAlias implements CAlias {

        private String name;

        public MyCAlias(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name.toString();
        }
    }

}
