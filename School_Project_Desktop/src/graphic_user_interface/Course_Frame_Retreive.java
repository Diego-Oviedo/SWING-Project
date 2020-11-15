package graphic_user_interface;

import model.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import DAOimplementation.*;
import dao_interface.RegisterDAOInterface;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Course_Frame_Retreive extends JFrame implements ActionListener {

	

	public static void main(String[] args)throws ClassNotFoundException {

					Course_Frame_Retreive frame = new Course_Frame_Retreive();
					frame.setVisible(true);

	}
	
	RegisterDAOInterface  register_DAO = new RegisterDAOImplementation();

	private JPanel layer_Course_Retreive;
	private JTextField textField_course_id;
	private JTable table;
	JLabel greeting_label = new JLabel("Retreive a Course");
	JLabel courseid_label = new JLabel("Course ID");
	JButton search_button = new JButton("Search");
	JButton cancel_button = new JButton("Cancel");
	private final JButton back_button = new JButton("Back");

	
	
	public Course_Frame_Retreive()throws ClassNotFoundException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 930, 370);
		layer_Course_Retreive = new JPanel();
		layer_Course_Retreive.setBackground(Color.DARK_GRAY);
		layer_Course_Retreive.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(layer_Course_Retreive);
		layer_Course_Retreive.setLayout(null);
		
		
		greeting_label.setForeground(Color.WHITE);
		greeting_label.setFont(new Font("Lao MN", Font.PLAIN, 20));
		greeting_label.setBounds(341, 6, 188, 40);
		layer_Course_Retreive.add(greeting_label);
		
		
		courseid_label.setForeground(Color.WHITE);
		courseid_label.setBounds(290, 46, 84, 38);
		layer_Course_Retreive.add(courseid_label);
		
		textField_course_id = new JTextField();
		textField_course_id.setColumns(10);
		textField_course_id.setBounds(367, 52, 112, 26);
		layer_Course_Retreive.add(textField_course_id);
		
		
		search_button.setBounds(482, 52, 117, 29);
		layer_Course_Retreive.add(search_button);
		search_button.addActionListener(this);
		
		
		cancel_button.setBounds(807, 313, 117, 29);
		layer_Course_Retreive.add(cancel_button);
		
		ArrayList<Course> courses_registered = register_DAO.retreiveCourses();
		String columns[]={"Course ID","Course Name","Start Date","Classroom"};   
		ArrayList<String[]> values = new ArrayList<String[]>();		
		
		 for (int i = 0; i < courses_registered.size() ; i++) {	 
			 
	            values.add(new String[] {courses_registered.get(i).getCourseID(),
					            		 courses_registered.get(i).getCourseName(), 
					            		 courses_registered.get(i).getStartDate(),
					            		 courses_registered.get(i).getClassRoom() + ""});
	        }
		
		 TableModel tableModel = new DefaultTableModel(values.toArray(new Object[][] {}),columns);
		
		
		table = new JTable(tableModel);
		table.setBackground(Color.GRAY);
		table.setBounds(6, 87, 918, 224);
		layer_Course_Retreive.add(table);
		back_button.setBounds(0, 319, 117, 29);
		
		layer_Course_Retreive.add(back_button);
		cancel_button.addActionListener(this);
		back_button.addActionListener(this);

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
			
			String id = textField_course_id.getText();
			
			ArrayList<Register> courses_registered_by_id = register_DAO.retreiveCoursesRegisteredByID(id);
			
			String columns[]={"Student ID","Student Name","Teacher Name","Employee ID","Course ID","Course Name","Start date","Classroom"};   
			
			ArrayList<String[]> values = new ArrayList<String[]>();		
			
			 for (int i = 0; i < courses_registered_by_id.size() ; i++) {	 
				 
			        values.add(new String[] {
						            		 courses_registered_by_id.get(i).getStudent().getStudentID(),
						            		 courses_registered_by_id.get(i).getStudent().getFirstName() + " " + courses_registered_by_id.get(i).getStudent().getLastName(),
						            		 courses_registered_by_id.get(i).getTeacher().getFirstName() + " " + courses_registered_by_id.get(i).getTeacher().getLastName(),
						            		 courses_registered_by_id.get(i).getTeacher().getEmployeeID(),
			        						 courses_registered_by_id.get(i).getCourse().getCourseID(),
						            		 courses_registered_by_id.get(i).getCourse().getCourseName(), 
						            		 courses_registered_by_id.get(i).getCourse().getStartDate(),
						            		 courses_registered_by_id.get(i).getCourse().getClassRoom() + ""});
			    }
			
			 TableModel tableModel = new DefaultTableModel(values.toArray(new Object[][] {}),columns);
			 table.setModel(tableModel);
			
		}else if(button==back_button){
			Course_Frame_Retreive retreive_course;
			try {
				retreive_course = new Course_Frame_Retreive();
				retreive_course.setVisible(true);
				this.setVisible(false);
				this.dispose();
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}
			
			
			 
			 
		}else if(button==cancel_button){
			Course_Frame_Menu course_menu = new Course_Frame_Menu();
			course_menu.setVisible(true);
			this.setVisible(false);
			this.dispose();	
		}
		
	}
}
