package org.cookietrust.mtbaker.client.provider.xml;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "configuration")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "configuration")
public class ConfigurationType {

    @XmlElement(name = "namespace", required = true)
	private List<PropertySetType> namespaces;

	public ConfigurationType(List<PropertySetType> namespaces) {
		super();
		this.namespaces = namespaces;
	}

	public ConfigurationType() {
	}

	public List<PropertySetType> getNamespaces() {
		return namespaces;
	}

	public void setNamespaces(List<PropertySetType> namespaces) {
		this.namespaces = namespaces;
	}

}
