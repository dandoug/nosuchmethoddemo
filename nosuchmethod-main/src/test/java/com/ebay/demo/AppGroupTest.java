package com.ebay.demo;

import static com.ebay.demo.AppGroup.setup;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AppGroupTest 
{
    @Test
	public void test()
    {
    	AppGroup grp = setup();

        assertEquals("world!",grp.get("Hello"));
    }
}
