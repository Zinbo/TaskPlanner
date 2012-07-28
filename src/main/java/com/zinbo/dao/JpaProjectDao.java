package com.zinbo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.zinbo.controllers.Status;
import com.zinbo.model.Project;
import com.zinbo.model.ProjectIdea;

@Component
@Transactional
public class JpaProjectDao implements ProjectDao {

	@PersistenceContext(unitName="NTISEmf")
	private EntityManager em;
	
	@Override
	public void persistProject(Project project) {
		em.persist(project);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Project> getAllUncompleteProjects() {
		return em.createNamedQuery("getAllUncompleteProjects").getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Project> getAllInProgressProjects() {
		return em.createNamedQuery("getAllInProgressProjects").getResultList();
	}

	@Override
	public void deleteProject(long id) {
		em.createNamedQuery("deleteProject").setParameter("id", id).executeUpdate();
	}

	@Override
	public void completeProject(long id) {
		Project project = (Project) em.createNamedQuery("findProjectById").setParameter("id", id).getSingleResult();
		project.setStatus(Status.COMPLETE);
		em.persist(project);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Project> getAllProjects() {
		return em.createNamedQuery("getAllProjects").getResultList();
	}

	@Override
	public void changeProgressStatusOfProject(long id) {
		Project project = em.find(Project.class, id);
		if(project.getStatus() == Status.NOT_IN_PROGRESS){
			project.setStatus(Status.IN_PROGRESS);
		} else{
			project.setStatus(Status.NOT_IN_PROGRESS);
		}
		em.persist(project);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProjectIdea> getAllProjectIdeas() {
		return em.createNamedQuery("getAllProjectIdeas").getResultList();
	}

	@Override
	public void persistProjectIdea(ProjectIdea projectIdea) {
		em.persist(projectIdea);
		
	}

	@Override
	public void convertProjectIdeaToProject(long id) {
		ProjectIdea projectIdea = em.find(ProjectIdea.class, id);
		
		Project project = new Project();
		project.setDescription(projectIdea.getDescription());
		project.setName(projectIdea.getName());
		project.setProgrammingLanguage(projectIdea.getProgrammingLanguage());
		persistProject(project);
		
		em.remove(projectIdea);
		
	}

	@Override
	public void deleteProjectIdea(long id) {
		em.remove(em.find(ProjectIdea.class, id));
	}
	
}
