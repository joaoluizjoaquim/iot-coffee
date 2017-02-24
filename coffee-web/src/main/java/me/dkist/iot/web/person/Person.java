package me.dkist.iot.web.person;

import org.springframework.data.annotation.Id;

public class Person {
	
	@Id
	private String id;
	
	private String name;
	
	private String rfid;
	
	private String slackUser;

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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
	
}
