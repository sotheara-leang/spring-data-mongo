package com.mcnc.springdatamongo.service;

import org.bson.types.ObjectId;

import com.mcnc.springdatamongo.domain.Employee;
import com.mcnc.springdatamongo.frmk.service.BaseService;

public interface EmployeeService extends BaseService<Employee, ObjectId> {

}
