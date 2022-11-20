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
		
		if(userID == null) {
			script.println("<script>");
			script.println("alert('로그인이 되어 있지 않습니다')");
			script.println("location.href = 'login.jsp'");
			script.println("</script>");
		}
		else{
				int reportType = Integer.parseInt(request.getParameter("report_type"));
				String user1name = request.getParameter("user1name");
				String user2name = request.getParameter("user2name");
				BbsReportDAO reportDAO = new BbsReportDAO();
				int result = reportDAO.report(user1name,user2name,reportType);
				if(result == -1){
					script.println("<script>");
					script.println("alert('신고에 실패하였습니다.')");
					script.println("window.close()");
					script.println("</script>");
				}
				else{
					script.println("<script>");
					script.println("alert('신고가 접수되었습니다.')");
					script.println("window.close()");
					script.println("</script>");
				}
		}
	%>
</body>
</html>