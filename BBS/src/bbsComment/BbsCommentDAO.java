package bbsComment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BbsCommentDAO {
	private Connection conn;
	private ResultSet rs;
	
	// mysqㅣ 접속
	public BbsCommentDAO(){ 
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
		String SQL = "select commentID from bbs_comment order by commentID desc;";
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
	
	public ArrayList<BbsComment> getList(int bbsID) {
		String SQL = "select * from bbs_comment where bbsID=? and commentAvailable = 1 order by commentID asc";
		ArrayList<BbsComment> list = new ArrayList<BbsComment>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, bbsID);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BbsComment bbsComment = new BbsComment();
				bbsComment.setBbsID(rs.getInt(1));
				bbsComment.setCommentID(rs.getInt(2));
				bbsComment.setUserID(rs.getString(3));
				bbsComment.setCommentDate(rs.getString(4));
				bbsComment.setCommentContent(rs.getString(5));
				bbsComment.setCommentAvailable(rs.getInt(6));
				list.add(bbsComment);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public ArrayList<BbsComment> getCommentList(String userID) {
		String SQL = "select * from bbs_comment where userID=? order by commentID asc";
		ArrayList<BbsComment> list = new ArrayList<BbsComment>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userID);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BbsComment bbsComment = new BbsComment();
				bbsComment.setBbsID(rs.getInt(1));
				bbsComment.setCommentID(rs.getInt(2));
				bbsComment.setUserID(rs.getString(3));
				bbsComment.setCommentDate(rs.getString(4));
				bbsComment.setCommentContent(rs.getString(5));
				bbsComment.setCommentAvailable(rs.getInt(6));
				list.add(bbsComment);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public BbsComment getBbsCommentID(int commentID) {
		String SQL = "select * from bbs_comment where commentID = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, commentID);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BbsComment comment = new BbsComment();
				comment.setBbsID(rs.getInt(1));
				comment.setCommentID(rs.getInt(2));
				comment.setUserID(rs.getString(3));
				comment.setCommentDate(rs.getString(4));
				comment.setCommentContent(rs.getString(5));
				comment.setCommentAvailable(rs.getInt(6));
				return comment;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int write(int bbsID, String userID, String bbsContent) {
		String SQL = "insert into bbs_comment values(?,?,?,?,?,?);";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, bbsID);
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
	
	public int update(String commentContent, int commentID) {
		String SQL = "update bbs_comment set commentContent = ? where commentID = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, commentContent);
			pstmt.setInt(2, commentID);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public int delete(int commentID) {
		String SQL = "update bbs_comment set CommentAvailable = 0 where commentID = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, commentID);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1; // 데이터베이스 오류
	}
}
