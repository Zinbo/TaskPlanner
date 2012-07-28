package com.zinbo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zinbo.dao.TaskDao;
import com.zinbo.model.Task;

@Controller
public class TaskController {

	@Autowired
	private TaskDao taskDao;
	
	@RequestMapping("/tasks")
	public ModelAndView showTaskSummaryPage() {
		return new ModelAndView("taskSummaryPage");
	}

	@RequestMapping(value="/completeTask",method=RequestMethod.POST)
	public @ResponseBody void completeTask(@ModelAttribute(value="taskId") Task task){
		taskDao.completeTask(task.getId());
		System.out.println("Task with id " + task.getId() + " has status set to complete");
	}

	
	@RequestMapping(value="/deleteTask",method=RequestMethod.POST)
	public @ResponseBody void deleteTask(@ModelAttribute(value="taskId") Task task){
		taskDao.deleteTask(task.getId());
	}
	
	@RequestMapping(value="/changeProgressStatusOfTask",method=RequestMethod.POST)
	public @ResponseBody void changeProgressStatusOfTask(@ModelAttribute(value="taskId") Task task){
		taskDao.changeProgressStatusOfTask(task.getId());
	}
	
	@RequestMapping(value="/loadTasks",method=RequestMethod.GET)
	public ModelAndView loadTasks(){
		return new ModelAndView("taskSummaryTable", "tasks", taskDao.getAllTasks());
	}
	
	@RequestMapping(value="/addTask",method=RequestMethod.GET)
	public ModelAndView showAddTaskForm(){
		return new ModelAndView("addTaskForm");
	}
	
	@RequestMapping(value="/addTask",method=RequestMethod.POST)
	public @ResponseBody String addTask(@ModelAttribute(value="task") Task task, BindingResult result ){
		taskDao.persistTask(task);
		return "success";
	}

}
