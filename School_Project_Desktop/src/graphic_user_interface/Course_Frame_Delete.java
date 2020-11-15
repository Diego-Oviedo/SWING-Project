package graphic_user_interface;

import model.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import DAOimplementation.*;

import java.awt.*;
import java.awt.event.*;


public class Course_Frame_Delete extends JFrame implements ActionListener {

	

	public static void main(String[] args) {
					Course_Frame_Delete frame = new Course_Frame_Delete();
					frame.setVisible(true);
	}

	private JPanel layer_Course_Delete;
	private JTextField textField_course_id;
	JLabel greeting_label = new JLabel("Delete a Course");
	JLabel courseid_label = new JLabel("Course ID");
	JLabel course_label = new JLabel("Course:");
	JLabel coursename_display = new JLabel("");
	JLabel startdate_display = new JLabel("");
	JLabel classroom_display = new JLabel("");
	JButton delete_button = new JButton("Delete");
	JButton search_button = new JButton("Search");
	JButton cancel_button = new JButton("Cancel");
	
	public Course_Frame_Delete() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 408, 276);
		layer_Course_Delete = new JPanel();
		layer_Course_Delete.setBackground(Color.DARK_GRAY);
		layer_Course_Delete.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(layer_Course_Delete);
		layer_Course_Delete.setLayout(null);
		
		
		greeting_label.setForeground(Color.WHITE);
		greeting_label.setFont(new Font("Lao MN", Font.PLAIN, 20));
		greeting_label.setBounds(105, 6, 188, 40);
		layer_Course_Delete.add(greeting_label);
		
		
		courseid_label.setForeground(Color.WHITE);
		courseid_label.setBounds(60, 46, 84, 38);
		layer_Course_Delete.add(courseid_label);
		
		textField_course_id = new JTextField();
		textField_course_id.setColumns(10);
		textField_course_id.setBounds(137, 52, 112, 26);
		layer_Course_Delete.add(textField_course_id);
		
		
		search_button.setBounds(252, 52, 117, 29);
		layer_Course_Delete.add(search_button);
		
		
		course_label.setForeground(Color.WHITE);
		course_label.setBounds(28, 96, 61, 16);
		layer_Course_Delete.add(course_label);
		search_button.addActionListener(this);
		
		
		coursename_display.setVerticalAlignment(SwingConstants.TOP);
		coursename_display.setHorizontalAlignment(SwingConstants.CENTER);
		coursename_display.setForeground(Color.WHITE);
		coursename_display.setBounds(85, 90, 304, 26);
		layer_Course_Delete.add(coursename_display);
		
		
		startdate_display.setVerticalAlignment(SwingConstants.TOP);
		startdate_display.setHorizontalAlignment(SwingConstants.CENTER);
		startdate_display.setForeground(Color.WHITE);
		startdate_display.setBounds(85, 124, 304, 26);
		layer_Course_Delete.add(startdate_display);
		
		
		classroom_display.setVerticalAlignment(SwingConstants.TOP);
		classroom_display.setHorizontalAlignment(SwingConstants.CENTER);
		classroom_display.setForeground(Color.WHITE);
		classroom_display.setBounds(85, 155, 304, 26);
		layer_Course_Delete.add(classroom_display);
		
		
		delete_button.setBounds(60, 193, 132, 31);
		layer_Course_Delete.add(delete_button);
		delete_button.addActionListener(this);
		
		
		cancel_button.setBounds(193, 194, 132, 29);
		layer_Course_Delete.add(cancel_button);
		cancel_button.addActionListener(this);
		
		setResizable(false);
		centerWindow(this);
		
	}
	
	private void centerWindow(Window w) {
	
	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension d = tk.getScreenSize();
	setLocation(  (d.width-w.getWidth())/2 , (d.height-w.getHeight())/2  );
	
	}


	public void actionPerformed(ActionEvent e) {
		Object button = e.getSource();
		if(button==search_button) {
			try {
				CourseDAOIplementation course_DAO = new CourseDAOIplementation();
				String id = textField_course_id.getText();
				Course course_obtained = course_DAO.readCourse(id);
				coursename_display.setText("ID: " + course_obtained.getCourseID() + " Name: " + course_obtained.getCourseName());
				startdate_display.setText("Start Date: " + course_obtained.getStartDate());
				classroom_display.setText("Classroom: " + course_obtained.getClassRoom());
						
				} catch (ClassNotFoundException ex) {
					ex.printStackTrace();
				}
			
		}else if(button==delete_button){
			try {
				CourseDAOIplementation course_DAO = new CourseDAOIplementation();
				String id = textField_course_id.getText();
				course_DAO.deleteCourse(id);
			} catch (ClassNotFoundException ex) {
				ex.printStackTrace();
			}
		
			
		}else if(button==cancel_button){
			Course_Frame_Menu course_menu = new Course_Frame_Menu();
			course_menu.setVisible(true);
			this.setVisible(false);
			this.dispose();
			
	}
}
}
