package com.zinbo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zinbo.dao.ProjectDao;
import com.zinbo.model.Project;
import com.zinbo.model.ProjectIdea;

@Controller
public class ProjectController {

	@Autowired
	private ProjectDao projectDao;
	
	@RequestMapping("/projects")
	public ModelAndView showProjectPage() {
		return new ModelAndView("projectSummaryPage");
	}

	@RequestMapping(value="/completeProject",method=RequestMethod.POST)
	public @ResponseBody void completeProject(@ModelAttribute(value="projectId") Project project){
		projectDao.completeProject(project.getId());
		System.out.println("Project with id " + project.getId() + " has status set to complete");
	}

	@RequestMapping(value="/deleteProject",method=RequestMethod.POST)
	public @ResponseBody void deleteProject(@ModelAttribute(value="taskId") Project project){
		projectDao.deleteProject(project.getId());
	}
	
	@RequestMapping(value="/deleteProjectIdea",method=RequestMethod.POST)
	public @ResponseBody void deleteProjectIdea(@ModelAttribute(value="taskId") ProjectIdea projectIdea){
		projectDao.deleteProjectIdea(projectIdea.getId());
	}
	
	@RequestMapping(value="/changeProgressStatusOfProject",method=RequestMethod.POST)
	public @ResponseBody void changeProgressStatusOfTask(@ModelAttribute(value="taskId") Project project){
		projectDao.changeProgressStatusOfProject(project.getId());
	}
	
	@RequestMapping(value="/cancelProject",method=RequestMethod.POST)
	public @ResponseBody void removeProject(@ModelAttribute(value="projectId") Project project){
		projectDao.deleteProject(project.getId());
	}
	
	@RequestMapping(value="/loadProjects",method=RequestMethod.GET)
	public ModelAndView loadProjects(){
		List<Project> projects = projectDao.getAllProjects();
		List<ProjectIdea> projectIdeas = projectDao.getAllProjectIdeas();
		ModelAndView modelAndView = new ModelAndView("projectSummaryTable", "projects", projects);
		modelAndView.addObject("projectIdeas", projectIdeas);
		return modelAndView;
	}
	
	@RequestMapping(value="/addProject",method=RequestMethod.GET)
	public ModelAndView addProjectForm(){
		return new ModelAndView("addProjectForm");
	}
	
	@RequestMapping(value="/addProject",method=RequestMethod.POST)
	public @ResponseBody String addProject(@ModelAttribute(value="project") Project project, BindingResult result ){
		System.out.println("Persisting project...");
		projectDao.persistProject(project);
		return "success";
	}
	
	@RequestMapping(value="/addProjectIdea",method=RequestMethod.GET)
	public ModelAndView addProjectIdeaForm(){
		return new ModelAndView("addProjectIdeaForm");
	}
	
	@RequestMapping(value="/addProjectIdea",method=RequestMethod.POST)
	public @ResponseBody String addProjectIdea(@ModelAttribute(value="project") ProjectIdea projectIdea, BindingResult result ){
		System.out.println("Persisting project idea...");
		projectDao.persistProjectIdea(projectIdea);
		return "success";
	}
	
	@RequestMapping(value="/convertToProject",method=RequestMethod.POST)
	public @ResponseBody String convertProjectIdeaToProject(@ModelAttribute(value="project") ProjectIdea projectIdea, BindingResult result ){
		projectDao.convertProjectIdeaToProject(projectIdea.getId());
		return "success";
	}
}
