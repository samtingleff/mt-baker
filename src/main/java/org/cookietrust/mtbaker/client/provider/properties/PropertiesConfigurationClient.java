package org.cookietrust.mtbaker.client.provider.properties;

import java.util.Properties;

import org.cookietrust.mtbaker.client.Configuration;
import org.cookietrust.mtbaker.client.ConfigurationClient;


public class PropertiesConfigurationClient implements ConfigurationClient {

	private Properties properties;

	public PropertiesConfigurationClient(Properties properties) {
		this.properties = properties;
	}

	@Override
	public Configuration getConfiguration(String namespace, int ttlMillis) {
		return new PropertiesConfiguration(this.properties);
	}

}
