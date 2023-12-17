<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="domain.rating.Rating" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String query = request.getParameter("club");
    if (query == null) {
        query = "";
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="./css/globals.css">
    <link rel="stylesheet" href="./css/List.css">
    <title>동아리 후기 리스트</title>
</head>
<body>
<jsp:include page="Header.jsp"/>
<div class="list-wrapper">
    <div class="list__header">
        <button class="list__write" onclick="window.location.href='Rating_post.jsp'">글작성</button>
        <div class="list__search-wrapper">
            <form action="ratinglist" method="get">
                <button class="list__search-button">Search</button>
                <input type="search" class="list__search-input" name="club" value="<%=query%>" placeholder="동아리 검색">
            </form>
        </div>
    </div>
    <div class="list__content">
        <ul>
            <c:forEach var="rating" items="${sessionScope.ratingList}">
                <li>
                    <div class="list__item">
                        <div class="list__item__header">
                            <a href="rating?id=${rating.ratingID}">${rating.ratingName}</a>
                            <span>${rating.userNickname}</span>
                        </div>
                        <div class="list__item__content">
                            평가 동아리: ${rating.ratingClub}
                        </div>
                    </div>
                </li>
            </c:forEach>
        </ul>
    </div>
</div>


<jsp:include page="Footer.jsp"/>
</body>
</html>

