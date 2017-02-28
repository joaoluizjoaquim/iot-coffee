
package me.dkist.iot.web.batch;

import java.io.IOException;
import java.time.LocalDateTime;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import me.dkist.iot.web.batch.Batch.BatchStatus;
import me.dkist.iot.web.person.Person;
import me.dkist.iot.web.person.PersonRepository;

@RestController
@RequestMapping("/api/v1/batch")
public class BatchController {
	
	//@Autowired MongoTemplate mongoTemplate;
	@Autowired BatchRepository batchRepository;
	@Autowired PersonRepository personRepository;
	
	@RequestMapping(value = "/{status}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Document coffeeMachineStatus(@PathVariable BatchStatus status) throws IOException {
		if(status.equals(BatchStatus.IN_PRODUCTION)) {
			Batch b = batchRepository.findOpenBatch();
			if(b == null) {
				b = new Batch();
				b.setInsertTime(LocalDateTime.now());
			}
			b.setInitTime(LocalDateTime.now());
			b.setStatus(status);
			batchRepository.save(b);
		} else if(status.equals(BatchStatus.COMPLETED)) {
			Batch b = batchRepository.findOpenBatch();
			if(b != null) {
				b.setStatus(status);
				b.setEndTime(LocalDateTime.now());
				b.setNumberOfCups(38); //TODO Implement calc for cups/time
				batchRepository.save(b);
				notifyPersons(b);
			}
		}
		return new Document("status", "ok");
	}
	
	@Async 
	private void notifyPersons(Batch b) {
		if(b.getNotify() == null || b.getNotify().size() == 0) return;
		Person maker = personRepository.findById(b.getNotify().remove(0));
		sendSlackNotification(maker);
		try {Thread.sleep(30000);} catch (InterruptedException e) {e.printStackTrace();}
		b.getNotify().forEach(personId -> {
			Person p = personRepository.findById(personId);
			sendSlackNotification(p);
		});
	}
	
	private void sendSlackNotification(Person p) {
		if(p == null) return;
		System.out.println("Notification: " + p.getId());
	}

}