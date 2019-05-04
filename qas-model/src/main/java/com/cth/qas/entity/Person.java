package com.cth.qas.entity;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.springframework.stereotype.Repository;

import com.cth.qas.base.BaseEntity;
import com.cth.qas.base.EntityType;

@Repository
@NodeEntity(label=EntityType.PERSON)
public class Person extends BaseEntity{
	
	@Property(name="gender")
	private int gender;
	
	@Property(name="age")
	private int age;
	
	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public static void main(String[] args) {

	}

}
