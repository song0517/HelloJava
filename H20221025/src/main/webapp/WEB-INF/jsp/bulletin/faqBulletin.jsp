<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h3>πFAQ νμ΄μ§μλλ€.π</h3>
	
	<table border='1'>
	<thead>
	<tr><th>κΈλ²νΈ</th><th>μ λͺ©</th><th>λ΄μ©</<th>μμ±μ</th><th>μμ±μΌμ</th></tr>
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