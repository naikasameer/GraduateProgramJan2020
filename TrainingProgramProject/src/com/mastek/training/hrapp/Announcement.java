package com.mastek.training.hrapp;
// we declare class as abstract
//  a. any one of the method in the class is declared as abstract
//  b. if any one of the abstract method from the base class is not overriden
public abstract class Announcement {
	
	private String from;
	private String forGroup;
	private String subject;
	private String contentText;
	
	// we declare the method as abstract when we want derived class to define 
	// the logic of this method/behavior
	// we cannot declare abstract method/class as final
	// we cannot declare abstract method as private method, only public/protected is allowed
	public abstract void sendAnnouncement();
	
	
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getForGroup() {
		return forGroup;
	}
	public void setForGroup(String forGroup) {
		this.forGroup = forGroup;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContentText() {
		return contentText;
	}
	public void setContentText(String contentText) {
		this.contentText = contentText;
	}
	
}
