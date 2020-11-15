package graphic_user_interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Teacher_Frame_Menu extends JFrame implements ActionListener {


	public static void main(String[] args) {
					Teacher_Frame_Menu frame = new Teacher_Frame_Menu();
					frame.setVisible(true);
	}
	private JPanel layer_Teacher_Menu;
	JButton createTeacher_button = new JButton("Create Teacher");
	JButton updateTeacher_button = new JButton("Update Teacher");
	JButton deleteTeacher_button = new JButton("Delete Teacher");
	JButton retreiveTeacher_button = new JButton("Retreive Teacher");
	JButton mainMenu_button = new JButton("Main Menu");

	public Teacher_Frame_Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 437, 300);
		layer_Teacher_Menu = new JPanel();
		layer_Teacher_Menu.setBackground(Color.DARK_GRAY);
		layer_Teacher_Menu.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(layer_Teacher_Menu);
		layer_Teacher_Menu.setLayout(null);
		
		JLabel description_label_Teacher = new JLabel("Please choose onde of the following options:");
		description_label_Teacher.setForeground(Color.WHITE);
		description_label_Teacher.setFont(new Font("Lao MN", Font.PLAIN, 20));
		description_label_Teacher.setBounds(6, 49, 439, 68);
		layer_Teacher_Menu.add(description_label_Teacher);
		
		JLabel welcome_label_Teacher = new JLabel("Teacher's Menu");
		welcome_label_Teacher.setForeground(Color.WHITE);
		welcome_label_Teacher.setFont(new Font("Lao MN", Font.PLAIN, 23));
		welcome_label_Teacher.setBounds(127, 6, 189, 68);
		layer_Teacher_Menu.add(welcome_label_Teacher);
		
		
		createTeacher_button.setBounds(41, 105, 153, 46);
		layer_Teacher_Menu.add(createTeacher_button);
		createTeacher_button.addActionListener(this);
		
		updateTeacher_button.setBounds(216, 105, 153, 46);
		layer_Teacher_Menu.add(updateTeacher_button);
		updateTeacher_button.addActionListener(this);
		
		deleteTeacher_button.setBounds(216, 163, 153, 46);
		layer_Teacher_Menu.add(deleteTeacher_button);
		deleteTeacher_button.addActionListener(this);
		
		
		retreiveTeacher_button.setBounds(41, 163, 153, 46);
		layer_Teacher_Menu.add(retreiveTeacher_button);
		retreiveTeacher_button.addActionListener(this);
		
		
		mainMenu_button.setBounds(152, 222, 117, 29);
		layer_Teacher_Menu.add(mainMenu_button);
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
		if(button==createTeacher_button) {
			Teacher_Frame_Create create_teacher = new Teacher_Frame_Create();
			create_teacher.setVisible(true);
			this.setVisible(false);
			this.dispose();
			
		}else if(button==updateTeacher_button) {
			Teacher_Frame_Update update_teacher = new Teacher_Frame_Update();
			update_teacher.setVisible(true);
			this.setVisible(false);
			this.dispose();
		
			
		}else if(button==retreiveTeacher_button) {
			Teacher_Frame_Retreive retreive_teacher;
			try {
				retreive_teacher = new Teacher_Frame_Retreive();
				retreive_teacher.setVisible(true);
				this.setVisible(false);
				this.dispose();
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}
			
		
			
		}else if(button==deleteTeacher_button) {
			Teacher_Frame_Delete delete_teacher = new Teacher_Frame_Delete();
			delete_teacher.setVisible(true);
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
