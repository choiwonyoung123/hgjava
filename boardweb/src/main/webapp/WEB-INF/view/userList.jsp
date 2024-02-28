<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h3>userlist page</h3>
<!-- 자바스크립트 연결 -->
<script src="static/js/userList.js"></script>
<input type="text" id="name">
<select id="genderList" class="form-control">
	<option value="Male">남성</option>
	<option value="Female">여성</option>
</select>
<div id="show">
	<table border="1" id="tableList" class="table">
		<thead>
			<tr>
				<th>id</th>
				<th>first_name</th>
				<th>last_name</th>
				<th>email</th>
				<th>salary</th>
			</tr>
		</thead>
		<tbody>
			
		</tbody>
	</table>
</div>