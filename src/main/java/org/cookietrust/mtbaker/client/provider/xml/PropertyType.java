package org.cookietrust.mtbaker.client.provider.xml;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType
public class PropertyType {

    @XmlAttribute(name = "name", required = true)
	private String name;

    @XmlElement(name = "value", required = false)
	private List<String> values;

	public PropertyType(String name, List<String> values) {
		super();
		this.name = name;
		this.values = values;
	}

	public PropertyType() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getValues() {
		return values;
	}

	public void setValues(List<String> values) {
		this.values = values;
	}
}
