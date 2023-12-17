<%@ page import="domain.promotion.Promotion" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Promotion promotion = (Promotion) request.getAttribute("promotion");
%>
<html>
<head>
    <link href="./css/globals.css" type="text/css" rel="stylesheet">
    <link href="./css/write.css" type="text/css" rel="stylesheet">
    
    <title>홍보 게시판</title>
</head>
<body>
<jsp:include page="Header.jsp"/>
<%
    if (session.getAttribute("userID") == null) {
        response.getWriter().println("<script>alert('세션이 만료되었습니다. 다시 로그인 해주세요.'); window.location.href='Login.jsp';</script>");
    }
    if (promotion == null) {
%>
<form class="promotion__form" action="promotion" method="post">
    <input type="hidden" name="userID" value="<%=session.getAttribute("userID")%>">
    <label for="promotionName">제목</label>
    <input type="text" id="promotionName" name="promotionName" required>
    <label for="promotionClub">동아리명</label>
    <input type="text" id="promotionClub" name="promotionClub" required>
    <label for="promotionContents">본문</label>
    <textarea name="promotionContents" id="promotionContents" cols="30" rows="10" required></textarea>
    <input type="submit" value="작성">
</form>
<%} else {%>
<form class="promotion__form" action="promotionUpdate" method="post">
    <input type="hidden" name="promotionID" value="<%=promotion.getPromotionID()%>">
    <label for="updatePromotionName">제목</label>
    <input type="text" id="updatePromotionName" name="promotionName" value="<%=promotion.getPromotionName()%>" required>
    <label for="updatePromotionClub">동아리명</label>
    <input type="text" id="updatePromotionClub" name="promotionClub" value="<%=promotion.getPromotionClub()%>" required>
    <label for="updatePromotionContents">본문</label>
    <textarea name="promotionContents" id="updatePromotionContents" cols="30" rows="10" required><%=promotion.getPromotionContents()%></textarea>
    <input type="submit" value="작성">
</form>
<%}%>
<jsp:include page="Footer.jsp"/>
</body>
</html>
