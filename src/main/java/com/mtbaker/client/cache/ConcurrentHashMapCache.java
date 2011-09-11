package com.mtbaker.client.cache;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.mtbaker.client.Cache;

public class ConcurrentHashMapCache implements Cache {

	private Map<String, Map<String, Cacheable>> namespaces = new ConcurrentHashMap<String, Map<String, Cacheable>>();

	private int ttl;

	public ConcurrentHashMapCache(int ttlMillis) {
		this.ttl = ttlMillis;
	}

	@Override
	public <T> T get(String namespace, String key) throws IOException {
		T retval = null;
		Map<String, Cacheable> m = getNamespace(namespace);
		Cacheable<T> c = m.get(key);
		if (c == null)
			retval = null;
		else {
			if ((System.currentTimeMillis() - c.timestamp) > ttl) {
				m.remove(key);
			} else
				retval = c.obj;
		}
		return retval;
	}

	@Override
	public <T> void set(String namespace, String key, T value)
			throws IOException {
		Map<String, Cacheable> m = getNamespace(namespace);
		m.put(key, new Cacheable<T>(value, System.currentTimeMillis()));
	}

	private synchronized Map<String, Cacheable> getNamespace(String namespace) {
		Map<String, Cacheable> m = namespaces.get(namespace);
		if (m == null) {
			m = new ConcurrentHashMap<String, Cacheable>();
			namespaces.put(namespace, m);
		}
		return m;
	}

	private static class Cacheable<T> {
		private T obj;

		private long timestamp;

		public Cacheable(T obj, long timestamp) {
			this.obj = obj;
			this.timestamp = timestamp;
		}
	}
}
