<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>삭제메뉴</title>
</head>

<body>

	<h3>${error }</h3>

	<h3>★도서삭제조회★</h3>
	<form action="./searchBook.do" method="get">
		<input type="text" name="bookCode"><br> <input
			type="hidden" name="job" value="remove"> <input type="submit"
			value="조회">
	</form>

	<c:choose>
		<c:when test="${bookInfo.bookCode != null }">
			<!-- 도서삭제를 위한 화면 작성코드를 입력하세요. -->
			<form action="./removeBook.do" method="post">
				▶코드 : <input type="text" name="bookCode" value="${bookInfo.bookCode }" readonly><br> 
				<input type="submit" value="삭제">
			</form>
		</c:when>
		
		<c:otherwise>
			<p>★올바른 코드를 조회할 경우 삭제항목이 나타납니다<br>★삭제항목이 나타나지 않을 경우 코드를 다시 확인해 주세요!</p>
		</c:otherwise>
	</c:choose>

	<a href="main.do">첫페이지</a>

</body>

</html>