<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- Page674 : 아래 2줄 taglib 소스 코딩 추가함 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
    
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>WEB-INF 폴더 안에 views 폴더 안에 all.jsp 소스 코딩</title>
</head>
<body>
	<!-- all or member or admin -->
	<h1>/sample/all URI로 볼 수 있는 웹 페이지입니다!</h1>
	
	<!-- Page674 : 아래 3줄 소스 코딩 추가함
     : 표현식 isAnonymous()는 익명의 사용자의 경우(로그인을 하지 않은 경우도 해당) -->
    <sec:authorize access="isAnonymous()">
    	<a href="/customLogin">로그인</a>
    </sec:authorize> 
    
    <!-- Page674 : 아래 3줄 소스 코딩 추가함
     : 표현식 isAuthenticated()는 인증된 사용자면 true -->
     <sec:authorize access="isAuthenticated()">
     	<a href="/customLogout">로그아웃</a>
     </sec:authorize>	
	
</body>
</html>