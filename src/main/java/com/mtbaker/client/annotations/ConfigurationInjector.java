package com.mtbaker.client.annotations;

import java.io.IOException;
import java.lang.reflect.Field;

import com.mtbaker.client.Configuration;

public class ConfigurationInjector {

	public void inject(Configuration conf, Object obj) {
		Class<?> cls = obj.getClass();
		Configurable c = cls.getAnnotation(Configurable.class);
		if (c != null) {
			Field[] fields = cls.getDeclaredFields();
			for (Field f : fields) {
				ConfigurableField cf = f.getAnnotation(ConfigurableField.class);
				if (cf != null) {
					Class<?> type = f.getType();
					setField(conf, obj, cf, f, type);
				}
			}
		}
	}

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
