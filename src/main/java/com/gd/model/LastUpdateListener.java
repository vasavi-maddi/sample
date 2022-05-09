package com.gd.model;

import java.util.Date;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public class LastUpdateListener {
	@PreUpdate
	public void setLastModifiedDateGd(Employee e) {
		e.setLastModifiedDate(new Date());
	}

	@PrePersist
	public void setCreatedDateGd(Employee e) {
		e.setCreatedDate(new Date());
	}
}