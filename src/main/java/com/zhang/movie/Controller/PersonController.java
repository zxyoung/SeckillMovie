package com.zhang.movie.Controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhang.movie.Model.Person;
import com.zhang.movie.Service.PersonService;

@Controller
@RequestMapping("/user.do")
public class PersonController {
	
	@Autowired
	@Qualifier("PersonServiceImpl")
	private PersonService personService;
	
	@RequestMapping(params="method=login")
	public String add(Person person){
		System.out.println("personname:"+person.getName());  
        System.out.println("author:"+person.getEmail());  
//        personService.add(person);  
		
		return "/jsp/success";
	}

	@RequestMapping(params="method=update")
	public String update(Person person){
		personService.equals(person);
		return "success";
	}
	
	public PersonService getPersonService() {
		return personService;
	}

	@Resource
	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}
	
}	
