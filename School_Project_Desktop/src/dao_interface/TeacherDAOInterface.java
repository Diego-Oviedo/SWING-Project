package dao_interface;
import model.*;

public interface TeacherDAOInterface {
	public void insertTeacher(Teacher teacher);
	public void deleteTeacher(String employee_id);
	public Teacher readTeacher(String employee_id);
	public void updateTeacher(String employee_id,String firstName,String lastName,String hireDate,String email);
}
