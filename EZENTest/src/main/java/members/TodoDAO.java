package members;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mimmi.OracleConnector;

// Data Access Object
public class TodoDAO {

	// select
	public TodoVO getTodo(String id) {
		String sql = "SELECT * FROM todo WHERE tid = ?";
	
	ResultSet rs = null;
	TodoVO todo = new TodoVO();
	
	try {
		Connection conn = OracleConnector.getConnection();
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		stmt.setString(1, id);
		rs = stmt.executeQuery();
		
		
		if(rs.next()) {
			String tid = rs.getString("tid");
			String title = rs.getString("title");
			String content = rs.getString("content");
			Date regdate = rs.getDate("regdate");
			
			todo.setTid(tid);
			todo.setTitle(title);
			todo.setContent(content);
			todo.setRegdate(regdate);
		}
		rs.close();
		stmt.close();
		// OracleConnector.closeConnection();
	
	}
	catch(SQLException e) {
		System.out.println("[getTodo] SQLException : " + e.toString());
		}
		return todo;
	}//getTodo
	
	
	
// new
public void insertTodo(TodoVO todoVO) {
	String sql = "INSERT INTO todo (tid, title, content) VALUES (?, ?, ?)";
	
	try {
		Connection conn = OracleConnector.getConnection();
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		stmt.setString(1, todoVO.getTid());
		stmt.setString(2, todoVO.getTitle());
		stmt.setString(3, todoVO.getContent());
		
		stmt.executeUpdate();

		stmt.close();
		// OracleConnector.closeConnection();

	}
	catch(SQLException e) {
		System.out.println("[insertTodo] SQLException : " + e.toString());
	}
}//insertTodo
	

	
// edit
public void updateTodo(TodoVO todoVO) {
	String sql = "UPDATE todo SET title=?, content=? WHERE tid=?";
	
	try {
		Connection conn = OracleConnector.getConnection();
		PreparedStatement stmt = conn.prepareStatement(sql);
		

		stmt.setString(1, todoVO.getTitle());
		stmt.setString(2, todoVO.getContent());
		stmt.setString(3, todoVO.getTid());
		
		stmt.executeUpdate();
		stmt.close();
		// OracleConnector.closeConnection();

	}
	catch(SQLException e) {
		System.out.println("[updateTodo] SQLException : " + e.toString());
	}
}//updateTodo
	

	
	
// delete
public void deleteTodo(String tid) {
	String sql = "DELETE FROM todo WHERE tid = ?";
	
	try {
		Connection conn = OracleConnector.getConnection();
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		stmt.setString(1, tid);
		stmt.executeUpdate();
		stmt.close();
		
		// OracleConnector.closeConnection();
	}
	catch(SQLException e) {
		System.out.println("[deleteTodo] SQLException : " + e.toString());
	}
}//deleteTodo
	
	
	
	
// selct all
public List<TodoVO> getTodos() {
	List<TodoVO> listTodos = new ArrayList<TodoVO>();
	
	Connection conn = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;

	try {
		String sql = "SELECT * FROM todo ORDER BY tid";
	
	conn = OracleConnector.getConnection();
	stmt = conn.prepareStatement(sql);
	rs = stmt.executeQuery();
	
	while(rs.next()) {
		String tid = rs.getString("tid");
		String title = rs.getString("title");
		String content = rs.getString("content");
		Date regdate = rs.getDate("regdate");
		
		TodoVO todo = new TodoVO();
		todo.setTid(tid);
		todo.setTitle(title);
		todo.setContent(content);
		todo.setRegdate(regdate);
		
		listTodos.add(todo);
	}
}
catch(SQLException e) {	
	System.out.println("[getTodos] SQLException : " + e.toString()); //
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
		System.out.println("[getTodos] finally SQLException : " + e.toString());
	}
	
//			OracleConnector.closeConnection();
	}
	
	return listTodos;
}//getTodos

	
}
