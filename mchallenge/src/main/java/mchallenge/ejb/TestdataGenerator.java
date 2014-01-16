package mchallenge.ejb;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import mchallenge.entites.Employee;


@Singleton
@Startup
public class TestdataGenerator {
	@PersistenceContext
	EntityManager em;
	

	@PostConstruct
	public void setupTestData() throws ParseException{
		SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd"); 

	     
		
		
		
		em.persist(new Employee("Tom", "Smith", "200 wall Street", 1, ft.parse("2013-12-01")));
		
		em.persist(new Employee("Jan", "Small", "1800  sea lane", 2, ft.parse("1990-10-01")));
		em.persist(new Employee("Mike", "Cxe", "800 rock blvd", 3, ft.parse("2001-1-18")));
		em.persist(new Employee("Bill", "Cruz", "100 stone rd", 4, ft.parse("2004-6-30")));
		em.persist(new Employee("Sue", "Calls", "20  flower Street", 5, ft.parse("2014-01-01")));
	}
}
