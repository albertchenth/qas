package com.cth.qas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cth.qas.entity.Person;
import com.cth.qas.repository.PersonRepository;
import com.google.common.collect.Lists;

@Service
public class PersonService {
	
	@Autowired
	private PersonRepository personRepository;

	public List<Person> findAllPersonList(){
		List<Person> personList = Lists.newArrayList(personRepository.findAll().iterator());
		return personList;
	}
}
