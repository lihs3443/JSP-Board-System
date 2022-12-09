<%@page import="sun.font.Script"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="bbsReport.BbsReportDAO" %>
<%@ page import="java.io.PrintWriter" %>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 게시판 웹 사이트</title>
</head>
<body>
	<%
		PrintWriter script = response.getWriter();
		
		String userID = null;
		if(session.getAttribute("userID") != null) {
			userID = (String)session.getAttribute("userID");
		}
		
		if(userID == null || userID == "admin") {
			script.println("<script>");
			script.println("alert('관리자가 아닙니다.')");
			script.println("location.href = 'main.jsp'");
			script.println("</script>");
		}
		else{
				/* 여기 수정 해야함 ApprovalText== null */
				int reportID = Integer.parseInt(request.getParameter("reportID"));
				int approval = 0;
				if(request.getParameter("ApprovalText")=="처리")
				{
					script.println("<script>");
					script.println("alert('처리')");
					script.println("</script>");
					approval = 1;
				}
				if(request.getParameter("ApprovalText")=="미처리")
				{
					script.println("<script>");
					script.println("alert('미처리')");
					script.println("</script>");
					approval = 2;
				}
				BbsReportDAO reportDAO = new BbsReportDAO();
				int result = reportDAO.disposeReport(reportID, approval);
				if(result == -1){
					script.println("<script>");
					script.println("alert('신고처리에 실패하였습니다.')");
					script.println("location.href = 'report.jsp'");
					script.println("</script>");
				}
				else{
					result = reportDAO.checkingBanID(reportID);
						script.println("<script>");
						script.println("alert('처리 성공.')");
						script.println("location.href = 'report.jsp'");
						script.println("</script>");
				}
		}
	%>
</body>
</html>