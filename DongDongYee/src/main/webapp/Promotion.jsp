<%@ page import="java.util.List" %>
<%@ page import="domain.promotion.Promotion" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String query = request.getParameter("search");
    if (query == null) {
        query = "";
    }
%>
<html>
<head>
    <link rel="stylesheet" href="css/globals.css">
    <link rel="stylesheet" href="css/List.css">
    <title>홍보 게시판</title>
</head>
<body>
<jsp:include page="Header.jsp"/>
<div class="list-wrapper">
    <div class="list__header">
        <button class="list__write" onclick="window.location.href='PromotionWrite.jsp'">글작성</button>
        <div class="list__search-wrapper">
            <form action="promotionlist" method="get">
                <button class="list__search-button">Search</button>
                <input type="search" class="list__search-input" name="search" value="<%=query%>" placeholder="제목 검색">
            </form>
        </div>
    </div>
    <div class="list__content">
        <ul>
            <%
                List<Promotion> promotionList = (List<Promotion>) request.getAttribute("promotionList");
                for (Promotion promotion : promotionList) {
                    String promotionContents = promotion.getPromotionContents();
            %>
            <li>
                <div class="list__item">
                    <div class="list__item__header">
                        <a href="promotion?id=<%=promotion.getPromotionID()%>"><%=promotion.getPromotionName()%></a>
                        <span><%=promotion.getPromotionClub()%></span>
                    </div>
                    <div class="list__item__content">
                        <%if (promotionContents.length() > 30) {%>
                        <%=promotionContents.substring(0, 30) + "..."%>
                        <%} else {%>
                        <%=promotionContents%>
                        <%}%>
                    </div>
                </div>
            </li>
            <%
                }
            %>
        </ul>
    </div>
</div>
<jsp:include page="Footer.jsp"/>
</body>
</html>
