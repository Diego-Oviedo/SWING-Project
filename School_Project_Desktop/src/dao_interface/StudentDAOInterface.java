package dao_interface;
import model.*;

public interface StudentDAOInterface {
	public void insertStudent(Student student);
	public void deleteStudent(String student_id);
	public Student readStudent(String student_id);
	public void updateStudent(String student_id,String firstName,String lastName,String dateOfBirth,String email);
}
