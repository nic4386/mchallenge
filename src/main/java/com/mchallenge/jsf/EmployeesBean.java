package com.mchallenge.jsf;


import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

import com.mchallenge.ejb.EmployeeDao;
import com.mchallenge.entites.Employee;


@Named
@RequestScoped
public class EmployeesBean {
	private List<Employee> employees;
	
	@Inject
	EmployeeDao employeeDao;
	
	private Date startDate;
	private Date endDate;
	
	public List<Employee> getEmployees() {
		
		if(employees == null){
			employees = employeeDao.listEmployees(startDate, endDate);
			
		}
		
		return employees;
		
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
		employees =null;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
		employees =null;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
	
}
