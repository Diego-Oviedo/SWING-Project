package graphic_user_interface;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import DAOimplementation.*;
import model.*;


public class Student_Frame_Delete extends JFrame implements ActionListener {

	public static void main(String[] args) {
			Teacher_Frame_Delete frame = new Teacher_Frame_Delete();
			frame.setVisible(true);
	}
	
	private JPanel layer_Student_Delete;
	private JTextField textField_studentid;
	JLabel DeleteAStudent_label = new JLabel("Delete a Student");
	JLabel studentid_label = new JLabel("Student ID");
	JButton search_button = new JButton("Search");
	JLabel student_label = new JLabel("Student:");
	JButton cancel_button = new JButton("Cancel");
	JButton delete_button = new JButton("Delete");
	private final JLabel id_name_display = new JLabel("");
	private final JLabel DOB_display = new JLabel("");
	private final JLabel email_display = new JLabel("");


	public Student_Frame_Delete() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 408, 276);
		layer_Student_Delete = new JPanel();
		layer_Student_Delete.setBackground(Color.DARK_GRAY);
		layer_Student_Delete.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(layer_Student_Delete);
		layer_Student_Delete.setLayout(null);
		
		
		DeleteAStudent_label.setForeground(Color.WHITE);
		DeleteAStudent_label.setFont(new Font("Lao MN", Font.PLAIN, 20));
		DeleteAStudent_label.setBounds(98, 6, 188, 40);
		layer_Student_Delete.add(DeleteAStudent_label);
		
		
		studentid_label.setForeground(Color.WHITE);
		studentid_label.setBounds(73, 46, 84, 38);
		layer_Student_Delete.add(studentid_label);
		
		textField_studentid = new JTextField();
		textField_studentid.setColumns(10);
		textField_studentid.setBounds(150, 52, 112, 26);
		layer_Student_Delete.add(textField_studentid);
		textField_studentid.addActionListener(this);
		
		
		search_button.setBounds(265, 52, 117, 29);
		layer_Student_Delete.add(search_button);
		search_button.addActionListener(this);
		
		
		student_label.setForeground(Color.WHITE);
		student_label.setBounds(41, 96, 61, 16);
		layer_Student_Delete.add(student_label);
		
		
		
		cancel_button.setBounds(206, 194, 132, 29);
		layer_Student_Delete.add(cancel_button);
		cancel_button.addActionListener(this);
		
		
		delete_button.setBounds(73, 193, 132, 31);
		layer_Student_Delete.add(delete_button);
		id_name_display.setVerticalAlignment(SwingConstants.TOP);
		id_name_display.setHorizontalAlignment(SwingConstants.LEFT);
		id_name_display.setForeground(Color.WHITE);
		id_name_display.setBounds(98, 91, 304, 26);
		
		layer_Student_Delete.add(id_name_display);
		DOB_display.setVerticalAlignment(SwingConstants.TOP);
		DOB_display.setHorizontalAlignment(SwingConstants.LEFT);
		DOB_display.setForeground(Color.WHITE);
		DOB_display.setBounds(98, 124, 304, 26);
		
		layer_Student_Delete.add(DOB_display);
		email_display.setVerticalAlignment(SwingConstants.TOP);
		email_display.setHorizontalAlignment(SwingConstants.LEFT);
		email_display.setForeground(Color.WHITE);
		email_display.setBounds(98, 156, 304, 26);
		
		layer_Student_Delete.add(email_display);
		delete_button.addActionListener(this);
		
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
				StudentDAOImplementation student_DAO = new StudentDAOImplementation();
				String ID = textField_studentid.getText();
				Student student_obtained = student_DAO.readStudent(ID);
				
				
				
			id_name_display.setText("ID: " + student_obtained.getStudentID() + "\n" + 
										"Name : " + student_obtained.getFirstName() + " " + 
									   student_obtained.getLastName());
										
			DOB_display.setText("Date of birth: " + student_obtained.getDateOfBirth());
			
			email_display.setText("E-mail: " + student_obtained.getEmail());
			} catch (ClassNotFoundException ex) {
				ex.printStackTrace();
			}
			
		}else if (button==delete_button) {
			try {
				StudentDAOImplementation student_DAO = new StudentDAOImplementation();
			
				String id = textField_studentid.getText();
				student_DAO.deleteStudent(id);
						
				} catch (ClassNotFoundException ex) {
					ex.printStackTrace();
				}
			
			
		}else if(button==cancel_button) {
			Student_Frame_Menu student_menu = new Student_Frame_Menu();
			student_menu.setVisible(true);
			this.setVisible(false);
			this.dispose();	
		}
		
	}
	
	
}
