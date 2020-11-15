package graphic_user_interface;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import DAOimplementation.*;
import model.*;


public class Student_Frame_Menu extends JFrame implements ActionListener {

	private JPanel layer_Student_Menu;
	JLabel description_label_Student = new JLabel("Please choose onde of the following options:");
	JLabel welcome_label_Student = new JLabel("Student's Menu");
	JButton createStudent_button = new JButton("Create Student");
	JButton updateStudent_button = new JButton("Update Student");
	JButton retreiveStudent_button = new JButton("Retreive Student");
	JButton deleteStudent_button = new JButton("Delete Student");
	JButton mainMenu_button = new JButton("Main Menu");

	public static void main(String[] args) {
					Student_Frame_Menu frame = new Student_Frame_Menu();
					frame.setVisible(true);
	}


	public Student_Frame_Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 437, 300);
		layer_Student_Menu = new JPanel();
		layer_Student_Menu.setBackground(Color.DARK_GRAY);
		layer_Student_Menu.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(layer_Student_Menu);
		layer_Student_Menu.setLayout(null);
		
		
		description_label_Student.setBounds(6, 49, 439, 68);
		description_label_Student.setForeground(Color.WHITE);
		description_label_Student.setFont(new Font("Lao MN", Font.PLAIN, 20));
		layer_Student_Menu.add(description_label_Student);
		
		
		welcome_label_Student.setForeground(Color.WHITE);
		welcome_label_Student.setFont(new Font("Lao MN", Font.PLAIN, 23));
		welcome_label_Student.setBounds(127, 6, 189, 68);
		layer_Student_Menu.add(welcome_label_Student);
		

		createStudent_button.setBounds(41, 105, 153, 46);
		layer_Student_Menu.add(createStudent_button);
		createStudent_button.addActionListener(this);
		
		
		updateStudent_button.setBounds(216, 105, 153, 46);
		layer_Student_Menu.add(updateStudent_button);
		updateStudent_button.addActionListener(this);
		
		retreiveStudent_button.setBounds(41, 163, 153, 46);
		layer_Student_Menu.add(retreiveStudent_button);
		retreiveStudent_button.addActionListener(this);
		
		
		deleteStudent_button.setBounds(216, 163, 153, 46);
		layer_Student_Menu.add(deleteStudent_button);
		deleteStudent_button.addActionListener(this);
		
		
		mainMenu_button.setBounds(152, 222, 117, 29);
		layer_Student_Menu.add(mainMenu_button);
		mainMenu_button.addActionListener(this);

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
		if(button==createStudent_button) {
			Student_Frame_Create create_student = new Student_Frame_Create();
			create_student.setVisible(true);
			this.setVisible(false);
			this.dispose();
			
		}else if(button==updateStudent_button) {
			Student_Frame_Update update_student = new Student_Frame_Update();
			update_student.setVisible(true);
			this.setVisible(false);
			this.dispose();
		
			
		}else if(button==retreiveStudent_button) {
			Student_Frame_Retreive retreive_student;
			try {
				retreive_student = new Student_Frame_Retreive();
				retreive_student.setVisible(true);
				this.setVisible(false);
				this.dispose();
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}
			
		
			
		}else if(button==deleteStudent_button) {
			Student_Frame_Delete delete_student = new Student_Frame_Delete();
			delete_student.setVisible(true);
			this.setVisible(false);
			this.dispose();
			
		}else if(button==mainMenu_button) {
			MainMenu main_menu = new MainMenu();
			main_menu.setVisible(true);
			this.setVisible(false);
			this.dispose(); 
			
		}
		
	}

}
