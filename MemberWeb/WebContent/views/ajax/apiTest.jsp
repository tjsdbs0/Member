<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
 <script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=0ej5x4qako&submodules=geocoder"></script>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<body>
   <h1>1. 다음(카카오) 주소 찾기 API</h1>
   <ul>
      <li>
         <input type="text" id="postCode"
         style = "width:200px; display:inline-block;" placeholder="우편번호" readonly>
         <button id="addrSearchBtn" onclick="addSearch();">주소검색</button>
          
      </li>
      <li>
         <input type="text" id="roadAddr"
         style = "width:400px; display:inline-block;" placeholder="도로명주소" >
         <input type="text" id="jibunAddr"
         style = "width:400px; display:inline-block;" placeholder="지번주소" >
         
          
      </li>
      <li>
         <input type="text" id="detailAddr"
         style = "width:400px; display:inline-block;" placeholder="상세주소" >
      
         
          
      </li>
   </ul>
   <br>
   <h1>2. 네이버 지도</h1>
   <div id="map" style="width:100%;height:400px;"></div>
   <!-- 0ej5x4qako -->
   <script>
      function addSearch() {
          new daum.Postcode({
                  oncomplete: function(data) {
                     console.log(data);
                     $("#postCode").val(data.zonecode);
                     $("#roadAddr").val(data.roadAddress); 
                     $("#jibunAddr").val(data.jibunAddress);
                     
                      // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
                      // 예제를 참고하여 다양한 활용법을 확인해 보세요.
                  }
              }).open();
      }
      $(function() {
         var map = new naver.maps.Map('map', {
        	 center: new naver.maps.LatLng(37.533807,126.896772),
            zoom: 17,
            zoomControl : true,
            zoomControlOptions : {
               position : naver.maps.Position.TOP_RIGHT,
               style : naver.maps.ZoomControlStyle.SMALL
            }
         });
         var marker = new naver.maps.Marker({
            position : new naver.maps.LatLng(37.533807, 127.105399),
            map:map
         });
           //최초 중심지 주소
         var contentString = [
            "<div class ='iw_inner'><h3>kh정보교육원</h3>"
            + "<p>서울시 영등포구 선유로2동 57 이레빌딩 19F</p></div>"
         ].join("");
         var infoWindow = new naver.maps.InfoWindow();
         naver.maps.Event.addListener(marker, "click",function(e){
            console.log(infoWindow.getMap());
              //윈도우 창을 여는 부분
            if(infoWindow.getMap()) {
            	//윈도우 창을 닫는부분
               infoWindow.close();
            }else {
               infoWindow = new naver.maps.InfoWindow({
                  content : contentString
               });
               infoWindow.open(map,marker);
            }
         });
         naver.maps.Event.addListener(map,"click",function(e){
        	marker.setPosition(e.coord);
        	if(infoWindow != null){
        		if(infoWindow.getMap()){
        			infoWindow.close();
        		};
        	}
        	naver.maps.Service.reverseGeocode({
        		location : new naver.maps.LatLng(e.coord.lat(),e.coord.lng())
        	},
        	function(status,response){
        		if(status !== naver.maps.Service.Status.OK){
        			return alert("아무리 찾아도 없어..");
        		}
        		var result = response.result;
        		items = result.items;
        		address = items[2].address;
        		contentString = ["<div class='iw_inner'>" + "<p>" + address + "</p></div>"].join("");
        	
        	});
         });         
      });
   </script>

</body>
</html>