package com.cth.qas.entity;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.springframework.stereotype.Repository;

@Repository
@NodeEntity(label="Person")
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

	@Override
	public String toString() {
		return "Person [id=" + getId() + ", name=" + getName() + ", telephone="
				+ getTelephone() + ", gender=" + getGender() + ", age=" + getAge() + "]";
	}
	
	public static void main(String[] args) {

	}

}
