package me.dkist.iot.web.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Batch {
	
	@Id
	private ObjectId id;
	
	private LocalDateTime initTime;
	
	private LocalDateTime endTime;
	
	private Status status;
	
	private List<String> notify;
	
	private Integer numberOfCups;
	
	public void addRfidToPool(String rfid) {
		if(this.notify == null) this.notify = new ArrayList<>();
		if(getNotify().stream().filter(r -> r.equals(rfid)).count() == 0) getNotify().add(rfid);
	}
	
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

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
		PENDING, IN_PRODUCTION, COMPLETED;
	}

}
