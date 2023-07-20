<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>views 폴더 안에 accessError.jsp 소스 코딩</title>
</head>
<body>

	<h1>Access Denied Page 접근 거부 안내 웹 페이지 입니다!</h1>
	
	<!-- Access Denied의 경우 403 에러 메시지가 발생합니다.
	      JSP에서는 HttpServlet Request 안에 SPRING_SECURITY_403_EXCEPTION 이라는
	          이름으로 Access DeniedException 객체가 전달됩니다. 그래서,
	      403 에러 발생 시 웹 브라우저에서는 '/sample/admin' URI를 member/member 정보로
	      로그인한 사용자가 접근하는 경우, 이전과 달리 403 에러 메시지 대신에 
	      accessError.jsp의 내용이 보이게 됩니다! -->
	<h2><c:out value="${SPRING_SECURITY_403_EXCEPTION.getMessage()}" /></h2>
	<h2><c:out value="${msg}" /></h2>

</body>
</html>