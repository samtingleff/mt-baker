package org.cookietrust.mtbaker.client.provider.properties;

import java.io.IOException;
import java.util.Properties;

import org.cookietrust.mtbaker.client.Configuration;
import org.cookietrust.mtbaker.client.NullCache;
import org.cookietrust.mtbaker.client.provider.SimpleConfiguration;


public class PropertiesConfiguration extends SimpleConfiguration implements Configuration {
	private Properties props;

	public PropertiesConfiguration(Properties props) {
		super(new NullCache(), null, "ignored");
		this.props = props;
	}

	@Override
	protected String get(String namespace, String key) throws IOException {
		return props.getProperty(key);
	}
}
