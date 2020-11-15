package DAOimplementation;

import connection.*;
import dao_interface.*;
import model.*;

import java.sql.*;

import javax.swing.JOptionPane;

public class CourseDAOIplementation implements CourseDAOInterface  {
	
	Connection connection;
	
	public CourseDAOIplementation() throws ClassNotFoundException {
		connection = Connection_school_DB.get_Connection();
	}
		
	public void insertCourse(Course course){
		CallableStatement statement;
		try {
			statement = connection.prepareCall(" CALL insert_course( ? , ? , ? , ? ) ");
			statement.setString(1, course.getCourseID());
			statement.setString(2, course.getCourseName());
			statement.setString(3, course.getStartDate());
			statement.setInt(4, course.getClassRoom());
			statement.executeUpdate();
			connection.commit();
			statement.close();			
			
		}catch(SQLException e) {
		e.printStackTrace();	
		}
		
		JOptionPane.showMessageDialog(null, "Course sucessfully added!!!");
	}


	public void deleteCourse(String course_id) {
		PreparedStatement statement;
		try {
			statement = connection.prepareStatement("DELETE  FROM Courses "
											+ " WHERE course_id = ? ");
			
			statement.setString(1, course_id);
			statement.executeUpdate();
			connection.commit();
			statement.close();
			
		}catch(SQLException e) {
		e.printStackTrace();	
		}
		JOptionPane.showMessageDialog(null, "Course sucessfully deleted!!!");
	}

	
	public Course readCourse(String course_id) {
		Course course = new Course();
		PreparedStatement statement;
		
		try {
			statement = connection.prepareStatement(" SELECT  course_id, course_name, TO_CHAR(start_date, 'DD MONTH YYYY' ) AS start_date ,class_room "
											+ " FROM Courses "
											+ " WHERE course_id = ? ");
			statement.setString(1, course_id);
			
			ResultSet result = statement.executeQuery();
			while(result.next()) {
			course.setCourseID(result.getString("course_id"));
			course.setCourseName(result.getString("course_name"));
			course.setStartDate(result.getString("start_date"));
			course.setClassRoom(result.getInt("class_room"));
			}
		}catch(SQLException e) {
			e.printStackTrace();	
			}
			
		return course ;
	}


	public void updateCourse(String courseID,String courseName,String startDate,int classRoom) {
		PreparedStatement statement;
		
		try {
			statement = connection.prepareStatement("UPDATE Courses "
											+ " SET course_name = ? , start_date = ? , class_room = ? "
											+ " WHERE course_id = ? ");
			
			statement.setString(4, courseID);
			statement.setString(1, courseName);
			statement.setString(2, startDate);
			statement.setInt(3, classRoom);
			
			statement.executeUpdate();
			connection.commit();
			statement.close();
			
		}catch(SQLException e) {
		e.printStackTrace();	
		}
		JOptionPane.showMessageDialog(null, "Course sucessfully updated!!!");
	}

}
