package org.cookietrust.mtbaker.client;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class LoggingErrorHandler implements ErrorHandler {
	private static Log exceptions = LogFactory.getLog("mtbaker.exceptions");

	private static Log other = LogFactory.getLog("mtbaker.errors");

	@Override
	public void exception(String namespace, String key, Throwable error) {
		exceptions.error(
				String.format("Exception reading key (%1$s) from namespace (%2$s)",
				key, namespace),
				error);
	}

	@Override
	public void numberFormatException(String value, Class<? extends Number> cls) {
		other.error(
				String.format("Could not read number type %1$s from value %2$s", cls, value));
	}

}
