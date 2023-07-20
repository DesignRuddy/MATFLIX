<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Sign Form Page</title>
<link href='https://fonts.googleapis.com/css?family=Lato:300,400' rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="resources/signup/css/LEE.css">
</head>
<body>
	<form>
		<input id="input-1" type="text" placeholder="email@address.com" required autofocus /> 
		<label for="input-1"> 
			<span class="nav-dot"></span>
			<div class="signup-button-trigger">Sign Up</div>
		</label>
		
		<input id="input-2" type="text" placeholder="이름을 입력해 주세요." required /> 
		<label for="input-2"> 
			<span class="nav-dot"></span>
		</label>
		
		<input id="input-2" type="text" placeholder="ID를 입력해 주세요." required /> 
		<label for="input-2"> 
			<span class="nav-dot"></span>
		</label>
		
		<input id="input-4" type="text" placeholder="비밀번호를 입력해 주세요." required />
		<label for="input-4"> 
			<span class="nav-dot"></span>
		</label> 
		
		<input id="input-5" type="text"placeholder="비밀번호를 한번 더 입력해 주세요." required />
		<label for="input-5"> 
			<span class="nav-dot"></span>
		</label>
		
		<button type="submit">Create Your Account</button>
		<p class="tip">Press Enter</p>
		<div class="signup-button">Sign Up</div>
	</form>

</body>
</html>