package com.mtbaker.client.provider.xml;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType
public class PropertySetType {

	@XmlAttribute(name = "name", required = true)
	private String name;

	@XmlElement(name = "property", required = true)
	private List<PropertyType> properties;

	public PropertySetType(String name, List<PropertyType> properties) {
		super();
		this.name = name;
		this.properties = properties;
	}

	public PropertySetType() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<PropertyType> getProperties() {
		return properties;
	}

	public void setProperties(List<PropertyType> properties) {
		this.properties = properties;
	}
}
