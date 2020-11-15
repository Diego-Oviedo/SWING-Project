package graphic_user_interface;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import DAOimplementation.*;
import model.*;

public class Student_Frame_Update extends JFrame implements ActionListener {
	
	public static void main(String[] args) {
			Student_Frame_Update frame = new Student_Frame_Update();
			frame.setVisible(true);
	}
	
	private JPanel layer_Student_Update;
	private JTextField textField_studentid;
	private JTextField textField_firstname;
	private JTextField textField_lastname;
	private JTextField textField_email;
	private JTextField textField_date;
	JLabel UpdateStudent_label = new JLabel("Update a Student");
	JLabel studentid_label = new JLabel("Student ID:");
	JButton search_button = new JButton("Search");
	JLabel firstname_label = new JLabel("First Name");
	JLabel lastname_label = new JLabel("Last Name");
	JLabel DOB_label = new JLabel("Date Of Birth");
	JLabel email_label = new JLabel("E-mail");
	JButton cancel_button = new JButton("Cancel");
	JButton submmit_button = new JButton("Submmit");



	public Student_Frame_Update() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 433, 304);
		layer_Student_Update = new JPanel();
		layer_Student_Update.setBackground(Color.DARK_GRAY);
		layer_Student_Update.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(layer_Student_Update);
		layer_Student_Update.setLayout(null);
		
		
		UpdateStudent_label.setForeground(Color.WHITE);
		UpdateStudent_label.setFont(new Font("Lao MN", Font.PLAIN, 20));
		UpdateStudent_label.setBounds(118, 6, 188, 40);
		layer_Student_Update.add(UpdateStudent_label);
		
		
		studentid_label.setForeground(Color.WHITE);
		studentid_label.setBounds(71, 46, 84, 38);
		layer_Student_Update.add(studentid_label);
		
		textField_studentid = new JTextField();
		textField_studentid.setColumns(10);
		textField_studentid.setBounds(144, 52, 112, 26);
		layer_Student_Update.add(textField_studentid);
		
		
		search_button.setBounds(259, 52, 117, 29);
		layer_Student_Update.add(search_button);
		search_button.addActionListener(this);
		
		
		firstname_label.setForeground(Color.WHITE);
		firstname_label.setBounds(41, 96, 84, 38);
		layer_Student_Update.add(firstname_label);
		
		textField_firstname = new JTextField();
		textField_firstname.setColumns(10);
		textField_firstname.setBounds(137, 102, 259, 26);
		layer_Student_Update.add(textField_firstname);
		
		
		lastname_label.setForeground(Color.WHITE);
		lastname_label.setBounds(41, 134, 84, 38);
		layer_Student_Update.add(lastname_label);
		
		textField_lastname = new JTextField();
		textField_lastname.setColumns(10);
		textField_lastname.setBounds(137, 140, 258, 26);
		layer_Student_Update.add(textField_lastname);
		
		
		DOB_label.setForeground(Color.WHITE);
		DOB_label.setBounds(41, 176, 84, 26);
		layer_Student_Update.add(DOB_label);
		
		
		email_label.setForeground(Color.WHITE);
		email_label.setBounds(41, 208, 84, 38);
		layer_Student_Update.add(email_label);
		
		textField_email = new JTextField();
		textField_email.setColumns(10);
		textField_email.setBounds(138, 214, 258, 26);
		layer_Student_Update.add(textField_email);
		
		
		cancel_button.setBounds(135, 249, 117, 29);
		layer_Student_Update.add(cancel_button);
		cancel_button.addActionListener(this);
		
		
		submmit_button.setBounds(279, 249, 117, 29);
		layer_Student_Update.add(submmit_button);
		
		textField_date = new JTextField();
		textField_date.setBounds(138, 176, 258, 26);
		layer_Student_Update.add(textField_date);
		textField_date.setColumns(10);
		
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
				StudentDAOImplementation student_DAO = new StudentDAOImplementation();
				String ID = textField_studentid.getText();
				Student student_obtained = student_DAO.readStudent(ID);
	
				textField_studentid.setText(student_obtained.getStudentID());
				textField_firstname.setText(student_obtained.getFirstName());
				textField_lastname.setText(student_obtained.getLastName());
				textField_email.setText(student_obtained.getEmail());
				textField_date.setText(student_obtained.getDateOfBirth());
				
				} catch (ClassNotFoundException ex) {
					ex.printStackTrace();
				}
			
		}else if(button==submmit_button){
			
			try {
				StudentDAOImplementation student_DAO = new StudentDAOImplementation();
				String student_id = textField_studentid.getText();
				String firstName = textField_firstname.getText();
				String lastName = textField_lastname.getText();
				String dateOfBirth = textField_date.getText();
				String email = textField_email.getText();
				
				student_DAO.updateStudent(student_id,firstName,lastName,dateOfBirth,email);
				
						
				} catch (ClassNotFoundException ex) {
					ex.printStackTrace();
				}
			
			
		}else if(button==cancel_button){
			Student_Frame_Menu student_menu = new Student_Frame_Menu();
			student_menu.setVisible(true);
			this.setVisible(false);
			this.dispose();	
		}
		
	}
}
