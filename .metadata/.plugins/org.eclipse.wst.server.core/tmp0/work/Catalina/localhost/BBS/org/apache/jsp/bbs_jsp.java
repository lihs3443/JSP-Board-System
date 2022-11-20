/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.65
 * Generated at: 2022-11-20 12:27:47 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javafx.scene.control.Alert;
import java.io.PrintWriter;
import bbs.BbsDAO;
import bbs.Bbs;
import user.UserDAO;
import user.User;
import java.util.ArrayList;

public final class bbs_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes.add("javafx.scene.control.Alert");
    _jspx_imports_classes.add("user.User");
    _jspx_imports_classes.add("bbs.BbsDAO");
    _jspx_imports_classes.add("user.UserDAO");
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width\", initial-scale=\"1\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"css/bootstrap.css\">\r\n");
      out.write("<title>JSP 게시판 웹 사이트</title>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("	a, a/hover{\r\n");
      out.write("		color: #000000;\r\n");
      out.write("		text-decoration: none;\r\n");
      out.write("	}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	");

		String userID = null;
		if(session.getAttribute("userID") != null){
			userID = (String)session.getAttribute("userID");
		}
		int pageNumber = 1;
		int pageNum = 1;
		if(request.getParameter("pageNumber") != null){
			pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
		}
		String search ="";
		
		if(request.getParameter("search") != null){
			search = request.getParameter("search");
		}
	
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
      out.write("		<div class=\"row\">\r\n");
      out.write("			<form method=\"get\" action=\"bbs.jsp\">\r\n");
      out.write("				<div style=\"text-align: right; margin-bottom: 10px;\">\r\n");
      out.write("					<input type=\"text\" placeholder=\"검색어 입력\" name=\"search\" maxlength=\"50\">\r\n");
      out.write("					<button type=\"submit\" class=\"btn btn-primary\">검색</button>\r\n");
      out.write("				</div>\r\n");
      out.write("			</form>\r\n");
      out.write("			");

				BbsDAO bbsDAO = new BbsDAO();
				ArrayList<Bbs> list = bbsDAO.getList(pageNumber,search);
				pageNum = bbsDAO.getList(search).size()/10;
				if(bbsDAO.getList(search).size()%10 > 0)
					pageNum += 1;
			
      out.write("\r\n");
      out.write("			<table class=\"table table-striped\" style=\"text-align: center; border: 1px solid #dddddd\">\r\n");
      out.write("				<thead>\r\n");
      out.write("					<tr> \r\n");
      out.write("						<th style=\"background-color: #eeeeee; text-align: center;\">번호</th>\r\n");
      out.write("						<th style=\"background-color: #eeeeee; text-align: center;\">제목</th>\r\n");
      out.write("						<th style=\"background-color: #eeeeee; text-align: center;\">작성자</th>\r\n");
      out.write("						<th style=\"background-color: #eeeeee; text-align: center;\">작성일</th>\r\n");
      out.write("					</tr>\r\n");
      out.write("				</thead>\r\n");
      out.write("				<tbody>\r\n");
      out.write("					");
	
						for(int i = 0; i < list.size();i++){
							User user = new UserDAO().getUser(list.get(i).getUserID());
					
      out.write("\r\n");
      out.write("					<tr>\r\n");
      out.write("						<td> ");
      out.print( 10*(pageNumber-1)+i+1 );
      out.write("</td>\r\n");
      out.write("						<td> <a href=\"view.jsp?bbsID=");
      out.print( list.get(i).getBbsID());
      out.write("\" style=\"color: black;\">");
      out.print( list.get(i).getBbsTitle().replaceAll(" ", "&nbsp;").replaceAll("<", "&lt;").replaceAll(">","&gt;").replaceAll("\n", "<br>") );
      out.write("</a></td>\r\n");
      out.write("						<td> ");
      out.print( user.getUserName() );
      out.write("</td>\r\n");
      out.write("						<td> ");
      out.print( list.get(i).getBbsDate() );
      out.write("</td>\r\n");
      out.write("					</tr>\r\n");
      out.write("					");
	
						}
					
      out.write("\r\n");
      out.write("				</tbody>\r\n");
      out.write("			</table>\r\n");
      out.write("			<div style=\"text-align: center; margin-top: 100px;\">\r\n");
      out.write("				<span>(( </span>\r\n");
      out.write("				");

					for(int i = 1; i <= pageNum; i++){
				
      out.write("\r\n");
      out.write("					<a href=\"bbs.jsp?pageNumber=");
      out.print( i );
      out.write("&search=");
      out.print(search);
      out.write('"');
      out.write('>');
      out.print( i );
      out.write("</a>\r\n");
      out.write("				");

					}
				
      out.write("\r\n");
      out.write("				<span> ))</span>\r\n");
      out.write("				<a href=\"write.jsp\" class=\"btn btn-primary pull-right\" style=\"float: right;\">글쓰기</a>\r\n");
      out.write("			</div>\r\n");
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
