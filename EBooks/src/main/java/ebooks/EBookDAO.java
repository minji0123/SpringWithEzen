/*
 * EBookDAO: Data Access Object
 */
package ebooks;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import minmi.OracleConnector;

public class EBookDAO {

	public boolean isBook(String serial) {
		String sql = "SELECT decode(count(*), 0, 'false', 'true') AS booked FROM ebook WHERE eb_serial=?";
		
		boolean booked = false;
		
		try {
			Connection conn = OracleConnector.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, Integer.parseInt(serial));
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				booked = Boolean.parseBoolean(rs.getString("booked"));
			}
			System.out.println("isBook=" + booked);

			rs.close();
			stmt.close();
//			OracleConnector.closeConnection();
		}
		catch(SQLException e) {
			System.out.println("[isBook] SQLException : " + e.toString());
		}
		
		return booked;
	}

	public boolean isBook(Integer serial) {
		String sql = "SELECT eb_serial FROM ebook WHERE eb_serial=?";
		
		boolean booked = false;
		
		try {
			Connection conn = OracleConnector.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, serial);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				Integer sno = rs.getInt("serial");
				if(sno == serial) {
					booked = true;
				}
			}

			rs.close();
			stmt.close();
//			OracleConnector.closeConnection();
		}
		catch(SQLException e) {
			System.out.println("[isBook] SQLException : " + e.toString());
		}
		
		return booked;
	}

	
	public void updateBook(EBookVO ebook) {
		String sql = "UPDATE ebook SET eb_title=?, eb_author=?, eb_price=?, eb_qty=? WHERE eb_serial=?";
		
		try {
			Connection conn = OracleConnector.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, ebook.getTitle());
			stmt.setString(2, ebook.getAuthor());
			stmt.setInt(3, ebook.getPrice());
			stmt.setInt(4, ebook.getQty());
			stmt.setInt(5, ebook.getSerial());
			
			int success = stmt.executeUpdate();
			if(success > 0) {
				System.out.printf("[updateMember] 수정완료: 수정된 데이터 갯수(%d)\n", success);
			}
			else {
				System.out.printf("[updateMember] 수정실패: 수정된 데이터 갯수(%d)\n", success);
			}
			stmt.close();
//			OracleConnector.closeConnection();
		}
		catch(SQLException e) {
			System.out.println("[updateMember] SQLException : " + e.toString());
		}
	}

	
	public EBookVO getBook(String sno) {
		String sql = "SELECT * FROM ebook WHERE eb_serial=?";
		
		EBookVO ebook = new EBookVO();
		
		try {
			Connection conn = OracleConnector.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, Integer.parseInt(sno));
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				Integer serial = rs.getInt("eb_serial");
				String title   = rs.getString("eb_title");
				String author  = rs.getString("eb_author");
				Integer price = rs.getInt("eb_price");
				Integer qty = rs.getInt("eb_qty");
				
				ebook.setSerial(serial);
				ebook.setTitle(title);
				ebook.setAuthor(author);
				ebook.setPrice(price);
				ebook.setQty(qty);
			}
			
			rs.close();
			stmt.close();
//			OracleConnector.closeConnection();
		}
		catch(SQLException e) {
			System.out.println("[getMember] SQLException : " + e.toString());
		}
		
		return ebook;
	}
	
	public void insertBook(EBookVO ebook) {
		String sql = "INSERT INTO ebook VALUES (EBOOK_seq.nextval, ?, ?, ?, ?)";
		
		try {
			Connection conn = OracleConnector.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, ebook.getTitle());
			stmt.setString(2, ebook.getAuthor());
			stmt.setInt(3, ebook.getPrice());
			stmt.setInt(4, ebook.getQty());
			
			stmt.executeUpdate();
			stmt.close();
//			OracleConnector.closeConnection();
		}
		catch(SQLException e) {
			System.out.println("[insertBook] SQLException : " + e.toString());
		}
	}
	
	public void deleteBook(String sno) {
		String sql = "DELETE FROM ebook WHERE eb_serial = ?";
		
		try {
			Connection conn = OracleConnector.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, Integer.parseInt(sno));
			stmt.executeUpdate();
			stmt.close();
			
//			OracleConnector.closeConnection();
		}
		catch(SQLException e) {
			System.out.println("[deleteBook] SQLException : " + e.toString());
		}
	}

	
	
	public List<EBookVO> getBooks() {
		List<EBookVO> books = new ArrayList<EBookVO>();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT * FROM ebook ORDER BY eb_serial";
			
			conn = OracleConnector.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				Integer serial = rs.getInt("eb_serial");
				String title   = rs.getString("eb_title");
				String author  = rs.getString("eb_author");
				Integer price = rs.getInt("eb_price");
				Integer qty = rs.getInt("eb_qty");
				
				EBookVO ebook = new EBookVO(serial, title, author, price, qty);
				books.add(ebook);
			}
		}
		catch(SQLException e) {
			System.out.println("[getBooks] SQLException : " + e.toString());
		}
		finally {
			try {
				if(rs != null) {
					rs.close();
				}
				
				if(stmt != null) {
					stmt.close();
				}
			}
			catch(Exception e) {
				System.out.println("[getMembers] finally SQLException : " + e.toString());
			}
			
//			OracleConnector.closeConnection();
		}
		
		return books;
	}
}
