package com.szuul.service;

import java.util.List;
import java.util.UUID;

import com.szuul.exception.HandleException;
import com.szuul.model.Audit;
import com.szuul.wrapper.UpdateAudit;

public interface IAuditService {
	
//CRUD
	
	/**Audit created.
	 * @param object
	 * @return
	 */
	public Audit createAudit(Audit object) throws HandleException;
	
	
	/**read Audit.
	 * @return
	 */
	public List<Audit> readAudit() throws HandleException;
	
	/**update Audit.
	 *
	 * @param Id
	 * @return
	 */
	public Audit Update(UpdateAudit object) throws HandleException;
	
	
	/**Delete Update.
	 * @param Id
	 * @return
	 */
	public List<Audit> delete(long Id) throws HandleException;


	
}
