package graphic_user_interface;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;



public class MainMenu extends JFrame implements ActionListener {

	public static void main(String[] args) {

		MainMenu frame = new MainMenu();
		frame.setVisible(true);

	}
	
	private JPanel layer_MainMenu;
	JLabel welcome_label = new JLabel("Welcome");
	JLabel description_label = new JLabel("Pease choose one of the following options:");
	JButton StudentsMenu_button = new JButton("Students Menu");
	JButton TeachersMenu_button = new JButton("Teachers Menu");
	JButton CoursesMenu_button = new JButton("Courses Menu");
	JButton Registration_button = new JButton("Registration Menu");

	public MainMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 420, 353);
		layer_MainMenu = new JPanel();
		layer_MainMenu.setBackground(Color.DARK_GRAY);
		layer_MainMenu.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(layer_MainMenu);
		layer_MainMenu.setLayout(null);
		
		
		
		welcome_label.setHorizontalAlignment(SwingConstants.CENTER);
		welcome_label.setForeground(Color.WHITE);
		welcome_label.setFont(new Font("Lao MN", Font.PLAIN, 26));
		welcome_label.setBounds(113, 6, 174, 59);
		layer_MainMenu.add(welcome_label);
		
		
		description_label.setHorizontalAlignment(SwingConstants.CENTER);
		description_label.setForeground(Color.WHITE);
		description_label.setFont(new Font("Lao MN", Font.PLAIN, 19));
		description_label.setBounds(6, 40, 413, 59);
		layer_MainMenu.add(description_label);
		
		
		StudentsMenu_button.setBounds(113, 96, 174, 44);
		layer_MainMenu.add(StudentsMenu_button);
		StudentsMenu_button.addActionListener(this);
		
		
		TeachersMenu_button.setActionCommand("Teacher's Menu");
		TeachersMenu_button.setBounds(113, 152, 174, 44);
		layer_MainMenu.add(TeachersMenu_button);
		TeachersMenu_button.addActionListener(this);
		
		
		CoursesMenu_button.setBounds(113, 208, 174, 44);
		layer_MainMenu.add(CoursesMenu_button);
		CoursesMenu_button.addActionListener(this);
		
		
		Registration_button.setBounds(113, 264, 174, 44);
		layer_MainMenu.add(Registration_button);
		Registration_button.addActionListener(this);

		setResizable(false);
		centerWindow(this);
		
	}
	
	private void centerWindow(Window w) {
	
	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension d = tk.getScreenSize();
	setLocation(  (d.width-w.getWidth())/2 , (d.height-w.getHeight())/2 );
	
	}
	
	public void actionPerformed(ActionEvent e) {
		Object button = e.getSource();
		if(button==StudentsMenu_button) {
			Student_Frame_Menu menu_student = new Student_Frame_Menu();
			menu_student.setVisible(true);
			this.setVisible(false);
			this.dispose();
			
		}else if(button==TeachersMenu_button) {
			Teacher_Frame_Menu menu_teacher = new Teacher_Frame_Menu();
			menu_teacher.setVisible(true);
			this.setVisible(false);
			this.dispose();
		
			
		}else if(button==CoursesMenu_button) {
			Course_Frame_Menu menu_course = new Course_Frame_Menu();
			menu_course.setVisible(true);
			this.setVisible(false);
			this.dispose();
			
		}else if(button==Registration_button) {
			Register_Frame_Menu menu_register = new Register_Frame_Menu();
			menu_register.setVisible(true);
			this.setVisible(false);
			this.dispose();
		
		
	}
		
	}
}
