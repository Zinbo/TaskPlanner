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
@Table(name="TASK")
@NamedQueries(value = { 
		@NamedQuery(name = "getAllTasks", query = "from Task"),
		@NamedQuery(name = "getAllInProgressTasks", query = "from Task where status = 1"),
		@NamedQuery(name = "deleteTask", query = "delete from Task where id=:id")
	}
)
public class Task {

	private long id;
	private String name;
	private String description;
	private String dueDate;
	private Status status = Status.NOT_IN_PROGRESS;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="TASK_ID")
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
	
	@Column(name="DUE_DATE")
	public String getDueDate() {
		return dueDate;
	}
	
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	@Column(name="STATUS")
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}
