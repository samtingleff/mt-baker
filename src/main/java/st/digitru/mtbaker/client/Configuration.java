package st.digitru.mtbaker.client;

import java.io.IOException;
import java.util.List;

public interface Configuration {

	public String getString(String key, String defaultValue) throws IOException;

	public boolean getBoolean(String key, boolean defaultValue) throws IOException;

	public int getInteger(String key, int defaultValue) throws IOException;

	public long getLong(String key, long defaultValue) throws IOException;

	public double getDouble(String key, double defaultValue) throws IOException;

	public List<String> getStringList(String key, List<String> defaultValue) throws IOException;

	public List<Integer> getIntegerList(String key, List<Integer> defaultValue) throws IOException;

	public List<Long> getLongList(String key, List<Long> defaultValue) throws IOException;

	public List<Double> getDoubleList(String key, List<Double> defaultValue) throws IOException;
}
