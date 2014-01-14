package org.cookietrust.mtbaker.client;

import java.io.IOException;

public interface Cache {
	public <T> T get(String namespace, String key) throws IOException;

	public <T> void set(String namespace, String key, T value) throws IOException;
}
