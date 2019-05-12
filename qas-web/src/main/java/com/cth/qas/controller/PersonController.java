package com.cth.qas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cth.qas.appbase.AppPage;
import com.cth.qas.entity.Person;
import com.cth.qas.service.PersonService;

@Controller
@RequestMapping(value = "/person", method = RequestMethod.GET)
public class PersonController {
	
	public static final int PAGE_SIZE = 5;

	@Autowired
	PersonService personService;
	
	@Autowired
	AppPage p;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String findUsersByPage(Integer pageNo, Model model) {
		try {
			pageNo = (pageNo==null?1:pageNo);
		 
			p.setTotalUsers(personService.findAllPersonList().size());
			p.setCurrentPage(pageNo);
			
			Pageable pageable = PageRequest.of(pageNo-1, PAGE_SIZE);
			Page<Person> personPage = personService.findPersonsByPage(pageable);
			List<Person> personList = personPage.getContent(); // 查询结果是list集合
			
			model.addAttribute("list", personList);
			model.addAttribute("page", p);
			return "person_list";
		} catch (Exception e) {
			model.addAttribute("error_message", "未能获取数据");
			return "error_message";
		}
	}

}
