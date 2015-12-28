/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tempoc.ezrsql4j.impl;

import com.tempoc.ezrsql4j.syntax.types.Symbols;
import com.tempoc.ezrsql4j.syntax.helper.SelectListable;

/**
 *
 * @author Grodriguez
 */
public class SelectListableAsterisk implements SelectListable {

    @Override
    public String toString() {
        return Symbols.ASTERISK;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj==null) {
            return false;
        }
        if(!(obj instanceof SelectListableAsterisk)) {
            throw new ClassCastException();
        }
        SelectListableAsterisk other = (SelectListableAsterisk) obj;
        return Symbols.ASTERISK.equals(other.toString());
    }

    @Override
    public int hashCode() {
        return Symbols.ASTERISK.hashCode();
    }

}
