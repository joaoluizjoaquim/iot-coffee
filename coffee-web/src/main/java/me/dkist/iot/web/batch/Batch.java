package me.dkist.iot.web.batch;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Batch {
	
	@Id
	private ObjectId id;
	
	private ObjectId maker;
	
	private LocalDateTime insertTime;
	
	private LocalDateTime initTime;
	
	private LocalDateTime endTime;
	
	private BatchStatus status;
	
	private List<ObjectId> notify;
	
	private Integer numberOfCups;
	
	public void addRfidToPool(ObjectId personId) {
		if(this.notify == null) this.notify = new ArrayList<>();
		if(getNotify().stream().filter(r -> r.equals(personId)).count() == 0) getNotify().add(personId);
	}
	
	public BatchStatus getStatus() {
		return status;
	}

	public void setStatus(BatchStatus status) {
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

	public List<ObjectId> getNotify() {
		return notify;
	}

	public void setNotify(List<ObjectId> notify) {
		this.notify = notify;
	}

	public Integer getNumberOfCups() {
		return numberOfCups;
	}

	public void setNumberOfCups(Integer numberOfCups) {
		this.numberOfCups = numberOfCups;
	}
	
	public enum BatchStatus {
		PENDING, IN_PRODUCTION, COMPLETED, CLOSED;
	}

	public LocalDateTime getInsertTime() {
		return insertTime;
	}

	public void setInsertTime(LocalDateTime insertTime) {
		this.insertTime = insertTime;
	}

	public ObjectId getMaker() {
		return maker;
	}

	public void setMaker(ObjectId maker) {
		this.maker = maker;
	}

}
