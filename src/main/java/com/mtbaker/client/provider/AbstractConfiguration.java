package com.mtbaker.client.provider;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.mtbaker.client.Cache;
import com.mtbaker.client.Configuration;
import com.mtbaker.client.ErrorHandler;

public abstract class AbstractConfiguration implements Configuration {
	private static final String LIST_SPLIT = "[,\\s]+";

	protected Cache cache;

	protected ErrorHandler errors;

	protected String namespace;

	protected abstract String get(String namespace, String key) throws IOException;

	public AbstractConfiguration(Cache cache, ErrorHandler errorHandler, String namespace) {
		this.cache = cache;
		this.errors = errorHandler;
		this.namespace = namespace;
	}

	public AbstractConfiguration() {
	}

	public void setCache(Cache cache) {
		this.cache = cache;
	}

	public void setErrorHandler(ErrorHandler errors) {
		this.errors = errors;
	}

	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}

	public String getString(String key, String defaultValue) throws IOException {
		String v = cache.get(namespace, key);
		if (v == null) {
			v = get(namespace, key);
			cache.set(namespace, key, v);
		}
		return (v == null) ? defaultValue : v;
	}

	public int getInteger(String key, int defaultValue) throws IOException {
		Integer v = cache.get(namespace, key);
		if (v == null) {
			v = new Integer(toInteger(get(namespace, key), defaultValue));
			cache.set(namespace, key, v);
		}
		return (v == null) ? defaultValue : v.intValue();
	}

	public long getLong(String key, long defaultValue) throws IOException {
		Long v = cache.get(namespace, key);
		if (v == null) {
			v = new Long(toLong(get(namespace, key), defaultValue));
			cache.set(namespace, key, v);
		}
		return (v == null) ? defaultValue : v.longValue();
	}

	public double getDouble(String key, double defaultValue) throws IOException {
		Double v = cache.get(namespace, key);
		if (v == null) {
			v = new Double(toDouble(get(namespace, key), defaultValue));
			cache.set(namespace, key, v);
		}
		return (v == null) ? defaultValue : v.doubleValue();
	}

	public List<String> getStringList(String key, List<String> defaultValue) throws IOException {
		List<String> l = cache.get(namespace, key);
		if (l == null) {
			l = toStringList(get(namespace, key), defaultValue);
			cache.set(namespace, key, l);
		}
		return l;
	}

	public List<Integer> getIntegerList(String key, List<Integer> defaultValue) throws IOException {
		List<Integer> l = cache.get(namespace, key);
		if (l == null) {
			l = toIntegerList(get(namespace, key), defaultValue);
			cache.set(namespace, key, l);
		}
		return l;
	}

	public List<Long> getLongList(String key, List<Long> defaultValue) throws IOException {
		List<Long> l = cache.get(namespace, key);
		if (l == null) {
			l = toLongList(get(namespace, key), defaultValue);
			cache.set(namespace, key, l);
		}
		return l;
	}

	public List<Double> getDoubleList(String key, List<Double> defaultValue) throws IOException {
		List<Double> l = cache.get(namespace, key);
		if (l == null) {
			l = toDoubleList(get(namespace, key), defaultValue);
			cache.set(namespace, key, l);
		}
		return l;
	}

	protected int toInteger(String s, int defaultValue) {
		int i = defaultValue;
		try {
			if (!isEmpty(s)) {
				i = Integer.parseInt(s);
			}
		} catch (NumberFormatException e) {
			if (errors != null)
				errors.numberFormatException(s, int.class);
		}
		return i;
	}

	protected long toLong(String s, long defaultValue) {
		long l = defaultValue;
		try {
			if (!isEmpty(s)) {
				l = Long.parseLong(s);
			}
		} catch (NumberFormatException e) {
			if (errors != null)
				errors.numberFormatException(s, long.class);
		}
		return l;
	}

	protected double toDouble(String s, double defaultValue) {
		double d = defaultValue;
		try {
			if (!isEmpty(s)) {
				d = Double.parseDouble(s);
			}
		} catch (NumberFormatException e) {
			if (errors != null)
				errors.numberFormatException(s, double.class);
		}
		return d;
	}

	protected List<String> toStringList(String s, List<String> defaultValue) {
		List<String> l = defaultValue;
		if (!isEmpty(s)) {
			String[] split = s.split(LIST_SPLIT);
			l = Arrays.asList(split);
		}
		return l;
	}

	protected List<Integer> toIntegerList(String s, List<Integer> defaultValue) {
		List<Integer> l = defaultValue;
		try {
			if (!isEmpty(s)) {
				String[] split = s.split(LIST_SPLIT);
				List<Integer> foo = new ArrayList<Integer>(split.length);
				for (int i = 0; i < split.length; ++i) {
					foo.add(Integer.parseInt(split[i]));
				}
				l = foo;
			}
		} catch (NumberFormatException e) {
			if (errors != null)
				errors.numberFormatException(s, int.class);
		}
		return l;
	}

	protected List<Long> toLongList(String s, List<Long> defaultValue) {
		List<Long> l = defaultValue;
		try {
			if (!isEmpty(s)) {
				String[] split = s.split(LIST_SPLIT);
				List<Long> foo = new ArrayList<Long>(split.length);
				for (int i = 0; i < split.length; ++i) {
					foo.add(Long.parseLong(split[i]));
				}
				l = foo;
			}
		} catch (NumberFormatException e) {
			if (errors != null)
				errors.numberFormatException(s, long.class);
		}
		return l;
	}

	protected List<Double> toDoubleList(String s, List<Double> defaultValue) {
		List<Double> l = defaultValue;
		try {
			if (!isEmpty(s)) {
				String[] split = s.split(LIST_SPLIT);
				List<Double> foo = new ArrayList<Double>(split.length);
				for (int i = 0; i < split.length; ++i) {
					foo.add(Double.parseDouble(split[i]));
				}
				l = foo;
			}
		} catch (NumberFormatException e) {
			if (errors != null)
				errors.numberFormatException(s, double.class);
		}
		return l;
	}

	protected boolean isEmpty(String s) {
		return ((s == null) || (s.length() == 0));
	}
}
