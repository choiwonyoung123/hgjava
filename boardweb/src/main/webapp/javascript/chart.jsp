<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
  <head>
  	<!-- 차트 라이브러리 -->
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      
      //[['sido', 'count per sido'],['서울특별시', '20'], []] 형태
      let dataAry = [['Sido', 'Count Per Sido']];
           
      //json데이터 가져오기
      fetch('../getSidoInfo.do') //해당 url에 get 형식의 요청 전송 >> 성공하면 응답 반환(resolve)
      .then(resolve => resolve.json()) //응답받은 본문을 json 형식을 javascript 형식으로 파싱(변환)
      .then(result => {
    	  //console.log(result); //[{sido: '대구광역시', cnt: 18}] 형태
    	  result.forEach(item => {
    		  dataAry.push([item.sido, item.cnt]); //for(let prop in item){ ary.push(item[prop])) }
    	  });
    	  console.log(dataAry);
    	  //차트호출
    	  google.charts.load('current', {'packages':['corechart']});
          google.charts.setOnLoadCallback(drawChart);
      })
      .catch(err => console.log(err));
	  //함수
      function drawChart() {
		//배열형식 데이터
        var data = google.visualization.arrayToDataTable(dataAry);
		
        //  [
        //    ['Sido', 'Count per Sido'],
        //    ['Work',     11],
        //    ['Eat',      2],
        //    ['Commute',  2],
        //    ['Watch TV', 2],
        //    ['Sleep',    7]
        //  ]
		//제목
        var options = {
          title: 'My Daily Activities'
        };
		//차트 위치
        var chart = new google.visualization.PieChart(document.getElementById('piechart'));

        chart.draw(data, options);
      }
    </script>
  </head>
  <body>
    <div id="piechart" style="width: 900px; height: 500px;"></div>
  </body>
</html>