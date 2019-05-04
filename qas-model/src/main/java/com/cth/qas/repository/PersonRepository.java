package com.cth.qas.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import com.cth.qas.entity.Person;

@Repository
public interface PersonRepository extends Neo4jRepository<Person, Long> {

	List<Person> findByName(String name);

	List<Person> findByTelephone(String telephone);
	
	List<Person> findByAgeAndGender(int age,int gender);
	
	Page<Person> findAll(Pageable pageable);
	
	@Query("match (:COMPANY)-[:LENDING_TO]->(person:PERSON) return person")
	List<Person> getPersonBorrowFromCompany(Sort sort);
}
