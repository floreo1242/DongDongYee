<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- <link rel="stylesheet" href="./css/globals.css"> -->
<!-- <link rel="stylesheet" href="./css/Login.css"> -->
<title>동아리 후기 리스트</title>
</head>
<body>
    <%
        ArrayList<Rating> ratingList = (ArrayList<Rating>) request.getAttribute("ratingList");
        for(Rating rating : ratingList) {
    %>
        <div>
            <a href="RatingViewServlet?ratingId=<%= rating.getRatingId() %>"><%= rating.getRatingName() %></a>
            <p><%= rating.getRatingClub() %></p>
            <p><%= rating.getRatingPlay() %></p>
        </div>
    <% } %>
</body>
</html>