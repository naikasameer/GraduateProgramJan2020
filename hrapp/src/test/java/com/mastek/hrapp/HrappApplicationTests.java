package com.mastek.hrapp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mastek.hrapp.dao.DepartmentJPADAO;
import com.mastek.hrapp.dao.EmployeeJPADAO;
import com.mastek.hrapp.dao.ProjectJPADAO;
import com.mastek.hrapp.entities.Department;
import com.mastek.hrapp.entities.Designation;
import com.mastek.hrapp.entities.Employee;
import com.mastek.hrapp.entities.Project;
import com.mastek.hrapp.services.EmployeeService;

@SpringBootTest 
class HrappApplicationTests {

	@Autowired // spring will provide the object using IOC, dependency Injection technique
	EmployeeService empSvc;
	
	@Autowired
	EmployeeService empSvc1;
	
	@Autowired
	EmployeeJPADAO empDAO;
	
	@Autowired 
	DepartmentJPADAO deptDAO;
	
	@Autowired
	ProjectJPADAO projectDAO;
	
	
	@Test
	void testEmployeeServiceExampleMethod() {
		empSvc.exampleMethod();
		empSvc1.exampleMethod();
	}

	@Test
	void testEmployeeDAOAdd() {
		Employee emp = new Employee();
		emp.setName("NEw Emp");
		emp.setSalary(2334);
		emp.setDesignation(Designation.MANAGER);
	
		//emp = empDAO.save(emp);
		
		System.out.println(emp);
		assertNotNull(emp,"Employee Not Added");
	}
	
	@Test
	void testListEmployees() {
		Iterable<Employee> emps =  empDAO.findAll();
		assertNotNull(emps,"Employees not Found");
		for (Employee employee : emps) {
			System.out.println(employee);
		}
	}
	
	@Test
	void testUpdateEmployees() {
		Employee emp = empDAO.findById(1).get();
		System.out.println("Employee Fetched:"+emp);
		
		emp.setSalary(emp.getSalary()+1001);
		emp.setDesignation(Designation.TESTER);
		
		emp = empDAO.save(emp);
		
		System.out.println("Updated Employee:"+emp);
	}
	

	@Test
	void testDeleteEmployeeById() {
		//empDAO.delete(emp); deletes by Object 
		//empDAO.deleteById(5); // deletes by Id
		
	}
	

	@Test
	void testDepartmentDAOAdd() {
		Department dept = new Department();
		dept.setName("Admin");
		dept.setLocation("UK");
		
		//dept = deptDAO.save(dept);
		
		assertNotNull(dept,"Department Not Added");
	}

	
	@Test
	void testProjectDAOAdd() {
		Project project = new Project();
		project.setName("NHS");
		project.setLocation("UK");
		
	//	project =  projectDAO.save(project);
		assertNotNull(project,"project Not Added");
	}
	
	@Test
	void testAssignEmployeeToDepartment() {
						// empSVC.assingEmployeeToDepartment(empno,deptno)
			Employee emp = empSvc.assignEmployeeToDepartment(6,12);
			assertNotNull(emp.getCurrentDepartment(),"Department Not Assigned");
	}
	
	
	@Test
	void testAssignEmployeeToProject() {		// empno,projectId
		Employee emp =  empSvc.assignEmployeeToProject(4,19);
		assertTrue(emp.getProjectsAssigned().size()>0,"Projects assigned");	
	}
	
	
}


