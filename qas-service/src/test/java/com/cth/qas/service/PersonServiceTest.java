package com.cth.qas.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cth.qas.entity.Person;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/spring*.xml"})
public class PersonServiceTest {

	@Autowired
	PersonService personService;
	
	@Test
	public void testFindAll() {
		List<Person> persons = personService.findAllPersonList();
		for(Person p:persons) System.out.println(p.getName() + " " + p.getAge());
	}
}
