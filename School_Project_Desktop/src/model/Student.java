package model;


public class Student extends Person {
	
	private String studentID;
	private String dateOfBirth;
	private String email;
	

	
	//CONSTRUCTORS 
	public Student() {
	} 

	public Student(String studentID, String dateOfBirth, String email) { 
		super();
		this.studentID = studentID;
		this.dateOfBirth = dateOfBirth;
		this.email = email;
	}

	//SETTERS

	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}
	
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
 
	//GETTERS	
	public String getStudentID() {
		return studentID;
	}
	
	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public String getEmail() {
		return email;
	}


	//METHOD TO STRING

	public String toString() {
		return "Student ID: " + studentID + "\nDate of bith:" + dateOfBirth + "\nE-mail=" + email;
	}
	
	
	

}
