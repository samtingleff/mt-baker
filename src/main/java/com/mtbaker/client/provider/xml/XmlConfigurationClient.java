package com.mtbaker.client.provider.xml;

import java.io.IOException;

import com.mtbaker.client.Configuration;
import com.mtbaker.client.ConfigurationClient;
import com.mtbaker.client.provider.io.InputStreamSource;

public class XmlConfigurationClient implements ConfigurationClient {
	private InputStreamSource source;

	public XmlConfigurationClient(InputStreamSource source) {
		this.source = source;
	}

	@Override
	public Configuration getConfiguration(String namespace, int ttlMillis) throws IOException {
		return new XmlConfiguration(this.source, namespace, ttlMillis);
	}

}
