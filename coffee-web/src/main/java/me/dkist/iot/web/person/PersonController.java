
package me.dkist.iot.web.person;

import java.io.IOException;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class PersonController {
	
	
	@RequestMapping(value = "/rfid/{rfid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Person loginConvaniado(@PathVariable String rfid) throws IOException {
		Person p = new Person();
		p.setRfid(rfid);
		System.out.println(rfid);
		return p;
	}

	@RequestMapping(value = "/coffee-machine/status/{status}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Person coffeeMachineStatus(@PathVariable String status) throws IOException {

		return null;
	}


}