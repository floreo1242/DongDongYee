<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="domain.rating.Rating" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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

<%
	String club = request.getParameter("club");
%>

   <div class="list-wrapper">
   <button class="list__write" onclick="window.location.href='Rating_post.jsp'">글작성</button>
   
	<c:forEach var="rating" items="${sessionScope.ratingList}">
		   		 <div class=itembox >
			   		<div class="name-nickname-wrapper">
			   		<p id=ratingname><a href="RatingDetailServlet?ratingID=${rating.ratingID}">${rating.ratingName}</a></p]>
			   		
			         <div id=nickname>${rating.userNickname}</div>
			        </div>
		        <p id=ratingclub>평가 동아리:   ${rating.ratingClub}</p>
		        </div>
	</c:forEach>
	
	

    </div>
	
    
    <jsp:include page="Footer.jsp"/>
</body>
</html>

