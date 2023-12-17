<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/globals.css">
<link rel="stylesheet" href="./css/Login.css">
<link rel="stylesheet" href="css/List.css">

<title>로그인</title>
</head>
<body>
<div class="main-content">
    <jsp:include page="Header.jsp"/>
	    <div class="center">
	    <h1>로그인</h1>
	    <p>아이디와 비밀번호를 입력해주세요.</p>
	    <form action="LoginServlet" method="post">
	        <label for="UserID">아이디</label>
	        <input type="text" id="UserID" name="UserID" placeholder="아이디를 입력해주세요"/>
	        <br>
	        <label for="UserPassword">비밀번호</label>
	        <input type="password" id="UserPassword" name="UserPassword" placeholder="비밀번호을 입력해주세요"/>
	        <button type="submit">로그인</button>
	        <br><br><a href="Register.jsp">회원가입</a>
	        
		  </form>
	    </div>
	    </div>
</div>
<jsp:include page="Footer.jsp"/>
</body>
</html>