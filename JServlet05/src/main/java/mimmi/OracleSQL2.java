package mimmi;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OracleSQL2 {

// 변수를 ?로 바꿔서 처리하기
	public static void main(String[] args) {
		System.out.println(">>> preparedStatement<<< ");
		OracleSQL2 hello = new OracleSQL2();
//		hello.select();
//		hello.insert("5000", "자바5", "010-1111-1111");
//		hello.select();
//		hello.update("3000", "자바3", "010-1111-1111");
//		hello.select();
//		hello.delete("1");
		hello.select("%1");
	}
	
	
	public void delete(String hid) {
		String sql = String.format("DELETE FROM hello WHERE hid = ?");
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		System.out.println("HELLO table delete");
		System.out.printf("hid %s 번 데이터 삭제\n",hid);
		
		try {			
			conn = OracleConnector.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, hid);
			
			int success = stmt.executeUpdate();// 처리 결과 갯수를 리턴
			
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
		String sql = String.format("UPDATE hello SET hname = ?, htel =? WHERE hid = ? ");
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		System.out.println("HELLO table update");
		
		try {			
			conn = OracleConnector.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, hname);
			stmt.setString(2, htel);
			stmt.setString(3, hid);
			
			int success = stmt.executeUpdate();// 처리 결과 갯수를 리턴
			
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
		String sql = String.format("INSERT INTO hello VALUES (?, ?, ?)");
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		System.out.println("HELLO table insert");
		
		try {			
			conn = OracleConnector.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, hid);
			stmt.setString(2, hname);
			stmt.setString(3, htel);

			
			int success = stmt.executeUpdate();// 처리 결과 갯수를 리턴
			
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
	
	
	
	
	public void select(String query) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;
		
		System.out.println("HELLO table select");
		System.out.println("찾는 값 : "+query);
		try {
			String sql = "SELECT * FROM hello WHERE hname LIKE ? ORDER BY hname";
			
			conn = OracleConnector.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, query);
			
			rset = stmt.executeQuery();
			
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
