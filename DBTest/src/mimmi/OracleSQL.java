package mimmi;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OracleSQL {

	
	public static void main(String[] args) {
		OracleSQL hello = new OracleSQL();
//		hello.insert("5000", "자바다", "010-1111-1111");
//		hello.update("3000", "삼돌이", "010-1111-1111");
		hello.select();
//		hello.delete("5000");
//		hello.select();
	}
	
	
	public void delete(String hid) {
		String sql = String.format("DELETE FROM hello WHERE hid = %s ", hid);
		
		Connection conn = null;
		Statement stmt = null;
		
		System.out.println("HELLO table delete");
		
		try {			
			conn = OracleConnector.getConnection();
			stmt = conn.createStatement();
			int success = stmt.executeUpdate(sql);// 처리 결과 갯수를 리턴
			
			if(success >0 ) { 
				System.out.println("delete: 성공! "+success+ "개 삭제");
			}else {
				System.out.println("delete: 실패! "+success);
			}
		}
		catch(SQLException e) {
			System.out.println("delete : SQLException "+ e.toString());
		}
		
		finally {
			try {
				if(stmt != null) {
					stmt.close();
				}
			}
			catch(Exception e){
				System.out.println("delete: finally Exception " + e.toString());
			}
		}
	}
	

	
	public void update(String hid, String hname, String htel) {
		String sql = String.format("UPDATE hello SET hname = '%s', htel ='%s' WHERE hid = %s ",hname, htel, hid);
		
		Connection conn = null;
		Statement stmt = null;
		
		System.out.println("HELLO table update");
		
		try {			
			conn = OracleConnector.getConnection();
			stmt = conn.createStatement();
			int success = stmt.executeUpdate(sql);// 처리 결과 갯수를 리턴
			
			if(success >0 ) { 
				System.out.println("update: 성공! "+success+ "개 수정");
			}else {
				System.out.println("update: 실패! "+success);
			}
		}
		catch(SQLException e) {
			System.out.println("update : SQLException "+ e.toString());
		}
		
		finally {
			try {
				if(stmt != null) {
					stmt.close();
				}
			}
			catch(Exception e){
				System.out.println("update: finally Exception " + e.toString());
			}
		}
	}
	
	
	
	public void insert(String hid, String hname, String htel) {
		String sql = String.format("INSERT INTO hello VALUES ('%s', '%s', '%s')",hid, hname, htel);
		
		Connection conn = null;
		Statement stmt = null;
		
		System.out.println("HELLO table insert");
		
		try {			
			conn = OracleConnector.getConnection();
			stmt = conn.createStatement();
			int success = stmt.executeUpdate(sql);// 처리 결과 갯수를 리턴
			
			if(success >0 ) { 
				System.out.println("insert: 성공! "+success + "개 생성");
			}else {
				System.out.println("insert: 실패! "+success + "개 생성");
			}
		}
		catch(SQLException e) {
			System.out.println("insert : SQLException "+ e.toString());
		}
		
		finally {
			try {
				if(stmt != null) {
					stmt.close();
				}
			}
			catch(Exception e){
				System.out.println("insert: finally Exception " + e.toString());
			}
		}
	}
	
	
	
	
	public void select() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		System.out.println("HELLO table select");
		try {
			String sql = "SELECT * FROM hello ORDER BY hid";
			
			conn = OracleConnector.getConnection();
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);
			
			System.out.println("[HID]   [HNAME]   [HTEL]");
			System.out.println("-------------------------------");
			
			while (rset.next() ) {
				String hid = rset.getString(1);
				String hname = rset.getString(2);
				String htel = rset.getString(3);
				
//				System.out.println("hid: "+ hid + " hname: "+ hname + " htel: "+ htel);
				System.out.println(hid + "     "+ hname + "     "+ htel);

			}
		}
		catch(SQLException e) {
			System.out.println("select : SQLException "+ e.toString());
		}
		
		finally {
			try {
				if(rset != null) {
					rset.close();
				}
				if(stmt != null) {
					stmt.close();
				}
			}
			catch(Exception e){
				System.out.println("select: finally Exception " + e.toString());
			}
//			OracleConnector.closeConnection();
		}
	}
	
	
	
	
}
