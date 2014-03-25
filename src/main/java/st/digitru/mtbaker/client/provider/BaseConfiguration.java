package st.digitru.mtbaker.client.provider;

import java.io.IOException;

import st.digitru.mtbaker.client.Configuration;


public abstract class BaseConfiguration implements Configuration {

	protected abstract String get(String namespace, String key) throws IOException;
}
