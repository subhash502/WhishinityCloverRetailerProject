package com.trendbrew.vocab;

import com.koinplus.common.KoinPlusEnum;
import com.koinplus.common.KoinPlusEnumEnhancer;

/**
 * @author Abhijit Patil
 */
public enum BrewerType implements KoinPlusEnum {
	SYSTEM_BREWER("SystemBrewer"),
	BREWER("Brewer"),
	SHOPPER("Shopper");

	private static final KoinPlusEnumEnhancer<BrewerType> enhancer = new KoinPlusEnumEnhancer<BrewerType>(values());

	private String value;

	private BrewerType(String name) {
		this.value = name;
	}

	public String getValue() {
		return value;
	}

	// This is delegation.
	public String toString() {
		return enhancer.toString(this);
	}

	// This too is delegation.
	public static BrewerType lookup(String name) {
		return enhancer.lookup(name);
	}
}
