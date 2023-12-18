<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/globals.css">
    <link rel="stylesheet" href="css/signout.css">
    <title>회원탈퇴</title>
</head>
<body>
<jsp:include page="Header.jsp"/>
<div class="signout-container">
    <h1 class="signout-title">회원탈퇴</h1>
    <p>회원탈퇴를 위해 비밀번호를 입력해주세요</p>
    <form action="Profile" method="post">
        <input class="signout-input" type="password" name="password" id="password" required>
        <input class="signout-button" type="submit" value="탈퇴하기">
    </form>
</div>
<jsp:include page="Footer.jsp"/>
</body>
</html>
