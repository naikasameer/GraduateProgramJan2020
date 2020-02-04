package com.mastek.training.packtwo;

import com.mastek.training.packone.SimpleClass;

public class DerivedClass extends SimpleClass {

	
	public static void main(String[] args) {
		DerivedClass sc1 = new DerivedClass();
		// In the Derived Class, of other package we can access public and protected members of the class
		// we cannot access private and default members of the class
		System.out.println(
				//"Private: "+sc1.privateNumber+
				//"\nDefault: "+sc1.defaultNumber+
				"\nProtected: "+sc1.protectedNumber+
				"\nPublic: "+sc1.publicNumber);
	}
}
