package com.putandpost.quicktour.util;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.putandpost.quicktour.dto.PackageInfo;

// Singleton 
public class InMemoryDatabase {
	private static InMemoryDatabase instance;
	private Map<String, PackageInfo> userPackages;

	public InMemoryDatabase() {
		userPackages = new ConcurrentHashMap<>();
		System.out.println("UserPackages Map has been created ::"+userPackages.hashCode());
	}

	public PackageInfo getPackage(String key) {
		if (userPackages.containsKey(key) == false) {
			throw new IllegalArgumentException("No such key found..");
		} else {
			return userPackages.get(key);
		}
	}

	public void storePackage(String key, PackageInfo userPackage) {
		userPackages.put(key, userPackage);
	}

	public boolean contains(String key) {
		return userPackages.containsKey(key);
	}

	public static InMemoryDatabase getInstance() {
		if (instance == null) {
			synchronized (InMemoryDatabase.class) {
				if (instance == null) {
					instance = new InMemoryDatabase();
				}
			}
		}
		return instance;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}

	// Magic method
	public Object readResolve() {
		return InMemoryDatabase.getInstance();
	}

}
