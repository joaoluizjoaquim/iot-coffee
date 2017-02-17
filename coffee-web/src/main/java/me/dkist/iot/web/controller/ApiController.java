package me.dkist.iot.web.controller;

import java.io.IOException;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import me.dkist.iot.web.model.Person;

@RestController
public class ApiController {
	
	final String API = "/api/v1";
	
	// 
	@RequestMapping(value=API + "/rfid/{rfid}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public Person loginConvaniado(@PathVariable String rfid) throws IOException {
		Person p = new Person();
		p.setRfid(rfid);
		System.out.println(rfid);
		return p;
	}
	
	@RequestMapping(value=API + "/coffee-machine/status/{status}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public Person coffeeMachineStatus(@PathVariable String status) throws IOException {
		
		return null;
	}

}