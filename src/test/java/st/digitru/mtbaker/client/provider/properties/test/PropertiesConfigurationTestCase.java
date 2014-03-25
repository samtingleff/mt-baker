package st.digitru.mtbaker.client.provider.properties.test;

import java.util.Properties;


import st.digitru.mtbaker.client.provider.properties.PropertiesConfigurationClient;
import st.digitru.mtbaker.client.provider.test.BasicConfigurationTestCase;


public class PropertiesConfigurationTestCase extends BasicConfigurationTestCase {

	public void setUp() throws Exception {
		super.setUp();
		Properties props = new Properties();
		props.load(getClass().getResourceAsStream(
				"/properties/test-properties.properties"));
		PropertiesConfigurationClient client = new PropertiesConfigurationClient(
				props);
		super.conf = client.getConfiguration(null, 10);
	}

}
