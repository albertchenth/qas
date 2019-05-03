package com.cth.qas.entity;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.Property;

public class BaseEntity {
	
	@Id @GeneratedValue
	private Long id;
	
	@Property(name="name")
	private String name;
	
	@Property(name="telephone")
	private String telephone;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Override
	public String toString() {
		return "BaseEntity [id=" + id + ", name=" + name + ", telephone="
				+ telephone + "]";
	}

	public static void main(String[] args) {

	}

}
