<%@page import="sun.font.Script"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="bbsReply.BbsReplyDAO" %>
<%@ page import="java.io.PrintWriter" %>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="bbsReply" class="bbsReply.BbsReply" scope="page"/>
<jsp:setProperty name="bbsReply" property="replyContent"/>
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
		int commentID = 0;
		if(request.getParameter("commentID") != null){
			commentID = Integer.parseInt(request.getParameter("commentID"));
		}
		if(commentID == 0){
			script.println("<script>");
			script.println("alert('유효하지 않은 댓글입니다')");
			script.println("history.back()");
			script.println("</script>");
		}
		
		if(userID == null) {
			script.println("<script>");
			script.println("alert('로그인이 되어 있지 않습니다')");
			script.println("location.href = 'login.jsp'");
			script.println("</script>");
		}
		else{
			if(bbsReply.getReplyContent() == null){
				script.println("<script>");
				script.println("alert('아무것도 입력하지 않았습니다.')");
				script.println("history.back()");
				script.println("</script>");
			}
			else{
				BbsReplyDAO replyDAO = new BbsReplyDAO();
				int result = replyDAO.write(commentID, userID, bbsReply.getReplyContent());
				if(result == -1){
					script.println("<script>");
					script.println("alert('글쓰기에 실패하였습니다.')");
					script.println("history.back()");
					script.println("</script>");
				}
				else{
					int bbsID = Integer.parseInt(request.getParameter("bbsID"));
					script.println("<script>");
					script.print("location.href = 'view.jsp?bbsID="+bbsID+"'");
					script.println("</script>");
				}
			}
		}
		script.println("</script>");
	%>
</body>
</html>