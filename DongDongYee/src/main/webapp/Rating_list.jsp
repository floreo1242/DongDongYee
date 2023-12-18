<%@ page import="domain.rating.Rating" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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

    <title>후기 게시판</title>
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
    <div class="list">
        <div class="list__content">
            <ul>
                <%
                    List<Rating> ratingList = (List<Rating>) session.getAttribute("ratingList");
                    for (Rating rating : ratingList) {
                %>
                    <li>
                        <div class="list__item">
                            <div class="list__item__header">
                                <div>
                                    <a href="rating?id=<%=rating.getRatingID()%>"><%=rating.getRatingName()%></a>
                                    <span>&nbsp;| <%=rating.getUserNickname()%></span>
                                </div>
                                <span><%=new SimpleDateFormat("MM/dd HH:mm").format(rating.getRatingTime())%></span>
                            </div>
                            <div class="list__item__content">
                                <span><%=rating.getRatingClub()%></span>
                            </div>
                        </div>
                    </li>
                <%}%>
<%--                </c:forEach>--%>
            </ul>
        </div>
    </div>
</div>


<jsp:include page="Footer.jsp"/>
</body>
</html>

