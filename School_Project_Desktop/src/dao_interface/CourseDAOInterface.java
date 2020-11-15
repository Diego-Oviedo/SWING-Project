package dao_interface;
import model.*;

public interface CourseDAOInterface {
	public void insertCourse(Course course);
	public void deleteCourse(String course_id);
	public Course readCourse(String course_id);
	public void updateCourse(String courseID,String courseName,String startDate,int classRoom);
}
