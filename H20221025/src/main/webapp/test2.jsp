<%@page import="co.edu.board.BoardVO"%>
<%@page import="java.util.List"%>
<%@page import="co.edu.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Expression Language (EL) JSP Standard Tag Library(JSTL)</title>
</head>
<body>
	<%
		String info = (String) application.getAttribute("info");
		System.out.println(info);
		
		BoardDAO dao = new BoardDAO();
		List<BoardVO> list = (List<BoardVO>) dao.pageList(1);
		
		request.setAttribute("bList", list);
	%>
	
	<p>${info }</p> <!-- 표현식 -->
	<p>${"Hongkildong" eq "Hong" }</p>
	<p>${3>2 }</p>
	<p>${55+22}</p>
	<p>${param.page }</p>
	<p>app: ${sessionScope.hissession eq null }</p>
	
	<!-- 변수선언 -->
	<c:set var="myName" value="홍길동"></c:set>
	<p>${myName }</p>
	<!-- 출력 -->
	<c:out value="${myName }"></c:out>
	
	<!-- if 조건 -->
	<c:if test="${info eq 'hong' }">
		<p>같습니다</p>
	</c:if>
	
	<c:if test="${!info2 }">
		<p>값이 없습니다.</p>
	</c:if>
	
	<c:set var="score" value="75"></c:set>
	
	<!-- else if 조건 -->
	<c:choose>
		<c:when test="${score > 90 }"><p>A학점</p></c:when>
		<c:when test="${score > 80 }"><p>B학점</p></c:when>
		<c:when test="${score > 70 }"><p>C학점</p></c:when>
		<c:otherwise><p>불합격</p></c:otherwise>
	</c:choose>
	
	<!-- 반복문 -->
	<c:forEach var="i" begin="1" end="10" step="1">
		<p>${i }</p>
	</c:forEach>
	<!-- for(BoardVO board : bList) -->
	<c:forEach var="board" items="${bList }">
		<p>글번호:${board.boardNo }, 제목:${board.title }, 작성자:${board.writer }</p>
	</c:forEach>
	
</body>
</html>
