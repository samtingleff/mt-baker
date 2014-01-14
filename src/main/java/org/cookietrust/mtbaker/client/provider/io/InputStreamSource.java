package org.cookietrust.mtbaker.client.provider.io;

import java.io.IOException;
import java.io.InputStream;

public interface InputStreamSource {

	public InputStream open() throws IOException;
}
