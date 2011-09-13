package com.mtbaker.client.provider.valkyrie;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.mtbaker.client.Configuration;
import com.mtbaker.client.provider.AbstractConfiguration;
import com.othersonline.kv.KeyValueStore;
import com.othersonline.kv.KeyValueStoreException;
import com.othersonline.kv.transcoder.StringTranscoder;
import com.othersonline.kv.transcoder.Transcoder;

public class ValkyrieConfiguration extends AbstractConfiguration implements Configuration {
	private static Log log = LogFactory.getLog(ValkyrieConfiguration.class);

	private Transcoder transcoder = new StringTranscoder();

	private KeyValueStore kv;

	public void setKeyValueStore(KeyValueStore kv) {
		this.kv = kv;
	}

	@Override
	protected String get(String namespace, String key) throws IOException {
		try {
			return (String) kv.get(key, transcoder);
		} catch (KeyValueStoreException e) {
			log.error("Error calling kv.get()", e);
			if (errors != null)
				errors.exception(namespace, key, e);
			throw new IOException(e);
		}
	}

}
