<%@page import="co.edu.board.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 상세보기</title>
</head>
<body>
	<%BoardVO vo = (BoardVO) request.getAttribute("board"); %>
	
	<table border='1'>
		<tr>
			<th>글번호</th><td><%=vo.getBoardNo() %></td>
			<th>작성자</th><td><%=vo.getWriter() %></td>
		</tr>
		<tr>
			<th>제목</th><td><%=vo.getTitle() %></td>
		</tr>
		<tr>
			<td colspan='2'>
				<textarea rows=5 cols=30>
					<%=vo.getContent() %>
				</textarea>
			</td>
		</tr>
		<tr>
			<th>작성일자</th><td><%=vo.getWriteDate() %></td>
			<th>조회수</th><td><%=vo.getClickCnt() %></td>
		</tr>
	</table>
</body>
</html>