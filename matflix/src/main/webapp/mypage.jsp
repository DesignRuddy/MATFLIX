<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>MyPage</title>
    <link rel="stylesheet" href="resources/mypage/css/bootstrap.min.css">
    <link rel="stylesheet" href="resources/mypage/css/mystyle.css">
    <script src="resources/mypage/javascript/jquery-2.2.4.min.js"></script>
    <script src="resources/mypage/javascript/bootstrap.min.js"></script>
    <link rel="shortcut icon" href="resources/mypage/images/mlogo.png">
    <link rel="stylesheet" href="resources/mypage/css/mypage.css">
</head>
<body>
    <div id="top"></div>		
	<!-- sticky-top 적용 : https://getbootstrap.com/docs/4.0/utilities/position/ -->
	<div class="mybox sticky-top">
		<!-- 네비게이션 바 navbar-example2 활용 : https://getbootstrap.com/docs/4.0/components/scrollspy/#one -->

		<nav class="navbar navbar-expand-lg navbar-light container">
			<!-- 로고 작성 -->
			<a class="navbar-brand" href="main.jsp"> <img
				src="resources/mypage/images/mlogo.svg" alt="">
				<p></p>
			</a>
			<!-- https://getbootstrap.com/docs/4.0/components/navbar/ -->

			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav mr-auto">
		</nav>    
    </div>

<div class="account">
    <h1>계정</h1><hr>
    <div class="section1">
        멤버십 & 결제 정보 <br>
        <button>멤버십 해지</button>
    </div>
    
    <div class="section2">
        사용자 이메일 <br>
        비밀번호 <br>
        전화번호 <br> <hr>
    </div>

	<div class="section3">
		<a href="#">이메일 주소 변경</a> <br>
		<a href="#">비밀번호 변경 </a> <br>
		<a href="#">휴대폰 번호 변경 </a> <hr>
	</div>

	<div class="section1">
        
    </div>
    
    <div class="section2">
      <br>
	  <br>
	  <br>
	  <hr>
    </div>

	<div class="section3">
		<a href="#">결제 정보 관리</a> <br>
		<a href="#">결제 상세 정보</a> <br>
		<a href="#">결제일 변경</a> <hr>
	</div>

	<div class="section1">
		멤버십 상세 정보<hr> <br> 
  	</div>
  
  <div class="section2">
	구독한 멤버십 <hr>
  </div>

  <div class="section3">
	  <a href="#">멤버십 변경</a> <br> <hr>
  </div>

	<div class="section1">
		보안 & 개인 정보<br> 
  	</div>
  
  <div class="section2">
	이 계정에 대한 접근 권한을 관리하세요
  </div>

  <div class="section3">
	  <a href="#">개인 정보 다운로드</a> <br> 
  </div>

</div>   

<!-- footer start -->
    <footer class="page-footer font-small blue text-muted">
		<div class="container text-left">
			<div class="row justify-content-space-between">
				<div class="col-12 mt-5 mb-2">
					<p class="h5 text-capitalize">질문이 있으신가요? 문의 전화: 하이미디어컴퓨터학원
						구로캠퍼스(02-3667-0008)</p>
				</div>
				<hr class="clearfix w-100 d-md-none pb-3" />
				<div class="col-6 col-sm-4 col-md-3">
					<ul class="list-unstyled articles mb-4">
						<li><a href="#">찾아 오시는 길</a></li>
						<li><a href="#">입사 정보</a></li>

					</ul>
				</div>
				<div class="col-6 col-sm-4 col-md-3">
					<ul class="list-unstyled articles mb-4">
						<li><a href="#">고객센터</a></li>
						<li><a href="#">이용 약관</a></li>

					</ul>
				</div>
				<div class="col-6 col-sm-4 col-md-3">
					<ul class="list-unstyled articles mb-4">
						<li><a href="#">계정</a></li>
						<li><a href="#">개인정보 처리방침</a></li>

					</ul>
				</div>
				<div class="col-6 col-sm-4 col-md-3">
					<ul class="list-unstyled articles mb-4">
						<li><a href="#">투자 정보(IR)</a></li>
						<li><a href="#">법적 고지</a></li>

					</ul>
				</div>

			</div>

			<div class="dropdown">
				<button class="btn language dropdown-toggle text-left" type="button"
					id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false">
					<span class="globe"> &#127770;</span>한국어
				</button>
				<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
					<a class="dropdown-item" href="#">한국어</a> <a class="dropdown-item"
						href="#">English</a>
				</div>
			</div>
			<p class="footer-copyright pt-5 pb-2 font-weight-lighter text-muted">
				맛플릭스 코리아</p>
		</div>
	</footer>

  

</body>
</html>