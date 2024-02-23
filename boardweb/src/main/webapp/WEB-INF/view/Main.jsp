<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../includes/header.jsp"></jsp:include>
	<h3>main page</h3>
	<c:set var="msg" value="hello" />
	<p>message <c:out value="${msg}"/></p>
	<!-- 조건문 -->
	<c:if test="$msg == hello">
		<p>참입니다</p>
	</c:if>
	<c:choose>
		<c:when test="${msg == 'hello'}">
			<p>참입니다</p>
		</c:when>
		<c:otherwise>
			<p>거짓입니다</p>
		</c:otherwise>
	</c:choose>
	
	<!-- 반복문 -->
	<c:forEach begin="1" end="5" var="i">
		<p>${i }</p>		
	</c:forEach>
<!-- action 태그 > 기능 수행 -->
<jsp:include page="../includes/footer.jsp"></jsp:include>