<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>views 폴더 안에 customLogin.jsp 소스 코딩</title>
</head>
<body>

	<h1>Custom Login Page 사용자 정의 로그인 페이지!</h1>
	<h2><c:out value="${error}" /></h2>
	<h2><c:out value="${logout}" /></h2>
	
	<!-- Page633 우선 form 태그의 action 속성값을 '/login'으로 지정하며,
     실제로 로그인의 처리 작업은 '/login'을 통해서 이루어집니다.
     이때, 반드시 POST 방식으로 데이터를 전송해야만 합니다.
    input 태그의 name 속성은 기본적으로 username과 password 속성을 이용합니다. -->
	<form action="/login" method="post">
	<div>
		<input type="text" name="username" value="admin">
	</div>
	<div>
		<input type="password" name="password" value="admin">
	</div>
	
	<!-- Page679 Remember Me 로그인 유지 설정 체크 박스 추가 -->
	<div>
		<input type="checkbox" name="remember-me"> Remember Me
	</div>
	
	<div>
		<input type="submit">
		<input type="reset">
	</div>
	<!-- Page633 input type의 hidden 태그는 ${_csrf.parameterName}로 처리합니다.
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

</body>
</html>