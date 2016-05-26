package com.mcnc.springdatamongo.repository.impl;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.query.MongoEntityInformation;

import com.mcnc.springdatamongo.domain.Department;
import com.mcnc.springdatamongo.frmk.repository.BaseRepositoryImpl;
import com.mcnc.springdatamongo.repository.DepartmentRepository;

public class DepartmentRepositoryImpl extends BaseRepositoryImpl<Department, ObjectId> implements DepartmentRepository {

	public DepartmentRepositoryImpl(MongoEntityInformation<Department, ObjectId> metadata, MongoOperations mongoOperations) {
		super(metadata, mongoOperations);
	}

	@Override
	public List<Department> searchDepartments(String name) {
		return findAll(new Query().addCriteria(Criteria.where("name").is(name)));
	}
}