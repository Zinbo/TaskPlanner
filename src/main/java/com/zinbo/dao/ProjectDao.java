package com.zinbo.dao;

import java.util.List;

import com.zinbo.model.Project;
import com.zinbo.model.ProjectIdea;

public interface ProjectDao {

	void persistProject(Project project);

	List<Project> getAllUncompleteProjects();
	
	List<Project> getAllInProgressProjects();
	
	void deleteProject(long id);
	
	void completeProject(long id);

	List<Project> getAllProjects();

	void changeProgressStatusOfProject(long id);
	
	List<ProjectIdea> getAllProjectIdeas();
	
	void persistProjectIdea(ProjectIdea projectIdea);
	
	void convertProjectIdeaToProject(long id);

	void deleteProjectIdea(long id);
	
}

