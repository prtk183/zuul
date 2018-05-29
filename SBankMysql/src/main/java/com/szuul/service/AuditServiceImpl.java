/*package com.sbank.service;

import java.util.List;
import java.util.logging.Logger;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;


import com.sbank.model.Audit;

@Service
public class AuditServiceImpl implements IAuditService{

  Logger Log = Logger.getLogger(AuditServiceImpl.class.getName());
  
 @Autowired
 private DiscoveryClient discoveryClient;
 
 @Autowired
 @LoadBalanced
  private RestTemplate restTemplate;
 
 *//**-----------resttemplate object ---------.*//*
 @Inject
 private RestTemplate restTemplate;
 
  *//**
  /* sending created audit report to mongoDB
   * @see com.sbank.service.IAuditService#sendAuditToMongo(com.sbank.model.Audit)
   *//*
  @Override
      public void sendAuditToMongo(Audit auditData) {

      List<ServiceInstance> instance=discoveryClient.getInstances("MongoAudit");
      ServiceInstance serviceInstance=instance.get(0);
       String uri =serviceInstance.getUri().toString();
       uri=uri+"/createAudit";
      Audit audit = auditData;
      System.out.println(audit);
      Audit resultOfOperation = restTemplate.postForObject(uri, audit, Audit.class);
    }
  }


  

*/