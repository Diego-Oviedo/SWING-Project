package graphic_user_interface;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import DAOimplementation.*;
import dao_interface.RegisterDAOInterface;
import model.*;


public class Teacher_Frame_Retreive extends JFrame implements ActionListener {

	public static void main(String[] args) throws ClassNotFoundException {

		Teacher_Frame_Retreive frame = new Teacher_Frame_Retreive();
		frame.setVisible(true);
}
	
	RegisterDAOInterface  register_DAO = new RegisterDAOImplementation();
	
	private JPanel layer_Teacher_Retreive;
	private JTextField textField_employeeid;
	private JTable table;
	JLabel retreiveateacher_label = new JLabel("Retreive a Teacher");
	JLabel employeeid_label = new JLabel("Employee ID:");
	JButton search_button = new JButton("Search");
	JButton cancel_button = new JButton("Cancel");
	private final JButton back_button = new JButton("Back");
	

public Teacher_Frame_Retreive() throws ClassNotFoundException {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 730, 371);
	layer_Teacher_Retreive = new JPanel();
	layer_Teacher_Retreive.setBackground(Color.DARK_GRAY);
	layer_Teacher_Retreive.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(layer_Teacher_Retreive);
	layer_Teacher_Retreive.setLayout(null);
	
	
	retreiveateacher_label.setForeground(Color.WHITE);
	retreiveateacher_label.setFont(new Font("Lao MN", Font.PLAIN, 20));
	retreiveateacher_label.setBounds(283, 6, 188, 40);
	layer_Teacher_Retreive.add(retreiveateacher_label);
	
	
	employeeid_label.setForeground(Color.WHITE);
	employeeid_label.setBounds(226, 46, 84, 38);
	layer_Teacher_Retreive.add(employeeid_label);
	
	textField_employeeid = new JTextField();
	textField_employeeid.setColumns(10);
	textField_employeeid.setBounds(309, 52, 112, 26);
	layer_Teacher_Retreive.add(textField_employeeid);
	
	
	search_button.setBounds(424, 52, 117, 29);
	layer_Teacher_Retreive.add(search_button);
	search_button.addActionListener(this);
	
	
	cancel_button.setBounds(607, 314, 117, 29);
	layer_Teacher_Retreive.add(cancel_button);
	
	ArrayList<Teacher> teachers_registered = register_DAO.retreiveTeachers();
	String columns[]={"Employee ID","Teacher Name","Hire date","Email"};   
	ArrayList<String[]> values = new ArrayList<String[]>();		
	
	 for (int i = 0; i < teachers_registered.size() ; i++) {	 
		 
            values.add(new String[] {teachers_registered.get(i).getEmployeeID(),
            						 teachers_registered.get(i).getFirstName() + " " + teachers_registered.get(i).getLastName(),
            						 teachers_registered.get(i).getHireDate(), teachers_registered.get(i).getEmail()});
        }
	
	 TableModel tableModel = new DefaultTableModel(values.toArray(new Object[][] {}),columns);
	table = new JTable(tableModel);	
	table.setBackground(Color.GRAY);
	table.setBounds(14, 83, 710, 217);
	layer_Teacher_Retreive.add(table);
	back_button.setBounds(6, 314, 117, 29);
	
	layer_Teacher_Retreive.add(back_button);
	
	
	cancel_button.addActionListener(this);
	back_button.addActionListener(this);

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
			
		String ID = textField_employeeid.getText();
		
		ArrayList<Register> teachers_registered_by_id = register_DAO.retreiveTeachersRegisteredByID(ID);
		String columns[]={"Employee ID","Teacher Name","Course Name","Course ID","Classroom","Start date","Schedule" };   
		ArrayList<String[]> values = new ArrayList<String[]>();		
		
		 for (int i = 0; i < teachers_registered_by_id.size() ; i++) {	 
			 
		        values.add(new String[] {teachers_registered_by_id.get(i).getTeacher().getEmployeeID(),
		        						 teachers_registered_by_id.get(i).getTeacher().getFirstName() + " " + teachers_registered_by_id.get(i).getTeacher().getLastName(),
		        						 teachers_registered_by_id.get(i).getCourse().getCourseName(),
		        						 teachers_registered_by_id.get(i).getCourse().getCourseID(),
		        						 teachers_registered_by_id.get(i).getCourse().getClassRoom() + "",
		        						 teachers_registered_by_id.get(i).getCourse().getStartDate(),
		        						 teachers_registered_by_id.get(i).getSchedule()});
		    }
		 TableModel tableModel = new DefaultTableModel(values.toArray(new Object[][] {}),columns);
		 table.setModel(tableModel);
			
		
	}else if(button==back_button){
		Teacher_Frame_Retreive retreive_teacher;
		try {
			retreive_teacher = new Teacher_Frame_Retreive();
			retreive_teacher.setVisible(true);
			this.setVisible(false);
			this.dispose();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}

	}else if(button==cancel_button){
		Teacher_Frame_Menu teacher_menu = new Teacher_Frame_Menu();
		teacher_menu.setVisible(true);
		this.setVisible(false);
		this.dispose();	
	}
	
}
}
