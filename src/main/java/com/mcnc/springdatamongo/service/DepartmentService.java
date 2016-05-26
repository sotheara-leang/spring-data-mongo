package com.mcnc.springdatamongo.service;

import org.bson.types.ObjectId;

import com.mcnc.springdatamongo.domain.Department;
import com.mcnc.springdatamongo.frmk.service.BaseService;

public interface DepartmentService extends BaseService<Department, ObjectId> {

}
