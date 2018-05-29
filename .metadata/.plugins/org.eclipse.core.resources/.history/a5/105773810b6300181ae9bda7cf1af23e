package com.sbank.model;
import java.sql.Timestamp;
import java.util.UUID;
import org.springframework.data.annotation.Id;

public class Audit {

/*EventId - UUID
eventName - String
eventType - String
eventDate - timestamp
userId - String
oldValue - BaseEntity
newValue - BaseEntity */
	/**-------audit id reference-------.*/
	public String auditId;
	
  /**--------EventId----------.*/
  public UUID eventId;
  
  /**------------event  names-----------.*/
  public String eventName;
  


  /**---- EVENT TTYPES----------.*/
  public String eventType;
  
  /**---------EVENT STAMP-----------.*/
  public Timestamp eventDate;
  
  /**------userId---------.*/
  public String userId;
  
  /**--------old value--------------.*/
  public Object oldValue;
  
  /**---------new value ----------.*/
  public Object newValue;
  
	public Audit()
	{
	  
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
	public String getAuditId() {
    return auditId;
  }

  public void setAuditId(String auditId) {
    this.auditId = auditId;
  }

  public UUID getEventId() {
    return eventId;
  }

  public void setEventId(UUID eventId) {
    this.eventId = eventId;
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
