package me.dkist.iot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import de.undercouch.bson4jackson.types.ObjectId;
import me.dkist.iot.web.model.Person;
import me.dkist.iot.web.service.PersonService;

@Controller
public class PagesController {
	
	@Autowired PersonService service;
		
	@RequestMapping("/")
    public String index() {
		Person person = new Person();
		//person.setId(new ObjectId());
		person.setName("Daniel");
		person.setRfid("" + System.currentTimeMillis());
		person.setSlackUser("daniel.kist");
		//service.getCollection().save(person);
		return "index";
    }

}