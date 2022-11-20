<%@page import="user.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="bbs.Bbs" %>
<%@ page import="bbs.BbsDAO" %>
<%@ page import="user.User" %>
<%@ page import="user.UserDAO" %>
<%@ page import="bbsComment.BbsComment" %>
<%@ page import="bbsComment.BbsCommentDAO" %>
<%@ page import="bbsReply.BbsReply" %>
<%@ page import="bbsReply.BbsReplyDAO" %>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/bootstrap.css">
<script src="https://kit.fontawesome.com/31b51bb94e.js"></script>
<title>JSP 게시판 웹 사이트</title>
<style type="text/css">
	textarea {
	resize: none;
}
</style>
</head>
<body>
	<%
		String userID = null;
		if(session.getAttribute("userID") != null){
			userID = (String)session.getAttribute("userID");
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
		User user = new UserDAO().getUser(userID);
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
				<li class="active"><a href="bbs.jsp">게시판</a></li>
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
							<th colspan="3" style="background-color: #eeeeee; text-align: center;">게시판 글 보기</th>
						</tr>
					</thead>
					<tbody>
						<tr> 
							<td style="width: 20%;">글 제목</td>
							<td colspan="2"><%= bbs.getBbsTitle().replaceAll(" ", "&nbsp;").replaceAll("<", "&lt;").replaceAll(">","&gt;").replaceAll("\n", "<br>") %></td>
						</tr>
						<tr> 
							<td>작성자</td>
							<td colspan="2"><%= user.getUserName() %></td>
						</tr>
						<tr> 
							<td>작성일자</td>
							<td colspan="2"><%= bbs.getBbsDate() %></td>
						</tr>
						<tr> 
							<td>내용</td>
							<td colspan="2" style="min-height:200px; text-align:left;"> <!-- 특수문자 처리(스크립트를 이용한 해킹기법을 방어할 수 있음) -->
							<%= bbs.getBbsContent().replaceAll(" ", "&nbsp;").replaceAll("<", "&lt;").replaceAll(">","&gt;").replaceAll("\n", "<br>") %></td>
						</tr>
					</tbody>
				</table>
				<a href="bbs.jsp" class="btn btn-primary">목록</a>
				<%
					if(userID != null && userID.equals(bbs.getUserID())){
				%>

					<a href="update.jsp?bbsID=<%=bbsID%>" class="btn btn-primary">수정</a>
					<a onclick="return confirm('정말로 삭제하시겠습니까?')" href="deleteAction.jsp?bbsID=<%=bbsID%>" class="btn btn-primary">삭제</a>
				<%
					}
				%>
				<!-- <input type="submit" href="write.jsp" class="btn btn-primary pull-right" value="글쓰기"> -->
				<table class="table" style="text-align:center;border: 1px solid #dddddd; margin-top: 20px; margin-bottom: 0px;">
					<thead>
						<tr>
							<th colspan="2" style="background-color: #eeeeee;">댓글</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td style="text-align: left;">
								<%	
								BbsCommentDAO bbsCommentDAO = new BbsCommentDAO();
								ArrayList<BbsComment> list = bbsCommentDAO.getList(bbsID);
								for(int i = 0; i < list.size();i++){
									User user1name = new UserDAO().getUser(userID);
									User username = new UserDAO().getUser(list.get(i).getUserID());
								%>
									<div style="border-bottom: 1px solid #dddddd;">		
										<div style="padding-bottom: 10px; padding-top: 10px;">						
											<div style="margin-bottom: 10px;">
												<div class="commentContainer" style="display: flex;">
													<div class="commentItem">
														<span style="font-size: 18px"><%=username.getUserName()%></span>
														<span style="color: #aaaaaa;">(<%=list.get(i).getCommentDate()%>)</span>
														<%
														if(userID != null && userID.equals(list.get(i).getUserID())){
														%>
														<a data-toggle="collapse" href=".comment-collapse-<%=list.get(i).getCommentID()%>" style="color: black;">수정</a>
														<a onclick="return confirm('정말로 삭제하시겠습니까?')" href="deleteAction.jsp?bbsID=<%=bbsID%>&commentID=<%=list.get(i).getCommentID()%>" style="color: black;">삭제</a>
														<%
														}
														%>
													</div>
													<div class="commentItem" style="margin-left: auto;">
														<a href="#" onclick="window.open('http://localhost:8080/BBS/reporting.jsp?user1name=<%=user1name.getUserName()%>&user2name=<%=username.getUserName()%>','report','width=500,height=500,resizable=no')" style="color: black;">신고</a>
													</div>
												</div>
												<form method="post" action="updateAction.jsp?bbsID=<%=bbsID%>&commentID=<%=list.get(i).getCommentID()%>" id="update-content" aria-expanded="false" class="collapse comment-collapse-<%=list.get(i).getCommentID()%>">
													<div class="form-group">
														<textarea class="form-control" name="commentContent" maxlength="1024" style="height: 80px;"><%=list.get(i).getCommentContent().replaceAll(" ", "&nbsp;").replaceAll("<", "&lt;").replaceAll(">","&gt;").replaceAll("\n", "") %></textarea>
														<input type="submit" class="btn btn-primary" value="수정">											
													</div>
												</form>
											</div>
											<p class="collapse comment-collapse-<%=list.get(i).getCommentID()%> in"><%=list.get(i).getCommentContent().replaceAll(" ", "&nbsp;").replaceAll("<", "&lt;").replaceAll(">","&gt;").replaceAll("\n", "<br>") %></p>
											<div style="text-align: right;">
												<a data-toggle="collapse" href=".comment-reply-collapse-<%=list.get(i).getCommentID()%>" style="color: black;">답글</a>
											</div>
											<form method="post" action="replyAction.jsp?bbsID=<%=bbsID%>&commentID=<%=list.get(i).getCommentID()%>" id="reply-content" aria-expanded="false" class="collapse comment-reply-collapse-<%=list.get(i).getCommentID()%>">
												<div class="form-group">
													<textarea class="form-control" placeholder="답글달기" name="replyContent" maxlength="1024" style="height: 80px;"></textarea>
													<input type="submit" class="btn btn-primary" value="작성">											
												</div>
											</form>
										</div>
									</div>
									<%
									BbsReplyDAO bbsReplyDAO = new BbsReplyDAO();
									ArrayList<BbsReply> replyList = bbsReplyDAO.getList(list.get(i).getCommentID());
									for(int j = 0; j < replyList.size();j++){
										User R_username = new UserDAO().getUser(replyList.get(j).getUserID());
									%>
										<div style="border-bottom: 1px solid #dddddd; display: flex;">
											<p style="font-size: 20px; padding-top: 7px;">┗</p>
											<div style="padding-bottom: 10px; padding-top: 10px; width: 99%">						
												<div style="margin-bottom: 10px;">
													<div class="replyContainer" style="display: flex;">
														<div class="replyItem">
															<span style="font-size: 18px"><%=R_username.getUserName()%></span>
															<span style="color: #aaaaaa;">(<%=replyList.get(j).getReplyDate()%>)</span>
															<%
															if(userID != null && userID.equals(replyList.get(j).getUserID())){
															%>
															<a data-toggle="collapse" href=".reply-collapse-<%=replyList.get(j).getReplyID()%>" style="color: black;">수정</a>
															<a onclick="return confirm('정말로 삭제하시겠습니까?')" href="deleteAction.jsp?bbsID=<%=bbsID%>&replyID=<%=replyList.get(j).getReplyID()%>" style="color: black;">삭제</a>
															<%
															}
															%>
														</div>
														<div class="replyItem" style="margin-left: auto;" >
															<a href="#" onclick="window.open('http://localhost:8080/BBS/reporting.jsp?user1name=<%=user1name.getUserName()%>&user2name=<%=R_username.getUserName()%>','report','width=500,height=500,resizable=no')" style="color: black;">신고</a>
														</div>
													</div>
													<form method="post" action="updateAction.jsp?bbsID=<%=bbsID%>&replyID=<%=replyList.get(j).getReplyID()%>" id="update-content" aria-expanded="false" class="collapse reply-collapse-<%=replyList.get(j).getReplyID()%>">
														<div class="form-group">
															<textarea class="form-control" name="replyContent" maxlength="1024" style="height: 80px;"><%=replyList.get(j).getReplyContent().replaceAll(" ", "&nbsp;").replaceAll("<", "&lt;").replaceAll(">","&gt;").replaceAll("\n", "") %></textarea>
															<input type="submit" class="btn btn-primary" value="수정">									
														</div>
													</form>
												</div>
												<p class="collapse reply-collapse-<%=replyList.get(j).getReplyID()%> in"><%=replyList.get(j).getReplyContent().replaceAll(" ", "&nbsp;").replaceAll("<", "&lt;").replaceAll(">","&gt;").replaceAll("\n", "<br>") %></p>
											</div>
										</div>
									<%
									}
									%>
								<%
								}
								%>
								<form method="post" action="commentAction.jsp?bbsID=<%=bbsID%>">
									<table class="table" cellpading="0">
										<tbody>
											<tr>
												<td>
													<textarea class="form-control" placeholder="댓글달기" name="commentContent" maxlength="1024" style="height: 80px;"></textarea>
												</td>
												<td style="width: 0%">
													<input style="height: 80px; background-color: white; color: black;" type="submit" class="btn btn-primary pull-right" value="등록">
												</td>
											</tr>
										</tbody>
									</table>
								</form>
							</td>
						</tr>
					</tbody>		
				</table>
		</div>
	</div>
	<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="js/bootstrap.js"></script>
</body>
</html>