<%@page import="co.edu.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원상세정보 결과</title>
</head>
<body>

	<%
		//가져오기, memberInfo읽어들이기
		MemberVO result = (MemberVO) request.getAttribute("memberInfo");
	%>

	<h3>회원상제정보 보기</h3>
	<% if(result.getId() != null) { %>
		<p>회원아이디: <%=result.getId() %></p>
		<p>회원이름: <%=result.getName() %></p>
		<p>회원이메일: <%=result.getEmail() %></p>
	<%} else { %>
		<p>조회된 정보가 없습니다!!</p>
	<%} %>
	
	<%@ include file="home.jsp" %> <!-- 페이지내에 다른 페이지를 추가 -->
	
</body>
</html>