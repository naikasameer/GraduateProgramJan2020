package com.mastek.training.hrapp.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.mastek.training.hrapp.Employee;

public class EmployeeBinaryFileDAO implements DataAccessObject<Employee> {

	Map<Integer, Employee> empMap;
	
	private String fileName;
	
	public EmployeeBinaryFileDAO(String fileName) {
		empMap = new HashMap<Integer, Employee>();
		this.fileName = fileName;
		// read all the data from file and load in collection map
		readMapFromFile();
	}
	
	// read the data from File and add it to the map Shared
	private void readMapFromFile() {
		// ObjectInputStream: Read Object from Binary FileInputStream
		// FileInputStream: Read Binary Data from File Objects
		// File: Open or refer to the file using Filename/File Path
		try (ObjectInputStream objIn = new ObjectInputStream(
											new FileInputStream(
													new File(fileName)))){
			// we use try block with resources to manage autoclosing of streams
			empMap = (Map<Integer, Employee>) objIn.readObject();
		} catch (Exception e) {
			System.out.println("Exception Thrown");
			e.printStackTrace();
		}
	}
	
	// update file with the Map content 
	private void writeMapToFile() {
		//ObjectOutputStream: Write Binary Object in Serialized Format in FileOutputStream
		// FileOutputStream: Write Binary Object to Files
		// File: File Object will refer to the file to be updated/created if not present
		try (ObjectOutputStream objOut =  new ObjectOutputStream(
											new FileOutputStream(
													new File(fileName)))){
			objOut.writeObject(empMap); // write all the data in serialized format in the file
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Employee add(Employee newEmployee) {
		readMapFromFile();
		if(!empMap.containsKey(newEmployee.getEmpno())) {
			System.out.println("Adding Employee "+newEmployee.getEmpno());
			empMap.put(newEmployee.getEmpno(), newEmployee);
			// update the file with new content
			writeMapToFile();
		}
		return newEmployee;
	}

	@Override
	public Collection<Employee> listAll() {
		readMapFromFile();
		return empMap.values(); // return all the values from the Map
	}

	@Override
	public Employee find(int key) {
		readMapFromFile();
		return empMap.get(key);
	}

	@Override
	public Employee remove(int key) {
		readMapFromFile();
		
		Employee removedEmp =null;
		if(empMap.containsKey(key)) {
			System.out.println("Removing Employee "+key);
			removedEmp = empMap.remove(key);
			writeMapToFile();
		}
		return removedEmp;
	}

}
