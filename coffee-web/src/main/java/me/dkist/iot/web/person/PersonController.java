
package me.dkist.iot.web.person;

import java.io.IOException;
import java.time.LocalDateTime;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import me.dkist.iot.web.batch.Batch;
import me.dkist.iot.web.batch.Batch.BatchStatus;
import me.dkist.iot.web.batch.BatchRepository;

@RestController
@RequestMapping("/api/v1/person")
public class PersonController {
	
	@Autowired PersonRepository personRepository;
	@Autowired BatchRepository batchRepository;
	
	@RequestMapping(value = "/rfid/{rfid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Document rfid(@PathVariable String rfid) throws IOException {
		Person p = personRepository.findUsersByRfid(rfid);
		if(p == null) p = createJohnDoe(rfid);
		
		Batch b = batchRepository.findOpenBatch();
		if(b == null) b = createNewPendindBatch();
		if(b.getStatus().equals(BatchStatus.IN_PRODUCTION) && b.getMaker() == null) {
			b.setMaker(p.getId());
		}
		b.addRfidToPool(p.getId());
		batchRepository.save(b);
		return new Document("status", "ok");
	}
	
	private Batch createNewPendindBatch() {
		Batch b = new Batch();
		b.setStatus(BatchStatus.PENDING);
		b.setInsertTime(LocalDateTime.now());
		b = batchRepository.save(b);
		return b;
	}

	private Person createJohnDoe(String rfid) {
		Person p = new Person();
		p.setName("-John Doe-");
		p.setSlackUser("@johndoe");
		p.setRfid(rfid);
		p.setInsertTime(LocalDateTime.now());		
		p = personRepository.save(p);
		return p;
	}


}