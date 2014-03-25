package st.digitru.mtbaker.client.provider.properties;

import java.io.IOException;
import java.util.Properties;


import st.digitru.mtbaker.client.Configuration;
import st.digitru.mtbaker.client.NullCache;
import st.digitru.mtbaker.client.provider.SimpleConfiguration;


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
