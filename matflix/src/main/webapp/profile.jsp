<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description"
	content="Disfruta de Netflix, películas y series en streaming en tu smart TV, consola, PC, Mac, móvil, tableta y más dispositivos." />
<title>MATFLIX</title>
<link rel="shortcut icon" href="resources/img/mlogo.svg"">
<link href="resources/profile/css/bootstrap.min.css" rel="stylesheet" />
<link rel="canonical"
	href="https://getbootstrap.com/docs/4.5/examples/floating-labels/">
<link href="../assets/dist/css/bootstrap.css" rel="stylesheet">
<link href="floating-labels.css" rel="stylesheet">
<link href="resources/profile/css/style.css" rel="stylesheet" />
</head>

<body>
	<main class="container-fluid">
		<!---->
		<section id="backGround">
			<div class="container-fluid relative">
				<header>
					<a href="/main.jsp"> <img
						src="resources/profile/img/matlogos.svg"
						alt="Responsive image LOGO" class="img-fluid" /></a> <a
						href="/customLogin"><button type="button" class="btn btn-danger">로그인</button></a>
				</header>
			</div>
			<div class="jumbotron jumbotron-fluid relative mt-5">
				<h1>Company Profile</h1>
				<br>
				<p class="lead">Matflix is one of the world's leading
					restaurant OTT services with over 232 million paid profiles in
					over 190 countries enjoying all kind of foods
					Members can have a delicious food as much as they want, anywhere, and can
					change their plans at any time.</p>
				<form method="POST" action="/action_page.php"
					class="form-signin needs-validation" novalidate>
					
				</form>
			</div>
		</section>


	</main>
	<!---footer---------->
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
						<li><a href="/map.jsp">찾아 오시는 길</a></li>
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
	</footer>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script src="resources/profile/js/bootstrap.bundle.min.js"></script>
	<script src="resources/profile/js/main.js"></script>
</body>
</html>