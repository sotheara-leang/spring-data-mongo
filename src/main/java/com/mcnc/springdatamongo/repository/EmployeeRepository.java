package com.mcnc.springdatamongo.repository;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;

import com.mcnc.springdatamongo.domain.Employee;
import com.mcnc.springdatamongo.frmk.repository.BaseRepository;

@Repository
public interface EmployeeRepository extends BaseRepository<Employee, ObjectId> {
	
}
