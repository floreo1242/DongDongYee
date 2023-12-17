<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<div class="main-content">
    <div class="center">
    <form action="ratinglist" method="post" class="promotion__form"> 
    	<div class="cate">평가 제목</div><br>
        <input type="text" id="RatingName" name="RatingName"/><br>
        
        <div class="cate">동아리명</div><br>
        <input type="text" id="RatingClub" name="RatingClub"/><br>
        
       <div class="cate">동아리 활동으로 이런 것을 했어요</div><br>
        <textarea id="RatingPlay" name="RatingPlay" cols="30" rows="10"></textarea><br>
        
 		<div class="cate">이런 점이 좋았어요</div><br>
        <textarea id="RatingGood" name="RatingGood" cols="30" rows="10"></textarea><br>
        
        <div class="cate">이런 점이 아쉬웠어요</div><br>
        <textarea id="RatingBad" name="RatingBad" cols="30" rows="10"></textarea><br>
        
        <input type="submit" value="작성">
	  </form>
	  
    </div>
</div>
    <jsp:include page="Footer.jsp"/>
</body>
</html>