package com.tempoc.ezrsql4j.impl;

import com.tempoc.ezrsql4j.syntax.CollectionExpression;
import com.tempoc.ezrsql4j.syntax.TableCollectionExpression;

import static com.tempoc.ezrsql4j.syntax.types.KeyWords.*;
import static com.tempoc.ezrsql4j.syntax.types.Symbols.*;

/**
 *
 * @author tempoc
 */
public class TableCollectionExpressionImpl implements TableCollectionExpression{
    private CollectionExpression collectionExpression;
    private boolean plus;

    public TableCollectionExpressionImpl(CollectionExpression collectionExpression) {
        this.collectionExpression = collectionExpression;
    }

    public TableCollectionExpressionImpl(CollectionExpression collectionExpression,
                                         boolean plus) {
        this.collectionExpression = collectionExpression;
        this.plus = plus;
    }

    @Override
    public String toString() {
        String result = TABLE + SP + L_PAREN + collectionExpression + R_PAREN;
        if(plus) {
            result += SP + L_PAREN + PLUS + R_PAREN;
        }
        return result;
    }


}
