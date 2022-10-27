<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
    <div class="border-end bg-white" id="sidebar-wrapper">
    	<div class="sidebar-heading border-bottom bg-light">
		<c:choose>
			<c:when test="${sessionScope.id != null}">
				<p>💕${sessionScope.id }</p>
			</c:when>
			<c:otherwise>
				<p>손님</p>
			</c:otherwise>
		</c:choose>
		
		</div>
    	<div class="list-group list-group-flush">
    		<a
    			class="list-group-item list-group-item-action list-group-item-light p-3" href="bulletin.do?page=1">📃게시판</a> <a
    			class="list-group-item list-group-item-action list-group-item-light p-3" href="writeBoardForm.do">✏글등록</a> <a
    			class="list-group-item list-group-item-action list-group-item-light p-3" href="updateBoardForm.do">📋글수정</a> <a
    			class="list-group-item list-group-item-action list-group-item-light p-3" href="signUpForm.do">🙆‍♀️회원가입</a> <a
    			class="list-group-item list-group-item-action list-group-item-light p-3" href="memberList.do">📂회원목록</a> <a
    			class="list-group-item list-group-item-action list-group-item-light p-3" href="signInForm.do">🔎로그인</a> <a
    			class="list-group-item list-group-item-action list-group-item-light p-3" href="signOut.do">👋로그아웃</a> <a
    			class="list-group-item list-group-item-action list-group-item-light p-3" href="faq.do">📌자주묻는질문(FAQ)</a>
    	</div>
    </div>