package graphic_user_interface;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import DAOimplementation.*;
import model.*;

public class Teacher_Frame_Update extends JFrame implements ActionListener {
	
	public static void main(String[] args) {
			Teacher_Frame_Update frame = new Teacher_Frame_Update();
			frame.setVisible(true);
	}
	
	private JPanel layer_Teacher_Update;
	private JTextField textField_employeeid;
	private JTextField textField_firstname;
	private JTextField textField_lastname;
	private JTextField textField_email;
	private JTextField textField_date;
	JLabel UpdateTeacher_label = new JLabel("Update a Teacher");
	JLabel employeeid_label = new JLabel("Employee ID");
	JButton search_button = new JButton("Search");
	JLabel firstname_label = new JLabel("First Name");
	JLabel lastname_label = new JLabel("Last Name");
	JLabel hiredate_label = new JLabel("Hire Date");
	JLabel email_label = new JLabel("E-mail");
	JButton cancel_button = new JButton("Cancel");
	JButton submmit_button = new JButton("Submmit");
	


	public Teacher_Frame_Update() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 433, 325);
		layer_Teacher_Update = new JPanel();
		layer_Teacher_Update.setBackground(Color.DARK_GRAY);
		layer_Teacher_Update.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(layer_Teacher_Update);
		layer_Teacher_Update.setLayout(null);
		
		
		UpdateTeacher_label.setForeground(Color.WHITE);
		UpdateTeacher_label.setFont(new Font("Lao MN", Font.PLAIN, 20));
		UpdateTeacher_label.setBounds(118, 6, 188, 40);
		layer_Teacher_Update.add(UpdateTeacher_label);
		
		
		employeeid_label.setForeground(Color.WHITE);
		employeeid_label.setBounds(67, 46, 84, 38);
		layer_Teacher_Update.add(employeeid_label);
		
		textField_employeeid = new JTextField();
		textField_employeeid.setColumns(10);
		textField_employeeid.setBounds(144, 52, 112, 26);
		layer_Teacher_Update.add(textField_employeeid);
		
		
		search_button.setBounds(259, 52, 117, 29);
		layer_Teacher_Update.add(search_button);
		search_button.addActionListener(this);
		
		
		
		firstname_label.setForeground(Color.WHITE);
		firstname_label.setBounds(40, 104, 84, 38);
		layer_Teacher_Update.add(firstname_label);
		
		textField_firstname = new JTextField();
		textField_firstname.setColumns(10);
		textField_firstname.setBounds(136, 110, 259, 26);
		layer_Teacher_Update.add(textField_firstname);
		
		
		lastname_label.setForeground(Color.WHITE);
		lastname_label.setBounds(40, 142, 84, 38);
		layer_Teacher_Update.add(lastname_label);
		
		textField_lastname = new JTextField();
		textField_lastname.setColumns(10);
		textField_lastname.setBounds(136, 148, 258, 26);
		layer_Teacher_Update.add(textField_lastname);
		
		
		hiredate_label.setForeground(Color.WHITE);
		hiredate_label.setBounds(40, 184, 84, 26);
		layer_Teacher_Update.add(hiredate_label);
		
		
		email_label.setForeground(Color.WHITE);
		email_label.setBounds(40, 216, 84, 38);
		layer_Teacher_Update.add(email_label);
		
		textField_email = new JTextField();
		textField_email.setColumns(10);
		textField_email.setBounds(137, 222, 258, 26);
		layer_Teacher_Update.add(textField_email);
		
		
		cancel_button.setBounds(134, 257, 117, 29);
		layer_Teacher_Update.add(cancel_button);
		cancel_button.addActionListener(this);
		
		
		submmit_button.setBounds(278, 257, 117, 29);
		layer_Teacher_Update.add(submmit_button);
		
		textField_date = new JTextField();
		textField_date.setBounds(137, 184, 258, 26);
		layer_Teacher_Update.add(textField_date);
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
				TeacherDAOImplementation teacher_DAO = new TeacherDAOImplementation();
				String ID = textField_employeeid.getText();
				Teacher teacher_obtained = teacher_DAO.readTeacher(ID);

				textField_employeeid.setText(teacher_obtained.getEmployeeID());
				textField_firstname.setText(teacher_obtained.getFirstName());
				textField_lastname.setText(teacher_obtained.getLastName());
				textField_date.setText(teacher_obtained.getHireDate());
				textField_email.setText(teacher_obtained.getEmail());
						
				} catch (ClassNotFoundException ex) {
					ex.printStackTrace();
				}
			
		}else if(button==submmit_button){
			
			try {
				TeacherDAOImplementation teacher_DAO = new TeacherDAOImplementation();
				String employee_id = textField_employeeid.getText();
				String firstName = textField_firstname.getText();
				String lastName = textField_lastname.getText();
				String hireDate = textField_date.getText();
				String email = textField_email.getText();
				
				teacher_DAO.updateTeacher(employee_id,firstName,lastName,hireDate,email);
				
						
				} catch (ClassNotFoundException ex) {
					ex.printStackTrace();
				}
			
			
		}else if(button==cancel_button){
			Teacher_Frame_Menu teacher_menu = new Teacher_Frame_Menu();
			teacher_menu.setVisible(true);
			this.setVisible(false);
			this.dispose();	
		}
		
	}
}
