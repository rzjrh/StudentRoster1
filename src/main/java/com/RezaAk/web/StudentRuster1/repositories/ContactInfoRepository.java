package com.RezaAk.web.StudentRuster1.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.RezaAk.web.StudentRuster1.models.ContactInfo;

@Repository
public interface ContactInfoRepository extends CrudRepository<ContactInfo, Long>{
	List<ContactInfo> findAll();
}