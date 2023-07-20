<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>views 폴더 안에 payment.jsp 소스 코딩</title>
<!-- https://portone.gitbook.io/docs/sdk/javascript-sdk-old -->
<!-- jQuery -->
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
<!-- iamport.payment.js -->
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>


<script type="text/javascript">

function fn_buy() {
	var IMP = window.IMP;
	<!-- https://github.com/iamport/iamport-manual/blob/master/인증결제/README.md#pc-mobile -->
	IMP.init('imp08681661'); //portone 대신 자신의 "가맹점 식별코드"를 사용하시면 됩니다
	// IMP.request_pay(param, callback) 결제창 호출
	IMP.request_pay({
		pg: 'html5_inicis',
		pay_method: 'card',
		merchant_uid : 'merchant_' + new Date().getTime(),
		name : '결제테스트',
		amount : 10,
		buyer_email : 'romikiju1@gmail.com',
		buyer_name : '장나라',
		buyer_tel : '010-1234-5678',
		buyer_addr : '서울특별시 강남구 삼성동',
		buyer_postcode : '123-456',
		m_redirect_url : '/paymentDone.do'
	}, function(rsp) {  // callback
		
		if ( rsp.success ) {
			var paymentInfo = {
				imp_uid : rsp.imp_uid,
				merchant_uid : rsp.merchant_uid,
				paid_amount : rsp.paid_amount,
				apply_num : rsp.apply_num,
				paid_at : new Date()
		};
			
		$.ajax({
			url : "/paymentProcess.do",
			method : "post",
			contentType : "application/json",
			data : JSON.stringify(paymentInfo),
			success:function(data, textStatus){
				console.log(paymentInfo);
				location.href = "/paymentDone.do";
			},
			error : function(e) {
				console.log(e);
			}			
		});		
		
		} else {
			alert("결제 실패 : " + rsp.error_msg)
		}
	});	
}

</script>

</head>
<body>

	<button type="button" onclick="fn_buy()">결제하기</button>
	<br><br>
	<a href="goMain.do">[처음으로]</a>

</body>
</html>