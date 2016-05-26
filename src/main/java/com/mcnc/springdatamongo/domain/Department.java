package com.mcnc.springdatamongo.domain;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mcnc.springdatamongo.frmk.domain.BaseDocument;


@Document(collection = "departments")
public class Department extends BaseDocument<ObjectId> {

	private String name;
	
	private String description;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
