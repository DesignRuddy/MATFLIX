<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>views 폴더 안에 customLogout.jsp 소스 코딩</title>
</head>
<body>

	<!-- Page641 로그아웃 역시 로그인과 동일하게 실제 작업은 '/customLogout'으로 처리하고
	     POST 방식으로 이루어 집니다. POST 방식으로 처리되기 때문에 CSRF 토큰 값을 아래와 같이 지정합니다.
	     POST 방식으로 처리되는 로그아웃은 스프링 시큐리티의 내부에서 동작합니다.
	     만일, 로그아웃 시 추가적인 작업을 해야 한다면 logoutSuccessHandler를 정의해서 처리합니다.-->
	     <h1>Logout Page 사용자 정의 로그아웃 웹페이지 입니다!</h1>
	     <form action="/customLogout" method="post">
	     
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
	
		<button>로그아웃</button>     
	     
	     </form>
</body>
</html>