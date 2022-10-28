<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정결과페이지</title>
</head>
<body>

	<h3>★수정결과페이지★</h3>
	<p>▶코드: ${bookInfo.bookCode }</p>
	<p>▶제목: ${bookInfo.bookTitle }</p>
	<p>▶저자: ${bookInfo.bookAuthor }</p>
	<p>▶출판사: ${bookInfo.bookPress }</p>
	<p>▶가격: ${bookInfo.bookPrice }</p>
	<p>수정완료!!</p>
    <a href="main.do">첫페이지</a>

</body>
</html>