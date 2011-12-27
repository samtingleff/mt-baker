package com.mtbaker.client.annotations.test;

import java.util.Arrays;
import java.util.List;

import com.mtbaker.client.annotations.Configurable;
import com.mtbaker.client.annotations.ConfigurableField;

@Configurable("test")
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

	@ConfigurableField("test.string.list")
	private List<String> someStringList;

	@ConfigurableField(value = "test.integer.list", type = Integer.class)
	private List<Integer> someIntegerList;

	@ConfigurableField(value = "test.long.list", type = Long.class)
	private List<Long> someLongList;

	@ConfigurableField(value = "test.double.list", type = Double.class)
	private List<Double> someDoubleList;

	@ConfigurableField(value = "test.double.list.not.found", type = Double.class)
	private List<Double> someOtherDoubleList = Arrays.asList(13.4, 50.5);

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

	public List<String> getSomeStringList() {
		return someStringList;
	}

	public void setSomeStringList(List<String> someStringList) {
		this.someStringList = someStringList;
	}

	public List<Integer> getSomeIntegerList() {
		return someIntegerList;
	}

	public void setSomeIntegerList(List<Integer> someIntegerList) {
		this.someIntegerList = someIntegerList;
	}

	public List<Long> getSomeLongList() {
		return someLongList;
	}

	public void setSomeLongList(List<Long> someLongList) {
		this.someLongList = someLongList;
	}

	public List<Double> getSomeDoubleList() {
		return someDoubleList;
	}

	public void setSomeDoubleList(List<Double> someDoubleList) {
		this.someDoubleList = someDoubleList;
	}

	public List<Double> getSomeOtherDoubleList() {
		return someOtherDoubleList;
	}

	public void setSomeOtherDoubleList(List<Double> someOtherDoubleList) {
		this.someOtherDoubleList = someOtherDoubleList;
	}
}
