<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- <link rel="stylesheet" href="./css/globals.css"> -->
<!-- <link rel="stylesheet" href="./css/Login.css"> -->
<title>평가 게시글 작성</title>
</head>
<body>
<div class="main-content">
<%--     <jsp:include page="Header.jsp"/> --%>
    <div class="center">
    <center>
    <h1>후기 작성</h1><br>
    
    <!--     1204에 기본 루트 폴더 이름 넣을 것 -->
    <form action="/1204/RatingPostServlet" method="post"> 
    	<h6>평가 제목</h6><br>
        <input type="text" id="RatingName" name="RatingName"/><br>
        
        <h6>동아리명</h6><br>
        <input type="text" id="RatingClub" name="RatingClub"/><br>
        
        <h6>동아리 활동으로 이런 것을 했어요</h6><br>
        <textarea id="RatingPlay" name="RatingPlay" cols="60" rows="30"></textarea><br>
        
 		<h6>이런 점이 좋았어요</h6><br>
        <textarea id="RatingGood" name="RatingGood" cols="60" rows="30"></textarea><br>
        
        <h6>이런 점이 아쉬웠어요</h6><br>
        <textarea id="RatingBad" name="RatingBad" cols="60" rows="30"></textarea><br>
        
        <input type="submit" value="작성">
	  </form>
	  
	  </center>
    </div>
</div>
<%-- <jsp:include page="Footer.jsp"/> --%>
</body>
</html>