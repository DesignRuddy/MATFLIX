<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>views 폴더 안에 customLogout.jsp 소스 코딩</title>

    <!-- Bootstrap Core CSS -->
    <link href="/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="/resources/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="/resources/dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="/resources/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

    <div class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">Logout Page</h3>
                    </div>
                    <div class="panel-body">
                        <form role="form" method="post" action="/customLogout">
                            <fieldset>
                                <!-- Change this to a button or input when using this as a form -->
                                <!-- Page708 소스 코딩할 때 아래 1줄 소스는 밑에 Javascript 5줄 소스와 필히! 연계해서 코딩해야 함  -->
                                <a href="index.html" class="btn btn-lg btn-success btn-block">Logout</a>
                                <!-- Page708 소스 코딩할 때 아래 1줄 소스 코딩하면, 밑에 Javascript 5줄 소스 코딩 안해도 됨 -->                                 
                                <!--  
                                <input type="submit" class="btn btn-lg btn-success btn-block" value="Login">
                                 -->            
                            </fieldset>
 <!-- Page737 input type의 hidden 태그는 ${_csrf.parameterName}로 처리합니다.
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
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- jQuery -->
    <script src="/resources/vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="/resources/vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="/resources/vendor/metisMenu/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="/resources/dist/js/sb-admin-2.js"></script>

	<!-- Page709 아래 script 태그 안에 5줄 소스 필히! 코딩 바랍니다 -->	 
	<script type="text/javascript">
	$(".btn-success").on("click", function(e) {
		e.preventDefault();
		$("form").submit();
	});	
	</script>
	
	<!-- Page737 로그아웃 시 자동으로 로그인 페이지로 이동하면서
	     alert(경고창)을 보여주게 코딩해 주는 소스는
	     customLogout.jsp 웹페이지 하단이 아니라,
	     customLogin.jsp 웹페이지 하단에 소스 코딩해
	         주시기 바랍니다. -->
	<!-- 
	<c:if test="${param.logout != null}">
		<script type="text/javascript">
			$(document).ready(function() {
				alert("로그아웃 하였습니다!");
			});
		</script>
	</c:if>
	-->	
	 
</body>

</html>
