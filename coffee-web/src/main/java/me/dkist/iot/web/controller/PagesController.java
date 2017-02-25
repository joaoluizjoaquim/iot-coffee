package me.dkist.iot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import me.dkist.iot.web.person.Person;
import me.dkist.iot.web.person.PersonRepository;

@RestController
public class PagesController {
	
	@Autowired 
	private PersonRepository personRepository;
		
	@RequestMapping(value="/",method=RequestMethod.GET)
    public String index() {
		Person person = new Person();
		person.setName("Daniel");
		person.setRfid("" + System.currentTimeMillis());
		person.setSlackUser("daniel.kist");
		personRepository.save(person);
		return "index";
    }

}