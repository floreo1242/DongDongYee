<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="Header.jsp"/>
<h1>회원탈퇴</h1>
<p>회원탈퇴를 위해 비밀번호를 입력해주세요</p>
<form action="Profile" method="post">
    <label for="password">비밀번호</label>
    <input type="password" name="password" id="password">
    <input type="submit" value="탈퇴하기">
</form>
<jsp:include page="Footer.jsp"/>
</body>
</html>
