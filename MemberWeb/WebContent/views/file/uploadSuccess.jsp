<%@page import="file.model.vo.FileData"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	FileData data = (FileData) request.getAttribute("fileData");
%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>upload success</title>
</head>
<body>
	<center>
		<h1>업로드 정보</h1>
		<h3><%= "파일이름 : " + data.getFileName() %></h3><br>
		<h3><%= "파일경로 : " + data.getFilePath() %></h3><br>
		<h3><%= "파일사이즈 : " + data.getFileSize() %></h3><br>
		<h3><%= "업로드 아이디 : : " + data.getFileUser() %></h3>
		<h3><%= "업로드 시간 : : " + data.getUploadTime() %></h3>
		<a href = "/index.jsp">메인페이지로 이동</a>
		
	</center>

</body>
</html>