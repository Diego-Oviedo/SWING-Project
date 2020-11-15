package model;

public class Course {
	
	private String courseName;
	private String courseID;
	private String startDate;
	private int classRoom;
	
	//CONSTRUCTORS
	public Course() {
	}

	public Course(String courseName, String courseID, String startDate, int classRoom) {
		super();
		this.courseName = courseName;
		this.courseID = courseID;
		this.startDate = startDate;
		this.classRoom = classRoom;
	}

	//SETTERS
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}


	public void setClassRoom(int classRoom) {
		this.classRoom = classRoom;
	}

	//GETTERS
	public String getCourseName() {
		return courseName;
	}

	public String getCourseID() {
		return courseID;
	}

	public String getStartDate() {
		return startDate;
	}


	public int getClassRoom() {
		return classRoom;
	}

	public String toString() {
		return "Course: " + courseName + "\nCourse ID:" + courseID + "\nStart Date:" + startDate
				+ "\nClassroom: " + classRoom ;
	}
			


}
