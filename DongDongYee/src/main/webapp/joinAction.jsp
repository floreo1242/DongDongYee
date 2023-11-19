<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="dd_user.DD_UserDAO"%>
<%@ page import="java.io.PrintWriter"%>
<%
request.setCharacterEncoding("UTF-8");
%>

<jsp:useBean id="user" class="dd_user.DD_User" scope="page"></jsp:useBean>
<jsp:setProperty name="user" property="userID" />
<jsp:setProperty name="user" property="userPassword" />
<jsp:setProperty name="user" property="userName" />
<jsp:setProperty name="user" property="userGender" />
<jsp:setProperty name="user" property="userEmail" />

<head>
<meta http-equiv="Content-Type" content="text/html; c harset=UTF-8">
<title>JSP dongdong</title>
</head>
<body>
	<%
	if (user.getUserID() == null || user.getUserPassword() == null || user.getUserEmail() == null
			|| user.getUserNickname() == null) {
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('모든 문항을 입력해주세요.')");
		script.println("history.back()"); // 이전 페이지로 사용자를 보냄
		script.println("</script>");
	} else {
		DD_UserDAO userDAO = new DD_UserDAO();
		int result = userDAO.join(user);
		if (result == -1) { // 회원가입 실패시
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('이미 존재하는 아이디입니다.')");
			script.println("history.back()"); // 이전 페이지로 사용자를 보냄
			script.println("</script>");
		} else if (result == -2) {
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('이미 존재하는 이메일입니다.')");
			script.println("history.back()"); // 이전 페이지로 사용자를 보냄
			script.println("</script>");
		} else if (result == -3) {
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('이미 존재하는 닉네임입니다.')");
			script.println("history.back()"); // 이전 페이지로 사용자를 보냄
			script.println("</script>");
		} else { // 회원가입 성공시
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("location.href = 'main.jsp'"); // 메인 페이지로 이동
			script.println("</script>");
		}
	}
	%>

</body>
</html>