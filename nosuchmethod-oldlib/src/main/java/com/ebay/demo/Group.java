package com.ebay.demo;

@SuppressWarnings("serial")
public class Group extends java.util.HashMap<String, String> {

	public void register(String key, String value) {
		super.put(key, value);
	}
}
