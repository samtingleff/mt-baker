package com.mtbaker.client.cache.test;

import com.mtbaker.client.Cache;
import com.mtbaker.client.cache.ConcurrentHashMapCache;

import junit.framework.TestCase;

public class ConcurrentHashMapCacheTestCase extends TestCase {
	private Cache cache;

	public void setUp() throws Exception {
		super.setUp();
		cache = new ConcurrentHashMapCache(10);
	}

	public void testCache() throws Exception {
		// should be null
		assertNull(cache.get("foo", "bar"));
		// put it
		cache.set("foo", "bar", "baz");
		// get it
		assertEquals(cache.get("foo", "bar"), "baz");
		// no namespace collision
		assertNull(cache.get("fiz", "bar"));
		// wait for it to expire
		Thread.sleep(11);
		assertNull(cache.get("foo", "bar"));

		// try an int
		assertNull(cache.get("foo", "fiz"));
		cache.set("foo", "fiz", 10);
		assertEquals(cache.get("foo", "fiz"), 10);
	}
}
