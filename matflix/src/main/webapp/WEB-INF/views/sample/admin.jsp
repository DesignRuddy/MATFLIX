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
<title>WEB-INF 폴더 안에 views 폴더 안에 admin.jsp 소스 코딩</title>
</head>
<body>
	<!-- admin 사람들만 접근 가능한 웹 페이지 -->
	<h1>/sample/admin URI로 볼 수 있는 웹 페이지입니다!</h1>
	
	<!-- Page671 : 스프링 시큐리티와 관련된 정보를 출력하거나 사용하려면 JSP 상단에 스프링 시큐리티 관련
      태그 라이브러리의 사용을 선언하고, sec:authentication 태그와
   principal(스프링 시큐리티에서 principal 속성은 표현식으로 "현재 사용자 정보를 의미함") 이라는
      이름의 속성을 사용합니다. 아래에서 <sec:authentication property="principal"/> 태그를 이용했을 때,
      의미하는 것은 UserDetailsService에서 반환된 객체입니다. 즉, CustomUserDetailsService를 이용했다면
   loadUserByUsername() 메서드에서 반환된 CustomUser 객체가 됩니다. 이에, 'principal'이
  CustomUser를 의미하므로 'principal.member'는 CustomUser 객체의 getMemeber()를 호출하게 됩니다 -->

	<p>principal : <sec:authentication property="principal"/>  </p>
	<p>MemberVO : <sec:authentication property="principal.member"/>  </p>
	<p>사용자이름 : <sec:authentication property="principal.member.userName"/>  </p>
	<p>사용자아이디 : <sec:authentication property="principal.username"/>  </p>
	<p>사용자 권한 리스트 : <sec:authentication property="principal.member.authList"/>  </p>
	
	<!-- Page642 로그아웃 테스트를 위하여 sample 폴더 안에 admin.jsp 파일의
     '/sample/admin.jsp' 페이지에 로그아웃으로 이동하는 링크를 추가합니다. -->
     <a href="/customLogout">Logout 로그아웃!</a>		
	
</body>
</html>