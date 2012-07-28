package com.zinbo.dao;

import java.util.List;

import com.zinbo.model.Task;

public interface TaskDao {

	public void persistTask(Task task);
	
	public List<Task> getAllInProgressTasks();
	
	public List<Task> getAllTasks();

	void deleteTask(long id);
	
	void completeTask(long id);

	void changeProgressStatusOfTask(long id);
}
