package me.dkist.iot.web.person;

import java.time.LocalDateTime;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Person {
	
	@Id
	private ObjectId id;
	
	private String name;
	
	private String rfid;
	
	private String slackUser;
	
	private LocalDateTime insertTime;

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

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public LocalDateTime getInsertTime() {
		return insertTime;
	}

	public void setInsertTime(LocalDateTime insertTime) {
		this.insertTime = insertTime;
	}

	
	
}
