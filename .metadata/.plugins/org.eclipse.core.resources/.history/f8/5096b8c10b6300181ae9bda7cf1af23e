package com.sbank.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import com.sbank.model.Audit;

@FeignClient("MongoAudit")
public interface IAuditService {

  
  /** sending audit to mongoDb
   * @param audit
   */
  @PostMapping("/createAudit")
  public void sendAuditToMongo(Audit audit);
}
