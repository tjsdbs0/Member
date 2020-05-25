<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="notice.model.vo.*,java.util.*,member.model.vo.*"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%--     <%
    PageData pd=(PageData)request.getAttribute("pageData");
    ArrayList<Notice> noticeList=pd.getPageList();    
    String search =(String)request.getAttribute("search");
    Member member=(Member)session.getAttribute("member");
    %> --%>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>공지사항</title>
</head>
<body>
   <center>
      <h1>공지사항</h1>
      <table border="1">
         <tr><th>글번호</th><th>글제목</th><th>글쓴이</th><th>작성일</th></tr>   
         <%-- <% for(Notice notice:noticeList) {%>    --%>
         <c:forEach items="${pageData.pageList }" var="notice" varStatus="i">
         <tr>
<%--          <td><%=notice.getNoticeNo() %></td>
         <td><%=notice.getSubject() %></td>
         <td><%=notice.getUserId() %></td>
         <td><%=notice.getRegDate() %></td> --%>
         <td>${notice.noticeNo}</td>
         <td>${notice.subject }</td>
         <td>${notice.userId }</td>
         <td>${notice.regDate }</td>
         </tr>
         </c:forEach>
         <%-- <% } %> --%>
         <tr>
            <td colspan="3" align="center">
            <form action="/noticeSearch" method="get">
            <input type="text" name="search" value="${search}"<%-- <%=search %> --%>>
            <input type="submit" value="검색">
            </form>
            </td>
            <%-- <% if(member !=null && member.getUserId().equals("admin")) {%> --%>
            <c:if test="${not empty sessionScope.member && sessionScope.member.userId=='admin' }">
            
            <td align="right">
            <form action="/views/notice/noticeWrite.html" method="post">
            <input type="submit" value="글쓰기">
            </form>
            </td>
            <%-- <% } %> --%></c:if>
         </tr>
         <tr>
         <td colspan="4" align="center">
      <!--    <a href="/notice?currentPage=1">1</a>         
         <a href="/notice?currentPage=2">2</a>         
         <a href="/notice?currentPage=3">3</a>         
         <a href="/notice?currentPage=4">4</a>         
         <a href="/notice?currentPage=5">5</a>    -->   
      <%--    <%= pd.getPageNavi() %>    --%>${pageData.pageNavi }
         </td>
         </tr>
         
      </table>
      <a href="/index.jsp">메인페이지로 이동</a>
   </center>
</body>
</html>