package com.mastek.training.hrapp;

// Each class specifies their base/parent class name using extends keyword
// If the class doesnot have extends keyword it is by default inheriting java.lang.Object 
public class SalesEmployee extends Employee { 

		private long target;
		private double commission;
		
		public static void example() {
			System.out.println("Sales");
		} 
		
		public SalesEmployee() {
			//System.out.println("Example");
			// use super keyword to call the base class constructor from the child/derived class
			// super constructor call must be the first line in the constructor
			super(7777,"SalesExample",99,Designations.OFFICER);
			this.setTarget(122);
			this.setCommission(0.1);
			System.out.println("Sales Employee Created");
		}
		
		// Method Overriding
		// We write the same method available in base class in child class with different or
		// additional logic for processing the result
		@Override
		public double getNetSalary(int noOfDays) throws Exception{
			return (super.getNetSalary(noOfDays)+(super.getNetSalary(noOfDays)*getCommission()));
		}
		
		public long getTarget() {
			return target;
		}
		public void setTarget(long target) {
			this.target = target;
		}
		public double getCommission() {
			return commission;
		}
		public void setCommission(double commission) {
			this.commission = commission;
		}
		
		
		public static void main(String[] args) {
			SalesEmployee semp = new SalesEmployee();
			SalesEmployee.example();
			
			Employee emp = new SalesEmployee();
			emp.example();
			
			Employee.example();
		}
}
