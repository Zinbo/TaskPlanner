package com.zinbo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="UNIVERSITY_TASK")
@NamedQueries(value = { 
		@NamedQuery(name = "getAllUniversityTasks", query = "from UniversityTask"),
		@NamedQuery(name = "deleteUniversityTask", query = "delete from UniversityTask where id=:id"),
		@NamedQuery(name = "findUniversityTaskById", query = "from UniversityTask where id=:id")
	}
)
public class UniversityTask extends Task{
	private String module;

	@Column(name="MODULE")
	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

}
