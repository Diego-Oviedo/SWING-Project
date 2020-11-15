package model;

public abstract class Person {

	private String firstName;
	private String lastName; 
	
	 //CONSTRUCTOR 
	public Person() {
	} 
	 
	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	//SETTERS
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	//GETTERS
	
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
	
	//TO STRING METHOD 
	public String toString() {
		return "Name: " + firstName + " " + lastName + "\n";
	}

	
	
}
