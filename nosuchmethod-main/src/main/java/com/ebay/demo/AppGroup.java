package com.ebay.demo;

public class AppGroup extends Group {
	@SuppressWarnings("unused")
	private static final long serialVersionUID = -4885298552808177028L;

	static AppGroup setup() {
		AppGroup grp = new AppGroup();

		grp.register("Hello", "world!");
		return grp;
	}

	public static void main(String[] args) {
		AppGroup grp = setup();

		// the call to grp.get() below will generate a NoSuchMethodError
		// if this code is compiled with oldLib and run with newLib
		// However, at a source level for either, it works correctly
		System.out.println("Hello" + ", " + grp.get("Hello"));
	}

}
