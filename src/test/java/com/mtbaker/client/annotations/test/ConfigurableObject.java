package com.mtbaker.client.annotations.test;

import com.mtbaker.client.annotations.Configurable;
import com.mtbaker.client.annotations.ConfigurableField;

@Configurable(namespace = "test")
public class ConfigurableObject {

	@ConfigurableField("test.string")
	private String someString;

	@ConfigurableField("test.boolean")
	private boolean someBoolean;

	@ConfigurableField("test.integer")
	private int someInteger;

	@ConfigurableField("test.long")
	private long someLong;

	@ConfigurableField("test.double")
	private double someDouble;

	@ConfigurableField("test.double.not.found")
	private double someOtherDouble = 13.4;

	public String getSomeString() {
		return someString;
	}

	public void setSomeString(String someString) {
		this.someString = someString;
	}

	public boolean isSomeBoolean() {
		return someBoolean;
	}

	public void setSomeBoolean(boolean someBoolean) {
		this.someBoolean = someBoolean;
	}

	public int getSomeInteger() {
		return someInteger;
	}

	public void setSomeInteger(int someInteger) {
		this.someInteger = someInteger;
	}

	public long getSomeLong() {
		return someLong;
	}

	public void setSomeLong(long someLong) {
		this.someLong = someLong;
	}

	public double getSomeDouble() {
		return someDouble;
	}

	public void setSomeDouble(double someDouble) {
		this.someDouble = someDouble;
	}

	public double getSomeOtherDouble() {
		return someOtherDouble;
	}

	public void setSomeOtherDouble(double someOtherDouble) {
		this.someOtherDouble = someOtherDouble;
	}
}
