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
//		Batch b = loadBatch();
//		if(b == null) {
//			//New pending batch
//			b = new Batch();
//			b.setInitTime(LocalDateTime.now());
//			b.setEndTime(LocalDateTime.now());
//			b.setStatus(Status.PENDING);
//		}
//		b.addRfidToPool(rfid);
//		batchService.getCollection().save(b);
	}
	
	public void createOrUpdateBatch() {
		Batch b = loadBatch();
		if(b == null) {
			//New batch
			b = new Batch();
			b.setInitTime(LocalDateTime.now());
			b.setEndTime(LocalDateTime.now());
			b.setStatus(Status.IN_PRODUCTION);
			batchService.getCollection().save(b);
		} else if(b.getEndTime().isAfter(LocalDateTime.now().minusSeconds(10))) {
			//Update existing batch
			b.setEndTime(LocalDateTime.now());
			b.setStatus(Status.IN_PRODUCTION);
			batchService.getCollection().save(b);
		} else {
			b.setEndTime(LocalDateTime.now());
			b.setStatus(Status.COMPLETED);
			batchService.getCollection().save(b);
		}
	}
	
	private Batch loadBatch() {
		return batchService.getCollection().findOne("{ status : {$in : [#, #] } }", Status.IN_PRODUCTION, Status.PENDING).orderBy("{_id : -1}").as(Batch.class);
	}

}
