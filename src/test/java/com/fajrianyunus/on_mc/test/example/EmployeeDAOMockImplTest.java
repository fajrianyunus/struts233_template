package com.fajrianyunus.on_mc.test.example;

import java.util.List;

import com.fajrianyunus.on_mc.example.Employee;
import com.fajrianyunus.on_mc.example.EmployeeDAO;
import com.fajrianyunus.on_mc.test.StrutsSpringTestCaseExpanded;

public class EmployeeDAOMockImplTest extends StrutsSpringTestCaseExpanded {
	
	private EmployeeDAO employeeDao = null;
	
	public void testTheTruth() {
		assertTrue("sanity test", true);
	}
	
	@Override
	public void setUp() throws Exception {
		super.setUp();
		employeeDao = new EmployeeDAOMockImpl();
	}
	
	public void testBasic() {
		
		List<Employee> beforeAddition = employeeDao.getAllEmployees();
		int beforeAdditionLength = beforeAddition.size()+1;
		
    	Employee em = new Employee();
    	em.setFullName("john doe");
    	em.setWage(9999D);
    	employeeDao.saveEmployee(em);
    	
    	List<Employee> afterAddition = employeeDao.getAllEmployees();
    	
    	
    	assertEquals("after addition, the length of getAllEmployees must increase by 1", beforeAdditionLength, afterAddition.size());
	}
}
