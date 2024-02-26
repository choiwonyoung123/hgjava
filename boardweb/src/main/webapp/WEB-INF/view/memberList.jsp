<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


	<h3>회원 목록</h3>
	<table class="table">
		<thead>
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>권한</th>
				<th>이미지</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="member" items="${list }">			
			<tr>
				<td><c:out value="${board.boardNo }"/></td>
				<td><a href="board.do?bno=${board.boardNo }">${board.title }</a></td>
				<td>${board.writer }</td>
				<td>${board.viewCnt }</td>
				<td><fmt:formatDate value="${board.createDate }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>

