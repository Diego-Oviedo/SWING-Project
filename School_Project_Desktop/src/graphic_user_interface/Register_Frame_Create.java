package graphic_user_interface;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import DAOimplementation.*;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import dao_interface.*;
import model.*;

public class Register_Frame_Create extends JFrame implements ActionListener{
	
	public static void main(String[] args)throws ClassNotFoundException {
		Register_Frame_Create frame = new Register_Frame_Create();
					frame.setVisible(true);
					
					
					
	}

	RegisterDAOInterface register_DAO = new RegisterDAOImplementation();
	ArrayList<Course> courses = register_DAO.retreiveCourses();
	ArrayList<Student> students = register_DAO.retreiveStudents();
	ArrayList<Teacher> teachers = register_DAO.retreiveTeachers();
	
	private JPanel layer_Register_Menu;
	private final JComboBox comboBox_course = new JComboBox();
	private final JComboBox comboBox_schedule = new JComboBox();
	private final JComboBox comboBox_student = new JComboBox();
	private final JComboBox comboBox_teacher = new JComboBox();
	JButton CreateRegister_button = new JButton("Create Register");
	JButton cancel_button = new JButton("Cancel");
	
	
	
	public Register_Frame_Create() throws ClassNotFoundException {	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 437, 300);
		layer_Register_Menu = new JPanel();
		layer_Register_Menu.setBackground(Color.DARK_GRAY);
		layer_Register_Menu.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(layer_Register_Menu);
		layer_Register_Menu.setLayout(null);
		
		JLabel welcome_label_Register = new JLabel("Create a Register");
		welcome_label_Register.setForeground(Color.WHITE);
		welcome_label_Register.setFont(new Font("Lao MN", Font.PLAIN, 23));
		welcome_label_Register.setBounds(110, 6, 234, 68);
		layer_Register_Menu.add(welcome_label_Register);
		
		
		cancel_button.setBounds(6, 222, 117, 29);
		layer_Register_Menu.add(cancel_button);
		
		
		CreateRegister_button.setBounds(280, 222, 151, 29);
		layer_Register_Menu.add(CreateRegister_button);
		
		//Creating ComboBox Courses
		comboBox_course.setBounds(121, 66, 215, 27);	
		for(Course course: courses) {
			comboBox_course.addItem(course.getCourseID() + " " + course.getCourseName());
		}
		layer_Register_Menu.add(comboBox_course);
		
		
		//Creating ComboBox Schedule
		comboBox_schedule.setBounds(121, 100, 215, 27);
		comboBox_schedule.addItem("DAY");
		comboBox_schedule.addItem("NIGHT");
		layer_Register_Menu.add(comboBox_schedule);
		
	
		//Creating ComboBox Students
		comboBox_student.setBounds(121, 132, 215, 27);
		for(Student student: students) {
			comboBox_student.addItem(student.getStudentID() + " " + student.getFirstName() + " " + student.getLastName());
		}
		layer_Register_Menu.add(comboBox_student);
		
		
		
		//Creating ComboBox Teachers
		comboBox_teacher.setBounds(121, 165, 215, 27);
		for(Teacher teacher: teachers) {
			comboBox_teacher.addItem(teacher.getEmployeeID() + " " + teacher.getFirstName() + " " + teacher.getLastName());
		}
		layer_Register_Menu.add(comboBox_teacher);
				
		JLabel Course_label = new JLabel("Course:");
		Course_label.setForeground(Color.WHITE);
		Course_label.setBounds(48, 70, 61, 16);
		layer_Register_Menu.add(Course_label);
		
		JLabel Schedule_label = new JLabel("Schedule:");
		Schedule_label.setForeground(Color.WHITE);
		Schedule_label.setBounds(48, 104, 61, 16);
		layer_Register_Menu.add(Schedule_label);
		
		JLabel Student_label = new JLabel("Student:");
		Student_label.setForeground(Color.WHITE);
		Student_label.setBounds(48, 136, 61, 16);
		layer_Register_Menu.add(Student_label);
		
		JLabel Teacher_label = new JLabel("Teacher:");
		Teacher_label.setForeground(Color.WHITE);
		Teacher_label.setBounds(48, 169, 61, 16);
		layer_Register_Menu.add(Teacher_label);
		cancel_button.addActionListener(this);
		CreateRegister_button.addActionListener(this);


		setResizable(false);
		centerWindow(this);
		
	
		
	}
	
	private void centerWindow(Window w) {
	
	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension d = tk.getScreenSize();
	setLocation(  (d.width-w.getWidth())/2 , (d.height-w.getHeight())/2  );
	
	}
	

	public void actionPerformed(ActionEvent e)  {
		Object button = e.getSource();
		if(button==cancel_button) {
			Register_Frame_Menu register_menu = new Register_Frame_Menu();
			register_menu.setVisible(true);
			this.setVisible(false);
			this.dispose(); 
			
		}else if(button==CreateRegister_button) {
			try {
			Register register = new Register();
			
			String course_id = (String) comboBox_course.getItemAt(comboBox_course.getSelectedIndex()); 
			course_id = course_id.substring(0,6);
			register.setCourse_id(course_id);
			
			String course_name = (String) comboBox_course.getItemAt(comboBox_course.getSelectedIndex()); 
			course_name = course_name.substring(7);
			register.setCourse_name(course_name);
			
			String schedule = (String) comboBox_schedule.getItemAt(comboBox_schedule.getSelectedIndex()); 
			register.setSchedule(schedule);
			
			String student_id = (String) comboBox_student.getItemAt(comboBox_student.getSelectedIndex()); 
			student_id = student_id.substring(0,6);
			register.setStudent_id(student_id);
			
			String employee_id = (String) comboBox_teacher.getItemAt(comboBox_teacher.getSelectedIndex()); 
			employee_id = employee_id.substring(0,6);
			register.setEmployee_id(employee_id);
			
			register_DAO.insertRegister(register);
			
			}catch(Exception ex) {
				
			}
		}
	}
}
