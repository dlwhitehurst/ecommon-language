package org.citechnical.ecommon.language.utility;

import junit.framework.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class BrokenStringTest {

    @Test
    public void testReduceFirstPartByOneWord() throws Exception {
        BrokenString bStr = new BrokenString();
        bStr.setFirstPart("My name is David Whitehurst and I was born in");
        bStr.setSecondPart(" Virginia.");

        bStr = bStr.reduceFirstPartByOneWord();

        Assert.assertEquals("My name is David Whitehurst and I was born ",bStr.getFirstPart());
        Assert.assertEquals("in Virginia.",bStr.getSecondPart());

    }

    @Test
    public void testGetFirstPart() throws Exception {
        BrokenString bStr = new BrokenString();
        bStr.setFirstPart("Hello there");
        Assert.assertNotNull(bStr);
        Assert.assertNotNull(bStr.getFirstPart());

        Assert.assertEquals("Hello there", bStr.getFirstPart());
    }

    @Test
    public void testSetFirstPart() throws Exception {

    }

    @Test
    public void testGetSecondPart() throws Exception {

    }

    @Test
    public void testSetSecondPart() throws Exception {

    }
}