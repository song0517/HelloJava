<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>✨게시글 수정 페이지</title>
</head>
<body>
	<form action="./updateBoard.do" method="post">
		BoardNo : <input type="text" name="boardNo"><br>
		내용 : <textarea name="content" rows="10" cols="30"></textarea><br>
		<input type="submit" value="수정">
	</form>
</body>
</html>