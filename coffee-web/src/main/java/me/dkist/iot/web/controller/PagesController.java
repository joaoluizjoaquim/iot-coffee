package me.dkist.iot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import me.dkist.iot.web.person.Person;
import me.dkist.iot.web.person.PersonRepository;

@Controller
public class PagesController {
	
	@Autowired PersonRepository personRepository;
		
	@RequestMapping("/")
    public String index() {
		Person person = new Person();
		person.setName("Daniel");
		person.setRfid("" + System.currentTimeMillis());
		person.setSlackUser("daniel.kist");
		personRepository.save(person);
		return "index";
    }

}