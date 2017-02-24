package me.dkist.iot.web.service;

import org.jongo.MongoCollection;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

	//private final static Jongo jongo = new Jongo(new MongoClient().getDB("iot-coffee"));
	
	public final MongoCollection getCollection() {
		//return jongo.getCollection("person");
		return null;
	}
	
	
}
