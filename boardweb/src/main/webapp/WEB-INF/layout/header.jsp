<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Simple Sidebar - Start Bootstrap Template</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="/static/assets/favicon.ico" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="/static/css/styles.css" rel="stylesheet" />
    </head>
    <body>
        <div class="d-flex" id="wrapper">
            <!-- Sidebar-->
            <div class="border-end bg-white" id="sidebar-wrapper">
            	<!-- 로그인의 아이디 파라미터를 받아와서 값이 없으면 손님 출력 / 값이 있으면 사용자 이름 출력 -->     		
            	<c:choose>
            		<c:when test="${empty logName }">   
	                	<div class="sidebar-heading border-bottom bg-light">Start Bootstrap (손님)</div>
            		</c:when>
            		<c:otherwise>    		
		                <div class="sidebar-heading border-bottom bg-light">Start Bootstrap (${logName })</div>
            		</c:otherwise>            	
            	</c:choose>
                <div class="list-group list-group-flush">
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="boardList.do">게시글 목록</a>
                    <!-- 세션 아이디가 없으면 사이드바에서 로그인 보여주기 / 아이디가 있으면 사이드바에서 로그아웃 보여주기 -->
                    <c:choose>
                    	<c:when test="${empty logid }">
                    		<a class="list-group-item list-group-item-action list-group-item-light p-3" href="LoginForm.do">로그인</a>
                    	</c:when>
                    	<c:otherwise>
                    		<!-- 로그인 했을때만 사이드바에서 게시글등록 메뉴 보여주기 -->                  	
		                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="addForm.do">게시글 등록</a>
                    		<c:choose>
                    			<c:when test="${logName eq '관리자' }">                    		
                    				<a class="list-group-item list-group-item-action list-group-item-light p-3" href="memberList.do">회원목록</a>
                    			</c:when>
                    			<c:otherwise>
                    				<a class="list-group-item list-group-item-action list-group-item-light p-3" href="memberList.do">회원목록</a>
                    			</c:otherwise>                    
                    		</c:choose>
                    		<a class="list-group-item list-group-item-action list-group-item-light p-3" href="Logout.do">로그아웃</a>
                    	</c:otherwise>
                    </c:choose>
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="#!">Status</a>
                </div>
            </div>
            <!-- Page content wrapper-->
            <div id="page-content-wrapper">
                <!-- Top navigation-->
                <nav class="navbar navbar-expand-lg navbar-light bg-light border-bottom">
                    <div class="container-fluid">
                        <button class="btn btn-primary" id="sidebarToggle">Toggle Menu</button>
                        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                        <div class="collapse navbar-collapse" id="navbarSupportedContent">
                            <ul class="navbar-nav ms-auto mt-2 mt-lg-0">
                                <li class="nav-item active"><a class="nav-link" href="#!">Home</a></li>
                                <li class="nav-item"><a class="nav-link" href="#!">Link</a></li>
                                <li class="nav-item dropdown">
                                    <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Dropdown</a>
                                    <div class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                                        <a class="dropdown-item" href="#!">Action</a>
                                        <a class="dropdown-item" href="#!">Another action</a>
                                        <div class="dropdown-divider"></div>
                                        <a class="dropdown-item" href="#!">Something else here</a>
                                    </div>
                                </li>
                            </ul>
                        </div>
                    </div>
                </nav>
                <!-- Page content-->
                <div class="container-fluid">