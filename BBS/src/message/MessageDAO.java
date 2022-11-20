package message;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MessageDAO {
	private Connection conn;
	private ResultSet rs;
	
	public MessageDAO(){ 
		try {
			String dbURL = "jdbc:mysql://localhost:3306/BBS";
			String dbID = "bbs";
			String dbPassword = "1234";
			Class.forName("com.mysql.jdbc.Driver"); // mysql에 접속하게 해주는 라이브러리 매개체
			conn = DriverManager.getConnection(dbURL,dbID,dbPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getDate() {
		String SQL = "select now()";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ""; // 데이터베이스 오류
	}
	
	public int getNext() {
		String SQL = "select messageID from message order by messageID desc";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getInt(1) + 1;
			}
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public int writeMessage(String userID, String senderID, String messageContent) {
		String SQL = "insert into message values(?,?,?,?,?,?);";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);			
			pstmt.setInt(1, getNext());
			pstmt.setString(2, userID);
			pstmt.setString(3, senderID);
			pstmt.setString(4, messageContent);
			pstmt.setString(5, getDate());
			pstmt.setInt(6, 1);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public ArrayList<Message> getList(String userID) {
		String SQL = "select * from message where messageAvailable = 1 and userID=? order by messageDate";
		ArrayList<Message> list = new ArrayList<Message>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userID);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Message message = new Message();
				message.setMessageID(rs.getInt(1));
				message.setUserID(rs.getString(2));
				message.setSenderID(rs.getString(3));
				message.setMessageContent(rs.getString(4));
				message.setMessageDate(rs.getString(5));
				message.setMessageAvailable(rs.getInt(6));
				list.add(message);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public ArrayList<Message> getList(String userID,int pageNumber) {
		String SQL = "select * from message where messageAvailable = 1 and userID=? order by messageDate asc limit ?, ?";
		ArrayList<Message> list = new ArrayList<Message>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userID);
			pstmt.setInt(2, pageNumber*10-10);
			pstmt.setInt(3, pageNumber*10);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Message message = new Message();
				message.setUserID(rs.getString(1));
				message.setUserID(rs.getString(2));
				message.setSenderID(rs.getString(3));
				message.setMessageContent(rs.getString(4));
				message.setMessageDate(rs.getString(5));
				message.setMessageAvailable(rs.getInt(6));
				list.add(message);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
