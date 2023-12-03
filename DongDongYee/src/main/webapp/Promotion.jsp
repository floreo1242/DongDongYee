<%@ page import="java.util.List" %>
<%@ page import="domain.promotion.Promotion" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/globals.css">
    <link rel="stylesheet" href="css/Promotion.css">
    <title>홍보 게시판</title>
</head>
<body>
<jsp:include page="Header.jsp"/>
<div class="board-wrapper">
    <div class="board__header">
        <button class="board__write">글작성</button>
        <div class="board__search-wrapper">
            <button class="board__search-button">Search</button>
            <input type="search" class="board__search-input">
        </div>
    </div>
    <div class="board">
        <div class="board__content">
            <%
                List<Promotion> boardList = (List<Promotion>) request.getAttribute("boardList");
                for (Promotion post : boardList) {
                    out.print(post.getPromotionID() + "<br>");
                    out.print(post.getPromotionName() + "<br>");
                    out.print(post.getPromotionContents() + "<br>");
                    out.print(post.getPromotionClub() + "<br>");
                }

            %>
        </div>
    </div>
</div>
<jsp:include page="Footer.jsp"/>
</body>
</html>
