package com.mtbaker.client.provider.properties;

import java.io.IOException;
import java.util.Properties;

import com.mtbaker.client.Configuration;
import com.mtbaker.client.NullCache;
import com.mtbaker.client.provider.AbstractConfiguration;

public class PropertiesConfiguration extends AbstractConfiguration implements Configuration {
	private Properties props;
	public PropertiesConfiguration(Properties props) {
		super(new NullCache(), null, null);
		this.props = props;
	}

	@Override
	protected String get(String namespace, String key) throws IOException {
		return props.getProperty(key);
	}
}