package ifsp;

import java.sql.*;

public class ConnectionFactory {
	
	public Connection getConnection() {
	      try {
	    	  Class.forName("com.mysql.jdbc.Driver");
	          return DriverManager.getConnection(
	  "jdbc:mysql://localhost:3306/fj21", "root", "root");
	      } catch (SQLException | ClassNotFoundException e) {
	          throw new RuntimeException(e);
	      }
	  }

	public static void closeResultSet(ResultSet result) throws Exception {
		if (result != null) {
			try {
				result.close();
			}
			catch(SQLException e) {
				throw new Exception(e.getMessage());
			}
		}
	}
	
	public static void closeStatement(Statement stmt) throws Exception {
		if(stmt != null) {
			try {
				stmt.close();
			}
			catch (SQLException e) {
				throw new Exception(e.getMessage());
			}
		}
	}
}
