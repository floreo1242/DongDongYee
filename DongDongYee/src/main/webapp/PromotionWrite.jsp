<%@ page import="domain.promotion.Promotion" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Promotion promotion = (Promotion) request.getAttribute("promotion");
%>
<html>
<head>
    <link href="./css/globals.css" type="text/css" rel="stylesheet">
    <title>홍보 게시판</title>
</head>
<body>
<jsp:include page="Header.jsp"/>
<%if (promotion == null) {%>
<form class="promotion__form" action="promotion" method="post">
    <input type="hidden" name="userID" value="<%=session.getAttribute("userID")%>">
    <label for="promotionName">제목</label>
    <input type="text" id="promotionName" name="promotionName">
    <label for="promotionClub">동아리명</label>
    <input type="text" id="promotionClub" name="promotionClub">
    <label for="promotionContents">본문</label>
    <textarea name="promotionContents" id="promotionContents" cols="30" rows="10"></textarea>
    <input type="submit" value="작성">
</form>
<%} else {%>
<form class="promotion__form" action="promotionUpdate" method="post">
    <input type="hidden" name="promotionID" value="<%=promotion.getPromotionID()%>">
    <label for="updatePromotionName">제목</label>
    <input type="text" id="updatePromotionName" name="promotionName" value="<%=promotion.getPromotionName()%>">
    <label for="updatePromotionClub">동아리명</label>
    <input type="text" id="updatePromotionClub" name="promotionClub" value="<%=promotion.getPromotionClub()%>">
    <label for="updatePromotionContents">본문</label>
    <textarea name="promotionContents" id="updatePromotionContents" cols="30" rows="10"><%=promotion.getPromotionContents()%></textarea>
    <input type="submit" value="작성">
</form>
<%}%>
<jsp:include page="Footer.jsp"/>
</body>
</html>
