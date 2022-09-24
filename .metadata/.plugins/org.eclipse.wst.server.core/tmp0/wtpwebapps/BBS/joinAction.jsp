<%@page import="sun.font.Script"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="user.UserDAO" %>
<%@ page import="java.io.PrintWriter" %>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="user" class="user.User" scope="page"/>
<jsp:setProperty name="user" property="userID"/>
<jsp:setProperty name="user" property="userPassword"/>
<jsp:setProperty name="user" property="userName"/>
<jsp:setProperty name="user" property="userGender"/>
<jsp:setProperty name="user" property="userEmail"/>
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
			userID = (String)session.getAttribute("UserID");
		}
		if(userID != null)
		{
			script.println("alert('이미 로그인이 되어있습니다')");
			script.println("location.href = 'main.jsp'");
		}
		
		if(user.getUserID() == null || user.getUserPassword() == null || user.getUserName() == null ||
			user.getUserGender() == null || user.getUserEmail() == null)
		{
			script.println("alert('입력이 안 된 사항이 있습니다.')");
			script.println("history.back()");
		}
		else{
			UserDAO userDAO = new UserDAO();
			int result = userDAO.join(user);
			if(result == -1)
			{
				script.println("alert('이미 존재하는 아이디입니다.')");
				script.println("history.back()");
			}
			else
			{
				session.setAttribute("userID", user.getUserID());
				script.println("location.href = 'main.jsp'");
			}
		}
		script.println("</script>");
	%>
</body>
</html>