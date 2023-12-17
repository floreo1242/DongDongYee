<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="navbar">
    <h1>Logo</h1>
    <div class="menu"><a href="promotionlist">홍보게시판</a></div>
    <div class="menu"><a href="ratinglist">리뷰게시판</div>
    <div class="menu"><a href="Profile">프로필</a></div>
    <div class="menu">
        <%if (session.getAttribute("userID") == null) {%>
        <a href="Login.jsp">로그인</a>
        <%} else {%>
        <%=session.getAttribute("userNickname")%>님 환영합니다 <a href="LogoutServlet">로그아웃</a>
        <%}%>
    </div>
</div>