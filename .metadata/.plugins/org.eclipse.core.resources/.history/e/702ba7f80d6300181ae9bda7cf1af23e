package com.sbank.Sbank;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sbank.exception.HandleException;
import com.sbank.model.Audit;
import com.sbank.repository.AuditRepository;
import com.sbank.service.AuditServiceImpl;
import com.sbank.wrapper.UpdateAudit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SbankAuditTests {
	
	@InjectMocks
	AuditServiceImpl auditServiceImpl;
	
	@Mock
	AuditRepository auditRepository;

	@Test
	public void createAuditSuccess() throws HandleException {
		
		Audit audit = new Audit();
		
		
		Timestamp temp = new Timestamp(1234);
		audit.setEventDate(temp);
		
		UUID id = new UUID(0, 0);
		
		audit.setEventId(id);
		Object object = new Object();
		audit.setEventName("MyEvent");
		audit.setEventType("MyEventType");
		audit.setNewValue(object);
		audit.setOldValue(object);
		audit.setUserId("111111");
		
		when(auditRepository.save(Mockito.<Audit>any())).thenReturn(audit);
		assertEquals("MyEvent",auditServiceImpl.createAudit(audit).getEventName());
		
		
	}
	
	@Test
	public void readAuditSuccess() throws HandleException {
		Audit audit = new Audit();
		
		
		Timestamp temp = new Timestamp(1234);
		audit.setEventDate(temp);
		
		UUID id = new UUID(0, 0);
		
		audit.setEventId(id);
		Object object = new Object();
		audit.setEventName("MyEvent");
		audit.setEventType("MyEventType");
		audit.setNewValue(object);
		audit.setOldValue(object);
		audit.setUserId("111111");
		
		LinkedList<Audit> list = new LinkedList<Audit>();
		list.add(audit);
		
		Mockito.when(auditRepository.findAll()).thenReturn(list);
		assertEquals(1,auditServiceImpl.readAudit().size());

		
	}
 

	@Test
	public void updateAuditSuccess() throws HandleException {
		Audit audit = new Audit();
		
		
		Timestamp temp = new Timestamp(1234);
		audit.setEventDate(temp);
		
		UUID id = new UUID(0, 0);
		
		audit.setEventId(id);
		Object object = new Object();
		audit.setEventName("MyEvent");
		audit.setEventType("MyEventType");
		audit.setNewValue(object);
		audit.setOldValue(object);
		audit.setUserId("111111");

		List<Audit> list = new ArrayList<Audit>();
		list.add(audit);
		
		Optional<Audit> opt=Optional.of(audit);
		
		Mockito.when(auditRepository.findByEventId(Mockito.<UUID>any())).thenReturn(opt); //finding by id
		
		when(auditRepository.save(Mockito.<Audit>any())).thenReturn(audit); //last i am saving 
		
		
		//calling through service, pasing wrapper object having audit id and updating values
		UpdateAudit updatingObject = new UpdateAudit();
		updatingObject.setAuditId("1");
			Audit argObject = new Audit();
		
			argObject.setEventDate(temp);
		
			UUID id1 = new UUID(0, 0);
		
			argObject.setEventId(id1);
			Object objects = new Object();
			argObject.setEventName("MyEvent11");
			argObject.setEventType("MyEventType11");
			argObject.setNewValue(objects);
			argObject.setOldValue(objects);
			argObject.setUserId("111111");
		updatingObject.setAudit(argObject);
		
		assertEquals("MyEvent11",auditServiceImpl.Update(updatingObject).getEventName()); //cheking finnally, by calling through service

		
	}
	

/*	@Test(expected = HandleException.class)
	public void viewAudit1() {
		Audit audit = new Audit();
		audit.setAuditId("1");
		
		Timestamp temp = new Timestamp(1234);
		audit.setEventDate(temp);
		
		UUID id = new UUID(0, 0);
		
		audit.setEventId(id);
		Object object = new Object();
		audit.setEventName("MyEvent");
		audit.setEventType("MyEventType");
		audit.setNewValue(object);
		audit.setOldValue(object);
		audit.setUserId("111111");
		
		Optional<Audit> auditlog = Optional.empty();

		when(auditRepository.findById(null)).thenReturn(auditlog);

		
	}*/
	
	
	@Test
	public void delete()
	{
		Audit audit = new Audit();

		
		Timestamp temp = new Timestamp(1234);
		audit.setEventDate(temp);
		
		UUID id = new UUID(0, 0);
		
		audit.setEventId(id);
		Object object = new Object();
		audit.setEventName("MyEvent");
		audit.setEventType("MyEventType");
		audit.setNewValue(object);
		audit.setOldValue(object);
		audit.setUserId("111111");
		
		List<Audit> list = new ArrayList<Audit>();
		list.add(audit);
		Optional<Audit> opt=Optional.of(audit);
		Mockito.when(auditRepository.findByEventId(Mockito.<UUID>any())).thenReturn(opt); //finding by id
		list.remove(audit);
		assertEquals(list.size(),auditServiceImpl.delete(id).size());

	}
	
}
