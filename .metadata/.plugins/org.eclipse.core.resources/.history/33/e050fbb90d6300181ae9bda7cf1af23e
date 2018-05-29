package com.sbank.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.sbank.model.Audit;
import com.sbank.model.User;

public interface AuditRepository extends  MongoRepository<Audit, UUID>{
	


	@Query
	void deleteByEventId(UUID eventId);

	@Query
	Optional<Audit> findByEventId(UUID id);

}
