package com.mtbaker.client.provider.valkyrie;

import com.mtbaker.client.Configuration;
import com.mtbaker.client.ConfigurationClient;
import com.mtbaker.client.ErrorHandler;
import com.othersonline.kv.KeyValueStore;

public class ValkyrieConfigurationClient implements ConfigurationClient {

	private KeyValueStore kv;

	private ErrorHandler errors;

	public void setKeyValueStore(KeyValueStore kv) {
		this.kv = kv;
	}

	public void setErrorHandler(ErrorHandler errors) {
		this.errors = errors;
	}

	@Override
	public Configuration getConfiguration(String namespace, int ttlMillis) {
		ValkyrieConfiguration config = new ValkyrieConfiguration();
		config.setKeyValueStore(kv);
		config.setErrorHandler(errors);
		return config;
	}

}
