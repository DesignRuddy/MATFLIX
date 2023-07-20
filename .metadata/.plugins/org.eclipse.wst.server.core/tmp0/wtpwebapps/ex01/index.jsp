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

	<h2>GET방식으로 데이터 전송</h2>
	<form action="sample/ex01">
	<p> 이름: <input type="text" name="name"> </p>
	<p> 나이: <input type="text" name="age"> </p>
	<input type="submit" value="전송">
	<input type="reset" value="취소">
	</form>

</body>
</html>