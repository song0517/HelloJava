<%@page import="co.test.vo.BookVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>수정메뉴</title>
</head>

<body>

	<h3>${error }</h3>

	<h3>★도서수정조회★</h3>
	<form action="./searchBook.do" method="get">
		<input type="text" name="bookCode"><br> <input
			type="hidden" name="job" value="modify"> <input type="submit"
			value="조회">
	</form>

	<c:choose>
		<c:when test="${bookInfo.bookCode != null }">
			<!-- 도서수정을 위한 화면 작성코드를 입력하세요. -->
			<form action="./modifyBook.do" method="post">
				<p>수정하고 싶은 부분만 수정해 주세요!</p>
				▶코드: <input type="text" name="bookCode" value="${bookInfo.bookCode }" readonly><br>
				▶제목: <input type="text" name="title" value="${bookInfo.bookTitle }"><br>
        		▶저자: <input type="text" name="author" value="${bookInfo.bookAuthor }"><br>
        		▶출판사: <input type="text" name="press" value="${bookInfo.bookPress }"><br>
				▶가격: <input type="text" name="price" value="${bookInfo.bookPrice }"><br>
				<input type="submit" value="수정">
			</form>
		</c:when>
		
		<c:otherwise>
			<p>★올바른 코드를 조회할 경우 수정항목이 나타납니다<br>★수정항목이 나타나지 않을 경우 코드를 다시 확인해 주세요!</p>
		</c:otherwise>
	</c:choose>

	<a href="main.do">첫페이지</a>

</body>
</html>