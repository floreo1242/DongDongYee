<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="domain.rating.Rating" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
	String club = request.getParameter("club");
%>

    <h1>Rating List</h1>
    <table border="1">
        <tr>
            <th>RatingID</th>
            <th>UserNickname</th>
            <th>RatingName</th>
            <th>RatingClub</th>
            <th>RatingPlay</th>
            <th>RatingTime</th>
        </tr>
        
	<c:forEach var="rating" items="${sessionScope.ratingList}">
		    <tr>
		        <td>${rating.ratingID}</td>
		        <td>${rating.userNickname}</td>
		        <td><a href="RatingDetailServlet?ratingID=${rating.ratingID}">${rating.ratingName}</a></td>
		        <td>${rating.ratingName}</td>
		        <td>${rating.ratingClub}</td>
		        <td>${rating.ratingPlay}</td>
		        <td>${rating.ratingTime}</td>
		    </tr>
			</c:forEach>

    </table>
    <a href="Rating_post.jsp">글 쓰기</a>
     <script>
     	window.onload = function() {
         location.href = 'RatingPostServlet?club=<%=club%>';
     }
    </script>
</body>
</html>