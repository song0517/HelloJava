<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
    <div class="border-end bg-white" id="sidebar-wrapper">
    	<div class="sidebar-heading border-bottom bg-light">
		<c:choose>
			<c:when test="${sessionScope.id != null}">
				<p>π${sessionScope.id }</p>
			</c:when>
			<c:otherwise>
				<p>μλ</p>
			</c:otherwise>
		</c:choose>
		
		</div>
    	<div class="list-group list-group-flush">
<<<<<<< HEAD
    		<a class="list-group-item list-group-item-action list-group-item-light p-3" href="bulletin.do?page=1">πκ²μν</a> 
    		<a class="list-group-item list-group-item-action list-group-item-light p-3" href="writeBoardForm.do" style="background-color: rgba(162, 80, 255, 0.466)">βκΈλ±λ‘</a>
    		<a class="list-group-item list-group-item-action list-group-item-light p-3" href="updateBoardForm.do">πκΈμμ </a> 
    		<a class="list-group-item list-group-item-action list-group-item-light p-3" href="signUpForm.do" >πββοΈνμκ°μ</a> 
    		<a class="list-group-item list-group-item-action list-group-item-light p-3" href="memberList.do" style="background-color: rgba(162, 80, 255, 0.466)">πνμλͺ©λ‘</a> 
    		<a class="list-group-item list-group-item-action list-group-item-light p-3" href="signInForm.do" >πλ‘κ·ΈμΈ</a> 
    		<a class="list-group-item list-group-item-action list-group-item-light p-3" href="signOut.do" style="background-color: rgba(162, 80, 255, 0.466)">πλ‘κ·Έμμ</a> 
    		<a class="list-group-item list-group-item-action list-group-item-light p-3" href="faq.do" >πμμ£Όλ¬»λμ§λ¬Έ(FAQ)</a>
=======
    		<a
    			class="list-group-item list-group-item-action list-group-item-light p-3" href="bulletin.do?page=1">πκ²μν</a> <a
    			class="list-group-item list-group-item-action list-group-item-light p-3" href="writeBoardForm.do">βκΈλ±λ‘</a> <a
    			class="list-group-item list-group-item-action list-group-item-light p-3" href="updateBoardForm.do">πκΈμμ </a> <a
    			class="list-group-item list-group-item-action list-group-item-light p-3" href="signUpForm.do">πββοΈνμκ°μ</a> <a
    			class="list-group-item list-group-item-action list-group-item-light p-3" href="memberList.do">πνμλͺ©λ‘</a> <a
    			class="list-group-item list-group-item-action list-group-item-light p-3" href="signInForm.do">πλ‘κ·ΈμΈ</a> <a
    			class="list-group-item list-group-item-action list-group-item-light p-3" href="signOut.do">πλ‘κ·Έμμ</a> <a
    			class="list-group-item list-group-item-action list-group-item-light p-3" href="faq.do">πμμ£Όλ¬»λμ§λ¬Έ(FAQ)</a>
>>>>>>> branch 'master' of https://github.com/song0517/HelloJava.git
    	</div>
    </div>