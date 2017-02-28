package me.dkist.iot.web.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import me.dkist.iot.web.person.Person;
import me.dkist.iot.web.person.PersonRepository;

@Controller
public class PagesController {
	
	@Autowired 
	private PersonRepository personRepository;
		
	@RequestMapping(value="/",method=RequestMethod.GET)
    public String index() {
		Person person = new Person();
		person.setName("Daniel");
		person.setRfid("" + System.currentTimeMillis());
		person.setSlackUser("daniel.kist");
		person.setInsertTime(LocalDateTime.now());
		personRepository.save(person);
		
		List<Person> list = personRepository.findUsersBySlack("daniel.kist");
		System.out.println(list.size());
		
		return "index";
    }

}