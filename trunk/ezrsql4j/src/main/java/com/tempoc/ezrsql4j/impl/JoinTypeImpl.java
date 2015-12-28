package com.tempoc.ezrsql4j.impl;

import com.tempoc.ezrsql4j.syntax.JoinType;

/**
 *
 * @author tempoc
 */
public class JoinTypeImpl implements JoinType {

    private Type type;

    public JoinTypeImpl(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type.toString().replace('_', ' ');
    }

    public enum Type {
        INNER,
        LEFT,
        RIGHT,
        FULL,
        LEFT_OUTER,
        RIGHT_OUTER,
        FULL_OUTER
    }
    
}
