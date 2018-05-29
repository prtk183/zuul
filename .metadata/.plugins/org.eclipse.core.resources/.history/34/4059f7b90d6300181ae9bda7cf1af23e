package com.sbank.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.sbank.controller.AuditController;
import com.sbank.exception.HandleException;
import com.sbank.model.Audit;
import com.sbank.model.User;
import com.sbank.repository.AuditRepository;
import com.sbank.wrapper.UpdateAudit;
import com.sbank.wrapper.UpdateUser;

@Service
public class AuditServiceImpl implements IAuditService {

	/**...........repo object............*/
	@Autowired
	AuditRepository auditServiceRepo;
	
	/**............environment object.............*/
	@Autowired
	Environment environment;
	
	Logger log = Logger.getLogger(AuditController.class.getName());
	
	/** creating auditing
	/* (non-Javadoc)
	 * @see com.sbank.service.IAuditService#createAudit(com.sbank.model.Audit)
	 */
	@Override
	public Audit createAudit(Audit object) throws HandleException{
		log.info("in audit impl of mongo db");
		// TODO Auto-generated method stub
		if(object!=null)
		{
			Audit audit = auditServiceRepo.save(object);
			return audit;
		}
		else
		{
			throw new HandleException(environment.getProperty("111"));
		}
		
		
	}

	@Override
	public List<Audit> readAudit() throws HandleException {
	
	List<Audit> list = 	auditServiceRepo.findAll();
	
		if(list.size()==0)
		{
			throw new HandleException(environment.getProperty("101"));
		}
		else
		return list;
	}

	@Override
	public Audit Update(UpdateAudit object) throws HandleException {
		
		
		Optional<Audit> audit22 = auditServiceRepo.findByEventId(object.getAudit().getEventId());
		
		if(audit22.isPresent())
		{
			Audit audit2=(Audit) audit22.get();
		audit2.setEventDate(object.getAudit().getEventDate());
		audit2.setEventId(object.getAudit().getEventId());
		audit2.setEventName(object.getAudit().getEventName());
		audit2.setEventType(object.getAudit().getEventType());
		audit2.setNewValue(object.getAudit().getNewValue());
		audit2.setOldValue(object.getAudit().getOldValue());
		audit2.setUserId(object.getAudit().getUserId());

		Audit updated = auditServiceRepo.save(audit2);
		
		
		return updated;
		}
		else
		{
			throw new HandleException(environment.getProperty("101"));
		}
	}

	@Override
	public List<Audit> delete(UUID Id) {
	
		Audit entity = auditServiceRepo.findByEventId(Id).get();
		auditServiceRepo.deleteByEventId(entity.getEventId());
		List<Audit> take = auditServiceRepo.findAll();
    	
		return take;
	}



}
