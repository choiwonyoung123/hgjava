<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>마커에 인포윈도우 표시하기</title>
</head>
<body>
<div id="map" style="width:100%;height:650px;"></div>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=feb27fbf7625b09f14f611452542df5a"></script>
<script>
//param >> 자바스크립트 내장객체
console.log("${param.lat}");
console.log("${param.lng}");
//자바스크립트로부터 파라미터 받아서 변수 생성, 문자열 안에서는 ${}형태로 사용
var lat = "${param.lat}";
var lng = "${param.lng}";
var centerName = "${param.centerName}";

var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = { 
		//최초 지도의 위치 설정
        center: new kakao.maps.LatLng(lat, lng), // 지도의 중심좌표 >> 파라미터로 변경
        level: 3 // 최초 지도의 확대 레벨
    };

var map = new kakao.maps.Map(mapContainer, mapOption);

// 마커가 표시될 위치입니다 
var markerPosition  = new kakao.maps.LatLng(lat, lng); //파라미터로 변경

// 마커를 생성합니다
var marker = new kakao.maps.Marker({
    position: markerPosition
});

// 마커가 지도 위에 표시되도록 설정합니다
marker.setMap(map);

var iwContent = '<div style="padding:5px;">${param.centerName}<br><a href="https://map.kakao.com/link/map/Hello World!,33.450701,126.570667" style="color:blue" target="_blank">큰지도보기</a> <a href="https://map.kakao.com/link/to/Hello World!,33.450701,126.570667" style="color:blue" target="_blank">길찾기</a></div>', // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
    iwPosition = new kakao.maps.LatLng(lat, lng); //인포윈도우 표시 위치입니다 >> 파라미터로 변경

// 인포윈도우를 생성합니다
var infowindow = new kakao.maps.InfoWindow({
    position : iwPosition, 
    content : iwContent 
});
  
// 마커 위에 인포윈도우를 표시합니다. 두번째 파라미터인 marker를 넣어주지 않으면 지도 위에 표시됩니다
infowindow.open(map, marker); 
</script>
</body>
</html>


