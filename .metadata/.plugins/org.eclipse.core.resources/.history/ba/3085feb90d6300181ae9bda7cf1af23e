package com.sbank.model;

import java.sql.Timestamp;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Audit {

/*EventId - UUID
eventName - String
eventType - String
eventDate - timestamp
userId - String
oldValue - BaseEntity
newValue - BaseEntity */
	@Id
	public UUID EventId;
	public String eventName;
	public String eventType;
	public Timestamp eventDate;
	public String userId;
	public Object oldValue;
	public Object newValue;
	

	
	public Audit() {
		EventId = UUID.randomUUID();
	}
	public UUID getEventId() {
		return EventId;
	}
	public void setEventId(UUID eventId) {
		EventId = UUID.randomUUID();
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getEventType() {
		return eventType;
	}
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	public Timestamp getEventDate() {
		return eventDate;
	}
	public void setEventDate(Timestamp eventDate) {
		this.eventDate = eventDate;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Object getOldValue() {
		return oldValue;
	}
	public void setOldValue(Object oldValue) {
		this.oldValue = oldValue;
	}
	public Object getNewValue() {
		return newValue;
	}
	public void setNewValue(Object newValue) {
		this.newValue = newValue;
	}

	
}
