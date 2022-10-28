<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보수정 페이지</title>
</head>
<body>
	
	<h3>회원조회</h3>
	<form action="./memberSearch.do" method="post">
		<input type="hidden" name="job" value="update">
		ID : <input type="text" name="id"><br>
		<input type="submit" value="조회">
	</form>
	
	<h3>회원정보수정</h3>
	
	<c:choose>
		<c:when test="${memberInfo != null }">
			<form action="./memberModify.do" method="post">
			ID : <input type="text" name="id" value="${sessionScope.id }" readonly><br>
			PW : <input type="text" name="passwd" value="${memberInfo.passwd }"><br>
			Name : <input type="text" name="name" value="${memberInfo.name }"><br>
			Mail : <input type="email" name="mail" value="${memberInfo.email }"><br>
			
			<c:if test="${sessionScope.id eq memberInfo.id }">
				<input type="submit" value="수정">
			</c:if>
			
			
			</form>
			</c:when>
			
		<c:otherwise>
			<p>조회된 결과가 없습니다!</p>
		</c:otherwise>
	</c:choose>
	
</body>
</html>