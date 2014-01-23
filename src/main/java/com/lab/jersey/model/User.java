/**
 * 
 */
package com.lab.jersey.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author paolobonansea
 *
 */
@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
public class User {
	
	@XmlElement
	private Long id;
	@XmlElement
	private String name;
	@XmlElement
	private String lastName;
	@XmlElement
	private Long idAddress;
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * @return the idAddress
	 */
	public Long getIdAddress() {
		return idAddress;
	}
	
	/**
	 * @param idAddress the idAddress to set
	 */
	public void setIdAddress(Long idAddress) {
		this.idAddress = idAddress;
	}
	
}