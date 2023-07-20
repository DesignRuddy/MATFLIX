<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
</head>
<body>
	<%
	request.setCharacterEncoding("utf-8");
	%>
	<%
	String name= request.getParameter("name");
	System.out.print(name);
	String originAge = request.getParameter("age");
	int age = Integer.parseInt(originAge);
	
	out.println("이름 =" + name + ", <br>");
	out.println("나이 =" + age + "살 <br>");
	%>
</body>
</html>