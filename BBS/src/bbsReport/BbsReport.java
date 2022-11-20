package bbsReport;

public class BbsReport {
	private int reportID;
	private String reportUserID;
	private String reportedUserID;
	private String reportDate;
	private int reportType;
	private int reportApproval;
	
	public int getReportID() {
		return reportID;
	}
	public void setReportID(int reportID) {
		this.reportID = reportID;
	}
	public String getReportUserID() {
		return reportUserID;
	}
	public void setReportUserID(String reportUserID) {
		this.reportUserID = reportUserID;
	}
	public String getReportedUserID() {
		return reportedUserID;
	}
	public void setReportedUserID(String reportedUserID) {
		this.reportedUserID = reportedUserID;
	}
	public String getReportDate() {
		return reportDate;
	}
	public void setReportDate(String reportDate) {
		this.reportDate = reportDate;
	}
	public int getReportType() {
		return reportType;
	}
	public void setReportType(int reportType) {
		this.reportType = reportType;
	}
	public int getReportApproval() {
		return reportApproval;
	}
	public void setReportApproval(int reportApproval) {
		this.reportApproval = reportApproval;
	}
}
