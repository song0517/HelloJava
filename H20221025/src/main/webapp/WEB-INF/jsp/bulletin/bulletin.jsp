<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- bulletin/bulletin.tiles -->

<h3>π£κ²μν νμ΄μ§μλλ€.π£</h3>
	
	<table border='1'>
	<thead>
	<tr><th>κΈλ²νΈ</th><th>μ λͺ©</th><th>μμ±μ</th><th>μμ±μΌμ</th></tr>
	</thead>
	
	<tbody>
		<c:forEach var="vo" items="${bList }">
			<tr>
				<td><a href="searchBoard.do?bno=${vo.boardNo }">${vo.boardNo }</td>
				<td>${vo.title }</td>
				<td>${vo.writer }</td>
				<td>${vo.writeDate }</td>
			</tr>
		</c:forEach>
	</tbody>
	</table>
	<p />
	
	<div class='pagination'>
		<!-- μ΄μ νμ΄μ§ μ€μ  -->
		<c:if test="${page.prev }">
			<a href="bulletin.do?page=${page.startPage - 1 }">&lt;&lt;</a>
		</c:if>
	
	<!-- νμ΄μ§ μμ μ€μ  -->
	<c:forEach var="i" begin="${page.startPage }" end="${page.endPage }" step="1">
		<c:choose>
			<c:when test="${page.pageNum == i }">
				<a class='active' href="bulletin.do?page=${i }">${i } </a>
			</c:when>
			<c:otherwise>
				<a href="bulletin.do?page=${i }">${i } </a>
			</c:otherwise>
		</c:choose>
	</c:forEach>
	
	<!-- λ€μνμ΄μ§ μ€μ  -->
	<c:if test="${page.next }">
			<a href="bulletin.do?page=${page.endPage + 1 }">&gt;&gt;</a>
	</c:if>
</div>