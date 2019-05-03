package com.cth.qas.repository;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cth.qas.entity.Person;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/spring*.xml"})
public class PersonRepositoryTest {
	
	@Autowired
	private PersonRepository personRepository;
	
//	 @Test
	public void testCRUDPerson() {
		Person person = new Person();
		person = personRepository.save(person);
		assertNotNull(person);
		assertNotNull(person.getId());

		Long personId = person.getId();
		personRepository.delete(person);
		
		Optional<Person> op = personRepository.findById(personId);
		assertFalse(op.isPresent());
	}
	
	 @Test
	public void testFindAllPerson() {
		Iterator<Person> it = personRepository.findAll().iterator();
		while(it.hasNext()) {
			Person p = it.next();
			System.out.println("person's name = " + p.getName());
		}
	}
	
//	 @Test
	public void testCreatePerson() {
		Person person1 = new Person();
		person1.setName("zhangsan");
		personRepository.save(person1);
		
		Person person2 = new Person();
		person2.setName("lisi");
		personRepository.save(person2);
	}
	
	// @Test
	public void testDeletePerson() {
		// personRepository.deleteAll();
		Iterable<Person> it = personRepository.findAll();
		personRepository.deleteAll(it);
	}
}
