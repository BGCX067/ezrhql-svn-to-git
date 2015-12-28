package com.tempoc.ezrsql4j.impl;

import com.tempoc.ezrsql4j.syntax.SelectList;
import com.tempoc.ezrsql4j.syntax.helper.SelectListable;
import java.util.ArrayList;

import static com.tempoc.ezrsql4j.syntax.types.Symbols.*;

/**
 * 
 * @author tempoc
 */
public class SelectListImpl extends ArrayList<SelectListable> implements SelectList {

    @Override
    public String toString() {
        String result = "";
        for(SelectListable sl : this) {
            if(!result.equals("")) {
                result += COMMA + SP;
            }
            result += sl;
        }
        return result;
    }

}
