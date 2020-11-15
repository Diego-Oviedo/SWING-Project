package graphic_user_interface;

import model.Course;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import DAOimplementation.*;

import java.awt.*;
import java.awt.event.*;

public class Course_Frame_Update extends JFrame implements ActionListener {




	public static void main(String[] args) {
					Course_Frame_Update frame = new Course_Frame_Update();
					frame.setVisible(true);
	}
	
	private JPanel layer_Course_Update;
	private JTextField textField_courseId;
	private JTextField textField_courseName;
	private JTextField textField_startDate;
	private JTextField textField_classroom;
	JLabel UpdateCourse_label = new JLabel("Update a Course");
	JLabel courseid_label = new JLabel("Course ID");
	JButton search_button = new JButton("Search");	
	JLabel coursename_label = new JLabel("Course Name");
	JLabel startdate_label = new JLabel("Start Date");
	JLabel classroom_label = new JLabel("Classroom");
	JButton cancel_button = new JButton("Cancel");
	JButton submmit_button = new JButton("Submmit");

	
	public Course_Frame_Update() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 433, 273);
		layer_Course_Update = new JPanel();
		layer_Course_Update.setBackground(Color.DARK_GRAY);
		layer_Course_Update.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(layer_Course_Update);
		layer_Course_Update.setLayout(null);
		
		
		UpdateCourse_label.setForeground(Color.WHITE);
		UpdateCourse_label.setFont(new Font("Lao MN", Font.PLAIN, 20));
		UpdateCourse_label.setBounds(118, 6, 188, 40);
		layer_Course_Update.add(UpdateCourse_label);
		
		
		courseid_label.setForeground(Color.WHITE);
		courseid_label.setBounds(67, 46, 84, 38);
		layer_Course_Update.add(courseid_label);
		
		textField_courseId = new JTextField();
		textField_courseId.setColumns(10);
		textField_courseId.setBounds(144, 52, 112, 26);
		layer_Course_Update.add(textField_courseId);
		
		
		search_button.setBounds(259, 52, 117, 29);
		layer_Course_Update.add(search_button);

		search_button.addActionListener(this);
		
		
		coursename_label.setForeground(Color.WHITE);
		coursename_label.setBounds(42, 96, 84, 38);
		layer_Course_Update.add(coursename_label);
		
		textField_courseName = new JTextField();
		textField_courseName.setColumns(10);
		textField_courseName.setBounds(138, 102, 259, 26);
		layer_Course_Update.add(textField_courseName);
		
		
		startdate_label.setForeground(Color.WHITE);
		startdate_label.setBounds(42, 134, 84, 38);
		layer_Course_Update.add(startdate_label);
		
		textField_startDate = new JTextField();
		textField_startDate.setColumns(10);
		textField_startDate.setBounds(138, 140, 258, 26);
		layer_Course_Update.add(textField_startDate);
		
		
		classroom_label.setForeground(Color.WHITE);
		classroom_label.setBounds(42, 176, 84, 26);
		layer_Course_Update.add(classroom_label);
		
		textField_classroom = new JTextField();
		textField_classroom.setColumns(10);
		textField_classroom.setBounds(139, 176, 258, 26);
		layer_Course_Update.add(textField_classroom);
		
		
		cancel_button.setBounds(138, 214, 117, 29);
		layer_Course_Update.add(cancel_button);
		cancel_button.addActionListener(this);
		
		
		submmit_button.setBounds(282, 214, 117, 29);
		layer_Course_Update.add(submmit_button);
		
		submmit_button.addActionListener(this);

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
				String id = textField_courseId.getText();
				Course course_obtained = course_DAO.readCourse(id);	
				textField_courseId.setText(course_obtained.getCourseID());
				textField_courseName.setText(course_obtained.getCourseName());
				textField_startDate.setText(course_obtained.getStartDate());
				textField_classroom.setText(course_obtained.getClassRoom() + "");
				
				
						
				} catch (ClassNotFoundException ex) {
					ex.printStackTrace();
				}
			
		}else if(button==submmit_button){
			
			try {
				CourseDAOIplementation course_DAO = new CourseDAOIplementation();
				
				String courseID = textField_courseId.getText();
				String courseName = textField_courseName.getText();
				String startDate = textField_startDate.getText();
				int classRoom = Integer.parseInt(textField_classroom.getText());
				
				course_DAO.updateCourse(courseID,courseName,startDate,classRoom);
				
						
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
