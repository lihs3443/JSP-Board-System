<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="bbsReport.BbsReport"%>
<%@ page import="bbsReport.BbsReportDAO"%>
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
				<li class="active"><a href="report.jsp">신고관리</a></li>
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
					<tr>
						<th colspan="7" style="background-color:#dddddd; text-align: center; ">신고 목록</th>					
					</tr>
					<tr>
						<th style="background-color: #eeeeee; text-align: center;">신고 번호</th>
						<th style="background-color: #eeeeee; text-align: center;">신고자</th>
						<th style="background-color: #eeeeee; text-align: center;">작성자</th>
						<th style="background-color: #eeeeee; text-align: center;">신고 사유</th>
						<th style="background-color: #eeeeee; text-align: center;">신고 날짜</th>
						<th colspan="2" style="background-color: #eeeeee; text-align: center;">처리여부</th>
					</tr>
				</thead>
				<tbody>
					<%	
						BbsReportDAO bbsReportDAO = new BbsReportDAO();
						ArrayList<BbsReport> list = bbsReportDAO.getList();

						for(int i = 0; i < list.size();i++){
							int Approval=0;
					%>
					<script>
						function showApproval(v,n){
							document.getElementById("report-content-"+n).value = v;
							var ReportID='<%= list.get(i).getReportID() %>';
							var Dispose=document.dispose;
							if(v == "처리")
								Dispose.action="disposeAction.jsp?reportID=1&Approval=1";
							if(v == "미처리")
								Dispose.action="disposeAction.jsp?reportID=1&Approval=2";
					}
					</script>
					<tr class="report_list">
						<td><%= list.get(i).getReportID() %></td>
						<td><%= list.get(i).getReportUserID() %></td>
						<td><%= list.get(i).getReportedUserID() %></td>
						<td><%= bbsReportDAO.getReportType(list.get(i).getReportType()) %></td>
						<td><%= list.get(i).getReportDate()%></td>
						<form name="dispose" method="post" action="disposeAction.jsp?reportID=<%= list.get(i).getReportID() %>">
							<td style="width: 100px; box-sizing: border-box;">
								<span class="dropdown">
									<button class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false" style="width: 100%; text-align: center;"><input type="button" id=report-content-<%= list.get(i).getReportID() %> name="ApprovalText" value="-" style="border: none; background: none;"><div style="display: inline-block; float: right;"><span class="caret"></span></div></button>
									<ul class="dropdown-menu">
										<li><a class="report-content-item" onclick="showApproval(this.innerText,<%= list.get(i).getReportID() %>)">처리</a></li>
										<li><a class="report-content-item" onclick="showApproval(this.innerText,<%= list.get(i).getReportID() %>)">미처리</a></li>
									</ul>
								</span>
							</td>
							<td style="width: 100px; box-sizing: border-box;"><button type="submit" style="width: 100%">확인</button></td>
						</form>
					</tr>
					<%	
						}
					%>
				</tbody>
			</table>
		</div>
	</div>
	<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="js/bootstrap.js"></script>
</body>
</html>