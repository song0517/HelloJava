<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 재발송 안내</title>
</head>
<body>
<c:choose>
	<c:when test="${logInfo != null }">
		<h3>메일로 비밀번호를 전송했습니다. 확인 후 다시 로그인해주세요!</h3>
	</c:when>
	
	<c:otherwise>
		<h3>아이디를 찾지 못했습니다. 다시 입력해주세요!</h3>
	</c:otherwise>
</c:choose>


</body>
</html>