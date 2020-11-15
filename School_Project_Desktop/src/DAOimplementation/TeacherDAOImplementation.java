package DAOimplementation;

import connection.*;
import dao_interface.*;
import model.*;

import java.sql.*;
import javax.swing.JOptionPane;


public class TeacherDAOImplementation implements TeacherDAOInterface{
	Connection connection;
	
	public TeacherDAOImplementation() throws ClassNotFoundException{
		connection = Connection_school_DB.get_Connection();
	}

	public void insertTeacher(Teacher teacher) {
		CallableStatement statement;
		try {
			statement = connection.prepareCall(" CALL insert_teacher ( ? , ? , ? , ? , ? ) ");
			statement.setString(1, teacher.getEmployeeID());
			statement.setString(2, teacher.getFirstName());
			statement.setString(3, teacher.getLastName());
			statement.setString(4, teacher.getHireDate());
			statement.setString(5, teacher.getEmail());
			statement.executeUpdate();
			connection.commit();
			statement.close();
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		JOptionPane.showMessageDialog(null, "Teacher sucessfully added!!!");
		
	}


	public void deleteTeacher(String employee_id) {
		PreparedStatement statement;
		try {
			statement = connection.prepareStatement("DELETE  FROM Teachers "
					+ " WHERE employee_id = ? ");
			statement.setString(1, employee_id);
			statement.executeUpdate();
			connection.commit();
			statement.close();
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		JOptionPane.showMessageDialog(null, "Teacher sucessfully deleted!!!");
		
	}


	public Teacher readTeacher(String employee_id) {
		Teacher teacher = new Teacher();
		PreparedStatement statement;
		try {
			statement = connection.prepareStatement(" SELECT  employee_id , first_name , last_name , TO_CHAR(hire_date, 'DD MONTH YYYY' ) AS hire_date , email  "
					+ " FROM Teachers " 
					+ " WHERE employee_id = ? ");
			
			statement.setString(1, employee_id);
			
			ResultSet result = statement.executeQuery();
			while(result.next()) {
			teacher.setEmployeeID(result.getString("employee_id"));
			teacher.setFirstName(result.getString("first_name"));
			teacher.setLastName(result.getString("last_name"));
			teacher.setHireDate(result.getString("hire_date"));
			teacher.setEmail(result.getString("email"));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return teacher;
	}


	public void updateTeacher(String employee_id,String firstName,String lastName,String hireDate,String email) {
		PreparedStatement statement;
		
		try {
			statement = connection.prepareStatement(" UPDATE Teachers "
					+ " SET first_name = ? , last_name = ? , hire_date = ? , email = ? "
					+ " WHERE employee_id = ? ");

				statement.setString(5, employee_id);
				statement.setString(1, firstName);
				statement.setString(2, lastName);
				statement.setString(3, hireDate);
				statement.setString(4, email);

				
				statement.executeUpdate();
				connection.commit();
				statement.close();
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		JOptionPane.showMessageDialog(null, "Teacher sucessfully updated!!!");
		
	}


	
}
