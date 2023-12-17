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

<title>후기 게시판</title>
</head>
<body>
<jsp:include page="Header.jsp"/>

<%
	String club = request.getParameter("club");
%>

   <div class="list-wrapper">
       <div class="list__header">
   	<button class="list__write" onclick="window.location.href='Rating_post.jsp'">글작성</button>
	</div>
	<div class="list">
	        <div class="list__content">
	<ul>
	<c:forEach var="rating" items="${sessionScope.ratingList}">
		   		 <li>
                    <div class="list__item">
	                    <div class="list__item__header">
				   		<a href="RatingDetailServlet?ratingID=${rating.ratingID}">${rating.ratingName}</a>
				         <span>${rating.userNickname}</span>
				        </div>
				        <div class="list__item__content">
				        	<span>평가 동아리|   ${rating.ratingClub}</span>
				        </div>
				      </div>
				 	</li>
	</c:forEach>
	</ul>
	</div>
	</div>
	</div>
		
    
    <jsp:include page="Footer.jsp"/>
</body>
</html>

