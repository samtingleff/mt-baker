package com.mtbaker.client.provider.test;

import java.util.Arrays;

import junit.framework.TestCase;

import com.mtbaker.client.Configuration;

public abstract class BasicConfigurationTestCase extends TestCase {

	protected Configuration conf;

	public void setUp() throws Exception {
		super.setUp();
	}

	public void testStringValues() throws Exception {
		// key with a value set should override the provided default
		assertEquals(conf.getString("test.string", "bar"), "foo");
		// key with no value set should return the default
		assertEquals(conf.getString("test.string.foo", "bar"), "bar");
		// key with no value set and a null default should return null
		assertNull(conf.getString("test.string.foo.null", null));
	}

	public void testIntegerValues() throws Exception {
		// key with a value set should override the provided default
		assertEquals(conf.getInteger("test.integer", 102), 101);
		// key with no value set should return the default
		assertEquals(conf.getInteger("test.integer.foo", 102), 102);
	}

	public void testLongValues() throws Exception {
		// key with a value set should override the provided default
		assertEquals(conf.getLong("test.long", 1892), 2147483648l);
		// key with no value set should return the default
		assertEquals(conf.getLong("test.long.foo", 2147483649l), 2147483649l);
	}

	public void testDoubleValues() throws Exception {
		// key with a value set should override the provided default
		assertEquals(conf.getDouble("test.double", 1892), 2147483648.12345);
		// key with no value set should return the default
		assertEquals(conf.getDouble("test.double.foo", 2147483649.12345),
				2147483649.12345);
	}

	public void testStringListValues() throws Exception {
		// key with a value set should override the provided default
		assertEquals(conf.getStringList("test.string.list", Arrays.asList("foo", "bar", "baz")), Arrays.asList("foo", "bar"));
		// key with no value set should return the default
		assertEquals(conf.getStringList("test.string.list.foo", Arrays.asList("foo", "baz")), Arrays.asList("foo", "baz"));
		// key with no value set and a null default should return null
		assertNull(conf.getStringList("test.string.list.foo.null", null));
	}

	public void testIntegerListValues() throws Exception {
		// key with a value set should override the provided default
		assertEquals(conf.getIntegerList("test.integer.list", Arrays.asList(19, 20, 21)), Arrays.asList(19, 22));
		// key with no value set should return the default
		assertEquals(conf.getIntegerList("test.integer.list.foo", Arrays.asList(19, 23)), Arrays.asList(19, 23));
		// key with no value set and a null default should return null
		assertNull(conf.getIntegerList("test.integer.list.foo.null", null));
	}

	public void testLongListValues() throws Exception {
		// key with a value set should override the provided default
		assertEquals(conf.getLongList("test.long.list", Arrays.asList(19l, 20l, 21l)), Arrays.asList(2147483648l, 909l));
		// key with no value set should return the default
		assertEquals(conf.getLongList("test.long.list.foo", Arrays.asList(19l, 23l)), Arrays.asList(19l, 23l));
		// key with no value set and a null default should return null
		assertNull(conf.getLongList("test.long.list.foo.null", null));
	}

	public void testDoubleListValues() throws Exception {
		// key with a value set should override the provided default
		assertEquals(conf.getDoubleList("test.double.list", Arrays.asList(17.5, 90.2, 13.45)), Arrays.asList(107.7, 94.5));
		// key with no value set should return the default
		assertEquals(conf.getDoubleList("test.double.list.foo", Arrays.asList(107.7, 93.3)), Arrays.asList(107.7, 93.3));
		// key with no value set and a null default should return null
		assertNull(conf.getDoubleList("test.double.list.foo.null", null));
	}
}
