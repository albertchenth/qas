package com.cth.qas.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cth.qas.entity.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

}
