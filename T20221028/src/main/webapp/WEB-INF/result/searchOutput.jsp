<%@page import="co.test.vo.BookVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>조회 결과 페이지.</title>
</head>
<body>

	<h3>★조회결과페이지★</h3>

	<c:choose>
		<c:when test="${bookInfo != null }">
			<table border="1">
				<caption>★도서조회★</caption>
				<thead style="background-color : pink">
					<tr>
						<th>도서코드</th>
						<th>도서명</th>
						<th>도서저자</th>
						<th>도서출판사</th>
						<th>도서가격</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>${bookInfo.bookCode }</td>
						<td>${bookInfo.bookTitle }</td>
						<td>${bookInfo.bookAuthor }</td>
						<td>${bookInfo.bookPress }</td>
						<td>${bookInfo.bookPrice }</td>
				</tbody>
			</table>
		</c:when>
		
		<c:otherwise>
			<p>없는 코드 번호 입니다!<br>코드를 다시 확인해 주세요!</p>
		</c:otherwise>

	</c:choose>


	<a href="main.do">첫페이지</a>

</body>
</html>