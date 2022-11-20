<%@page import="sun.font.Script"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="bbs.BbsDAO" %>
<%@ page import="bbs.Bbs" %>
<%@ page import="bbsComment.BbsCommentDAO" %>
<%@ page import="bbsComment.BbsComment" %>
<%@ page import="bbsReply.BbsReplyDAO" %>
<%@ page import="bbsReply.BbsReply" %>
<%@ page import="java.io.PrintWriter" %>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="bbsComment" class="bbsComment.BbsComment" scope="page"/>
<jsp:useBean id="bbsReply" class="bbsReply.BbsReply" scope="page"/>
<jsp:setProperty name="bbsComment" property="commentContent"/>
<jsp:setProperty name="bbsReply" property="replyContent"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 게시판 웹 사이트</title>
</head>
<body>
	<%

		
		String userID = null;
		if(session.getAttribute("userID") != null) {
			userID = (String)session.getAttribute("userID");
		}
		if(userID == null) {
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('로그인이 되어 있지 않습니다')");
			script.println("location.href = 'login.jsp'");
			script.println("</script>");
		}
		int bbsID = 0;
		if(request.getParameter("bbsID") != null){
			bbsID = Integer.parseInt(request.getParameter("bbsID"));
		}
		if(bbsID == 0){
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('유효하지 않은 글입니다')");
			script.println("history.back()");
			script.println("</script>");
		}
		Bbs bbs = new BbsDAO().getBbs(bbsID);
		if(!userID.equals(bbs.getUserID())){
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('권한이 없습니다.')");
			script.println("history.back()");
			script.println("</script>");
		}
		
		int commentID = 0;
		int replyID = 0;
		if(request.getParameter("replyID") != null){
			replyID = Integer.parseInt(request.getParameter("replyID"));
			if(replyID == 0){
				PrintWriter script = response.getWriter();
				script.println("<script>");
				script.println("alert('유효하지 않은 댓글입니다')");
				script.println("history.back()");
				script.println("</script>");
			}
			
			BbsReply reply = new BbsReplyDAO().getBbsReplyID(replyID);
			if(!userID.equals(reply.getUserID())){
				PrintWriter script = response.getWriter();
				script.println("<script>");
				script.println("alert('권한이 없습니다.')");
				script.println("history.back()");
				script.println("</script>");
			}
			else{
				BbsReplyDAO bbsReplyDAO = new BbsReplyDAO();
				int result = bbsReplyDAO.update(bbsReply.getReplyContent(),replyID);
				if(result == -1){
					PrintWriter script = response.getWriter();
					script.println("<script>");
					script.println("alert('댓글 수정에 실패하였습니다.')");
					script.println("history.back()");
					script.println("</script>");
				}
				else{
					PrintWriter script = response.getWriter();
					script.println("<script>");
					script.println("location.href = 'view.jsp?bbsID="+bbsID+"'");
					script.println("</script>");
				}
			}
		}
		else if(request.getParameter("commentID") != null){
			
			commentID = Integer.parseInt(request.getParameter("commentID"));
			if(commentID == 0){
				PrintWriter script = response.getWriter();
				script.println("<script>");
				script.println("alert('유효하지 않은 댓글입니다')");
				script.println("history.back()");
				script.println("</script>");
			}
			
			BbsComment comment = new BbsCommentDAO().getBbsCommentID(commentID);
			if(!userID.equals(comment.getUserID())){
				PrintWriter script = response.getWriter();
				script.println("<script>");
				script.println("alert('권한이 없습니다.')");
				script.println("history.back()");
				script.println("</script>");
			}
			else{
				BbsCommentDAO bbsCommentDAO = new BbsCommentDAO();
				int result = bbsCommentDAO.update(bbsComment.getCommentContent(),commentID);
				if(result == -1){
					PrintWriter script = response.getWriter();
					script.println("<script>");
					script.println("alert('댓글 수정에 실패하였습니다.')");
					script.println("history.back()");
					script.println("</script>");
				}
				else{
					PrintWriter script = response.getWriter();
					script.println("<script>");
					script.println("location.href = 'view.jsp?bbsID="+bbsID+"'");
					script.println("</script>");
				}
			}
		}		
		else{
			if(request.getParameter("bbsTitle") == null || request.getParameter("bbsContent") == null ||
					request.getParameter("bbsTitle").equals(" ") || request.getParameter("bbsContent").equals(" ")){
				PrintWriter script = response.getWriter();
				script.println("<script>");
				script.println("alert('입력이 안 된 사항이 있습니다.')");
				script.println("history.back()");
				script.println("</script>");
			}
			else{
				BbsDAO bbsDAO = new BbsDAO();
				int result = bbsDAO.update(bbsID, request.getParameter("bbsTitle"),request.getParameter("bbsContent"));
				if(result == -1){
					PrintWriter script = response.getWriter();
					script.println("<script>");
					script.println("alert('글수정에 실패하였습니다.')");
					script.println("history.back()");
					script.println("</script>");
				}
				else{
					PrintWriter script = response.getWriter();
					script.println("<script>");
					script.println("location.href = 'bbs.jsp'");
					script.println("</script>");
				}
			}
		}
	%>
</body>
</html>