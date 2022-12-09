package bbsReport;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BbsReportDAO {
	private Connection conn;
	private ResultSet rs;

	// mysqㅣ 접속
	public BbsReportDAO(){ 
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
		String SQL = "select reportID from bbs_report order by reportID desc;";
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
	
	public ArrayList<BbsReport> getList() {
		String SQL = "select * from bbs_report order by reportID asc";
		ArrayList<BbsReport> list = new ArrayList<BbsReport>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BbsReport bbsReport = new BbsReport();
				bbsReport.setReportID(rs.getInt(1));
				bbsReport.setReportUserID(rs.getString(2));
				bbsReport.setReportedUserID(rs.getString(3));
				bbsReport.setReportDate(rs.getString(4));
				bbsReport.setReportType(rs.getInt(5));
				bbsReport.setReportApproval(rs.getInt(6));
				list.add(bbsReport);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public int report(String reportUserID, String reportedUserID, int reportType) {
		String SQL = "insert into bbs_report values(?,?,?,?,?,?);";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, getNext());
			pstmt.setString(2, reportUserID);
			pstmt.setString(3, reportedUserID);
			pstmt.setString(4, getDate());
			pstmt.setInt(5, reportType);
			pstmt.setInt(6, 0);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1; // 데이터베이스 오류
	}
	
	public String getReportType(int reportType) {
		switch (reportType) {
		case 1:
			return "스팸";
		case 2:
			return "음란물";
		case 3:
			return "거짓 정보";
		case 4:
			return "혐오 발언";
		case 5:
			return "욕설 및 폭언";
		default:
			break;
		}
		return ""; // 오류
	}
	
	public int disposeReport(int reportID, int Approval) {
		String SQL = "update bbs_report set reportApproval=? where reportID=?";
			try {
				PreparedStatement pstmt = conn.prepareStatement(SQL);
				pstmt.setInt(1, Approval);
				pstmt.setInt(2, reportID);
				return pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return -1;
	}
	
	public int checkingBanID(int reportID) {
		String SQL = "select reportedUserID from bbs_report where reportID=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, reportID);
			rs=pstmt.executeQuery();
			String username=rs.getString(1);
			
			SQL = "select count(*) from bbs_report where reportedUserID=?";
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1,username);
			rs=pstmt.executeQuery();
			
			int count=rs.getInt(1);
			if(count>=5) {
				SQL = "delete from user where userName=?";
				pstmt = conn.prepareStatement(SQL);
				pstmt.setString(1, username);
				return pstmt.executeUpdate();
			}
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
}
