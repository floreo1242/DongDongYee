<%@ page import="domain.user.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    User user = (User) request.getAttribute("user");
%>
<html>
<head>
    <link rel="stylesheet" href="css/globals.css">
    <link rel="stylesheet" href="css/profile.css">
    <title>프로필</title>
</head>
<body>
<jsp:include page="Header.jsp"/>
<div class="profile-container">
    <h1 class="profile-title">프로필</h1>
    <div class="profile-info" id="userId">ID: <%=user.getUserID()%></div>
    <div class="profile-info" id="userNickname">닉네임: <%=user.getUserNickname()%></div>
    <div class="profile-info" id="userEmail">이메일: <%=user.getUserEmail()%></div>
    <a href="signout.jsp" class="profile-link">회원탈퇴</a>
</div>
<jsp:include page="Footer.jsp"/>
</body>

</html>
