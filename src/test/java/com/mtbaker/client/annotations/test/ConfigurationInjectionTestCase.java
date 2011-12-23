package com.mtbaker.client.annotations.test;

import java.util.Arrays;

import com.mtbaker.client.annotations.ConfigurationInjector;
import com.mtbaker.client.provider.io.ResourceStreamSource;
import com.mtbaker.client.provider.xml.XmlConfigurationClient;

import junit.framework.TestCase;

public class ConfigurationInjectionTestCase extends TestCase {

	public void testInjector() throws Exception {
		XmlConfigurationClient client = new XmlConfigurationClient(
				new ResourceStreamSource(getClass(),
						"/properties/test-properties.xml"));

		ConfigurationInjector injector = new ConfigurationInjector();
		ConfigurableObject obj = new ConfigurableObject();
		injector.inject(client, obj);

		// string types
		assertEquals(obj.getSomeString(), "foo");
		assertEquals(obj.isSomeBoolean(), true);
		assertEquals(obj.getSomeInteger(), 101);
		assertEquals(obj.getSomeLong(), 2147483648l);
		assertEquals(obj.getSomeDouble(), 2147483648.12345);
		assertEquals(obj.getSomeOtherDouble(), 13.4);

		// list types
		assertEquals(obj.getSomeStringList(), Arrays.asList("foo", "bar"));
		assertEquals(obj.getSomeIntegerList(), Arrays.asList(19, 22));
		assertEquals(obj.getSomeLongList(), Arrays.asList(2147483648l, 909l));
		assertEquals(obj.getSomeDoubleList(), Arrays.asList(107.7, 94.5));
		assertEquals(obj.getSomeOtherDoubleList(), Arrays.asList(13.4, 50.5));
	}
}
