package graphic_user_interface;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;


public class Course_Frame_Menu extends JFrame implements ActionListener{

	

	public static void main(String[] args) {
		Course_Frame_Menu frame = new Course_Frame_Menu();
					frame.setVisible(true);
	}
	private JPanel layer_Course_Menu;
	JLabel welcome_label_Course = new JLabel("Course's Menu");
	JLabel description_label_Course = new JLabel("Please choose onde of the following options:");
	JButton createCourse_button = new JButton("Create Course");
	JButton updateCourse_button = new JButton("Update Course");
	JButton deleteCourse_button = new JButton("Delete Course");
	JButton retreiveCourse_button = new JButton("Retreive Course");
	JButton mainMenu_button = new JButton("Main Menu");
	
	public Course_Frame_Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 437, 300);
		layer_Course_Menu = new JPanel();
		layer_Course_Menu.setBackground(Color.DARK_GRAY);
		layer_Course_Menu.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(layer_Course_Menu);
		layer_Course_Menu.setLayout(null);
		
		
		welcome_label_Course.setForeground(Color.WHITE);
		welcome_label_Course.setFont(new Font("Lao MN", Font.PLAIN, 23));
		welcome_label_Course.setBounds(121, 6, 189, 68);
		layer_Course_Menu.add(welcome_label_Course);
		
		
		description_label_Course.setForeground(Color.WHITE);
		description_label_Course.setFont(new Font("Lao MN", Font.PLAIN, 20));
		description_label_Course.setBounds(6, 45, 439, 68);
		layer_Course_Menu.add(description_label_Course);
		
		
		createCourse_button.setBounds(35, 105, 153, 46);
		layer_Course_Menu.add(createCourse_button);
		createCourse_button.addActionListener(this);
		
		
		updateCourse_button.setBounds(210, 105, 153, 46);
		layer_Course_Menu.add(updateCourse_button);
		updateCourse_button.addActionListener(this);
		
		
		deleteCourse_button.setBounds(210, 163, 153, 46);
		layer_Course_Menu.add(deleteCourse_button);
		deleteCourse_button.addActionListener(this);
		
		
		retreiveCourse_button.setBounds(35, 163, 153, 46);
		layer_Course_Menu.add(retreiveCourse_button);
		retreiveCourse_button.addActionListener(this);
		
		
		mainMenu_button.setBounds(146, 222, 117, 29);
		layer_Course_Menu.add(mainMenu_button);
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
		if(button==createCourse_button) {
			Course_Frame_Create create_course = new Course_Frame_Create();
			create_course.setVisible(true);
			this.setVisible(false);
			this.dispose();
			
		}else if(button==updateCourse_button) {
			Course_Frame_Update update_course = new Course_Frame_Update();
			update_course.setVisible(true);
			this.setVisible(false);
			this.dispose();
		
			
		}else if(button==retreiveCourse_button) {
			Course_Frame_Retreive retreive_course;
			try {
				retreive_course = new Course_Frame_Retreive();
				retreive_course.setVisible(true);
				this.setVisible(false);
				this.dispose();
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}
			
		
			
		}else if(button==deleteCourse_button) {
			Course_Frame_Delete delete_course = new Course_Frame_Delete();
			delete_course.setVisible(true);
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
