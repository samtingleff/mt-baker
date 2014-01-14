package org.cookietrust.mtbaker.client;

import java.io.IOException;

public class NullCache implements Cache {

	@Override
	public <T> T get(String namespace, String key) throws IOException {
		return null;
	}

	@Override
	public <T> void set(String namespace, String key, T value)
			throws IOException {
	}

}
