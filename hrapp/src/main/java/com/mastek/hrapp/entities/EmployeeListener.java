package com.mastek.hrapp.entities;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

import org.springframework.stereotype.Component;

@Component // class is initialized by Spring Application Context
public class EmployeeListener {

	// @<Lifecycle-Event>
	// public void <method-name>(Entity e)
	
	@PrePersist // call this method before inserting each emp object in employee table
	public void beforeEmpInsert(Employee e) {
		System.out.println("Before Employee Insert");
		System.out.println("Raise Email request for "+e.getName());
	}
	
	@PostPersist // call this method after inserting each emp object in employee table
	public void afterEmpInsert(Employee e) {
		System.out.println("After Employee Insert");
		System.out.println("Screen Name Generated: "+e.getName()+e.getEmpno());
	}
	
	@PreUpdate // call this method before updating each emp object in employee table
	public void beforeUpdate(Employee e) {
		System.out.println("Before Update: "+e);
	}

	@PostUpdate // call this method after updating each emp object in employee table
	public void afterUpdate(Employee e) {
		System.out.println("After Update: "+e);
	}

	@PostLoad // call this method after loading each emp object in employee table
	public void afterLoading(Employee e) {
		System.out.println("Employee Fetched: "+e);
	}
	
	@PreRemove // call this method before removing each emp object in employee table
	public void beforeDelete(Employee e) {
		System.out.println("Before Removing "+e);
		System.out.println("Disable Profile for "+e.getEmpno());
	}

}
