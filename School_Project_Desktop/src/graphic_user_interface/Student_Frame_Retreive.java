package graphic_user_interface;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import DAOimplementation.*;
import dao_interface.*;
import model.*;

public class Student_Frame_Retreive extends JFrame implements ActionListener {

		public static void main(String[] args)throws ClassNotFoundException {

			Student_Frame_Retreive frame = new Student_Frame_Retreive();
			frame.setVisible(true);
	}
		
		RegisterDAOInterface  register_DAO = new RegisterDAOImplementation();
		
		private JPanel layer_Student_Retreive;
		private JTextField textField_studentid;
		private JTable table;
		JLabel retreiveastudents_label = new JLabel("Retreive a Student");
		JLabel studentid_label = new JLabel("Student ID");
		JButton search_button = new JButton("Search");
		JButton cancel_button = new JButton("Cancel");
		JButton back_button = new JButton("Back");
		

	public Student_Frame_Retreive()throws ClassNotFoundException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 788, 371);
		layer_Student_Retreive = new JPanel();
		layer_Student_Retreive.setBackground(Color.DARK_GRAY);
		layer_Student_Retreive.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(layer_Student_Retreive);
		layer_Student_Retreive.setLayout(null);
		retreiveastudents_label.setBounds(306, 6, 188, 40);
		
		
		retreiveastudents_label.setForeground(Color.WHITE);
		retreiveastudents_label.setFont(new Font("Lao MN", Font.PLAIN, 20));
		layer_Student_Retreive.add(retreiveastudents_label);
		studentid_label.setBounds(255, 46, 84, 38);
		
		
		studentid_label.setForeground(Color.WHITE);
		layer_Student_Retreive.add(studentid_label);
		
		textField_studentid = new JTextField();
		textField_studentid.setBounds(332, 52, 112, 26);
		textField_studentid.setColumns(10);
		layer_Student_Retreive.add(textField_studentid);
		search_button.setBounds(447, 52, 117, 29);
		layer_Student_Retreive.add(search_button);
		search_button.addActionListener(this);
		cancel_button.setBounds(665, 304, 117, 29);
		layer_Student_Retreive.add(cancel_button);
		
		ArrayList<Student> students_registered = register_DAO.retreiveStudents();
		String columns[]={"Student ID","Student Name","Date of birth","Email"};   
		ArrayList<String[]> values = new ArrayList<String[]>();		
		
		 for (int i = 0; i < students_registered.size() ; i++) {	 
			 
	            values.add(new String[] {students_registered.get(i).getStudentID(),
	            						 students_registered.get(i).getFirstName() + " " + students_registered.get(i).getLastName(),
	            						 students_registered.get(i).getDateOfBirth(), students_registered.get(i).getEmail()});
	        }
		
		 TableModel tableModel = new DefaultTableModel(values.toArray(new Object[][] {}),columns);
		 table = new JTable(tableModel);	
			table.setBackground(Color.GRAY);
			table.setBounds(18, 90, 764, 202);
			layer_Student_Retreive.add(table);
		back_button.setBounds(42, 304, 117, 29);
		layer_Student_Retreive.add(back_button);
		
		
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
			String ID = textField_studentid.getText();
			
			ArrayList<Register> students_registered_by_id = register_DAO.retreiveStudentsRegisteredByID(ID);
			String columns[]={"Student ID","Student Name","Course Name","Course ID","Classroom","Start date","Schedule","Teacher" };   
			ArrayList<String[]> values = new ArrayList<String[]>();		
			
			 for (int i = 0; i < students_registered_by_id.size() ; i++) {	 
				 
			        values.add(new String[] {students_registered_by_id.get(i).getStudent().getStudentID(),
			        						 students_registered_by_id.get(i).getStudent().getFirstName() + " " + students_registered_by_id.get(i).getStudent().getLastName(),
			        						 students_registered_by_id.get(i).getCourse().getCourseName(),
			        						 students_registered_by_id.get(i).getCourse().getCourseID(),
			        						 students_registered_by_id.get(i).getCourse().getClassRoom() + "",
			        						 students_registered_by_id.get(i).getCourse().getStartDate(),
			        						 students_registered_by_id.get(i).getSchedule(),
			        						 students_registered_by_id.get(i).getTeacher().getFirstName() + " " + students_registered_by_id.get(i).getTeacher().getLastName()});
			    }
			 TableModel tableModel = new DefaultTableModel(values.toArray(new Object[][] {}),columns);
			 table.setModel(tableModel);
			
		}else if(button==back_button){
			Student_Frame_Retreive retreive_student;
			try {
				retreive_student = new Student_Frame_Retreive();
				retreive_student.setVisible(true);
				this.setVisible(false);
				this.dispose();
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}
			
		}else if(button==cancel_button){
			Student_Frame_Menu student_menu = new Student_Frame_Menu();
			student_menu.setVisible(true);
			this.setVisible(false);
			this.dispose();	
		}
		
	}
}
