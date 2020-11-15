package graphic_user_interface;

import model.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import DAOimplementation.*;

public class Course_Frame_Create extends JFrame  implements ActionListener {



	public static void main(String[] args) {
					Course_Frame_Create frame = new Course_Frame_Create();
					frame.setVisible(true);
	}

	private JPanel layer_Course_Create;
	private JTextField textField_courseid;
	private JTextField coursename_textField;
	private JTextField startdate_textField;
	private JTextField classroom_textField;
	JLabel CreateCourse_label = new JLabel("Create a Course");
	JLabel courseid_label = new JLabel("Course ID");
	JLabel courseName_label = new JLabel("Course Name");
	JLabel startDate_label = new JLabel("Start date");
	JLabel classRoom_label = new JLabel("Classroom");
	JButton submmit_button = new JButton("Submmit");
	JButton cancel_button = new JButton("Cancel");
	
	
	public Course_Frame_Create() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 390, 266);
		layer_Course_Create = new JPanel();
		layer_Course_Create.setBackground(Color.DARK_GRAY);
		layer_Course_Create.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(layer_Course_Create);
		layer_Course_Create.setLayout(null);
		
		
		CreateCourse_label.setForeground(Color.WHITE);
		CreateCourse_label.setFont(new Font("Lao MN", Font.PLAIN, 20));
		CreateCourse_label.setBounds(107, 6, 188, 40);
		layer_Course_Create.add(CreateCourse_label);
		
		
		courseid_label.setForeground(Color.WHITE);
		courseid_label.setBounds(6, 45, 84, 38);
		layer_Course_Create.add(courseid_label);
		
		textField_courseid = new JTextField();
		textField_courseid.setColumns(10);
		textField_courseid.setBounds(95, 51, 266, 26);
		layer_Course_Create.add(textField_courseid);
		
		
		courseName_label.setForeground(Color.WHITE);
		courseName_label.setBounds(6, 78, 84, 38);
		layer_Course_Create.add(courseName_label);
		
		coursename_textField = new JTextField();
		coursename_textField.setColumns(10);
		coursename_textField.setBounds(95, 84, 266, 26);
		layer_Course_Create.add(coursename_textField);
		
		
		startDate_label.setForeground(Color.WHITE);
		startDate_label.setBounds(6, 116, 84, 38);
		layer_Course_Create.add(startDate_label);
		
		startdate_textField = new JTextField();
		startdate_textField.setColumns(10);
		startdate_textField.setBounds(95, 122, 266, 26);
		layer_Course_Create.add(startdate_textField);
		
		
		classRoom_label.setForeground(Color.WHITE);
		classRoom_label.setBounds(6, 158, 84, 26);
		layer_Course_Create.add(classRoom_label);
		
		
		submmit_button.setBounds(244, 198, 117, 29);
		layer_Course_Create.add(submmit_button);
		submmit_button.addActionListener(this);
		
		
		cancel_button.setBounds(100, 198, 117, 29);
		layer_Course_Create.add(cancel_button);
		cancel_button.addActionListener(this);
		
		classroom_textField = new JTextField();
		classroom_textField.setColumns(10);
		classroom_textField.setBounds(95, 158, 266, 26);
		layer_Course_Create.add(classroom_textField);

		setResizable(false);
		centerWindow(this);

	}

	private void centerWindow(Window w) {

		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension d = tk.getScreenSize();
		setLocation((d.width - w.getWidth()) / 2, (d.height - w.getHeight()) / 2);

	}

	public void actionPerformed(ActionEvent e) {
		Object button = e.getSource();
		if (button == cancel_button) {
			Course_Frame_Menu course_menu = new Course_Frame_Menu();
			course_menu.setVisible(true);
			this.setVisible(false);
			this.dispose();	
		} else if (button == submmit_button) {
			Course course = new Course();
			course.setCourseID(textField_courseid.getText());
			course.setCourseName(coursename_textField.getText());
			course.setStartDate(startdate_textField.getText());
			course.setClassRoom(Integer.parseInt(classroom_textField.getText()));
			
			try {
				CourseDAOIplementation course_DAO = new CourseDAOIplementation();
				course_DAO.insertCourse(course);

			} catch (ClassNotFoundException ex) {
				ex.printStackTrace();
			}

			
		}

	}

}
