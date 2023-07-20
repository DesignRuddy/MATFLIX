console.log("Reply 모듈입니다!");

//JavaScript의 즉시 실행함수는 () 안에 함수를 선언하고
//바깥쪽에서 실행을 처리합니다.
//즉시 실행 함수는 함수의 실행 결과가 바깥쪽에 선언된 변수에 할당됩니다.
//아래 소스 코드에서는 replyService라는 변수에 name이라는 속성에
//"Jangnara"라는 속성값을 가진 객체가 할당됩니다. 
var replyService = (function() {	
	
	// return{name:"Jangnara"};
	
	// 외부에서 replyService.add(객체, 콜백, 에러)를 전달하는 형태로 호출 처리할 수 있습니다.
	// reply.js 내에 add 함수는 Ajax를 이용해서 POST 방식으로 호출하는 코드를 작성합니다.
	// 이때, 파라미터로 callback과 error를 함수로 받게 합니다.
	// 만일, Ajax 호출이 성공하고, callback 값으로 적절한 함수가 존재한다면
	// 해당 함수를 호출해서 결과를 반영하는 방식입니다.
	// JavaScript에서는 함수의 파라미터(매개변수) 개수를 일치시킬 필요가 없기 때문에
	// callback이나 error와 같은 파라미터는 필요에 따라서 작성할 수 있습니다.
	function add(reply, callback) {
		console.log("reply 댓글 테스트입니다!");

		// XMLHttpRequest (XHR) 객체는 서버와 상호작용하기 위한 객체로
		// 페이지의 새로고침 없이도 URL로부터 데이터를 받아올 수 있습니다.
		$.ajax({
			type : 'post',
			url : '/replies/new',
			data : JSON.stringify(reply),
			// 데이터 전송 타입은 "application/json; charset=utf-8" 방식으로 전송합니다.
			contentType : "application/json; charset=utf-8",
			success : function(result, status, xhr) {
				if(callback){
					callback(result);
				}
			},
			error : function(xhr, status, er) {
				if(error){
					error(er);
				}
			}
		});	
	}		
	
	// http://localhost/replies/pages/{bno}/{페이지번호}
	// Page406 : jQuery의 getJSON() 사용해서, 댓글의 목록 처리 확인
	// getList() 메서드는 param이라는 객체를 통해서 필요한 파라미터를 전달 받아서
	// JSON 목록을 호출합니다. JSON 형태가 필요하므로 URL 호출 시 확장자를
	// '.json'으로 요구합니다. 이제 get.jsp에서 해당 게시물의 모든 댓글을 가져오는지 확인하는
	// get.jsp 소스 수정 코드를 진행해 줍니다.
	function getList(param, callback, error) {
		var bno = param.bno;
		var page = param.page || 1;
		
		$.getJSON("/replies/pages/" + bno + "/" + page + ".json",
				function(data) {
					if(callback){
						// callback(data); // 기존에 댓글 목록만 가져오는 경우
						
						// Page437 아래 댓글 숫자와 목록을 가져오는 경우 1줄 소스 추가 
						callback(data.replyCnt, data.list);						
					}
				}).fail(function(xhr, status, err) {
					if(error){
						error();
					}
				});		
		}	
	
	// Page 408 댓글 삭제는 DELETE 방식을 통해서 해당 URL을 호출해서 처리해 줍니다.
	// 댓글 삭제를 처리하는 remove() 메서드를 정의해 줍니다.
	// Page731 아래 1줄 소스 수정 코딩 : 파라미터(매개변수)로 replyer를 추가해 줌.
	function remove(rno, replyer, callback, error) {
		$.ajax({
			// remove() 메서드는 DELETE 방식으로 데이터를 전달하므로,
			// $.ajax()를 이용해서 구체적으로 type 속성으로 'delete'를 지정합니다.
			// 이제, get.jsp 에서 실제 데이터베이스 댓글 번호를 이용해서 정상적으로
			// 댓글이 삭제되는지를 소스 코딩 확인해 봅니다.
			type : 'delete',
			url : '/replies/delete/' + rno,
			
			// Page731 아래 1줄 소스 추가 코딩 : 기존 remove() 메서드에 replyer를 추가적으로
			// 파라미터로 지정하고, 데이터 전송 시 JSON 타입으로 전송하도록 변경 코딩합니다.
			data : JSON.stringify({rno:rno, replyer:replyer}),

			// Page731 아래 1줄 소스 추가 코딩
			contentType: "application/json; charset=utf-8",
			success : function(deleteResult, status, xhr) {
				if(callback){
					callback(deleteResult);
				}
			},
			error : function(xhr, status, er) {
				if(error){
					error(er);
				}
			}
		});
	}
	
	// Page 410 : 댓글 수정은 수정하는 내용과 함께 댓글의 번호를 전송합니다.
	// 댓글의 내용은 JSON 형태로 전송하기 때문에 댓글 등록과 비슷한 부분이 많습니다.
	// 이제, get.jsp 소스 코딩을 해야합니다. 이때, replyService를 이용하는
	// get.jsp에서는 댓글 번호는 데이터베이스에 존재하는 댓글의 번호를 이용해야 합니다.
	// 댓글은 수정하는 내용이 댓글의 내용 밖에 없지만 JavaScript 객체로 처리하는 방식을
	// 활용합니다.
	function update(reply, callback, error) {
		console.log("RNO : " + reply.rno);
		
		$.ajax({
			type : 'put',
			url : '/replies/modify/' + reply.rno,
			data : JSON.stringify(reply),
				contentType : "application/json; charset=utf-8",
				success : function(result, status, xhr) {
					if(callback){
						callback(result);
					}
				},
				error : function(xhr, status, er) {
					if(error){
						error(er);
					}
				}
		});
	}
	
	// Page 413 댓글 조회 처리 : 특정 번호의 댓글 조회는 GET 방식으로 동작하므로
	//                      reply.js에서 처리해 줍니다.
	// 그리고, get.jsp에서는 댓글의 번호만을 전달 처리 합니다.
	function get(rno, callback, error) {
		$.get("/replies/" + rno + ".json", function(result) {
			if(callback){
				callback(result);
			}
		}).fail(function(xhr, status, err) {
			if(error){
				error();
			}
		});
	}
	
	// Page417~Page418 : 댓글에 대한 시간 처리 소스 코딩 시작
	// XML이나 JSON 형태로 데이터를 받을 때는 순수하게 숫자로 표현되는 시간 값이 나오게 되어
	// 있으므로, 화면에서는 이를 변환해서 사용하는 것이 좋습니다. 날짜 포맷의 경우, 문화권마다
	// 표기 순서 등이 다르기 때문에 화면에서 포맷을 처리하는 방식을 권장합니다.
	// 최근 웹페이지들을 보면 해당일에 해당하는 데이터는 '시/분/초'를 보여주고, 전날에 등록된
	// 데이터들은 '년/월/일' 등을 보여주는 경우가 많습니다. 현재 시간을 기준으로 해서
	// 화면에 내용이 달라지도록 하는 부분을 다음과 같이 displayTime() 메서드로 구현해 봅니다.
	// JSON 형태로 Date 형식의 날짜를 받아올 경우 날짜 처리가 안된 순수하게 숫자로 표현되는 시간 값이 나오게 됩니다. 그래서 아래와 같이 displayTime() 메서드로 변환 처리를 해줍니다.
	// 해당일 시간, 날짜 처리 함수 displayTime() 메서드 정의
	// displayTime() 메서드는 Ajax에서 데이터를 가져와서 HTML을 만들어 주는
	// get.jsp 부분에 'replyService.displayTime(list[i].replyDate)'의
	// 형태로 적용합니다.
	function displayTime(timeValue) {
		var today = new Date();
		// today.getTime() 오늘 지금 시간 - 매개변수 timeValue 시간 차이값을
		// 좌측 gap 변수에 대입해 줍니다.
		var gap = today.getTime() - timeValue;
		
		var dateObj = new Date(timeValue);
		var str = "";
		// 24시간이 지나지 않은 댓글(시간 표시 예시 = 14:20:22)
		if(gap < (1000*60*60*24)){   // 앞서 gap 변수값이 24시간[(ms*m*24)hh = 1000*60*60*24] 보다 작다면(지나지 않았다면)
			var hh = dateObj.getHours();
			var mi = dateObj.getMinutes();
			var ss = dateObj.getSeconds();
			
			return [(hh > 9 ? '' : '0') + hh, ":", (mi > 9 ? '':'0') + mi, ':', (ss > 9 ? '' : '0') + ss ].join('');
			
		// 24시간이 지난 댓글(날짜 표시 예시 = 2022/03/22)
		} else{
			var yy = dateObj.getFullYear();
			// getMonth() is zero-based 이기 때문에 +1을 처리해 줌.
			var mm = dateObj.getMonth() + 1;
			var dd = dateObj.getDate();
			
			return[yy, '/', (mm > 9 ? '' : '0') + mm, '/', (dd > 9 ? '' : '0') + dd ].join('');			
		}
	};	
	
	return {
		add : add,
		getList : getList,
		remove : remove, 
		update : update, 
		get : get,
		displayTime : displayTime
	};	
  })();

