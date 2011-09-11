package com.mtbaker.client.provider.properties;

import java.util.Properties;

import com.mtbaker.client.Configuration;
import com.mtbaker.client.ConfigurationClient;

public class PropertiesConfigurationClient implements ConfigurationClient {

	private Properties properties;

	public PropertiesConfigurationClient(Properties properties) {
		this.properties = properties;
	}

	@Override
	public Configuration getConfiguration(String namespace, int ttlSeconds) {
		return new PropertiesConfiguration(this.properties);
	}

}
