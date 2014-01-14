package org.cookietrust.mtbaker.client.provider.io;

import java.io.IOException;
import java.io.InputStream;

public class ResourceStreamSource implements InputStreamSource {

	private Class<?> cls;

	private String resource;

	public ResourceStreamSource(Class<?> cls, String resource) {
		this.cls = cls;
		this.resource = resource;
	}

	@Override
	public InputStream open() throws IOException {
		return cls.getResourceAsStream(resource);
	}

}
