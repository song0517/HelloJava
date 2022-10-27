<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h3>🎈FAQ 페이지입니다.🎈</h3>
	
	<table border='1'>
	<thead>
	<tr><th>글번호</th><th>제목</th><th>내용</<th>작성자</th><th>작성일자</th></tr>
	</thead>
	
	<tbody>
		<c:forEach var="vo" items="${fList }">
			<tr><td>${vo.faqNo }</td>
	    		<td>${vo.title }</td>
	    		<td>${vo.content }</td>
	    		<td>${vo.writer }</td>
	    		<td>${vo.writeDate }</td>
			</tr>
		</c:forEach>
	</tbody>
	</table>