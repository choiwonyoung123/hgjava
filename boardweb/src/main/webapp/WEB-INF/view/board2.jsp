<%@page import="co.yedam.board.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link href="//cdn.datatables.net/2.0.2/css/dataTables.dataTables.min.css" rel="stylesheet"/>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="//cdn.datatables.net/2.0.2/js/dataTables.min.js"></script>
<style>
div.reply div{
	margin: auto;
}
div.reply span{
	display: inline-block;
}
div.reply ul{
	list-style-type: none;
	margin-top: 10px;
}
div.reply li{
	padding-top: 1px;
	padding-bottom: 1px;
}

.center{
  display: block;
  text-align: center;
  width: 60%;
  margin: auto;
}
.pagination {
  display: inline-block;
}

.pagination a {
  color: black;
  float: left;
  padding: 8px 16px;
  text-decoration: none;
}
.pagination a.active {
  background-color: #4CAF50;
  color: white;
}
</style>
	
	${board }
	<h3>상세조회</h3>
	<form action="updateForm.do">
	 <input type="hidden" value="${board.boardNo }" name="bno">
	 <table class="table">
	 	<tr>
	 		<th>글번호</th>
	 		<td>${board.boardNo}</td>
	 		<th>조회수</th>
	 		<td>${board.viewCnt}</td>
	 	</tr>
	 	<tr>
	 		<th colspan="2">글제목</th>
	 		<td colspan="2">${board.title}</td>
	 	</tr>
	 	<tr>
	 		<td colspan="4">${board.content}</td>
	 	</tr>
	 	<tr>
	 		<th>작성자</th>
	 		<td>${board.writer}</td>
	 		<th>작성일시</th>
	 		<td>${board.createDate}</td>
	 	</tr>
	 	<tr>
	 		<td colspan="4" align="center">
	 		<!-- 글에 대한 작성자와 세션의 아이디를 비교 -->
	 		<!-- 같은면 수정과 삭제 활성화 / 다르면 수정과 삭제 비활성화 -->
	 		<c:choose>
	 			<c:when test="${board.writer eq logid }">	 				
	 				<button type="submit" class="btn btn-primary">수정</button>
	 				<button type="button" class="btn btn-warning" onclick="removeFunc()">삭제</button>
	 			</c:when>
	 			<c:otherwise>
	 				<button type="submit" class="btn btn-primary" disabled>수정</button>
	 				<button type="button" class="btn btn-warning" onclick="removeFunc()" disabled>삭제</button>
	 			</c:otherwise>
	 		</c:choose>
	 		</td>
	 	</tr>
	 </table>
	</form>
	
	<!-- 댓글목록 -->
	<div class="container reply" stype="width: 80%;">
		<div class="header">
			<input class="col-sm-8" type="text" name="reply" id="reply">
			<button class="col-sm-3 addReply">댓글등록</button>
		</div>
		<div class="content">		
			<ul>
				<li>
					<span class="col-sm-2">글번호</span>
					<span class="col-sm-5">내용</span>
					<span class="col-sm-2">작성자</span>
				    <span class="col-sm-2">삭제</span>
				</li>
				<li><hr></li>
			</ul>
		</div>
		<div class="footer">	
			<table id="example" class="display" style="width:100%">
        		<thead>
           			 <tr>
                		<th>댓글번호</th>
               			<th>댓글내용</th>
              		  	<th>작성자</th>
              		  	<th>작성일시</th>
           			 </tr>
        		</thead>
        		<tfoot>
           			<tr>
                		<th>댓글번호</th>
               			<th>댓글내용</th>
              		  	<th>작성자</th>
              		  	<th>작성일시</th>
            		</tr>
        		</tfoot>
    		</table>
		</div>
	</div>
<script>
	const bno = "${board.boardNo}";
	const replyer = "${logid}";
	console.log(bno);

	function removeFunc(){
		let form = document.querySelector('form');
		console.log(form.action);
		form.action = 'removeForm.do';
		form.submit();
	}
	//datatable
    var table = $('#example').DataTable({
		//url
	    ajax: 'dataTable.do?bno='+bno,
	    columns: [
	        { data: 'replyNo' },
	        { data: 'reply' },
	        { data: 'replyer' },
	        { data: 'replyDate' },
	    ],
	    legthName:[
	    	[5, 7, 10, 20, -1],
	    	[5, 7, 10, 20, 'All']
	    ]
	});
	
	$('.addReply').on('click', function(){
		table.row.add([{'replyNo': '1',
			          'reply': 'reply',
			          'replyer': 'replyer',
			          'replyDate': 'replyDate'}).draw(false);
	})
	//ajax 호출 >> db에 넣기 (+ 화면 추가)
	//retVal 찾아가기
</script>
