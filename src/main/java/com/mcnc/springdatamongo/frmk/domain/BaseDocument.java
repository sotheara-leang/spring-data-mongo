package com.mcnc.springdatamongo.frmk.domain;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;

public class BaseDocument<ID extends Serializable> {

	@Id
	private ID id;

	@Version
	private Long version;

	public ID getId() {
		return id;
	}

	public void setId(ID id) {
		this.id = id;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}
}
