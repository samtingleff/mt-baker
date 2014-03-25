package st.digitru.mtbaker.client;

import java.io.IOException;

public interface ConfigurationClient {

	public Configuration getConfiguration(String namespace, int ttlMillis) throws IOException;
}
