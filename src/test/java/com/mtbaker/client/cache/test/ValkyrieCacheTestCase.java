package com.mtbaker.client.cache.test;

import com.mtbaker.client.Cache;
import com.mtbaker.client.cache.ValkyrieCache;
import com.othersonline.kv.backends.ConcurrentHashMapKeyValueStore;

import junit.framework.TestCase;

public class ValkyrieCacheTestCase extends TestCase {
	private Cache cache;

	public void setUp() throws Exception {
		super.setUp();
		ConcurrentHashMapKeyValueStore c = new ConcurrentHashMapKeyValueStore();
		c.start();
		cache = new ValkyrieCache(c);
	}

	public void testCache() throws Exception {
		// should be null
		assertNull(cache.get("foo", "bar"));
		// put it
		cache.set("foo", "bar", "baz");
		// get it
		assertEquals(cache.get("foo", "bar"), "baz");
		// ValkyrieCache does not look at namespace
		assertEquals(cache.get("fiz", "bar"), "baz");
		// wait for it to expire
		Thread.sleep(11);
		// and does not respect ttl
		assertEquals(cache.get("foo", "bar"), "baz");

		// try an int
		assertNull(cache.get("foo", "fiz"));
		cache.set("foo", "fiz", 10);
		assertEquals(cache.get("foo", "fiz"), 10);
	}
}
