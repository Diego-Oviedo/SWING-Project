package graphic_user_interface;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import DAOimplementation.RegisterDAOImplementation;
import DAOimplementation.StudentDAOImplementation;
import dao_interface.RegisterDAOInterface;
import model.Course;
import model.Register;
import model.Student;
import model.Teacher;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

public class Register_Frame_Retreive extends JFrame implements ActionListener{

	public static void main(String[] args) throws ClassNotFoundException {
		Register_Frame_Retreive frame = new Register_Frame_Retreive();
					frame.setVisible(true);
	}

	RegisterDAOInterface  register_DAO = new RegisterDAOImplementation();
	
	private JPanel layer_Registers_Retreive;
	JLabel welcome_label_Register = new JLabel("Registers");
	JButton deleteRegister_button = new JButton("Delete Register");
	JButton btnCancel = new JButton("Cancel");
	private JTable table;

	public Register_Frame_Retreive()  throws ClassNotFoundException{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 795, 368);
		layer_Registers_Retreive = new JPanel();
		layer_Registers_Retreive.setBackground(Color.DARK_GRAY);
		layer_Registers_Retreive.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(layer_Registers_Retreive);
		layer_Registers_Retreive.setLayout(null);
		
		
		welcome_label_Register.setForeground(Color.WHITE);
		welcome_label_Register.setFont(new Font("Lao MN", Font.PLAIN, 23));
		welcome_label_Register.setBounds(337, 21, 117, 47);
		layer_Registers_Retreive.add(welcome_label_Register);
		
		
		deleteRegister_button.setBounds(634, 304, 139, 29);
		layer_Registers_Retreive.add(deleteRegister_button);
		deleteRegister_button.addActionListener(this);
		
		
		btnCancel.setBounds(18, 304, 117, 29);
		layer_Registers_Retreive.add(btnCancel);
		btnCancel.addActionListener(this);
		
		ArrayList<Register> registers_obtained = register_DAO.readRegister();
		
		String columns[]={"Student Name ","Student ID","Course Name","Teacher Name","Schedule"};   
		ArrayList<String[]> values = new ArrayList<String[]>();		
		
		 for (int i = 0; i < registers_obtained.size() ; i++) {	 
			 
	            values.add(new String[] {registers_obtained.get(i).getStudent().getFirstName() + " " + registers_obtained.get(i).getStudent().getLastName(),
	            						 registers_obtained.get(i).getStudent().getStudentID(),
	            						 registers_obtained.get(i).getCourse().getCourseName(),
	            						 registers_obtained.get(i).getTeacher().getFirstName() + " " + registers_obtained.get(i).getTeacher().getLastName(),
	            						 registers_obtained.get(i).getSchedule()});
	        }
		
		 TableModel tableModel = new DefaultTableModel(values.toArray(new Object[][] {}),columns);
		
		table = new JTable(tableModel);	
		table.setBackground(Color.GRAY);
		table.setBounds(18, 90, 764, 202);
		layer_Registers_Retreive.add(table);

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
		
		if(button==deleteRegister_button) {
			int selectedRow = table.getSelectedRow();
			int selectedColumn = 1;
			String id = (String) table.getValueAt(selectedRow,selectedColumn);
			System.out.print(id);
			register_DAO.deleteRegister(id);	
		
			
		}else if(button==btnCancel) {
			Register_Frame_Menu register_menu = new Register_Frame_Menu();
			register_menu.setVisible(true);
			this.setVisible(false);
			this.dispose(); 
			
		}
		
	}
}


