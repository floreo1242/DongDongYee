<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="domain.rating.Rating" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Rating View</title>
</head>
<body>
<form action="RatingModifyServlet" method="post">
    <input type="hidden" name="ratingID" value="${rating.ratingID}">
    Title: <input type="text" name="ratingName" id=ratingName value="${rating.ratingName}">
    Nickname: ${rating.userNickname}
    Time: ${rating.ratingTime}
    Club: <input type="text" name="ratingClub" id=ratingClub value="${rating.ratingClub}"></input>
    Play: <input type="text" name="ratingPlay" id=ratingPlay value="${rating.ratingPlay}"></input>
    Good: <input type="text" name="ratingGood" id=ratingGood value="${rating.ratingGood}"></input>
    Bad: <input type="text" name="ratingBad" id=ratingBad value="${rating.ratingBad}"></input>
    <%
    String userID = (String)session.getAttribute("userID");
    Rating rating = (Rating)request.getAttribute("rating");
    if(rating != null && userID != null) {
        String writerID = rating.getUserID();
        if(userID.equals(writerID)) {
    %>
    <button type="submit">수정</button>
    <% 
        }
    }
    %>
</form>

<form action="RatingDeleteServlet" method="post">
    <input type="hidden" name="ratingID" value="${rating.ratingID}">
    <%
    if(rating != null && userID != null) {
        String writerID = rating.getUserID();
        if(userID.equals(writerID)) {
    %>
    <button type="submit">삭제</button>
    <% 
        }
    }
    %>
</form>
</body>
</html>
