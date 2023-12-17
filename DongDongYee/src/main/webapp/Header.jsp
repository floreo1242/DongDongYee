<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="./css/common.css">


<div class="navbar">
    <p><a class="logo" href="/">동동이</a></p>
    <div class="menubox">
	    <div class="menu"><a href="promotionlist">홍보게시판</a></div>
		<div class="menu"><a href="ratinglist">후기게시판</a></div>
	    <div class="menu"><a href="Profile">프로필</a></div>
	    <div class="welcome">
	        <%if (session.getAttribute("userID") == null) {%>
	        <a href="Login.jsp">로그인</a>
	        <%} else {%>
	        <%=session.getAttribute("userNickname")%>님 환영합니다  &nbsp; &nbsp; |&nbsp; &nbsp; <a href="LogoutServlet">로그아웃</a>
	        <%}%>
	    </div>
	</div>
</div>