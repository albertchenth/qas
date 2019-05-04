package com.cth.qas.entity;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.springframework.stereotype.Repository;

import com.cth.qas.base.BaseEntity;
import com.cth.qas.base.EntityType;

@Repository
@NodeEntity(label=EntityType.COMPANY)
public class Company extends BaseEntity{
	
	@Property(name="address")
	private String address;
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public static void main(String[] args) {

	}

}
