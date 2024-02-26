<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


	<h3>등록화면</h3>
	<form action="addBoard.do" method="post">
		<table class="table">
			<tr>
				<th>제목</th>
				<td><input type="text" class="form-control" name="title"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea class="form-control" name="content"></textarea></td>
			</tr>
			<tr>
				<th>작성자</th>
				<!-- 세션 아이디가 있으면 글을 작성할때 읽기전용 설정 -->
				<td><input type="text" class="form-control" name="writer" value="${logid }" readonly></td>
			</tr>
			<tr>
				<td align="center" colspan="2">				
					<button type="submit" class="btn btn-primary">등록</button>
					<button type="reset" class="btn btn-secondary">취소</button>
				</td>
			</tr>
		</table>
	</form>

