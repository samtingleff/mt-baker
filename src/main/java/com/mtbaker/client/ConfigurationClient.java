package com.mtbaker.client;

public interface ConfigurationClient {

	public Configuration getConfiguration(String namespace, int ttlMillis);
}
