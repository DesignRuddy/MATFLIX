<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
    
<%@ include file="../includes/header.jsp" %>
    
               <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Board Register</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                      <div class="panel-heading">Board Register</div>                      
                      <div class="panel-body">
                      <form action="/board/register" method="post" role="form">
                      
            <!-- Page714 input type의 hidden 태그는 ${_csrf.parameterName}로 처리합니다.
          이때, EL의 값은 실제 브라우저에서는 '_csrf'라는 이름으로 처리됩니다.
    스프링 시큐리티에서 POST 방식을 이용하는 경우, 기본적으로 CSRF(Cross Site Request Forgery) 토큰
	     이라는 것을 이용하게 됩니다. 별도의 설정이 없다면 스프링 시큐리티가 적용된 사이트의 모든 POST방식에는
	     CSRF 토큰이 사용되는데 '사이트간 위조 방지'를 목적으로 특정한 값의 토큰을 사용하는 방식입니다.
	     CSRF 토큰은 사용자가 임의로 변하는 특정한 토큰값을 서버에서 체크하는 방식입니다. 서버에는 브라우저에
	     데이터를 전송할 때 CSRF 토큰을 같이 전송합니다. 사용자가 POST 방식 등으로 특정한 작업을 할 때는
     브라우저에서 전송된 CSRF 토큰의 값과 서버가 보관하고 있는 토큰의 값을 비교합니다. 만일, CSRF 토큰의 값이
	     다르다면 작업을 처리하지 않는 방식입니다. 서버에서 생성하는 토큰은 일반적으로 난수를 생성해서
	     공격자가 패턴을 찾을 수 없도록 합니다. -->	
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
						
                       <div class="form-group">
                          <label>Title</label>
                          <input class="form-control" name="title">
                       </div>
                       <div class="form-group">
                          <label>Text area</label>
                          <textarea class="form-control" rows="3" name="content"></textarea>
                       </div>
                       <div class="form-group">
                          <label>Writer</label>
                          <!-- Page714 아래에 admin.jsp 파일 sec:authentication 태그 내용 넣어줌 -->
                          <input class="form-control" name="writer" value="<sec:authentication property="principal.username"/>" readonly="readonly">
                       </div>
                       <button type="submit" class="btn btn-default">지금 등록!</button>
                       <button type="reset" class="btn btn-default">입력 취소!</button>
                       </form>
                       </div>
                       <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            
<%@ include file="../includes/footer.jsp" %>