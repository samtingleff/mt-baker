package st.digitru.mtbaker.client.provider.xml;

import java.io.IOException;


import st.digitru.mtbaker.client.Configuration;
import st.digitru.mtbaker.client.ConfigurationClient;
import st.digitru.mtbaker.client.provider.io.InputStreamSource;


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
