package model;

public class Register {
	Course course;
	Student student;
	Teacher teacher;
	
	String course_id;
	String course_name;
	String schedule;
	String student_id;
	String employee_id;
	
	//Constructors
	
	public Register() {
		super();
	}

	public Register(Course course, Student student, Teacher teacher, String course_id, String course_name,
			String schedule, String student_id, String employee_id) {
		super();
		this.course = course;
		this.student = student;
		this.teacher = teacher;
		this.course_id = course_id;
		this.course_name = course_name;
		this.schedule = schedule;
		this.student_id = student_id;
		this.employee_id = employee_id;
	}
	
	//Setters

	public void setCourse(Course course) {
		this.course = course;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public void setCourse_id(String course_id) {
		this.course_id = course_id;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}

	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}

	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}
	
	
	//Getters

	public Course getCourse() {
		return course;
	}

	public Student getStudent() {
		return student;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public String getCourse_id() {
		return course_id;
	}

	public String getCourse_name() {
		return course_name;
	}

	public String getSchedule() {
		return schedule;
	}

	public String getStudent_id() {
		return student_id;
	}

	public String getEmployee_id() {
		return employee_id;
	}


}
