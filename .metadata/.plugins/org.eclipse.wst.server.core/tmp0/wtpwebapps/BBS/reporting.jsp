<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width", initial-scale="1">
<link rel="stylesheet" href="css/bootstrap.css">
<title>JSP 신고</title>
	<style type="text/css">
		.report_list li{
			list-style: none;
			border-top: 1px solid silver;
			border-right: 1px solid silver;
			border-left: 1px solid silver;
			margin-right: 40px;
}
		.report_item input{
		border: max(2px, 0.1em);
		width: 2em;
  		height: 2em;
  		cursor:pointer;
}
		.report_item label{
		font-size: 25px;
		font-weight: normal;
		cursor:pointer;
}
	</style>
</head>
<body>
	<%
		String user1name="";
		String user2name="";
		String userID = null;
		if(session.getAttribute("userID") != null){
			userID = (String)session.getAttribute("userID");
		}

		if(request.getParameter("user2name") == null) {
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('유효하지 않은 글입니다')");
			script.println("window.close()");
			script.println("</script>");
		}
		else {
			user1name=request.getParameter("user1name");
			user2name=request.getParameter("user2name");
		}
	%>

	<nav class="navbar navbar-default">
		<div class="navbar-header" style="width: 100%; display: flex;">
			<h1 style="text-align: center; width: 99%;">신고하기</h1>
			<button type="button" value="X" onclick="window.close()" style="background: none; border: none;"><h1>X</h1></button>
		</div>
	</nav>
	<div class="report">
		<form method="post" action="reportAction.jsp?user1name=<%=user1name%>&user2name=<%=user2name%>">
			<div style="padding-bottom: 15px; border-bottom: 1px solid silver;">
				<span style="margin:20px; margin-left: 40px; margin-right:0px; font-size: 25px; font-weight: 600">작성자</span>
				<span style="margin:20px; margin-right:40px; margin-left:0px; font-size: 25px;"> : <%=user2name %></span>
			</div>
			<ul class="report_list">
				<li style="border: none; margin-top: 20px;"><p style="font-size: 25px; font-weight: 600">신고 사유 선택</p></li>
				<li>
					<div class="report_item">
						<input type="radio" id="1" name="report_type" value="1" checked="checked">
						<label for="1">스팸</label>		
					</div>
				</li>
				<li>
					<div class="report_item">
						<input type="radio" id="2" name="report_type" value="2">
						<label for="2">음란물</label>		
					</div>
				</li>
				<li>
					<div class="report_item">
						<input type="radio" id="3" name="report_type" value="3">
						<label for="3">거짓 정보</label>			
					</div>
				</li>
				<li>
					<div class="report_item">
						<input type="radio" id="4" name="report_type" value="4">
						<label for="4">혐오 발언</label>			
					</div>
				</li>
				<li style="border-bottom: 1px solid silver;">
					<div class="report_item">
						<input type="radio" id="5" name="report_type" value="5">
						<label for="5">욕설 및 폭언</label>		
					</div>
				</li>
				<li style="border: none; margin-top: 40px;"><input type="submit" class="btn btn-primary" value="신고하기" style="width: 100%; font-size: 30px;"></li>
			</ul>
			
		</form>
	</div>
	<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="js/bootstrap.js"></script>
</body>
</html>