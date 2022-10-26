<%@page import="co.edu.board.FaqVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	List<FaqVO> list = (List<FaqVO>) request.getAttribute("fList");
%>

<h3>게시판 페이지입니다.</h3>
	
	<table border='1'>
	<tr><th>글번호</th><th>제목</th><th>내용</<th>작성자</th><th>작성일자</th></tr>
<% for(FaqVO vo : list) { %>
	<tr><td><%=vo.getFaqNo() %></a></td>
	    <td><%=vo.getTitle() %></td>
	    <td><%=vo.getContent() %></td>
	    <td><%=vo.getWriter() %></td>
	    <td><%=vo.getWriteDate() %></td>
	</tr>
<%} %> 
	</table>