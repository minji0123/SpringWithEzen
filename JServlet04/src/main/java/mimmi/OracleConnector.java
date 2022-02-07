// JDBC CONNECTION : JDBC 접속
package mimmi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleConnector {
	final static String driver = "oracle.jdbc.driver.OracleDriver";
	final static String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	final static String userid = "MIMMI";
	final static String password = "Rkrk6500**";

	private static Connection _stconn = null;
	
	
	public static Connection getConnection() {
		
		try {
			if (_stconn != null) {
				return _stconn;
			}
			
			System.out.println(">>> Oracle Connection Test with java class");
			Class.forName(driver);
			
			_stconn = DriverManager.getConnection(url, userid, password);
			System.out.println("[getConnection] Connection: success " + (_stconn != null));
			
			boolean dbClosed = _stconn.isClosed();
			System.out.println("[getConnection] isClosed " + dbClosed);
			
			
		}catch(ClassNotFoundException e) {
			System.out.println("[getConnection] ClassNotFoundException " + e.toString());
		}catch(SQLException e) {
			System.out.println("[getConnection] SQLException " + e.toString());
		}catch(Exception e) {
			System.out.println("[getConnection] Exception " + e.toString());
		}
		
		return _stconn;
	}
	
	public static void closeConnection() {
		try {
			if (_stconn != null && _stconn.isClosed() !=true) {
				_stconn.close();
			}

		}catch(SQLException e) {
			System.out.println("[getConnection] SQLException " + e.toString());
		}catch(Exception e) {
			System.out.println("[getConnection] Exception " + e.toString());
		}

	}
	
	
	public static void main(String[] args) {
		try {
			System.out.println(">>> Oracle Connection Test with java class");
			Class.forName(driver);
			
			Connection conn = DriverManager.getConnection(url, userid, password);
			System.out.println("[main] Connection: success " + (conn != null));
			
			boolean dbClosed = conn.isClosed();
			System.out.println("[main] isClosed " + dbClosed);
			
			conn.close();
			System.out.println("[main] close " + conn.isClosed());
			
		}catch(ClassNotFoundException e) {
			System.out.println("[main] ClassNotFoundException " + e.toString());
		}catch(SQLException e) {
			System.out.println("[main] SQLException " + e.toString());
		}catch(Exception e) {
			System.out.println("[main] Exception " + e.toString());
		}
		
	}

}
