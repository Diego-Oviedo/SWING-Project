package model;

public class Teacher extends Person {
		
		private String employeeID;
		private String hireDate;
		private String email;
		
		
		//CONSTRUCTORS 
		public Teacher() {
		}
		
		public Teacher(String employeeID,String hireDate,String email) {
			super();
			this.employeeID = employeeID;
			this.hireDate = hireDate;
			this.email = email;
		}
		
		//SETTERS 
		public void setEmployeeID(String employeeID) {
			this.employeeID = employeeID;
		}
		
		public void setHireDate(String hireDate) {
			this.hireDate = hireDate;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		//GETTERS
		public String getEmployeeID() {
			return employeeID;
		}

		public String getHireDate() {
			return hireDate;
		}

		public String getEmail() {
			return email;
		}

		public String toString() {
			return "Employee ID: " + employeeID + "\nHire date: " + hireDate + "\nE-mail=" + email ;
		}
		
		
}

