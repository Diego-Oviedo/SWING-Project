package DAOimplementation;

import connection.*;
import dao_interface.*;
import model.*;
import java.util.*;

import javax.swing.JOptionPane;

import java.sql.*;

public class RegisterDAOImplementation implements RegisterDAOInterface{
	
	static Connection connection;
	
	public RegisterDAOImplementation() throws ClassNotFoundException {
		connection = Connection_school_DB.get_Connection();
	}

	public void insertRegister(Register register) {
		CallableStatement statement;
		try {
			statement = connection.prepareCall(" CALL insert_register ( ? , ? , ? , ? , ? ) ");
			statement.setString(1, register.getCourse_id());
			statement.setString(2, register.getCourse_name());
			statement.setString(3, register.getSchedule());
			statement.setString(4, register.getStudent_id());
			statement.setString(5, register.getEmployee_id());
			statement.executeUpdate();
			connection.commit();
			statement.close();	
		}catch(SQLException e) {
			e.printStackTrace();	
			}
		JOptionPane.showMessageDialog(null, "Register sucessfully created!!!");
	}


	public void deleteRegister(String ID) {
		PreparedStatement statement;
		try {
			statement = connection.prepareStatement("DELETE  FROM Registration "
											+ " WHERE student_id = ? ");
			
			statement.setString(1, ID);
			
			statement.executeUpdate();
			connection.commit();
			statement.close();
			
		}catch(SQLException e) {
		e.printStackTrace();	
		}
		JOptionPane.showMessageDialog(null, "Register sucessfully deleted!!!");
	}


