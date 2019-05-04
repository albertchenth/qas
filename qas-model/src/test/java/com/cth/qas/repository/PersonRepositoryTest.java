package com.cth.qas.repository;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
	
//	 @Test
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
		person1.setGender(0);
		person1.setAge(36);
		person1.setTelephone("18618808810");
		personRepository.save(person1);
		
		Person person2 = new Person();
		person2.setName("lisi");
		person2.setGender(1);
		person2.setAge(25);
		person2.setTelephone("18618806666");
		personRepository.save(person2);
	}
	
	// @Test
	public void testDeletePerson() {
		// personRepository.deleteAll();
		Iterable<Person> it = personRepository.findAll();
		personRepository.deleteAll(it);
	}
	
//	@Test
	public void testFindPerson() {
		List<Person> personList = personRepository.findByName("李四");
		for(Person p:personList) System.out.println(p.getName());
		personList = personRepository.findByAgeAndGender(19, 0);
		System.out.println("size="+personList.size());
	}
	
//	@Test
	public void testPageAndSort(){
		Sort sort = new Sort(Sort.Direction.DESC, "age");
		Pageable pageable = PageRequest.of(0, 1,sort);
		Page<Person> page = personRepository.findAll(pageable);
		Person p1 = page.getContent().get(0);
		System.out.println(p1.getName() + " " + p1.getAge());
	}
	
	@Test
	public void testQueryAnnotation(){
		Sort sort = new Sort(Sort.Direction.ASC, "person.age");
		List<Person> persons = personRepository.getPersonBorrowFromCompany(sort);
		for(Person p:persons) System.out.println(p.getName() + " " + p.getAge());
	}
}
