package com.mastek.hrapp.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity // declares the class as Entity , to be managed by JPA
@Table(name="JPA_Employees") // declare the table name associated with this class
@EntityListeners({EmployeeListener.class}) // call the appropriate listener event method on lifecyle event
public class Employee {

	int empno;
	String name;
	double salary;
	Designation designation;
	
	Department currentDepartment;
	
	@ManyToOne // One Employee is associated with one of the many Departments 
	@JoinColumn(name="fk_department_number") // the foreign key column to store the associate deptno
	public Department getCurrentDepartment() {
		return currentDepartment;
	}

	public void setCurrentDepartment(Department currentDepartment) {
		this.currentDepartment = currentDepartment;
	}
	
	Set<Project> projectsAssigned = new HashSet<>();
	
	@ManyToMany(cascade=CascadeType.ALL) // configure many to many association for entities
	@JoinTable(name="JPA_PROJECT_ASSIGNMENTS",  // provide the join table name
			joinColumns= {@JoinColumn(name="fk_empno")}, // foreign key column for current class
			inverseJoinColumns = {@JoinColumn(name="fk_projectId")} // foreign key column for collection type
			)
	public Set<Project> getProjectsAssigned() {
		return projectsAssigned;
	}

	public void setProjectsAssigned(Set<Project> projectsAssigned) {
		this.projectsAssigned = projectsAssigned;
	}

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	@Id // marking the property as primary Key for the table
	@Column(name="employee_number") // using Column to provide the default column name
	@GeneratedValue(strategy=GenerationType.AUTO) // Auto Numbering configuration as per DB
	public int getEmpno() {
		return empno;
	}


	public void setEmpno(int empno) {
		this.empno = empno;
	}

	@Column(name="employee_name",length=50,nullable=false)
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getSalary() {
		return salary;
	}


	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
	@Enumerated(EnumType.STRING)
	public Designation getDesignation() {
		return designation;
	}


	public void setDesignation(Designation designation) {
		this.designation = designation;
	}


	@Override
	public String toString() {
		return "Employee [empno=" + empno + ", name=" + name + ", salary=" + salary + ", designation=" + designation
				+ "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + empno;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (empno != other.empno)
			return false;
		return true;
	}
	
	
	
}
// @Transient : to mark the property get method, not to be stored in DB table

