package com.mastek.training.basics;

public class ExampleApplication {

	public static void main(String[] args) {
		int maxResult=0;
		
		maxResult = SolutionProvider.getMaxNumber(10, 2);
		System.out.println("Max Result is "+maxResult);
		
		maxResult = SolutionProvider.getMaxNumber(10, 10);
		System.out.println("Max Result is "+maxResult);
		
		maxResult = SolutionProvider.getMaxNumber(-110, -2);
		System.out.println("Max Result is "+maxResult);

		maxResult = SolutionProvider.getMaxNumber(99999999, 2);
		System.out.println("Max Result is "+maxResult);
		System.out.println("Luccky"+SolutionProvider.getLucky(12345));
	}
}
