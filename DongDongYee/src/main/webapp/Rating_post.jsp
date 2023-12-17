<%@ page import="domain.rating.Rating" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%Rating rating = (Rating) request.getAttribute("rating");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/globals.css">
<link href="./css/write.css" type="text/css" rel="stylesheet">
<title>평가 게시글 작성</title>
</head>
<body>
<jsp:include page="Header.jsp"/>
<%
    if (session.getAttribute("userID") == null) {
        response.getWriter().println("<script>alert('세션이 만료되었습니다. 다시 로그인 해주세요.'); window.location.href='Login.jsp';</script>");
    }
    if (rating == null) {
%>
<div class="main-content">
    <div class="center">
    <form action="ratinglist" method="post" class="promotion__form">
    	<div class="cate">평가 제목</div><br>
        <input type="text" id="RatingName" name="RatingName" required/><br>
        <div class="cate">동아리명</div><br>
        <input type="text" id="RatingClub" name="RatingClub" required/><br>
       <div class="cate">동아리 활동으로 이런 것을 했어요</div><br>
        <textarea id="RatingPlay" name="RatingPlay" cols="30" rows="10" required></textarea><br>
 		<div class="cate">이런 점이 좋았어요</div><br>
        <textarea id="RatingGood" name="RatingGood" cols="30" rows="10" required></textarea><br>
        <div class="cate">이런 점이 아쉬웠어요</div><br>
        <textarea id="RatingBad" name="RatingBad" cols="30" rows="10" required></textarea><br>
        <input type="submit" value="작성">
	  </form>
    </div>
</div>
<%} else {%>
<div class="main-content">
    <div class="center">
        <form action="RatingModifyServlet" method="post" class="promotion__form">
            <input type="hidden" name="RatingID" value="<%=rating.getRatingID()%>">
            <div class="cate">평가 제목</div><br>
            <input type="text" id="updateRatingName" name="RatingName" value="<%=rating.getRatingName()%>" required/><br>
            <div class="cate">동아리명</div><br>
            <input type="text" id="updateRatingClub" name="RatingClub" value="<%=rating.getRatingClub()%>" required/><br>
            <div class="cate">동아리 활동으로 이런 것을 했어요</div><br>
            <textarea id="updateRatingPlay" name="RatingPlay" cols="30" rows="10" required><%=rating.getRatingPlay()%></textarea><br>
            <div class="cate">이런 점이 좋았어요</div><br>
            <textarea id="updateRatingGood" name="RatingGood" cols="30" rows="10" required><%=rating.getRatingGood()%></textarea><br>
            <div class="cate">이런 점이 아쉬웠어요</div><br>
            <textarea id="updateRatingBad" name="RatingBad" cols="30" rows="10" required><%=rating.getRatingBad()%></textarea><br>
            <input type="submit" value="작성">
        </form>

    </div>
</div>
<%}%>
    <jsp:include page="Footer.jsp"/>
</body>
</html>