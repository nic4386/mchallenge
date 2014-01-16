package mchallenge.ejb;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import javax.persistence.criteria.Root;


import javax.persistence.metamodel.EntityType;

import mchallenge.entites.Employee;

@Stateless
public class EmployeeDao {
	@PersistenceContext
	EntityManager em;
	
	public List<Employee> listEmployees(Date startDate, Date endDate) {
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Employee> query = cb.createQuery(Employee.class);
		Root<Employee> employee = query.from(Employee.class);
		
		EntityType<Employee> Employee_ = employee.getModel();
		query.select(employee);
		
		
		if (startDate != null && endDate != null){
			//TODO: typesafe
			query.where(cb.between(employee.<Date>get("hireDate"), startDate, endDate));
			
		}
		
		return em.createQuery(query).getResultList();
	}
	
	public Employee saveExistingEmployee(Employee employee) {
		Employee exists = em.find(Employee.class, employee.getEmployeeID());
		  if(exists != null) {
		    em.merge(employee);
		  }
		  return employee;
		}
	
	public Employee findEmployee(long pid){
		return em.find(Employee.class,pid);
	}
	
}
