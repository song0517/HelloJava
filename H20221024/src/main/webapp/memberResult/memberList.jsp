<%@page import="co.edu.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원목록(memberList.jsp)</title>
</head>
<body>
	<%
	List<MemberVO> list = (List<MemberVO>) request.getAttribute("memberList"); //List<MemberVO>형식
	%>
	
	<h3>회원정보리스트 보기</h3>
	<%if(list.size() > 0) {%>
		<table border='1'>
			<tr><th>회원아이디</th><th>비밀번호</th><th>이름</th><th>이메일</th></tr>
			<!-- for반복문을 사용해서 테이블형식으로 리스트 만들기 -->
			<% for(MemberVO vo : list) {%>
				<tr>
					<!-- 링크 위치를 바꾸고 싶을 경우 href를 바꿔주면된답 -->
					<td><a href="./memberSearchForm.do?id=<%=vo.getId() %>&job=search"><%=vo.getId() %></a></td>
					<td><%=vo.getPasswd() %></td>
					<td><a href="./memberSearch.do?id=<%=vo.getId() %>&job=update"><%=vo.getName() %></td>
					<td><%=vo.getEmail() %></td>
				</tr>
			<%} %>
		</table>
	<%} else { %>
		<p>조회된 회원정보가 없습니다.</p>
	<%} %>
	
	<%@ include file="home.jsp" %> <!-- 페이지내에 다른 페이지를 추가 -->
</body>
</html>