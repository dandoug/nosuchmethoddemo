package com.ebay.demo;

@SuppressWarnings("serial")
public class AppGroup extends Group
{
    public static void main( String[] args )
    {
        AppGroup grp = new AppGroup();

        grp.register("Hello","world!");

        System.out.println("Hello"+", "+grp.get("Hello"));
    }
}
