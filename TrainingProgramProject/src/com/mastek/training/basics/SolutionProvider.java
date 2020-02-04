package com.mastek.training.basics;

public class SolutionProvider {

	/*
	 * take two numbers from the user and display the maximum number as output
	 */
	// public static <return-datatype> <name>(<param_type1> <param_name1>,...)
	public static int getMaxNumber(int num1,int num2) {// declare inputs as params
		int max=0; // declare output as local variable
		if (num1>num2) { // validate the conditions for logical result
			max=num1;
		} else {
			max=num2;
		}		
		return max;// return the result to the caller
	}
	
	public static int getLucky(int num1) {
		String num = ""+num1;
		if(num.length()>1) {
			int sum = 0;
			for (int i = 0; i < num.length(); i++) {
				sum+=Integer.parseInt(num.charAt(i)+"");
			}
			System.out.println(sum);
			return getLucky(sum);
		}else {
			return num1;
		}
	}
	
	
	
	
	
}
