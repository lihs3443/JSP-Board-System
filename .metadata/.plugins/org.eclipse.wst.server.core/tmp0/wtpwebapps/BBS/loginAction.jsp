<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="user.UserDAO" %>
<%@ page import="java.io.PrintWriter" %>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="user" class="user.User" scope="page"/>
<jsp:setProperty name="user" property="userID"/>
<jsp:setProperty name="user" property="userPassword"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 게시판 웹 사이트</title>
</head>
<body>
	<%
		PrintWriter script = response.getWriter();
		script.println("<script>");
	
		String userID = null;
		if(session.getAttribute("userID") != null)
		{
			userID = (String)session.getAttribute("userID");
		}
		if(userID != null)
		{
			script.println("alert('이미 로그인이 되어있습니다')");
			script.println("location.href = 'main.jsp'");
		}
		
		UserDAO userDAO = new UserDAO();
		int result = userDAO.login(user.getUserID(), user.getUserPassword());
		switch(result)
		{
		case 1:
			session.setAttribute("userID", user.getUserID());
			script.println("location.href = 'main.jsp'");
			break;
		case 0:
			script.println("alert('비밀번호가 틀립니다.')");
			script.println("history.back()");
			break;
		case -1:
			script.println("alert('존재하지 않는 아이디입니다.')");
			script.println("history.back()");
			break;
		case -2:
			script.println("alert('데이터베이스 오류가 발생했습니다.')");
			script.println("history.back()");
			break;
		}
		script.println("</script>");
	%>
</body>
</html>