package com.fajrianyunus.on_mc.example;

import java.util.List;

public interface EmployeeDAO {

	public List<Employee> getAllEmployees();
	public void saveEmployee(Employee e);
}
