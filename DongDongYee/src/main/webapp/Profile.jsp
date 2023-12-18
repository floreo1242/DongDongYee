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
    <table>
        <tr>
            <div class="profile-info" id="userId">
                <td>ID</td>
                <td><input class="profile-input" type="text" value="<%=user.getUserID()%>" readonly></td>
            </div>
        </tr>
        <tr>
            <div class="profile-info" id="userNickname">
                <td>닉네임</td>
                <td><input class="profile-input" type="text" value="<%=user.getUserNickname()%>" readonly></td>
            </div>
        </tr>
        <tr>
            <div class="profile-info" id="userEmail">
                <td>이메일</td>
                <td><input class="profile-input" type="text" value="<%=user.getUserEmail()%>" readonly></td>
            </div>
        </tr>
    </table>
    <a href="signout.jsp" class="profile-link">회원탈퇴</a>
</div>
<jsp:include page="Footer.jsp"/>
</body>

</html>
