<%@ page import="domain.user.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    User user = (User) request.getAttribute("user");
%>
<html>
<head>
    <title>프로필</title>
</head>
<body>
<jsp:include page="Header.jsp"/>
<h1>프로필</h1>
<div>ID: <%=user.getUserID()%></div>
<div>닉네임: <%=user.getUserNickname()%></div>
<div>이메일: <%=user.getUserEmail()%></div>
<a href="signout.jsp">회원탈퇴</a>
<jsp:include page="Footer.jsp"/>
</body>
</html>
