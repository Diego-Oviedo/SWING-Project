package dao_interface;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.*;


public interface RegisterDAOInterface {
	public void insertRegister(Register register);
	public void deleteRegister(String ID);
	
	ArrayList<Register> readRegister();	
	
	ArrayList<Course> retreiveCourses();
	ArrayList<Register> retreiveCoursesRegisteredByID(String course_id);
	
	ArrayList<Student> retreiveStudents();
	ArrayList<Register> retreiveStudentsRegisteredByID(String student_id);
	
	ArrayList<Teacher> retreiveTeachers();
	ArrayList<Register> retreiveTeachersRegisteredByID(String employee_id);
	
	public ResultSet getRegistersSet();
}
