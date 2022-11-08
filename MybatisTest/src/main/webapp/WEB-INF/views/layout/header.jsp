<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/menu.css">
</head>
<body>
	<nav id="topMenu">
		<ul>
			<li><a class="menuLink" href="main.do">Home</a></li>	
			<li><a class="menuLink" href="bookList.do">Book</a></li>
			<li><a class="menuLink" href="#">Content</a></li>
			
			<c:if test="${respsibility eq 'admin' }">
				<li><a class="menuLink" href="#">Member</a></li>
			</c:if>
			
			<c:if test="${empty id }">	
				<li><a class="menuLink" href="memberJoinForm.do">Join</a></li>
			</c:if>
			
			<c:if test="${empty id }">
				<li><a class="menuLink" href="memberLoginForm.do">Login</a></li>
			</c:if>
			<c:if test="${not empty id }">
				<li><a class="menuLink" href="logout.do">Logout</a></li>
				<li>${name }님 접속중</a></li>
			</c:if>
			
		</ul>
	</nav>
</body>
</html>