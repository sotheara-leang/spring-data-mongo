package com.mcnc.springdatamongo.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mcnc.springdatamongo.domain.Department;
import com.mcnc.springdatamongo.domain.Employee;
import com.mcnc.springdatamongo.repository.DepartmentRepository;
import com.mcnc.springdatamongo.repository.EmployeeRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:com/mcnc/springdatamongo/spring/root-context.xml")
public class DAOTest {
	
	@Autowired
	private DepartmentRepository departmentRepo;
	
	@Autowired
	private EmployeeRepository employeeRepo;
	
	@Test
	public void callCustomMethod() {
		List<Department> departments = departmentRepo.searchDepartments("Stock Department");
		System.out.println(departments);
	}
	
	@Test
	public void updateWithCriteria() {
		departmentRepo.update(
				new Query().addCriteria(Criteria.where("name").is("Sale Deparmtent")),
				new Update().set("name", "Sale Department")
		);
	}
	
	@Test
	public void aggregation() {
		Aggregation aggregation = Aggregation.newAggregation(
				Aggregation.project("addresses"),
				Aggregation.unwind("addresses"),
				Aggregation.group("addresses").count().as("n"),
				Aggregation.project("n").and("address").previousOperation(),
				Aggregation.sort(Direction.ASC, "n")
		);
		AggregationResults<AddressCount> results = employeeRepo.aggregate(aggregation, Employee.class, AddressCount.class);
		List<AddressCount> addressCount = results.getMappedResults();
		System.out.println(addressCount);
	}
}
