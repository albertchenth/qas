package com.cth.qas.repository;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cth.qas.entity.Company;
import com.cth.qas.entity.Person;
import com.cth.qas.relation.LendingTo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/spring*.xml" })
public class LendingToRepositoryTest {

	private static final Logger logger = LoggerFactory
			.getLogger(LendingToRepositoryTest.class);

	@Autowired
	private PersonRepository personRepository;

	@Autowired
	private BaseEntityRepository baseEntityRepository;

	@Autowired
	private LendingToRepository lendingToRepository;

	@Test
	public void testCreateRelation() {
		// Iterator<Person> it = personRepository.findAll().iterator();
		// Person zhangsan = null;
		// Person lisi = null;
		//
		// while(it.hasNext()) {
		// Person p = it.next();
		// if(p.getName().equals("zhangsan") &&
		// p.getTelephone().equals("18618808810")) {
		// zhangsan = p;
		// } else if(p.getName().equals("lisi") &&
		// p.getTelephone().equals("18618806666")) {
		// lisi = p;
		// }
		// }

		Company com = new Company();
		com.setName("中国银行");
		com.setTelephone("010-66668888");
		com.setAddress("北京复兴门内大街1号 ");

		Person lisi = new Person();
		lisi.setName("李四");
		lisi.setGender(1);
		lisi.setAge(25);
		lisi.setTelephone("18618806666");

		Person wangwu = new Person();
		wangwu.setName("王五");
		wangwu.setTelephone("18618803333");
		wangwu.setGender(0);
		wangwu.setAge(18);

		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.YEAR, 1);

		LendingTo lt = new LendingTo();
		lt.setLender(com);
		lt.setBorrower(lisi);
		lt.setAmount(new BigDecimal(10000.00));
		lt.setStartDate(new Date());
		lt.setEndDate(c.getTime());

		int pEnd = c.get(Calendar.DAY_OF_YEAR);
		c.setTime(new Date());
		int pStart = c.get(Calendar.DAY_OF_YEAR);
		lt.setPeriod(pEnd - pStart);
		lt.setRate(new BigDecimal(0.10));

		LendingTo lt1 = new LendingTo();
		lt1.setLender(com);
		lt1.setBorrower(wangwu);
		lt1.setAmount(new BigDecimal(10000.00));
		lt1.setStartDate(new Date());
		lt1.setEndDate(c.getTime());

		int pEnd1 = c.get(Calendar.DAY_OF_YEAR);
		c.setTime(new Date());
		int pStart1 = c.get(Calendar.DAY_OF_YEAR);
		lt.setPeriod(pEnd1 - pStart1);
		lt.setRate(new BigDecimal(0.10));

		Set<LendingTo> lts = new HashSet<LendingTo>();
		lts.add(lt);
		lts.add(lt1);

		com.setLendingToSet(lts);
		baseEntityRepository.save(com);

		logger.info("test ... ");
	}

}
