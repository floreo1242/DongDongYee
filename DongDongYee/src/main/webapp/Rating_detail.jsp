<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="domain.rating.Rating" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Rating View</title>
<link rel="stylesheet" href="./css/globals.css">
<link rel="stylesheet" href="./css/write.css">
<link rel="stylesheet" href="./css/List.css">

</head>
<body>
<jsp:include page="Header.jsp"/>
<div class="list-wrapper">
	<form action="RatingModifyServlet" method="post" class="ratingread">
	    <input type="hidden" name="ratingID" value="${rating.ratingID}">
	    <p>글 제목 | <input type="text" name="ratingName" id=ratingName value="${rating.ratingName}"></p>
	    
	    <p>글 작성자| ${rating.userNickname}</p>
	    <p>작성시간 | ${rating.ratingTime}</p>
	    <p>평가 동아리 | <input type="text" name="ratingClub" id=ratingClub value="${rating.ratingClub}"></p>
	    <p>동아리 활동내용</p>
	    <input type="text" name="ratingPlay" id=ratingPlay value="${rating.ratingPlay}"></input>
	    <p>동아리 활동 중 좋았던 점</p>
	    <input type="text" name="ratingGood" id=ratingGood value="${rating.ratingGood}"></input>
	    <p>동아리 활동 중 아쉬웠던 점</p>
		<input type="text" name="ratingBad" id=ratingBad value="${rating.ratingBad}"></input>
	    <%
	    String userID = (String)session.getAttribute("userID");
	    Rating rating = (Rating)request.getAttribute("rating");
	    if(rating != null && userID != null) {
	        String writerID = rating.getUserID();
	        if(userID.equals(writerID)) {
	    %>
	    <div class="button_wrap">
	    <br><button type="submit">수정</button>
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
	</div>
</div>
    <jsp:include page="Footer.jsp"/>

</body>
</html>
