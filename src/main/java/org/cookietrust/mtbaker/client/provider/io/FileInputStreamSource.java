package org.cookietrust.mtbaker.client.provider.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileInputStreamSource implements InputStreamSource {

	private File f;

	public FileInputStreamSource(File f) {
		this.f = f;
	}

	@Override
	public InputStream open() throws IOException {
		return new FileInputStream(f);
	}

}
