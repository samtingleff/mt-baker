package com.mtbaker.client.annotations.test;

import com.mtbaker.client.Configuration;
import com.mtbaker.client.annotations.ConfigurationInjector;
import com.mtbaker.client.provider.io.ResourceStreamSource;
import com.mtbaker.client.provider.xml.XmlConfigurationClient;

import junit.framework.TestCase;

public class ConfigurationInjectionTestCase extends TestCase {

	public void testInjector() throws Exception {
		XmlConfigurationClient client = new XmlConfigurationClient(
				new ResourceStreamSource(getClass(),
						"/properties/test-properties.xml"));
		Configuration conf = client.getConfiguration("test", 10);

		ConfigurationInjector injector = new ConfigurationInjector();
		ConfigurableObject obj = new ConfigurableObject();
		injector.inject(conf, obj);
		assertEquals(obj.getSomeString(), "foo");
		assertEquals(obj.isSomeBoolean(), true);
		assertEquals(obj.getSomeInteger(), 101);
		assertEquals(obj.getSomeLong(), 2147483648l);
		assertEquals(obj.getSomeDouble(), 2147483648.12345);
		assertEquals(obj.getSomeOtherDouble(), 13.4);
	}
}
