package com.springboot.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springboot.jpa.domain.Employee;

@Repository
public class EmployeeRepository {

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	public Employee findById(int id) {
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			return em.find(Employee.class, id);
		} finally {
			em.close();
		}
	}

	public List<Employee> findAll() {
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
			Root<Employee> root = cq.from(Employee.class);
			cq.select(root);
			TypedQuery<Employee> query = em.createQuery(cq);
			List<Employee> results = query.getResultList();
			return results;
		} finally {
			em.close();
		}
	}

	public Employee save(Employee employee) {
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(employee);
			em.getTransaction().commit();
			return employee;
		} finally {
			em.close();
		}
	}

	public void deleteById(int id) {
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			em.getTransaction().begin();
			Employee emp = em.find(Employee.class, id);
			em.remove(emp);
			em.getTransaction().commit();
		} finally {
			em.close();
		}
	}

}
