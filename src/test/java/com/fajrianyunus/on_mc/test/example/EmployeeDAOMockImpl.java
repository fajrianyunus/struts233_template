package com.fajrianyunus.on_mc.test.example;

import java.util.List;
import java.util.Vector;

import com.fajrianyunus.on_mc.example.Employee;
import com.fajrianyunus.on_mc.example.EmployeeDAO;

public class EmployeeDAOMockImpl implements EmployeeDAO {
	
	List<Employee> employees;
	
	public EmployeeDAOMockImpl() {
		employees = new Vector<Employee>();
		
		Employee e1 = new Employee();
		e1.setId(1L);
		e1.setFullName("john doe");
		e1.setWage(999D);
		employees.add(e1);
		
		Employee e2 = new Employee();
		e2.setId(1L);
		e2.setFullName("jane doe");
		e2.setWage(998D);
		employees.add(e2);				
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employees;
	}

	@Override
	public void saveEmployee(Employee e) {
		if (e != null) {
			employees.add(e);
		}
	}

}
