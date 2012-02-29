package com.sertice.sandbox.amazon.advertising;

import java.util.ResourceBundle;

public final class AwsConfig {

	private static final String CONFIG_FILE_NAME = "aws";

	private static final String DEFAULT_ASSOCIATE_TAG = "sertice-22";

	private static final ResourceBundle RESOURCES = ResourceBundle
			.getBundle(CONFIG_FILE_NAME);

	private AwsConfig() {
	}

	public static String get(String key) {
		String result = null;
		result = RESOURCES.getString(key);
		if (result == null && key.equals("associateTag")) {
			result = DEFAULT_ASSOCIATE_TAG;
		}
		return result;
	}

}
