package me.dkist.iot.web.model;

import java.time.LocalDateTime;
import java.util.List;

import org.bson.types.ObjectId;
import org.jongo.marshall.jackson.oid.MongoObjectId;

public class Batch {
	
	@MongoObjectId
	private ObjectId id;
	
	private LocalDateTime initTime;
	
	private LocalDateTime endTime;
	
	private Status status;
	
	private List<String> notify;
	
	private Integer numberOfCups;

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public LocalDateTime getInitTime() {
		return initTime;
	}

	public void setInitTime(LocalDateTime initTime) {
		this.initTime = initTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}

	public List<String> getNotify() {
		return notify;
	}

	public void setNotify(List<String> notify) {
		this.notify = notify;
	}

	public Integer getNumberOfCups() {
		return numberOfCups;
	}

	public void setNumberOfCups(Integer numberOfCups) {
		this.numberOfCups = numberOfCups;
	}
	
	public enum Status {
		IN_PRODUCTION, COMPLETED;
	}

}
