<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Expression Language (EL) JSP Standard Tag Library(JSTL)</title>
</head>
<body>
	<%	
		//어플리케이션에 값을 집어넣으면 다른 페이지에서도 값을 가져올수 있다.
		String info = (String) application.getAttribute("info");
		System.out.println(info);
	%>
	
	<!-- 간단한 표현을 할 수 있는 표현식... -->
	<!-- Attribute의 값을 읽어와서 ${ }안에 작성할 경우 편하게 사용 가능 -->
	<p>${info }</p>
	 
	
</body>
</html>