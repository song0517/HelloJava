<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main.jsp</title>
</head>
<body>
	<%
		//로그인이 되어있다면...id에 저장
		String id = (String) session.getAttribute("id");
		String auth = (String) session.getAttribute("auth");
	%>
	
	<%if(id != null) {%>
		<p>아이디: <%=id %></p>
	<%} else { %>
		<p>손님</p>
	<%} %>

	<h2>Member 첫 페이지.</h2>
	<%if(auth.equals("admin")) {%>
		<a href="./memberAddForm.do">회원정보생성페이지</a><br>
	<%}%>
	
	<a href="./memberModefyForm.do">회원정보수정페이지</a><br>
	<a href="./memberRemoveForm.do">회원정보삭제페이지</a><br>
	<a href="./memberSearchForm.do">회원정보상세페이지</a><br>
	<a href="./memberList.do">회원목록보기페이지</a><br>
	
	<!-- 로그인값이 없다면 로그인화면나타남, 있으면 로그아웃화면나타남 -->
	<%if(id == null) {%>
		<a href="./loginForm.do">로그인화면</a>
	<%} else { %>
		<a href="./loginOut.do">로그아웃</a>
	<%} %>
	
</body>
</html>