package connection;
import java.sql.*;

public class Connection_school_DB {

	private static Connection connection = null;
	
	private static final String URL = "jdbc:oracle:thin:@//localhost:1521/xe";
	private static final String USER = "School_desktop";
	private static final String PASSWORD = "school1234";
	
	public static Connection get_Connection() throws ClassNotFoundException{
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection(URL,USER,PASSWORD);
			return connection;
		}catch (SQLException e){
			
			throw new RuntimeException("Error connection to the database", e);
			
		}
	}
	
	public void closeConnection () throws SQLException{
		if(connection != null) {
			connection.close();
		}
		
	}
}
