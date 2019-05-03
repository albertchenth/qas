package com.cth.qas.entity;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.springframework.stereotype.Repository;

@Repository
@NodeEntity(label="Company")
public class Company extends BaseEntity{
	
	@Property(name="address")
	private String address;
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Company [id=" + getId() + ", name=" + getName() + ", telephone="
				+ getTelephone() + ", address=" + getAddress() + "]";
	}

	public static void main(String[] args) {

	}

}
