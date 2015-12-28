package com.tempoc.ezrsql4j.impl;

import com.tempoc.ezrsql4j.syntax.helper.SelectListable;
import com.tempoc.ezrsql4j.syntax.helper.SelectListableTest;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author tempoc
 */
public class SelectListableAsteriskTest extends SelectListableTest {

    @Test
    @Override
    public void testToString() {
        Assert.assertEquals("*", new SelectListableAsterisk().toString());
    }

    @Test
    public void testEquals() {
        Assert.assertEquals(new SelectListableAsterisk(), new SelectListableAsterisk());
        SelectListableAsterisk sla = new SelectListableAsterisk();
        Assert.assertTrue(sla.equals(sla));
        Assert.assertFalse(sla.equals(null));
    }

    @Test
    public void testHashCode() {
        Assert.assertEquals("*".hashCode(), new SelectListableAsterisk().hashCode());
    }

}
