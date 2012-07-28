package com.zinbo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.zinbo.controllers.Status;
import com.zinbo.model.Task;

@Component
@Transactional
public class JpaTaskDao implements TaskDao{
	
	@PersistenceContext(unitName="NTISEmf")
	private EntityManager em;
	
	@Override
	public void persistTask(Task task) {
		em.persist(task);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Task> getAllInProgressTasks() {
		return em.createNamedQuery("getAllInProgressTasks").getResultList();
	}
	
	@Override
	public void deleteTask(long id){
		em.createNamedQuery("deleteTask").setParameter("id", id).executeUpdate();
	}

	@Override
	public void completeTask(long id) {
		Task task = em.find(Task.class, id);
		task.setStatus(Status.COMPLETE);
		em.persist(task);
	}
	
	public void startTask(long id) {
		Task task = em.find(Task.class, id);
		task.setStatus(Status.IN_PROGRESS);
		em.persist(task);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Task> getAllTasks() {
		return em.createNamedQuery("getAllTasks").getResultList();
	}

	@Override
	public void changeProgressStatusOfTask(long id) {
		Task task = em.find(Task.class, id);
		if(task.getStatus() == Status.NOT_IN_PROGRESS){
			task.setStatus(Status.IN_PROGRESS);
		} else{
			task.setStatus(Status.NOT_IN_PROGRESS);
		}
		em.persist(task);
	}

}
