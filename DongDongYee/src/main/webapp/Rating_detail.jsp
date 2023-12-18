<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="domain.rating.Rating" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%
    Rating rating = (Rating) request.getAttribute("rating");
    String sessionUserID = session.getAttribute("userID").toString();
    String ratingName = rating.getRatingName();
    String ratingID = rating.getRatingID().toString();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd HH:mm");
    String ratingTime = simpleDateFormat.format(rating.getRatingTime());
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title><%=ratingName%>
    </title>
    <link rel="stylesheet" href="./css/globals.css">
    <link rel="stylesheet" href="css/PostItem.css">
</head>
<body>
<jsp:include page="Header.jsp"/>
<div class="item__wrapper">
    <div class="item__title-bar">
        <h1 class="item__title"><%=ratingName%>
        </h1>
    </div>
    <div class="item__info">
        <%=rating.getUserNickname()%> | <%=ratingTime%>
        <%if (sessionUserID.equals(rating.getUserID())) {%>
        <div class="item__modify">
            <a href="RatingModifyServlet?id=<%=ratingID%>">수정</a>
            <a href="RatingDeleteServlet?id=<%=ratingID%>"
               onclick="return confirm('정말로 삭제하시겠습니까?')">삭제</a>
        </div>
        <%}%>
    </div>
    <hr>
    <div class="item__main">
        <div>
            <h2 class="item__main__title">동아리 활동으로 이런 것을 했어요</h2>
            <pre class="item__main__content"><%=rating.getRatingPlay()%></pre>
        </div>
        <div>
            <h2 class="item__main__title">이런 점이 좋았어요</h2>
            <pre class="item__main__content"><%=rating.getRatingGood()%></pre>
        </div>
        <div>
            <h2 class="item__main__title">이런 점이 아쉬웠어요</h2>
            <pre class="item__main__content"><%=rating.getRatingBad()%></pre>
        </div>
    </div>
</div>
<jsp:include page="Footer.jsp"/>
</body>
</html>
