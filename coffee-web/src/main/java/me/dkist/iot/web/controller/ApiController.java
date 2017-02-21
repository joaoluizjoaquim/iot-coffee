package me.dkist.iot.web.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import me.dkist.iot.web.manager.ApiManager;

@RestController
public class ApiController {
	
	final String API = "/api/v1";
	
	@Autowired ApiManager manager;
	
	@RequestMapping(value=API + "/rfid/{rfid}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public String loginConvaniado(@PathVariable String rfid) throws IOException {
		manager.addPersonToNotificationPool(rfid);
		return "OK";
	}
	
	@RequestMapping(value=API + "/coffee-machine/status/{status}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public String coffeeMachineStatus(@PathVariable String status) throws IOException {
		
		return "OK";
	}

}