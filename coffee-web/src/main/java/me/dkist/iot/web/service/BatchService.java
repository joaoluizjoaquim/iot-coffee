package me.dkist.iot.web.service;

import org.jongo.Jongo;
import org.jongo.MongoCollection;
import org.springframework.stereotype.Service;

import com.mongodb.MongoClient;

@Service
public class BatchService {

	private final static Jongo jongo = new Jongo(new MongoClient().getDB("iot-coffee"));
	
	public final MongoCollection getCollection() {
		return jongo.getCollection("bacth");
	}
	
	
}
