package com.mtbaker.client.cache;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.mtbaker.client.Cache;
import com.othersonline.kv.KeyValueStore;
import com.othersonline.kv.KeyValueStoreException;
import com.othersonline.kv.transcoder.Transcoder;

public class ValkyrieCache implements Cache {
	private static Log log = LogFactory.getLog(ValkyrieCache.class);

	private KeyValueStore kv;

	private Transcoder transcoder;

	public ValkyrieCache(KeyValueStore kv, Transcoder transcoder) {
		this.kv = kv;
		this.transcoder = transcoder;
	}

	public ValkyrieCache(KeyValueStore kv) {
		this.kv = kv;
	}

	public ValkyrieCache() {
	}

	public void setKeyValueStore(KeyValueStore kv) {
		this.kv = kv;
	}

	public void setTranscoder(Transcoder t) {
		this.transcoder = t;
	}

	@Override
	public <T> T get(String namespace, String key) throws IOException {
		try {
			return (T) ((transcoder == null) ? kv.get(key) : kv.get(key,
					transcoder));
		} catch (KeyValueStoreException e) {
			log.error("Error calling kv.get()", e);
			throw new IOException(e);
		}
	}

	@Override
	public <T> void set(String namespace, String key, T value)
			throws IOException {
		try {
			if (transcoder == null)
				kv.set(key, value);
			else
				kv.set(key, value, transcoder);
		} catch (KeyValueStoreException e) {
			log.error("Error calling kv.set()", e);
			throw new IOException(e);
		}
	}

}
