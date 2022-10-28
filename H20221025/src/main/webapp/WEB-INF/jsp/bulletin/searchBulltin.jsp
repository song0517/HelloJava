<%@page import="co.edu.board.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 상세보기</title>
<style>
	tr{
		font-weight: bold;
	}

</style>
</head>
<body>
<h3>📕📙게시글 상세보기📗📘</h3>
	<table border='1'>
		<tr>
			<th>글번호</th><td>${board.boardNo }</td>
			<th>작성자</th><td>${board.writer }</td>
		</tr>
		<tr>
			<th>제목</th><td>${board.title }</td>
		</tr>
		<tr>
			<td colspan='2'>
				<textarea rows='5' cols='30'>${board.content }
				</textarea>
			</td>
			<td>
				<img src="upload/${board.image }" alt="" style="width:200px">
			</td>
		</tr>
		<tr>
			<th>작성일자</th><td>${board.writeDate }</td>
			<th>조회수</th><td>${clickCnt }</td>
		</tr>
	</table>
</body>
</html>