package com.cth.qas.base;

import java.util.Set;

import org.neo4j.ogm.annotation.CompositeIndex;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.Index;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.Relationship;

import com.cth.qas.relation.LendingTo;

@NodeEntity
//@CompositeIndex(properties={"name","telephone"},unique=true)
public class BaseEntity {
	
	@Id @GeneratedValue
	private Long id;
	
	@Property(name="name")
	private String name;
	
	@Index(unique=true)
	@Property(name="telephone")
	private String telephone;
	
	@Relationship(type="LENDING_TO")
	private Set<LendingTo> lendingToSet;
	
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

	public Set<LendingTo> getLendingToSet() {
		return lendingToSet;
	}

	public void setLendingToSet(Set<LendingTo> lendingToSet) {
		this.lendingToSet = lendingToSet;
	}

}
