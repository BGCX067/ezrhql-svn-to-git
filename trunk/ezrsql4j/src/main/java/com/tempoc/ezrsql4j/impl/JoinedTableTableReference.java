package com.tempoc.ezrsql4j.impl;

import com.tempoc.ezrsql4j.syntax.JoinedTable;
import com.tempoc.ezrsql4j.syntax.TableReference;

import static com.tempoc.ezrsql4j.syntax.types.Symbols.*;

/**
 *
 * @author tempoc
 */
public class JoinedTableTableReference implements TableReference {
    private JoinedTable joinedTable;

    public JoinedTableTableReference(JoinedTable joinedTable) {
        this.joinedTable = joinedTable;
    }

    @Override
    public String toString() {
        return L_PAREN + joinedTable + R_PAREN;
    }

}
