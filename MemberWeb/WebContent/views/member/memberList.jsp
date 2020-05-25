<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="member.model.vo.Member, java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>전체 회원 정보</title>
</head>
<body>
	<h1>관리자 : 회원관리 페이지</h1>
	<table border="1">
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>나이</th>
			<th>이메일</th>
			<th>휴대폰</th>
			<th>주소</th>
			<th>성별</th>
			<th>취미</th>
			<th>가입날짜</th>
		</tr>
		<c:forEach items="${list}" var="mOne">
			<tr>
				<td><a href="/myinfo?userId=${mOne.userId}"> ${mOne.userId }</a></td>
				
				<td>${mOne.userName }</td>
				<td>${mOne.age }</td>
				<td>${mOne.email }</td>   
				<td>${mOne.phone }</td>
				<td>${mOne.address }</td>
				<c:if test="${mOne.gender eq 'M' }">
					<td>남자</td>
				</c:if>
				<c:if test="${mOne.gender eq 'F' }">
					<td>여자</td>
				</c:if>
				<td>${mOne.hobby }</td>
				<td>${mOne.enrollDate }</td>
				
		</c:forEach>

		<%-- <% for(Member mOne : list){ %>
		<tr>
			<td><%=mOne.getUserId() %></td>
			<td><%=mOne.getUserName() %></td>
			<td><%=mOne.getAge() %></td>
			<td><%=mOne.getEmail() %></td>
			<td><%=mOne.getPhone() %></td>
			<td><%=mOne.getAddress() %></td>
			<% String gender = mOne.getGender(); 
			if(gender.equals("M")) {
				gender = "남자";
			}else {
				gender = "여자";
			}
			%>
			<td>
			<%= gender %>
			
			</td>
			<td><%=mOne.getHobby() %></td>
			<td><%=mOne.getEnrollDate() %></td>
		</tr>
		<% } %> --%>
	</table>
	<a href="/index.jsp">메인페이지로 이동</a>

</body>
</html>