<%@page import="notice.model.vo.Notice"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	Notice notice = (Notice)request.getAttribute("content");
    %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>공지사항 수정</h1>
<form action="/noticeModifyCommit" method = "post">
	<input type ="text" size = "100" name = "subject" value ="<%=notice.getSubject() %>"><br><br>
	<textarea rows="30" cols="100" name = "content"><%=notice.getContents() %></textarea><br>
	<input type="hidden" name = "noticeNo" value="<%=notice.getNoticeNo()%>">
	<input type="submit" value="수정">
	<input type="reset" value="취소">
</form>

</body>
</html>