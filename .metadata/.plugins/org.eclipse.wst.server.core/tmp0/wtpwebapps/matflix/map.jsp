<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>찾아오시는 길 </title>
    <style>
    h1{
    text-align: center;
    }
    
    .address{
    	text-align: center;
    }
  
    </style>
    
</head>

<body>
	<h1>찾아오시는 길 </h1>
	<div id="map" style="width:800px; height:700px; margin: auto;"></div>
<br>
<hr>

	<div class="address">
	 <img src="/resources/map/img/map.svg" width="30px; heigth:30px;"> 주소 : 서울특별시 구로구 경인로 557 신한은행 4층 <br>
		<img src="/resources/map/img/subway.svg"> 지하철  1호선 구로역 3번 출구 나오신 후 왼쪽 대각선 방향 4거리 횡단보도 건너 신한은행 건물 4층 407호
	</div>


	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=24d0f189d048fbac28caa08dcf8b8425"></script>
	<script>
	var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
	    mapOption = { 
	        center: new kakao.maps.LatLng(37.5030698, 126.8789856), // 지도의 중심좌표
	        level: 4 // 지도의 확대 레벨
	    };
	
	var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
	
	var imageSrc = '/resources/map/img/mlogo.png', // 마커이미지의 주소입니다    
	    imageSize = new kakao.maps.Size(64, 69), // 마커이미지의 크기입니다
	    imageOption = {offset: new kakao.maps.Point(27, 69)}; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.
	      
	// 마커의 이미지정보를 가지고 있는 마커이미지를 생성합니다
	var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imageOption),
	    markerPosition = new kakao.maps.LatLng(37.5030698, 126.8789856); // 마커가 표시될 위치입니다
	
	// 마커를 생성합니다
	var marker = new kakao.maps.Marker({
	    position: markerPosition, 
	    image: markerImage // 마커이미지 설정 
	});
	
	// 마커가 지도 위에 표시되도록 설정합니다
	marker.setMap(map);  
	</script>
	
	

	
</body>
</html>