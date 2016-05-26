package com.mcnc.springdatamongo.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;

import com.mcnc.springdatamongo.domain.Department;
import com.mcnc.springdatamongo.frmk.repository.BaseRepository;

@Repository
public interface DepartmentRepository extends BaseRepository<Department, ObjectId> {
	
	List<Department> searchDepartments(String name);
}
