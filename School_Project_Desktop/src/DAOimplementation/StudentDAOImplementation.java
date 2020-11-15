package DAOimplementation;

import connection.*;
import dao_interface.*;
import model.*;
import java.sql.*;
import javax.swing.JOptionPane;

public class StudentDAOImplementation implements StudentDAOInterface{
	
	Connection connection;
	
	public StudentDAOImplementation() throws ClassNotFoundException {
		connection = Connection_school_DB.get_Connection();
	}
		
		

	public void insertStudent(Student student) {
		CallableStatement statement;
	try {
		statement = connection.prepareCall (" CALL insert_student ( ? , ? , ? , ? , ? ) ");
		statement.setString(1, student.getStudentID());
		statement.setString(2, student.getFirstName());
		statement.setString(3, student.getLastName());
		statement.setString(4, student.getDateOfBirth());
		statement.setString(5, student.getEmail());
		statement.executeUpdate();
		connection.commit();
		statement.close();
		
	}catch(SQLException e){
		e.printStackTrace();
	}	
	JOptionPane.showMessageDialog(null, "Student sucessfully added!!!");
	}


	public void deleteStudent(String student_id) {
		PreparedStatement statement;
		try {
			statement = connection.prepareStatement("DELETE  FROM Students "
													+ " WHERE student_id = ? ");
			statement.setString(1, student_id);
			statement.executeUpdate();
			connection.commit();
			statement.close();
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		JOptionPane.showMessageDialog(null, "Student sucessfully deleted!!!");	
	}


	public Student readStudent(String student_id) {
		Student student = new Student();
		PreparedStatement statement;
		try {
			statement = connection.prepareStatement(" SELECT  student_id , first_name , last_name , TO_CHAR(date_of_birth, 'DD MONTH YYYY' ) AS date_of_birth , email  "
															+ " FROM Students "
															+ " WHERE student_id = ? ");
			
		

			statement.setString(1, student_id);
			
			ResultSet result = statement.executeQuery();
			while(result.next()) {
				student.setStudentID(result.getString("student_id"));
				student.setFirstName(result.getString("first_name"));
				student.setLastName(result.getString("last_name"));
				student.setDateOfBirth(result.getString("date_of_birth"));
				student.setEmail(result.getString("email"));
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return student;
	}


	public void updateStudent(String student_id,String firstName,String lastName,String dateOfBirth,String email)  {
		PreparedStatement statement;
		
		try {
			statement = connection.prepareStatement(" UPDATE Students "
					+ " SET first_name = ? , last_name = ? , date_of_birth = ? , email = ? "
					+ " WHERE student_id = ? ");

				statement.setString(5, student_id);
				statement.setString(1, firstName);
				statement.setString(2, lastName);
				statement.setString(3, dateOfBirth);
				statement.setString(4, email);

				
				statement.executeUpdate();
				connection.commit();
				statement.close();
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		JOptionPane.showMessageDialog(null, "Student sucessfully updated!!!");
		
	}
	
}
