<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="domain.rating.Rating" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Rating View</title>
</head>
<body>
    <%
        Rating rating = (Rating) request.getAttribute("rating");
    %>
    <div>
        <p><%= rating.getRatingName() %></p>
        <p><%= rating.getRatingClub() %></p>
        <p><%= rating.getUserId() %></p>
        <p><%= rating.getRatingPlay() %></p>
        <p><%= rating.getRatingGood() %></p>
        <p><%= rating.getRatingBad() %></p>
    </div>
</body>
</html>
