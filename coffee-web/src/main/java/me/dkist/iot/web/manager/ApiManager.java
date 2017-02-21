package me.dkist.iot.web.manager;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import me.dkist.iot.web.model.Batch;
import me.dkist.iot.web.model.Batch.Status;
import me.dkist.iot.web.model.Person;
import me.dkist.iot.web.service.BatchService;
import me.dkist.iot.web.service.PersonService;

@Component
public class ApiManager {

	@Autowired PersonService personService;
	
	@Autowired BatchService batchService;
	
	public void addPersonToNotificationPool(String rfid) {
		Person p = personService.getCollection().findOne("{rfid : #}", rfid).as(Person.class);
		if(p == null) {
			p = new Person();
			p.setName("-John Doe-");
			p.setRfid(rfid);
			p.setSlackUser("@johnboe");
			personService.getCollection().save(p);
		}
	}
	
	public void createOrUpdateBatch() {
		Batch b = batchService.getCollection().findOne("{ status : # }", Status.IN_PRODUCTION).orderBy("{_id : -1}").as(Batch.class);
		if(b == null) {
			//New batch
			b = new Batch();
			b.setInitTime(LocalDateTime.now());
			batchService.getCollection().save(b);
		} else {
			//Update existing batch
		}
		
	}

}
