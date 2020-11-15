package graphic_user_interface;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

public class Register_Frame_Menu extends JFrame implements ActionListener{

	

	public static void main(String[] args) {
		Register_Frame_Menu frame = new Register_Frame_Menu();
					frame.setVisible(true);
	}
	private JPanel layer_Register_Menu;
	JLabel welcome_label_Register = new JLabel("Register's Menu");
	JLabel description_label_Register = new JLabel("Please choose onde of the following options:");
	JButton createRegister_button = new JButton("Create a Register");
	JButton retreiveRegister_button = new JButton("Retreive Registers");
	JButton mainMenu_button = new JButton("Main Menu");
	
	public Register_Frame_Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 437, 300);
		layer_Register_Menu = new JPanel();
		layer_Register_Menu.setBackground(Color.DARK_GRAY);
		layer_Register_Menu.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(layer_Register_Menu);
		layer_Register_Menu.setLayout(null);
		
		
		welcome_label_Register.setForeground(Color.WHITE);
		welcome_label_Register.setFont(new Font("Lao MN", Font.PLAIN, 23));
		welcome_label_Register.setBounds(122, 0, 189, 68);
		layer_Register_Menu.add(welcome_label_Register);
		
		
		description_label_Register.setForeground(Color.WHITE);
		description_label_Register.setFont(new Font("Lao MN", Font.PLAIN, 20));
		description_label_Register.setBounds(6, 45, 439, 68);
		layer_Register_Menu.add(description_label_Register);
		
		
		createRegister_button.setBounds(35, 105, 153, 46);
		layer_Register_Menu.add(createRegister_button);
		createRegister_button.addActionListener(this);
		
		
		retreiveRegister_button.setBounds(210, 105, 153, 46);
		layer_Register_Menu.add(retreiveRegister_button);
		retreiveRegister_button.addActionListener(this);
		
		
		mainMenu_button.setBounds(150, 222, 117, 29);
		layer_Register_Menu.add(mainMenu_button);
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
		if(button==createRegister_button) {
			try {
			Register_Frame_Create create_register = new Register_Frame_Create();
			create_register.setVisible(true);
			this.setVisible(false);
			this.dispose();
			}catch(Exception ex) {
				
			}
		}else if(button==retreiveRegister_button) {
			Register_Frame_Retreive retreive_register;
			try {
				retreive_register = new Register_Frame_Retreive();
				retreive_register.setVisible(true);
				this.setVisible(false);
				this.dispose();
			} catch (ClassNotFoundException ex) {
				
				ex.printStackTrace();
			}
			
			
		}else if(button==mainMenu_button) {
			MainMenu main_menu = new MainMenu();
			main_menu.setVisible(true);
			this.setVisible(false);
			this.dispose(); 
			
		}
		
	}

}