	public ArrayList<Register> readRegister() {
		Register register=  null;
		Student student = null;
		Course course = null;
		Teacher teacher = null;
		
		ArrayList<Register> registers = new ArrayList<Register>();
		PreparedStatement statement;
		
		try {
			statement = connection.prepareStatement(" SELECT " + 
													" s.first_name AS student_first_name , s.last_name AS student_last_name, " + 
													" s.student_id, c.course_name, r.schedule, " + 
													" t.first_name AS teacher_first_name , t.last_name AS teacher_last_name  " + 
													" FROM registration r " + 
													" JOIN students s " + 
													" ON (r.student_id = s.student_id) " + 
													" JOIN courses c " + 
													" ON (r.course_id = c.course_id) " + 
													" JOIN teachers t " + 
													" ON (r.employee_id = t.employee_id) ");
			
			ResultSet result = statement.executeQuery();
			while(result.next()) {
			register = new Register();
			student = new Student();
			course = new Course();
			teacher = new Teacher();
			
			student.setFirstName(result.getString("student_first_name"));
			student.setLastName(result.getString("student_last_name"));
			student.setStudentID(result.getString("student_id"));
			
			course.setCourseName(result.getString("course_name"));
			
			teacher.setFirstName(result.getString("teacher_first_name"));
			teacher.setLastName(result.getString("teacher_last_name"));
			
			register.setStudent(student);
			register.setCourse(course);
			register.setTeacher(teacher);
			register.setSchedule(result.getString("schedule"));
			
			registers.add(register);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();	
			}
		
		return registers;
	}

	
			public ArrayList<Course> retreiveCourses() {
				ArrayList<Course> registed_courses = new ArrayList<Course>();
				Course course = null;
				
				PreparedStatement statement;
				
				try {
					
					
					statement = connection.prepareStatement(" SELECT  course_id , course_name, start_date, class_room "
													+ " FROM  Courses ");
													
					ResultSet result = statement.executeQuery();
				
					while (result.next()) {
					course= new Course();
					course.setCourseID(result.getString("course_id"));
					course.setCourseName(result.getString("course_name"));
					course.setStartDate(result.getString("start_date"));
					course.setClassRoom(result.getInt("class_room"));
					
					registed_courses.add(course);
					}
				
				}catch(SQLException e) {
					e.printStackTrace();	
					}
				return registed_courses;

				}
			public ArrayList<Register> retreiveCoursesRegisteredByID(String course_id){
				Register register=  null;
				Student student = null;
				Course course = null;
				Teacher teacher = null;
				
				ArrayList<Register> registers = new ArrayList<Register>();
				PreparedStatement statement;
				
				try {
					statement = connection.prepareStatement("  SELECT s.student_id, s.first_name, s.last_name,s.date_of_birth,s.email, " + 
															" t.employee_id, t.first_name AS employee_firstName , t.last_name AS employee_lastName , t.email, t.hire_date , " + 
															" c.course_id, c.course_name, c.class_room , c.start_date," + 
															" r.schedule " + 
															" FROM registration r " + 
															" JOIN students s " + 
															" ON (r.student_id = s.student_id) " + 
															" JOIN teachers t" + 
															" ON (r.employee_id = t.employee_id) " + 
															" JOIN courses  c " + 
															" ON (r.course_id = c.course_id) " +
															" WHERE r.course_id = ? ");
					
					statement.setString(1, course_id);
					
					ResultSet result = statement.executeQuery();
					while(result.next()) {
					register = new Register();
					student = new Student();
					course = new Course();
					teacher = new Teacher();
					
					student.setStudentID(result.getString("student_id"));
					student.setFirstName(result.getString("first_name"));
					student.setLastName(result.getString("last_name"));
					String dateOfBirth=result.getString("date_of_birth");
					if(dateOfBirth != null ) {
					student.setDateOfBirth(result.getString("date_of_birth").substring(0,10));
					}else {
					student.setDateOfBirth(result.getString("date_of_birth"));
					}
					student.setEmail(result.getString("email"));

					course.setCourseID(result.getString("course_id"));
					course.setCourseName(result.getString("course_name"));
					course.setClassRoom(result.getInt("class_room"));
					String startDate=result.getString("start_date");
					if(startDate != null ) {
					course.setStartDate(result.getString("start_date").substring(0,10));
					}else {
						course.setStartDate(result.getString("start_date"));
					}

					teacher.setEmployeeID(result.getString("employee_id"));
					teacher.setFirstName(result.getString("employee_firstName"));
					teacher.setLastName(result.getString("employee_lastName"));
					teacher.setEmail(result.getString("email"));
					String hireDate=result.getString("hire_date").substring(0,10);
					if(hireDate != null ) {
					teacher.setHireDate(result.getString("hire_date").substring(0,10));
					}else {
						teacher.setHireDate(result.getString("hire_date"));
					}
			
					register.setStudent(student);
					register.setCourse(course);
					register.setTeacher(teacher);
					register.setSchedule(result.getString("schedule"));
					
					registers.add(register);
					}
				}catch(SQLException e) {
					e.printStackTrace();	
					}
				
				return registers;

			}
			
			
			public ArrayList<Student> retreiveStudents() {
				ArrayList<Student> registed_students = new ArrayList<Student>();
				Student student= null;
				PreparedStatement statement;
				
				try {
					
					
					statement = connection.prepareStatement(" SELECT  student_id , first_name , last_name , date_of_birth , email  FROM  STUDENTS ");
													
					ResultSet result = statement.executeQuery();
				
					while (result.next()) {
					student=new Student();
					student.setStudentID(result.getString("student_id"));
					student.setFirstName(result.getString("first_name"));
					student.setLastName(result.getString("last_name"));
					student.setDateOfBirth(result.getString("date_of_birth"));
					student.setEmail(result.getString("email"));
					
					registed_students.add(student);
					}
				
				}catch(SQLException e) {
					e.printStackTrace();	
					}
				return registed_students;

				}
			public ArrayList<Register> retreiveStudentsRegisteredByID(String student_id) {
				Register register=  null;
				Student student = null;
				Course course = null;
				Teacher teacher = null;
				
				ArrayList<Register> registers = new ArrayList<Register>();
				PreparedStatement statement;
				
				try {
					statement = connection.prepareStatement("  SELECT s.student_id, s.first_name, s.last_name,s.date_of_birth,s.email, " + 
															" t.employee_id, t.first_name AS employee_firstName , t.last_name AS employee_lastName , t.email, t.hire_date , " + 
															" c.course_id, c.course_name, c.class_room , c.start_date," + 
															" r.schedule " + 
															" FROM registration r " + 
															" JOIN students s " + 
															" ON (r.student_id = s.student_id) " + 
															" JOIN teachers t" + 
															" ON (r.employee_id = t.employee_id) " + 
															" JOIN courses  c " + 
															" ON (r.course_id = c.course_id) " +
															" WHERE r.student_id = ? ");
					
					statement.setString(1, student_id);
					
					ResultSet result = statement.executeQuery();
					while(result.next()) {
					register = new Register();
					student = new Student();
					course = new Course();
					teacher = new Teacher();
					
					student.setStudentID(result.getString("student_id"));
					student.setFirstName(result.getString("first_name"));
					student.setLastName(result.getString("last_name"));
					String dateOfBirth=result.getString("date_of_birth");
					if(dateOfBirth != null ) {
					student.setDateOfBirth(result.getString("date_of_birth").substring(0,10));
					}else {
					student.setDateOfBirth(result.getString("date_of_birth"));
					}
					student.setEmail(result.getString("email"));

					course.setCourseID(result.getString("course_id"));
					course.setCourseName(result.getString("course_name"));
					course.setClassRoom(result.getInt("class_room"));
					String startDate=result.getString("start_date");
					if(startDate != null ) {
					course.setStartDate(result.getString("start_date").substring(0,10));
					}else {
						course.setStartDate(result.getString("start_date"));
					}

					teacher.setEmployeeID(result.getString("employee_id"));
					teacher.setFirstName(result.getString("employee_firstName"));
					teacher.setLastName(result.getString("employee_lastName"));
					teacher.setEmail(result.getString("email"));
					String hireDate=result.getString("hire_date").substring(0,10);
					if(hireDate != null ) {
					teacher.setHireDate(result.getString("hire_date").substring(0,10));
					}else {
						teacher.setHireDate(result.getString("hire_date"));
					}
			
					register.setStudent(student);
					register.setCourse(course);
					register.setTeacher(teacher);
					register.setSchedule(result.getString("schedule"));
					
					registers.add(register);
					}
				}catch(SQLException e) {
					e.printStackTrace();	
					}
				
				return registers;

				}
			
			
			
			public ArrayList<Teacher> retreiveTeachers() {
				ArrayList<Teacher> registed_teachers = new ArrayList<Teacher>();
				Teacher teacher= null;
				PreparedStatement statement;
				
				try {
					
					
					statement = connection.prepareStatement(" SELECT  employee_id , first_name ,last_name, hire_date, email FROM  Teachers ");
													
					ResultSet result = statement.executeQuery();
				
					while (result.next()) {
						teacher = new Teacher();
						teacher.setEmployeeID(result.getString("employee_id"));
						teacher.setFirstName(result.getString("first_name"));
						teacher.setLastName(result.getString("last_name"));
						teacher.setHireDate(result.getString("hire_date"));
						teacher.setEmail(result.getString("email"));
						
						registed_teachers.add(teacher);
					}
				
				}catch(SQLException e) {
					e.printStackTrace();	
					}
				return registed_teachers;

				}
			public ArrayList<Register> retreiveTeachersRegisteredByID(String employee_id){
				Register register=  null;
				Student student = null;
				Course course = null;
				Teacher teacher = null;
				
				ArrayList<Register> registers = new ArrayList<Register>();
				PreparedStatement statement;
				
				try {
					statement = connection.prepareStatement("  SELECT s.student_id, s.first_name, s.last_name,s.date_of_birth,s.email, " + 
															" t.employee_id, t.first_name AS employee_firstName , t.last_name AS employee_lastName , t.email, t.hire_date , " + 
															" c.course_id, c.course_name, c.class_room , c.start_date," + 
															" r.schedule " + 
															" FROM registration r " + 
															" JOIN students s " + 
															" ON (r.student_id = s.student_id) " + 
															" JOIN teachers t" + 
															" ON (r.employee_id = t.employee_id) " + 
															" JOIN courses  c " + 
															" ON (r.course_id = c.course_id) " +
															" WHERE r.employee_id = ? ");
					
					statement.setString(1, employee_id);
					
					ResultSet result = statement.executeQuery();
					while(result.next()) {
					register = new Register();
					student = new Student();
					course = new Course();
					teacher = new Teacher();
					
					student.setStudentID(result.getString("student_id"));
					student.setFirstName(result.getString("first_name"));
					student.setLastName(result.getString("last_name"));
					String dateOfBirth=result.getString("date_of_birth");
					if(dateOfBirth != null ) {
					student.setDateOfBirth(result.getString("date_of_birth").substring(0,10));
					}else {
					student.setDateOfBirth(result.getString("date_of_birth"));
					}
					student.setEmail(result.getString("email"));

					course.setCourseID(result.getString("course_id"));
					course.setCourseName(result.getString("course_name"));
					course.setClassRoom(result.getInt("class_room"));
					String startDate=result.getString("start_date");
					if(startDate != null ) {
					course.setStartDate(result.getString("start_date").substring(0,10));
					}else {
						course.setStartDate(result.getString("start_date"));
					}

					teacher.setEmployeeID(result.getString("employee_id"));
					teacher.setFirstName(result.getString("employee_firstName"));
					teacher.setLastName(result.getString("employee_lastName"));
					teacher.setEmail(result.getString("email"));
					String hireDate=result.getString("hire_date").substring(0,10);
					if(hireDate != null ) {
					teacher.setHireDate(result.getString("hire_date").substring(0,10));
					}else {
						teacher.setHireDate(result.getString("hire_date"));
					}
			
					register.setStudent(student);
					register.setCourse(course);
					register.setTeacher(teacher);
					register.setSchedule(result.getString("schedule"));
					
					registers.add(register);
					}
				}catch(SQLException e) {
					e.printStackTrace();	
					}
				
				return registers;
			}
			
		
			public ResultSet getRegistersSet() {
				PreparedStatement statement;
				
				try {
					statement = connection.prepareStatement(" SELECT " + 
															" s.first_name || ' ' || s.last_name AS student_name , " + 
															" s.student_id , c.course_name , r.schedule , " + 
															" t.first_name || ' ' ||  t.last_name AS teacher_name " + 
															" FROM registration r " + 
															" JOIN students s " + 
															" ON (r.student_id = s.student_id) " + 
															" JOIN courses c " + 
															" ON (r.course_id = c.course_id) " + 
															" JOIN teachers t " + 
															" ON (r.employee_id = t.employee_id) ");
					
					ResultSet result = statement.executeQuery();
				
					return result;
				}catch(SQLException e) {
					e.printStackTrace();
					return null;
					}
				
			}
}


	