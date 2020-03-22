package com.mastek.hrapp;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mastek.hrapp.dao.DepartmentJPADAO;
import com.mastek.hrapp.dao.EmployeeJPADAO;
import com.mastek.hrapp.dao.JobPositionDAO;
import com.mastek.hrapp.dao.PaymentJPADAO;
import com.mastek.hrapp.dao.ProjectJPADAO;
import com.mastek.hrapp.entities.CardPayment;
import com.mastek.hrapp.entities.ChequePayment;
import com.mastek.hrapp.entities.Department;
import com.mastek.hrapp.entities.Designation;
import com.mastek.hrapp.entities.Employee;
import com.mastek.hrapp.entities.JobPostion;
import com.mastek.hrapp.entities.Payment;
import com.mastek.hrapp.entities.Project;
import com.mastek.hrapp.entities.Role;
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

	@Autowired
	JobPositionDAO jobDAO;
	
	@Autowired
	PaymentJPADAO paymentDAO;

	@Test
	void testAddJobPositionDocument() {
		JobPostion jp = new JobPostion();
		jp.setJobId(135);
		jp.setLocation("LEEDS");
		jp.setClientName("NHS");
		jp.setSkillsRequired("Java");
		jp.setNumberOfPositions(3);
		
		jp = jobDAO.save(jp);
		
		assertNotNull(jp,"Job Position Not Saved");
	}
	
	@Test
	void testListAllJobPositions() {
		System.out.println("Print All Job Positions");
		for(JobPostion jp : jobDAO.findAll()) {
			System.out.println(jp);
		}
	}
	
	
	@Test
	void testFindEmployeesBySalary(){
		double minSalary=100.0;
		double maxSalary=5000.0;
								// empDAO.findBySalary(minSalary,maxSalary)
		Iterable<Employee> emps =  empDAO.findBySalary(minSalary,maxSalary);
		
		System.out.println("All Employees having salary between min:"+minSalary+
					" and max:"+maxSalary);
		for (Employee employee : emps) {
			System.out.println(employee);
		}
	}
	
	@Test
	void testFindEmployeesByDesignation() {
		Iterable<Employee> emps = empDAO.findByDesignation(Designation.MANAGER);	
		System.out.println("All Employees with Designation as "+Designation.MANAGER);
		
		for (Employee employee : emps) {
			System.out.println(employee);
		}
	}
	
	
	@Test
	void testCashPaymentAdd() {
		Payment cashP = new Payment();
		cashP.setAmount(100);
		
		cashP = paymentDAO.save(cashP);
		System.out.println(cashP);
		assertNotNull(cashP,"Cash Payment Not saved");
	}
	
	@Test
	void testCardPaymentAdd() {
		CardPayment cardP = new CardPayment();
		cardP.setAmount(2300);
		cardP.setCardNumber(1122334411229988l);
		cardP.setCardService("VISA");
		
		cardP = paymentDAO.save(cardP);
		System.out.println(cardP);
		assertNotNull(cardP,"Card Payment not saved");
	}
	
	@Test
	void testChequePaymentAdd() {
		ChequePayment cheqP = new ChequePayment();
		cheqP.setAmount(444);
		cheqP.setBankName("RBS");
		cheqP.setChequeNumber(223333);
		
		cheqP = paymentDAO.save(cheqP);
		System.out.println(cheqP);
		assertNotNull(cheqP,"Cheque Payment not saved");
	}
	
	
	
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
	
	/*
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
	

	@Test
	void testApplyForJobPosition() {
		int jobId=122;
		int empno=6;
		JobPostion jp = empSvc.applyForJobPosition(jobId,empno);
		
		assertNotNull(jp,"Job not Applied");
		System.out.println("Applications for JOB ID:"+jobId);
		for (Employee applicant : jp.getApplicants()) {
			System.out.println(applicant);
		}
	}	
	*/
}


