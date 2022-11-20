<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="message.MessageDAO"%>
<%@ page import="message.Message"%>
<%@ page import="user.UserDAO"%>
<%@ page import="user.User"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width", initial-scale="1">
<link rel="stylesheet" href="css/bootstrap.css">
<title>JSP 게시판 웹 사이트</title>
<style type="text/css">
	a, a/hover{
		color: #000000;
		text-decoration: none;
	}
</style>
</head>
<body>
	<%
		String userID = null;
		if(session.getAttribute("userID") != null){
			userID = (String)session.getAttribute("userID");
		}
		int pageNumber = 1;
		int pageNum = 0;
		if(request.getParameter("pageNumber") != null){
			pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
		}
	%>

	<nav class="navbar navbar-default"> <!-- 웹사이트 전반적인 구성 -->
		<div class="navbar-header"> <!-- 로고같은 것을 담는 영역 -->
			<!-- 화면이 작아졌을 때 버튼 생성 : 버튼 작대기 3개 -->
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expended="false">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>				
				</button>
				<a class="navbar-brand" href="main.jsp">JSP 게시판 웹 사이트</a>
		</div>
		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1"><!-- 버튼 데이터 타겟으랑 같은 것으로 입력 -->
			<ul class="nav navbar-nav"> <!-- 리스트 -->
				<li><a href="main.jsp">메인</a></li>
				<li><a href="bbs.jsp">게시판</a></li>
			</ul>
			<%
				if(userID == null){
			%>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown">
					<a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">접속하기<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="login.jsp">로그인</a></li>
						<li><a href="join.jsp">회원가입</a></li>
					</ul>
				</li>
			</ul>
			<%	
				}
				else {
			%>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown">
					<a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">회원관리<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="commentList.jsp">내 댓글보기</a>
						<li><a href="message.jsp">쪽지</a>
					<%
					if(userID.equals("admin")){
					%>
						<li><a href="admin.jsp">관리하기</a>
					<%
						}
					%>
						<li><a href="logoutAction.jsp">로그아웃</a></li>
					</ul>
				</li>
			</ul>
			<%	
				}
			%>			
		</div>
	</nav>
	<div class="container">
		<div class="row"> <!-- table-striped: 2가지 색상이 번갈아가면서 변경됨 -->
			<table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
				<thead> <!-- 테이블 제목부분 (속성부분)-->
					<tr> <!-- tr: 행 th: 속성-->
						<th width="25%" style="background-color: #eeeeee; text-align: center;">보낸 사람</th>
						<th colspan="2" style="background-color: #eeeeee; text-align: center;">내용</th>
						<th width="25%" style="background-color: #eeeeee; text-align: center;">날짜</th>
					</tr>
				</thead>
				<tbody>
					<%	
						MessageDAO messageDAO = new MessageDAO();
						ArrayList<Message> list = messageDAO.getList(userID, pageNumber);
						pageNum = messageDAO.getList(userID).size()/10;
						if(messageDAO.getList(userID).size()%10 > 0)
							pageNum += 1;
						for(int i = 0; i < list.size();i++){
							User user = new UserDAO().getUser(list.get(i).getUserID());
					%>
					<tr>
						<td> <a href="messegeView.jsp?messageID=<%= list.get(i).getMessageID()%>" style="color: black;"><%= list.get(i).getSenderID() %></a></td>
						<td colspan="2" style="overflow: hidden; text-overflow:ellipsis; white-space:nowrap;"><%= list.get(i).getMessageContent().replaceAll(" ", "&nbsp;").replaceAll("<", "&lt;").replaceAll(">","&gt;").replaceAll("\n", "<br>") %></td>
						<td> <%= list.get(i).getMessageDate() %></td>
					</tr>
					<%	
						}
					%>
				</tbody>
			</table>
			<div style="text-align: center; margin-top: 100px;">
				<span>(( </span>
				<%
					for(int i = 1; i <= pageNum; i++){
				%>
					<a href="message.jsp?pageNumber=<%= i %>"><%= i %></a>
				<%
					}
				%>
				<span> ))</span>
				<a href="messageWrite.jsp" class="btn btn-primary pull-right" style="float: right;">쪽지보내기</a>
			</div>
		</div>
	</div>
	<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="js/bootstrap.js"></script>
</body>
</html>