package graphic_user_interface;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import DAOimplementation.*;
import model.*;


public class Teacher_Frame_Delete extends JFrame implements ActionListener {

	public static void main(String[] args) {
			Teacher_Frame_Delete frame = new Teacher_Frame_Delete();
			frame.setVisible(true);
	}
	
	private JPanel layer_Teacher_Delete;
	private JTextField textField_employeeid;
	JLabel DeleteATeacher_label = new JLabel("Delete a Teacher");
	JLabel employeeid_label = new JLabel("Employee ID");
	JButton search_button = new JButton("Search");
	JLabel teacher_label = new JLabel("Teacher:");
	JButton cancel_button = new JButton("Cancel");
	JButton delete_button = new JButton("Delete");
	private final JLabel id_name_display = new JLabel("");
	private final JLabel HD_display = new JLabel("");
	private final JLabel email_display = new JLabel("");


	public Teacher_Frame_Delete() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 408, 276);
		layer_Teacher_Delete = new JPanel();
		layer_Teacher_Delete.setBackground(Color.DARK_GRAY);
		layer_Teacher_Delete.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(layer_Teacher_Delete);
		layer_Teacher_Delete.setLayout(null);
		
		
		DeleteATeacher_label.setForeground(Color.WHITE);
		DeleteATeacher_label.setFont(new Font("Lao MN", Font.PLAIN, 20));
		DeleteATeacher_label.setBounds(98, 6, 188, 40);
		layer_Teacher_Delete.add(DeleteATeacher_label);
		
		
		employeeid_label.setForeground(Color.WHITE);
		employeeid_label.setBounds(65, 46, 84, 38);
		layer_Teacher_Delete.add(employeeid_label);
		
		textField_employeeid = new JTextField();
		textField_employeeid.setColumns(10);
		textField_employeeid.setBounds(150, 52, 112, 26);
		layer_Teacher_Delete.add(textField_employeeid);
		textField_employeeid.addActionListener(this);
		
		
		search_button.setBounds(265, 52, 117, 29);
		layer_Teacher_Delete.add(search_button);
		search_button.addActionListener(this);
		
		
		teacher_label.setForeground(Color.WHITE);
		teacher_label.setBounds(41, 96, 61, 16);
		layer_Teacher_Delete.add(teacher_label);
		
		
		
		cancel_button.setBounds(206, 194, 132, 29);
		layer_Teacher_Delete.add(cancel_button);
		cancel_button.addActionListener(this);
		
		
		delete_button.setBounds(73, 193, 132, 31);
		layer_Teacher_Delete.add(delete_button);
		id_name_display.setVerticalAlignment(SwingConstants.TOP);
		id_name_display.setHorizontalAlignment(SwingConstants.LEFT);
		id_name_display.setForeground(Color.WHITE);
		id_name_display.setBounds(98, 91, 304, 26);
		
		layer_Teacher_Delete.add(id_name_display);
		HD_display.setVerticalAlignment(SwingConstants.TOP);
		HD_display.setHorizontalAlignment(SwingConstants.LEFT);
		HD_display.setForeground(Color.WHITE);
		HD_display.setBounds(98, 124, 304, 26);
		
		layer_Teacher_Delete.add(HD_display);
		email_display.setVerticalAlignment(SwingConstants.TOP);
		email_display.setHorizontalAlignment(SwingConstants.LEFT);
		email_display.setForeground(Color.WHITE);
		email_display.setBounds(98, 156, 304, 26);
		
		layer_Teacher_Delete.add(email_display);
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
				TeacherDAOImplementation teacher_DAO = new TeacherDAOImplementation();
				String ID = textField_employeeid.getText();
				Teacher teacher_obtained = teacher_DAO.readTeacher(ID);
				
				
				
			id_name_display.setText("Employee ID: " + teacher_obtained.getEmployeeID() + "\n" + 
										"Name : " + teacher_obtained.getFirstName() + " " + 
									   teacher_obtained.getLastName());
										
			HD_display.setText("Hire Date: " + teacher_obtained.getHireDate());
			
			email_display.setText("E-mail: " + teacher_obtained.getEmail());
			} catch (ClassNotFoundException ex) {
				ex.printStackTrace();
			}
			
		}else if (button==delete_button) {
			try {
				TeacherDAOImplementation teacher_DAO = new TeacherDAOImplementation();
			
				String id = textField_employeeid.getText();
				teacher_DAO.deleteTeacher(id);
						
				} catch (ClassNotFoundException ex) {
					ex.printStackTrace();
				}
			
			
		}else if(button==cancel_button) {
			Teacher_Frame_Menu teacher_menu = new Teacher_Frame_Menu();
			teacher_menu.setVisible(true);
			this.setVisible(false);
			this.dispose();	
		}
		
	}
	
	
}
