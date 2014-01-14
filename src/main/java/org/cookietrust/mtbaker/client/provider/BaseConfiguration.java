package org.cookietrust.mtbaker.client.provider;

import java.io.IOException;

import org.cookietrust.mtbaker.client.Configuration;


public abstract class BaseConfiguration implements Configuration {

	protected abstract String get(String namespace, String key) throws IOException;
}
