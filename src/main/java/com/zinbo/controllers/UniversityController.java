package com.zinbo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zinbo.model.Task;
import com.zinbo.model.UniversityTask;

@Controller
public class UniversityController {
	
	@RequestMapping("/university")
	public ModelAndView showUniversityPage() {
		return new ModelAndView("university", "listOfTasksByModule", generateListOfListsOfTasks());
	}
	
	@RequestMapping(value="/addUniTask",method=RequestMethod.GET)
	public ModelAndView showAddTaskForm(){
		System.out.println("Get on addUniTask, loading unitaskform...");
		return new ModelAndView("unitaskform");
	}
	
	@RequestMapping(value="/addUniTask",method=RequestMethod.POST)
	public @ResponseBody void addTask(@ModelAttribute(value="task") UniversityTask task, BindingResult result ){
		System.out.println("University task with name: " + task.getName() + " and description: " +  
							task.getDescription() + " and due date: " + task.getDueDate() +
							" to be persisted..");
		//taskDao.persistTask(task);
	}

	@RequestMapping(value="/completeUniTask",method=RequestMethod.POST)
	public @ResponseBody void completeTask(@ModelAttribute(value="taskId") UniversityTask task){
		System.out.println("Need to complete university task " + task.getId());
		//taskDao.completeTask(task.getId());
	}

	
	@RequestMapping(value="/removeUniTask",method=RequestMethod.POST)
	public @ResponseBody void removeTask(@ModelAttribute(value="taskId") UniversityTask task){
		System.out.println("Need to delete university task " + task.getId());
		//taskDao.removeTask(task.getId());
	}
	
	private List<List<UniversityTask>> generateListOfListsOfTasks(){
		List<List<UniversityTask>> listOfListsOfTasks = new ArrayList<List<UniversityTask>>();
		for(int i = 0; i < 10; i++){
			List<UniversityTask> listOfUniversityTasks = new ArrayList<UniversityTask>();
			for(int j = 0; j < 10; j++){
				UniversityTask universityTask = new UniversityTask();
				universityTask.setId((i*10) + j);
				universityTask.setName("Task " + ((i*10) + j));
				universityTask.setDescription("Description " + ((i*10) + j));
				universityTask.setDueDate("Date " + ((i*10) + j));
				universityTask.setModule("Module " + i);
				listOfUniversityTasks.add(universityTask);
			}
			listOfListsOfTasks.add(listOfUniversityTasks);
		}
		return listOfListsOfTasks;
	}

}
