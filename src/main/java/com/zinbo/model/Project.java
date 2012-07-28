package com.zinbo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.zinbo.controllers.Status;

@Entity
@Table(name="PROJECT")
@NamedQueries(value = { 
		@NamedQuery(name = "getAllProjects", query = "from Project"),
		@NamedQuery(name = "getAllInProgressProjects", query = "from Project where status = 1"),
		@NamedQuery(name = "deleteProject", query = "delete from Project where id=:id")
		
	}
)
public class Project {

	private long id;
	private String name;
	private String description;
	private String programmingLanguage;
	private Status status = Status.NOT_IN_PROGRESS;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PROJECT_ID")
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	@Column(name="NAME")
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="DESCRIPTION")
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Column(name = "PROGRAMMING_LANGUAGE")
	public String getProgrammingLanguage() {
		return programmingLanguage;
	}

	public void setProgrammingLanguage(String programmingLanguage) {
		this.programmingLanguage = programmingLanguage;
	}
	
	@Column(name="STATUS")
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}
