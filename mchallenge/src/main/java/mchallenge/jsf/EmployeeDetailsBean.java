package mchallenge.jsf;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import mchallenge.ejb.EmployeeDao;
import mchallenge.entites.Employee;



@ViewScoped
@ManagedBean
public class EmployeeDetailsBean {
	private Employee employee;
	private long pid;
	

	@Inject
	EmployeeDao employeeDao;
	
	public void loadEmployee(){
		employee = employeeDao.findEmployee(pid);
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public long getPid() {
		return pid;
	}

	public void setPid(long pid) {
		this.pid = pid;
	}
	
	public void updateEmployee(){
		employee = employeeDao.saveExistingEmployee(employee);
	}
	
	
	
	
}
