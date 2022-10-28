<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>조회메뉴</title>
</head>

<body>

	<h3>${error }</h3>
    <h3>★도서조회★</h3>
    <form action="./searchBook.do" method="get">
        ▶도서코드: <input type="text" name="bookCode" id=""><br>
        <input type="hidden" name="job" value="search">
        <input type="submit" value="조회">
    </form>
    
    <a href="main.do">첫페이지</a>

</body>

</html>