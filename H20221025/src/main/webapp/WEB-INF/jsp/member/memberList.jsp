<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원목록(memberList.jsp)</title>
<style>
	tr {
		border: 1px solid blue;
	}
	th, td {
		border: 1px dotted red;
	}
</style>
</head>
<body>
	<h3>📑회원목록</h3>
	<table boarder='1'>
		<tr><th>회원ID</th><th>회원이름</th><th>이메일</th></tr>
		<c:forEach var="member" items="${list }">
			<tr>
				<td>${member.id }</td><td>${member.name }</td><td>${member.email }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>