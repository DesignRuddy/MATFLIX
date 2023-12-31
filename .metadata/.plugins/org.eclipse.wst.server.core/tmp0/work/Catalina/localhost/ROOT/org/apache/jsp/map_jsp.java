/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.37
 * Generated at: 2023-06-06 04:19:54 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class map_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes = null;
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("    <title>찾아오시는 길 </title>\r\n");
      out.write("    <style>\r\n");
      out.write("    h1{\r\n");
      out.write("    text-align: center;\r\n");
      out.write("    }\r\n");
      out.write("    \r\n");
      out.write("    .address{\r\n");
      out.write("    \ttext-align: center;\r\n");
      out.write("    }\r\n");
      out.write("  \r\n");
      out.write("    </style>\r\n");
      out.write("    \r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\t<h1>찾아오시는 길 </h1>\r\n");
      out.write("\t<div id=\"map\" style=\"width:800px; height:700px; margin: auto;\"></div>\r\n");
      out.write("<br>\r\n");
      out.write("<hr>\r\n");
      out.write("\r\n");
      out.write("\t<div class=\"address\">\r\n");
      out.write("\t <img src=\"/resources/map/img/map.svg\" width=\"30px; heigth:30px;\"> 주소 : 서울특별시 구로구 경인로 557 신한은행 4층 <br>\r\n");
      out.write("\t\t<img src=\"/resources/map/img/subway.svg\"> 지하철  1호선 구로역 3번 출구 나오신 후 왼쪽 대각선 방향 4거리 횡단보도 건너 신한은행 건물 4층 407호\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"//dapi.kakao.com/v2/maps/sdk.js?appkey=24d0f189d048fbac28caa08dcf8b8425\"></script>\r\n");
      out.write("\t<script>\r\n");
      out.write("\tvar mapContainer = document.getElementById('map'), // 지도를 표시할 div \r\n");
      out.write("\t    mapOption = { \r\n");
      out.write("\t        center: new kakao.maps.LatLng(37.5030698, 126.8789856), // 지도의 중심좌표\r\n");
      out.write("\t        level: 4 // 지도의 확대 레벨\r\n");
      out.write("\t    };\r\n");
      out.write("\t\r\n");
      out.write("\tvar map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다\r\n");
      out.write("\t\r\n");
      out.write("\tvar imageSrc = '/resources/map/img/mlogo.png', // 마커이미지의 주소입니다    \r\n");
      out.write("\t    imageSize = new kakao.maps.Size(64, 69), // 마커이미지의 크기입니다\r\n");
      out.write("\t    imageOption = {offset: new kakao.maps.Point(27, 69)}; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.\r\n");
      out.write("\t      \r\n");
      out.write("\t// 마커의 이미지정보를 가지고 있는 마커이미지를 생성합니다\r\n");
      out.write("\tvar markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imageOption),\r\n");
      out.write("\t    markerPosition = new kakao.maps.LatLng(37.5030698, 126.8789856); // 마커가 표시될 위치입니다\r\n");
      out.write("\t\r\n");
      out.write("\t// 마커를 생성합니다\r\n");
      out.write("\tvar marker = new kakao.maps.Marker({\r\n");
      out.write("\t    position: markerPosition, \r\n");
      out.write("\t    image: markerImage // 마커이미지 설정 \r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("\t// 마커가 지도 위에 표시되도록 설정합니다\r\n");
      out.write("\tmarker.setMap(map);  \r\n");
      out.write("\t</script>\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\r\n");
      out.write("\t\r\n");
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
