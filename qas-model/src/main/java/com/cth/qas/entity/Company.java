package com.cth.qas.entity;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.springframework.stereotype.Repository;

@Repository
@NodeEntity(label="Company")
public class Company {
	
	@Id @GeneratedValue
	private Long id;
	
	@Property(name="full_name")
	private String fullName;
	
	@Property(name="address")
	private String address;
	
	@Property(name="telephone")
	private String telephone;

	public static void main(String[] args) {

	}

}
