package org.cookietrust.mtbaker.client.provider.xml.test;

import org.cookietrust.mtbaker.client.provider.io.ResourceStreamSource;
import org.cookietrust.mtbaker.client.provider.test.BasicConfigurationTestCase;
import org.cookietrust.mtbaker.client.provider.xml.XmlConfigurationClient;


public class XmlConfigurationTestCase extends BasicConfigurationTestCase {

	public void setUp() throws Exception {
		super.setUp();
		XmlConfigurationClient client = new XmlConfigurationClient(
				new ResourceStreamSource(getClass(),
						"/properties/test-properties.xml"));
		super.conf = client.getConfiguration("test", 10);
	}
}
