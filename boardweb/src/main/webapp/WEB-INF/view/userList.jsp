<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h3>userlist page</h3>
<!-- 자바스크립트 연결 -->
<script src="static/js/userAjax.js"></script>
<input type="text" id="name">
<select id="genderList" class="form-control">
	<option value="Male">남성</option>
	<option value="Female">여성</option>
</select>
<table class="table">
	<tr>
		<th>도서코드</th>
		<td><input type="text" id="bcode" value="B000"></td>
	</tr>
	<tr>
		<th>도서명</th>
		<td><input type="text" id="bname" value="파워자바"></td>
	</tr>
	<tr>
		<th>저자</th>
		<td><input type="text" id="bauthor" value="홍길동"></td>
	</tr>
	<tr>
		<th>출판사</th>
		<td><input type="text" id="bpress" value="길동사"></td>
	</tr>
	<tr>
		<th>금액</th>
		<td><input type="text" id="bprice" value="15000"></td>
	</tr>
	<tr>
		<td colspan="2" aligh="center">
			<button id="addBtn">등록</button>
		</td>
	</tr>
</table>
<div id="show">
	<table border="1" id="tableList" class="table">
		<thead>

		</thead>
		<tbody>
			
		</tbody>
	</table>
</div>