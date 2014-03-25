package st.digitru.mtbaker.client.provider.properties;

import java.util.Properties;

import st.digitru.mtbaker.client.Configuration;
import st.digitru.mtbaker.client.ConfigurationClient;


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
