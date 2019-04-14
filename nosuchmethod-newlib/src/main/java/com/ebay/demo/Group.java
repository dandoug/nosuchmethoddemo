package com.ebay.demo;

import java.util.HashMap;

public class Group {
	private final HashMap<String, String> map = new HashMap<>();

	public void register(String key, String value) {
		map.put(key, value);
	}

	public String get(String key) {
		return map.get(key);
	}
}
