package org.cookietrust.mtbaker.client;

import java.io.IOException;

public interface ConfigurationClient {

	public Configuration getConfiguration(String namespace, int ttlMillis) throws IOException;
}
