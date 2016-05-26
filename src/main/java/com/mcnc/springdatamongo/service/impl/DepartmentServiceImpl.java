package com.mcnc.springdatamongo.service.impl;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import com.mcnc.springdatamongo.domain.Department;
import com.mcnc.springdatamongo.frmk.service.BaseServiceImpl;
import com.mcnc.springdatamongo.service.DepartmentService;

@Service
public class DepartmentServiceImpl extends BaseServiceImpl<Department, ObjectId> implements DepartmentService {

}
