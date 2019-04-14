package com.ebay.demo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class GroupTest 
{

    @Test
    public void test()
    {
       Group grp = new Group();
       grp.register("one","two");
       assertEquals("two",grp.get("one"));
    }
}
