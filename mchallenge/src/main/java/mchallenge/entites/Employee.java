package mchallenge.entites;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


import java.util.Date;

  
@Entity
public class Employee {
	@Id @GeneratedValue
	long id;
	
	private String firstName;
	
	private String lastName;
	//TODO: CREATE ADDRESS CLASS
	private String address;
	
	private long employeeID;
	private Date hireDate;
	
	public Employee(){
		
	}
	
	public Employee(String firstName, String lastName, String address, long employeeID, Date hireDate ) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.employeeID = employeeID;
		this.hireDate = hireDate;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(long employeeID) {
		this.employeeID = employeeID;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
}
