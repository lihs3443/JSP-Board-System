package bbsReply;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

// 시작 하다가 말음

public class BbsReplyDAO {
	private Connection conn;
	private ResultSet rs;
	
	// mysqㅣ 접속
	public BbsReplyDAO(){ 
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
		String SQL = "select replyID from bbs_reply order by replyID desc;";
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
	
	public int write(int commentID, String userID, String bbsContent) {
		String SQL = "insert into bbs_reply values(?,?,?,?,?,?);";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, commentID);
			pstmt.setInt(2, getNext());
			pstmt.setString(3, userID);
			pstmt.setString(4, getDate());
			pstmt.setString(5, bbsContent);
			pstmt.setInt(6, 1);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1; // 데이터베이스 오류
	}
	
	public ArrayList<BbsReply> getList(int commentID) {
		String SQL = "select * from bbs_reply where commentID=? and replyAvailable = 1 order by replyID asc";
		ArrayList<BbsReply> list = new ArrayList<BbsReply>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, commentID);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BbsReply bbsReply = new BbsReply();
				bbsReply.setCommentID(rs.getInt(1));
				bbsReply.setReplyID(rs.getInt(2));
				bbsReply.setUserID(rs.getString(3));
				bbsReply.setReplyDate(rs.getString(4));
				bbsReply.setReplyContent(rs.getString(5));
				bbsReply.setReplyAvailable(rs.getInt(6));
				list.add(bbsReply);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public BbsReply getBbsReplyID(int ReplyID) {
		String SQL = "select * from bbs_reply where replyID = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, ReplyID);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BbsReply reply = new BbsReply();
				reply.setCommentID(rs.getInt(1));
				reply.setReplyID(rs.getInt(2));
				reply.setUserID(rs.getString(3));
				reply.setReplyDate(rs.getString(4));
				reply.setReplyContent(rs.getString(5));
				reply.setReplyAvailable(rs.getInt(6));
				return reply;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int update(String replyContent, int replyID) {
		String SQL = "update bbs_reply set replyContent = ? where replyID = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, replyContent);
			pstmt.setInt(2, replyID);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public int delete(int replyID) {
		String SQL = "update bbs_reply set replyAvailable = 0 where replyID = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, replyID);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1; // 데이터베이스 오류
	}
}
