/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.65
 * Generated at: 2022-11-20 11:15:15 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import user.UserDAO;
import java.io.PrintWriter;
import bbs.Bbs;
import bbs.BbsDAO;
import user.User;
import user.UserDAO;
import bbsComment.BbsComment;
import bbsComment.BbsCommentDAO;
import bbsReply.BbsReply;
import bbsReply.BbsReplyDAO;
import java.util.ArrayList;

public final class view_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.io.PrintWriter");
    _jspx_imports_classes.add("bbs.Bbs");
    _jspx_imports_classes.add("bbsReply.BbsReplyDAO");
    _jspx_imports_classes.add("user.User");
    _jspx_imports_classes.add("bbs.BbsDAO");
    _jspx_imports_classes.add("bbsComment.BbsCommentDAO");
    _jspx_imports_classes.add("bbsComment.BbsComment");
    _jspx_imports_classes.add("user.UserDAO");
    _jspx_imports_classes.add("bbsReply.BbsReply");
    _jspx_imports_classes.add("java.util.ArrayList");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"css/bootstrap.css\">\r\n");
      out.write("<script src=\"https://kit.fontawesome.com/31b51bb94e.js\"></script>\r\n");
      out.write("<title>JSP 게시판 웹 사이트</title>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("	textarea {\r\n");
      out.write("	resize: none;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	");

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
	
      out.write("\r\n");
      out.write("\r\n");
      out.write("	<nav class=\"navbar navbar-default\"> <!-- 웹사이트 전반적인 구성 -->\r\n");
      out.write("		<div class=\"navbar-header\"> <!-- 로고같은 것을 담는 영역 -->\r\n");
      out.write("			<!-- 화면이 작아졌을 때 버튼 생성 : 버튼 작대기 3개 -->\r\n");
      out.write("			<button type=\"button\" class=\"navbar-toggle collapsed\"\r\n");
      out.write("				data-toggle=\"collapse\" data-target=\"#bs-example-navbar-collapse-1\"\r\n");
      out.write("				aria-expended=\"false\">\r\n");
      out.write("				<span class=\"icon-bar\"></span>\r\n");
      out.write("				<span class=\"icon-bar\"></span>\r\n");
      out.write("				<span class=\"icon-bar\"></span>				\r\n");
      out.write("				</button>\r\n");
      out.write("				<a class=\"navbar-brand\" href=\"main.jsp\">JSP 게시판 웹 사이트</a>\r\n");
      out.write("		</div>\r\n");
      out.write("		<div class=\"collapse navbar-collapse\" id=\"bs-example-navbar-collapse-1\"><!-- 버튼 데이터 타겟으랑 같은 것으로 입력 -->\r\n");
      out.write("			<ul class=\"nav navbar-nav\"> <!-- 리스트 -->\r\n");
      out.write("				<li><a href=\"main.jsp\">메인</a></li>\r\n");
      out.write("				<li class=\"active\"><a href=\"bbs.jsp\">게시판</a></li>\r\n");
      out.write("			</ul>\r\n");
      out.write("			");

				if(userID == null){
			
      out.write("\r\n");
      out.write("			<ul class=\"nav navbar-nav navbar-right\">\r\n");
      out.write("				<li class=\"dropdown\">\r\n");
      out.write("					<a href=\"#\" class=\"dropdown-toggle\"\r\n");
      out.write("						data-toggle=\"dropdown\" role=\"button\" aria-haspopup=\"true\"\r\n");
      out.write("						aria-expanded=\"false\">접속하기<span class=\"caret\"></span></a>\r\n");
      out.write("					<ul class=\"dropdown-menu\">\r\n");
      out.write("						<li><a href=\"login.jsp\">로그인</a></li>\r\n");
      out.write("						<li><a href=\"join.jsp\">회원가입</a></li>\r\n");
      out.write("					</ul>\r\n");
      out.write("				</li>\r\n");
      out.write("			</ul>\r\n");
      out.write("			");
	
				}
				else {
			
      out.write("\r\n");
      out.write("			<ul class=\"nav navbar-nav navbar-right\">\r\n");
      out.write("				<li class=\"dropdown\">\r\n");
      out.write("					<a href=\"#\" class=\"dropdown-toggle\"\r\n");
      out.write("						data-toggle=\"dropdown\" role=\"button\" aria-haspopup=\"true\"\r\n");
      out.write("						aria-expanded=\"false\">회원관리<span class=\"caret\"></span></a>\r\n");
      out.write("					<ul class=\"dropdown-menu\">\r\n");
      out.write("						<li><a href=\"commentList.jsp\">내 댓글보기</a>\r\n");
      out.write("						<li><a href=\"message.jsp\">쪽지</a>\r\n");
      out.write("					");

					if(userID.equals("admin")){
					
      out.write("\r\n");
      out.write("						<li><a href=\"admin.jsp\">관리하기</a>\r\n");
      out.write("					");

					}
					
      out.write("\r\n");
      out.write("						<li><a href=\"logoutAction.jsp\">로그아웃</a></li>\r\n");
      out.write("					</ul>\r\n");
      out.write("				</li>\r\n");
      out.write("			</ul>\r\n");
      out.write("			");
	
				}
			
      out.write("			\r\n");
      out.write("		</div>\r\n");
      out.write("	</nav>\r\n");
      out.write("	<div class=\"container\">\r\n");
      out.write("		<div class=\"row\"> <!-- table-striped: 2가지 색상이 번갈아가면서 변경됨 -->\r\n");
      out.write("				<table class=\"table table-striped\" style=\"text-align: center; border: 1px solid #dddddd\">\r\n");
      out.write("					<thead> <!-- 테이블 제목부분 (속성부분)-->\r\n");
      out.write("						<tr> <!-- tr: 행 th: 속성-->\r\n");
      out.write("							<th colspan=\"3\" style=\"background-color: #eeeeee; text-align: center;\">게시판 글 보기</th>\r\n");
      out.write("						</tr>\r\n");
      out.write("					</thead>\r\n");
      out.write("					<tbody>\r\n");
      out.write("						<tr> \r\n");
      out.write("							<td style=\"width: 20%;\">글 제목</td>\r\n");
      out.write("							<td colspan=\"2\">");
      out.print( bbs.getBbsTitle().replaceAll(" ", "&nbsp;").replaceAll("<", "&lt;").replaceAll(">","&gt;").replaceAll("\n", "<br>") );
      out.write("</td>\r\n");
      out.write("						</tr>\r\n");
      out.write("						<tr> \r\n");
      out.write("							<td>작성자</td>\r\n");
      out.write("							<td colspan=\"2\">");
      out.print( user.getUserName() );
      out.write("</td>\r\n");
      out.write("						</tr>\r\n");
      out.write("						<tr> \r\n");
      out.write("							<td>작성일자</td>\r\n");
      out.write("							<td colspan=\"2\">");
      out.print( bbs.getBbsDate() );
      out.write("</td>\r\n");
      out.write("						</tr>\r\n");
      out.write("						<tr> \r\n");
      out.write("							<td>내용</td>\r\n");
      out.write("							<td colspan=\"2\" style=\"min-height:200px; text-align:left;\"> <!-- 특수문자 처리(스크립트를 이용한 해킹기법을 방어할 수 있음) -->\r\n");
      out.write("							");
      out.print( bbs.getBbsContent().replaceAll(" ", "&nbsp;").replaceAll("<", "&lt;").replaceAll(">","&gt;").replaceAll("\n", "<br>") );
      out.write("</td>\r\n");
      out.write("						</tr>\r\n");
      out.write("					</tbody>\r\n");
      out.write("				</table>\r\n");
      out.write("				<a href=\"bbs.jsp\" class=\"btn btn-primary\">목록</a>\r\n");
      out.write("				");

					if(userID != null && userID.equals(bbs.getUserID())){
				
      out.write("\r\n");
      out.write("\r\n");
      out.write("					<a href=\"update.jsp?bbsID=");
      out.print(bbsID);
      out.write("\" class=\"btn btn-primary\">수정</a>\r\n");
      out.write("					<a onclick=\"return confirm('정말로 삭제하시겠습니까?')\" href=\"deleteAction.jsp?bbsID=");
      out.print(bbsID);
      out.write("\" class=\"btn btn-primary\">삭제</a>\r\n");
      out.write("				");

					}
				
      out.write("\r\n");
      out.write("				<!-- <input type=\"submit\" href=\"write.jsp\" class=\"btn btn-primary pull-right\" value=\"글쓰기\"> -->\r\n");
      out.write("				<table class=\"table\" style=\"text-align:center;border: 1px solid #dddddd; margin-top: 20px; margin-bottom: 0px;\">\r\n");
      out.write("					<thead>\r\n");
      out.write("						<tr>\r\n");
      out.write("							<th colspan=\"2\" style=\"background-color: #eeeeee;\">댓글</th>\r\n");
      out.write("						</tr>\r\n");
      out.write("					</thead>\r\n");
      out.write("					<tbody>\r\n");
      out.write("						<tr>\r\n");
      out.write("							<td style=\"text-align: left;\">\r\n");
      out.write("								");
	
								BbsCommentDAO bbsCommentDAO = new BbsCommentDAO();
								ArrayList<BbsComment> list = bbsCommentDAO.getList(bbsID);
								for(int i = 0; i < list.size();i++){
									User user1name = new UserDAO().getUser(userID);
									User username = new UserDAO().getUser(list.get(i).getUserID());
								
      out.write("\r\n");
      out.write("									<div style=\"border-bottom: 1px solid #dddddd;\">		\r\n");
      out.write("										<div style=\"padding-bottom: 10px; padding-top: 10px;\">						\r\n");
      out.write("											<div style=\"margin-bottom: 10px;\">\r\n");
      out.write("												<div class=\"commentContainer\" style=\"display: flex;\">\r\n");
      out.write("													<div class=\"commentItem\">\r\n");
      out.write("														<span style=\"font-size: 18px\">");
      out.print(username.getUserName());
      out.write("</span>\r\n");
      out.write("														<span style=\"color: #aaaaaa;\">(");
      out.print(list.get(i).getCommentDate());
      out.write(")</span>\r\n");
      out.write("														");

														if(userID != null && userID.equals(list.get(i).getUserID())){
														
      out.write("\r\n");
      out.write("														<a data-toggle=\"collapse\" href=\".comment-collapse-");
      out.print(list.get(i).getCommentID());
      out.write("\" style=\"color: black;\">수정</a>\r\n");
      out.write("														<a onclick=\"return confirm('정말로 삭제하시겠습니까?')\" href=\"deleteAction.jsp?bbsID=");
      out.print(bbsID);
      out.write("&commentID=");
      out.print(list.get(i).getCommentID());
      out.write("\" style=\"color: black;\">삭제</a>\r\n");
      out.write("														");

														}
														
      out.write("\r\n");
      out.write("													</div>\r\n");
      out.write("													<div class=\"commentItem\" style=\"margin-left: auto;\">\r\n");
      out.write("														<a href=\"#\" onclick=\"window.open('http://localhost:8080/BBS/reporting.jsp?user1name=");
      out.print(user1name.getUserName());
      out.write("&user2name=");
      out.print(username.getUserName());
      out.write("','report','width=500,height=500,resizable=no')\" style=\"color: black;\">신고</a>\r\n");
      out.write("													</div>\r\n");
      out.write("												</div>\r\n");
      out.write("												<form method=\"post\" action=\"updateAction.jsp?bbsID=");
      out.print(bbsID);
      out.write("&commentID=");
      out.print(list.get(i).getCommentID());
      out.write("\" id=\"update-content\" aria-expanded=\"false\" class=\"collapse comment-collapse-");
      out.print(list.get(i).getCommentID());
      out.write("\">\r\n");
      out.write("													<div class=\"form-group\">\r\n");
      out.write("														<textarea class=\"form-control\" name=\"commentContent\" maxlength=\"1024\" style=\"height: 80px;\">");
      out.print(list.get(i).getCommentContent().replaceAll(" ", "&nbsp;").replaceAll("<", "&lt;").replaceAll(">","&gt;").replaceAll("\n", "") );
      out.write("</textarea>\r\n");
      out.write("														<input type=\"submit\" class=\"btn btn-primary\" value=\"수정\">											\r\n");
      out.write("													</div>\r\n");
      out.write("												</form>\r\n");
      out.write("											</div>\r\n");
      out.write("											<p class=\"collapse comment-collapse-");
      out.print(list.get(i).getCommentID());
      out.write(" in\">");
      out.print(list.get(i).getCommentContent().replaceAll(" ", "&nbsp;").replaceAll("<", "&lt;").replaceAll(">","&gt;").replaceAll("\n", "<br>") );
      out.write("</p>\r\n");
      out.write("											<div style=\"text-align: right;\">\r\n");
      out.write("												<a data-toggle=\"collapse\" href=\".comment-reply-collapse-");
      out.print(list.get(i).getCommentID());
      out.write("\" style=\"color: black;\">답글</a>\r\n");
      out.write("											</div>\r\n");
      out.write("											<form method=\"post\" action=\"replyAction.jsp?bbsID=");
      out.print(bbsID);
      out.write("&commentID=");
      out.print(list.get(i).getCommentID());
      out.write("\" id=\"reply-content\" aria-expanded=\"false\" class=\"collapse comment-reply-collapse-");
      out.print(list.get(i).getCommentID());
      out.write("\">\r\n");
      out.write("												<div class=\"form-group\">\r\n");
      out.write("													<textarea class=\"form-control\" placeholder=\"답글달기\" name=\"replyContent\" maxlength=\"1024\" style=\"height: 80px;\"></textarea>\r\n");
      out.write("													<input type=\"submit\" class=\"btn btn-primary\" value=\"작성\">											\r\n");
      out.write("												</div>\r\n");
      out.write("											</form>\r\n");
      out.write("										</div>\r\n");
      out.write("									</div>\r\n");
      out.write("									");

									BbsReplyDAO bbsReplyDAO = new BbsReplyDAO();
									ArrayList<BbsReply> replyList = bbsReplyDAO.getList(list.get(i).getCommentID());
									for(int j = 0; j < replyList.size();j++){
										User R_username = new UserDAO().getUser(replyList.get(j).getUserID());
									
      out.write("\r\n");
      out.write("										<div style=\"border-bottom: 1px solid #dddddd; display: flex;\">\r\n");
      out.write("											<p style=\"font-size: 20px; padding-top: 7px;\">┗</p>\r\n");
      out.write("											<div style=\"padding-bottom: 10px; padding-top: 10px; width: 99%\">						\r\n");
      out.write("												<div style=\"margin-bottom: 10px;\">\r\n");
      out.write("													<div class=\"replyContainer\" style=\"display: flex;\">\r\n");
      out.write("														<div class=\"replyItem\">\r\n");
      out.write("															<span style=\"font-size: 18px\">");
      out.print(R_username.getUserName());
      out.write("</span>\r\n");
      out.write("															<span style=\"color: #aaaaaa;\">(");
      out.print(replyList.get(j).getReplyDate());
      out.write(")</span>\r\n");
      out.write("															");

															if(userID != null && userID.equals(replyList.get(j).getUserID())){
															
      out.write("\r\n");
      out.write("															<a data-toggle=\"collapse\" href=\".reply-collapse-");
      out.print(replyList.get(j).getReplyID());
      out.write("\" style=\"color: black;\">수정</a>\r\n");
      out.write("															<a onclick=\"return confirm('정말로 삭제하시겠습니까?')\" href=\"deleteAction.jsp?bbsID=");
      out.print(bbsID);
      out.write("&replyID=");
      out.print(replyList.get(j).getReplyID());
      out.write("\" style=\"color: black;\">삭제</a>\r\n");
      out.write("															");

															}
															
      out.write("\r\n");
      out.write("														</div>\r\n");
      out.write("														<div class=\"replyItem\" style=\"margin-left: auto;\" >\r\n");
      out.write("															<a href=\"#\" onclick=\"window.open('http://localhost:8080/BBS/reporting.jsp?user1name=");
      out.print(user1name.getUserName());
      out.write("&user2name=");
      out.print(R_username.getUserName());
      out.write("','report','width=500,height=500,resizable=no')\" style=\"color: black;\">신고</a>\r\n");
      out.write("														</div>\r\n");
      out.write("													</div>\r\n");
      out.write("													<form method=\"post\" action=\"updateAction.jsp?bbsID=");
      out.print(bbsID);
      out.write("&replyID=");
      out.print(replyList.get(j).getReplyID());
      out.write("\" id=\"update-content\" aria-expanded=\"false\" class=\"collapse reply-collapse-");
      out.print(replyList.get(j).getReplyID());
      out.write("\">\r\n");
      out.write("														<div class=\"form-group\">\r\n");
      out.write("															<textarea class=\"form-control\" name=\"replyContent\" maxlength=\"1024\" style=\"height: 80px;\">");
      out.print(replyList.get(j).getReplyContent().replaceAll(" ", "&nbsp;").replaceAll("<", "&lt;").replaceAll(">","&gt;").replaceAll("\n", "") );
      out.write("</textarea>\r\n");
      out.write("															<input type=\"submit\" class=\"btn btn-primary\" value=\"수정\">									\r\n");
      out.write("														</div>\r\n");
      out.write("													</form>\r\n");
      out.write("												</div>\r\n");
      out.write("												<p class=\"collapse reply-collapse-");
      out.print(replyList.get(j).getReplyID());
      out.write(" in\">");
      out.print(replyList.get(j).getReplyContent().replaceAll(" ", "&nbsp;").replaceAll("<", "&lt;").replaceAll(">","&gt;").replaceAll("\n", "<br>") );
      out.write("</p>\r\n");
      out.write("											</div>\r\n");
      out.write("										</div>\r\n");
      out.write("									");

									}
									
      out.write("\r\n");
      out.write("								");

								}
								
      out.write("\r\n");
      out.write("								<form method=\"post\" action=\"commentAction.jsp?bbsID=");
      out.print(bbsID);
      out.write("\">\r\n");
      out.write("									<table class=\"table\" cellpading=\"0\">\r\n");
      out.write("										<tbody>\r\n");
      out.write("											<tr>\r\n");
      out.write("												<td>\r\n");
      out.write("													<textarea class=\"form-control\" placeholder=\"댓글달기\" name=\"commentContent\" maxlength=\"1024\" style=\"height: 80px;\"></textarea>\r\n");
      out.write("												</td>\r\n");
      out.write("												<td style=\"width: 0%\">\r\n");
      out.write("													<input style=\"height: 80px; background-color: white; color: black;\" type=\"submit\" class=\"btn btn-primary pull-right\" value=\"등록\">\r\n");
      out.write("												</td>\r\n");
      out.write("											</tr>\r\n");
      out.write("										</tbody>\r\n");
      out.write("									</table>\r\n");
      out.write("								</form>\r\n");
      out.write("							</td>\r\n");
      out.write("						</tr>\r\n");
      out.write("					</tbody>		\r\n");
      out.write("				</table>\r\n");
      out.write("		</div>\r\n");
      out.write("	</div>\r\n");
      out.write("	<script src=\"http://code.jquery.com/jquery-3.1.1.min.js\"></script>\r\n");
      out.write("	<script src=\"js/bootstrap.js\"></script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
