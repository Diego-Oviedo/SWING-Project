package graphic_user_interface;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import DAOimplementation.*;
import model.*;

public class Student_Frame_Create extends JFrame implements ActionListener {

	private JPanel layer_Student_Create;
	private JTextField textField;
	private JTextField textField_email;
	private JTextField textField_lastname;
	private JTextField textField_firstname;
	private JTextField textField_studentid;
	private JTextField textField_date;
	JLabel CreateAStudent_label = new JLabel("Create a Student");
	JLabel studentid_label = new JLabel("Student ID");
	JLabel firstName_label = new JLabel("First Name");
	JLabel lastName_label = new JLabel("Last Name");
	JLabel dateOfBirth_label = new JLabel("Date of birth");
	JLabel email_label = new JLabel("E-mail");
	JButton submmit_button = new JButton("Submmit");
	JButton cancel_button = new JButton("Cancel");
	 


	public static void main(String[] args) {
		Teacher_Frame_Create frame = new Teacher_Frame_Create();
	}

	public Student_Frame_Create() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 390, 313);
		layer_Student_Create = new JPanel();
		layer_Student_Create.setBackground(Color.DARK_GRAY);
		layer_Student_Create.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(layer_Student_Create);
		layer_Student_Create.setLayout(null);
		setVisible(true);

		CreateAStudent_label.setForeground(Color.WHITE);
		CreateAStudent_label.setFont(new Font("Lao MN", Font.PLAIN, 20));
		CreateAStudent_label.setBounds(107, 16, 188, 40);
		layer_Student_Create.add(CreateAStudent_label);

		studentid_label.setForeground(Color.WHITE);
		studentid_label.setBounds(6, 55, 84, 38);
		layer_Student_Create.add(studentid_label);

		textField_studentid = new JTextField();
		textField_studentid.setBounds(95, 61, 266, 26);
		layer_Student_Create.add(textField_studentid);
		textField_studentid.setColumns(10);

		firstName_label.setForeground(Color.WHITE);
		firstName_label.setBounds(6, 88, 84, 38);
		layer_Student_Create.add(firstName_label);

		textField_firstname = new JTextField();
		textField_firstname.setBounds(95, 94, 266, 26);
		layer_Student_Create.add(textField_firstname);
		textField_firstname.setColumns(10);

		lastName_label.setForeground(Color.WHITE);
		lastName_label.setBounds(6, 126, 84, 38);
		layer_Student_Create.add(lastName_label);

		textField_lastname = new JTextField();
		textField_lastname.setBounds(95, 132, 266, 26);
		layer_Student_Create.add(textField_lastname);
		textField_lastname.setColumns(10);

		dateOfBirth_label.setForeground(Color.WHITE);
		dateOfBirth_label.setBounds(6, 168, 84, 26);
		layer_Student_Create.add(dateOfBirth_label);
		
		textField_date = new JTextField();
		textField_date.setBounds(95, 170, 260, 26);
		layer_Student_Create.add(textField_date);
		textField_date.setColumns(10);
		

		textField_email = new JTextField();
		textField_email.setBounds(95, 206, 266, 26);
		layer_Student_Create.add(textField_email);
		textField_email.setColumns(10);

		email_label.setForeground(Color.WHITE);
		email_label.setBounds(6, 200, 84, 38);
		layer_Student_Create.add(email_label);

		submmit_button.setBounds(239, 244, 117, 29);
		layer_Student_Create.add(submmit_button);
		submmit_button.addActionListener(this);

		
		cancel_button.setBounds(95, 244, 117, 29);
		layer_Student_Create.add(cancel_button);
		cancel_button.addActionListener(this);

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
			Student_Frame_Menu student_menu = new Student_Frame_Menu();
			student_menu.setVisible(true);
			this.setVisible(false);
			this.dispose();
		} else if (button == submmit_button) {
			Student student= new Student();
			student.setFirstName(textField_firstname.getText());
			student.setLastName(textField_lastname.getText());
			student.setStudentID(textField_studentid.getText());
			student.setDateOfBirth(textField_date.getText());
			student.setEmail(textField_email.getText());									
			try {
				StudentDAOImplementation student_DAO = new StudentDAOImplementation();
				student_DAO.insertStudent(student);
			} catch (ClassNotFoundException ex) {
				ex.printStackTrace();
			}

			
		}

	}

}
