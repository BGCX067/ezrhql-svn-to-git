package com.tempoc.ezrsql4j.impl;

import com.tempoc.ezrsql4j.syntax.DBLink;
import com.tempoc.ezrsql4j.syntax.Partition;
import com.tempoc.ezrsql4j.syntax.QueryTableExpression;
import com.tempoc.ezrsql4j.syntax.SampleClause;
import com.tempoc.ezrsql4j.syntax.Schema;
import com.tempoc.ezrsql4j.syntax.Subpartition;
import com.tempoc.ezrsql4j.syntax.Table;
import com.tempoc.ezrsql4j.syntax.View;

import static com.tempoc.ezrsql4j.syntax.types.Symbols.*;
import static com.tempoc.ezrsql4j.syntax.types.KeyWords.*;

/**
 *
 * @author tempoc
 */
public class GridQueryTableExpression implements QueryTableExpression {

    private Schema schema;

    private Table table;

    private View view;

    private DBLink dBLink;

    private Partition partition;

    private Subpartition subpartition;

    private SampleClause sampleClause;

    public GridQueryTableExpression(Table table) {
        this.table = table;
    }

    public GridQueryTableExpression(Table table, DBLink dBLink) {
        this.table = table;
        this.dBLink = dBLink;
    }

    public GridQueryTableExpression(Table table, SampleClause sampleClause) {
        this.table = table;
        this.sampleClause = sampleClause;
    }

    public GridQueryTableExpression(Table table, Partition partition) {
        this.table = table;
        this.partition = partition;
    }

    public GridQueryTableExpression(Table table, Subpartition subpartition) {
        this.table = table;
        this.subpartition = subpartition;
    }

    public GridQueryTableExpression(Table table, Partition partition,
                                    SampleClause sampleClause) {
        this.table = table;
        this.partition = partition;
        this.sampleClause = sampleClause;
    }

    public GridQueryTableExpression(Table table, Subpartition subpartition,
                                    SampleClause sampleClause) {
        this.table = table;
        this.subpartition = subpartition;
        this.sampleClause = sampleClause;
    }

    public GridQueryTableExpression(View view) {
        this.view = view;
    }

    public GridQueryTableExpression(View view, DBLink dBLink) {
        this.view = view;
        this.dBLink = dBLink;
    }

    public GridQueryTableExpression(Schema schema, Table table) {
        this.schema = schema;
        this.table = table;
    }

    public GridQueryTableExpression(Schema schema, Table table, DBLink dBLink) {
        this.schema = schema;
        this.table = table;
        this.dBLink = dBLink;
    }

    public GridQueryTableExpression(Schema schema, Table table,
                                    SampleClause sampleClause) {
        this.schema = schema;
        this.table = table;
        this.sampleClause = sampleClause;
    }

    public GridQueryTableExpression(Schema schema, Table table,
                                    Partition partition) {
        this.schema = schema;
        this.table = table;
        this.partition = partition;
    }

    public GridQueryTableExpression(Schema schema, Table table,
                                    Subpartition subpartition) {
        this.schema = schema;
        this.table = table;
        this.subpartition = subpartition;
    }

    public GridQueryTableExpression(Schema schema, Table table,
                                    Partition partition,
                                    SampleClause sampleClause) {
        this.schema = schema;
        this.table = table;
        this.partition = partition;
        this.sampleClause = sampleClause;
    }

    public GridQueryTableExpression(Schema schema, Table table,
                                    Subpartition subpartition,
                                    SampleClause sampleClause) {
        this.schema = schema;
        this.table = table;
        this.subpartition = subpartition;
        this.sampleClause = sampleClause;
    }

    public GridQueryTableExpression(Schema schema, View view) {
        this.schema = schema;
        this.view = view;
    }

    public GridQueryTableExpression(Schema schema, View view, DBLink dBLink) {
        this.schema = schema;
        this.view = view;
        this.dBLink = dBLink;
    }

    @Override
    public String toString() {
        String result = "";
        if (schema != null) {
            result += schema + DOT;
        }
        result += append(result, table);
        result += append(result, view);
        if (dBLink != null) {
            result += SP + AT + SP + dBLink;
        }
        if (partition != null) {
            result += SP + PARTITION + SP + L_PAREN + partition + R_PAREN;
        }
        if (subpartition != null) {
            result += SP + SUBPARTITION + SP + L_PAREN + subpartition + R_PAREN;
        }
        result += spaceAppend(result, sampleClause);

        return result;
    }

    private String append(String original, Object appendage) {
        if (original != null && appendage != null) {
           return appendage.toString();
        }
        return "";
    }

    private String spaceAppend(String original, Object appendage) {
        String anotherOne = "";
        if (original != null && appendage != null) {
            if (!original.equals("")) {
                anotherOne += SP;
            }
            return anotherOne + appendage;
        }
        return "";
    }
}
