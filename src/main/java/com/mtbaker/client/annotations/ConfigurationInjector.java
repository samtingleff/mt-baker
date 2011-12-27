package com.mtbaker.client.annotations;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;

import com.mtbaker.client.Configuration;
import com.mtbaker.client.ConfigurationClient;

public class ConfigurationInjector {
	private ConfigurationClient client;

	public ConfigurationInjector(ConfigurationClient client) {
		this.client = client;
	}

	public ConfigurationInjector() {
	}

	public void setConfigurationClient(ConfigurationClient client) {
		this.client = client;
	}

	public void inject(Object obj) throws IOException {
		Class<?> cls = obj.getClass();
		String namespace = null;
		Configurable c = cls.getAnnotation(Configurable.class);
		if (c != null)
			namespace = c.value();
		inject(obj, namespace);
	}

	public void inject(Object obj, String namespace) throws IOException {
		Class<?> cls = obj.getClass();
		Configuration conf = client.getConfiguration(namespace, 1000);
		Field[] fields = cls.getDeclaredFields();
		for (Field f : fields) {
			ConfigurableField cf = f.getAnnotation(ConfigurableField.class);
			if (cf != null) {
				Class<?> type = f.getType();
				setField(conf, obj, cf, f, type);
			}
		}
	}

	@SuppressWarnings("unchecked")
	private void setField(Configuration conf, Object obj, ConfigurableField cf,
			Field f, Class<?> type) {
		try {
			f.setAccessible(true);
			Object defaultValue = f.get(obj);
			if (String.class.equals(type))
				f.set(obj, conf.getString(cf.value(), (String) defaultValue));
			else if (Boolean.class.equals(type))
				f.set(obj, conf.getBoolean(cf.value(), (Boolean) defaultValue));
			else if (boolean.class.equals(type))
				f.set(obj, conf.getBoolean(cf.value(), (Boolean) defaultValue));
			else if (Integer.class.equals(type))
				f.set(obj, conf.getInteger(cf.value(), (Integer) defaultValue));
			else if (int.class.equals(type))
				f.set(obj, conf.getInteger(cf.value(), (Integer) defaultValue));
			else if (Long.class.equals(type))
				f.set(obj, conf.getLong(cf.value(), (Long) defaultValue));
			else if (long.class.equals(type))
				f.set(obj, conf.getLong(cf.value(), (Long) defaultValue));
			else if (Double.class.equals(type))
				f.set(obj, conf.getDouble(cf.value(), (Double) defaultValue));
			else if (double.class.equals(type))
				f.set(obj, conf.getDouble(cf.value(), (Double) defaultValue));
			else if (List.class.equals(type)) {
				// use the type() hint if present
				Class<?> listType = cf.type();
				if (listType != null) {
					if (String.class.equals(listType))
						f.set(obj, conf.getStringList(cf.value(),
								(List<String>) defaultValue));
					else if (Integer.class.equals(listType))
						f.set(obj, conf.getIntegerList(cf.value(),
								(List<Integer>) defaultValue));
					else if (Long.class.equals(listType))
						f.set(obj, conf.getLongList(cf.value(),
								(List<Long>) defaultValue));
					else if (Double.class.equals(listType))
						f.set(obj, conf.getDoubleList(cf.value(),
								(List<Double>) defaultValue));
				} else {
					// otherwise assume a string
					f.set(obj, conf.getStringList(cf.value(),
							(List<String>) defaultValue));
				}
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
		}
	}
}
