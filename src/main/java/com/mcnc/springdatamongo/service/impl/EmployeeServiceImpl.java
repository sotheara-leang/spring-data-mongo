package com.mcnc.springdatamongo.service.impl;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import com.mcnc.springdatamongo.domain.Employee;
import com.mcnc.springdatamongo.frmk.service.BaseServiceImpl;
import com.mcnc.springdatamongo.service.EmployeeService;

@Service
public class EmployeeServiceImpl extends BaseServiceImpl<Employee, ObjectId> implements EmployeeService {

}
