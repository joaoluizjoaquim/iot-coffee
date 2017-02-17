package me.dkist.iot.web.model;

import org.bson.types.ObjectId;
import org.jongo.marshall.jackson.oid.MongoId;
import org.jongo.marshall.jackson.oid.MongoObjectId;

public class Person {
	
	@MongoId
	@MongoObjectId
	private ObjectId id;
	
	private String name;
	
	private String rfid;
	
	private String slackUser;

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRfid() {
		return rfid;
	}

	public void setRfid(String rfid) {
		this.rfid = rfid;
	}

	public String getSlackUser() {
		return slackUser;
	}

	public void setSlackUser(String slackUser) {
		this.slackUser = slackUser;
	}

}
