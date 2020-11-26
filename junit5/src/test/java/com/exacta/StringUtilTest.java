package com.exacta;

import org.junit.Assert;
import org.junit.Test;

public class StringUtilTest {

    @Test
    public void isEmptyComString(){
        boolean b = StringUtil.isEmpty("com string");
        Assert.assertFalse(b);
    }

    @Test
    public void isEmptyComStringVazia(){
        boolean b = StringUtil.isEmpty("");
        Assert.assertTrue(b);
    }

    @Test
    public void isEmptyComStringNull(){
        boolean b = StringUtil.isEmpty(null);
        Assert.assertTrue(b);
    }

    @Test
    public void reverseSucesso(){
        String s = StringUtil.reverse("abcd");
        Assert.assertEquals("dcba", s);
    }

    @Test
    public void reversenNull(){
        String s = StringUtil.reverse(null);
        Assert.assertNull(s);
    }

}
