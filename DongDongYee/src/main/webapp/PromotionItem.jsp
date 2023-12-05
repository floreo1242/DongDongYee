<%@ page import="domain.promotion.Promotion" %>
<%@ page import="domain.comment.Comment" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Promotion promotion = (Promotion) request.getAttribute("promotionItem");
    session.setAttribute("userID", "12312");
    String sessionUserID = session.getAttribute("userID").toString();
%>
<html>
<head>
    <title><%=promotion.getPromotionName()%>
    </title>
</head>
<body>
<div class="promotion-item__wrapper">
    <div class="promotion-item__title-bar">
        <h1 class="promotion-item__title"><%=promotion.getPromotionName()%>
        </h1>
        <button class="promotion-item__button"><a href="">평가 보러가기</a></button>
    </div>
    <div class="promotion-item__info">
        <%=promotion.getUserNickname()%> | <%=promotion.getPromotionTime()%>
        <%if (sessionUserID.equals(promotion.getUserID())) {%>
        <div class="promotion-item__modify">
            <a href="">수정</a>
            <a href="">삭제</a>
        </div>
        <%}%>
    </div>
    <div class="promotion-item__main">
        <%=promotion.getPromotionContents()%>
    </div>
    <hr>
    <div class="promotion-item__footer">
        <div class="promotion-item__">

        </div>
        <div class="promotion-item__comment">
            <div class="promotion-item__comment__form-wrapper">
                <form action="CommentServlet" class="promotion-item__comment__form" method="post">
                    <input type="hidden" name="userID" value="<%=sessionUserID%>>">
                    <input type="hidden" name="promotionID" value="<%=promotion.getPromotionID()%>">
                    <input type="text" name="comment" placeholder="댓글을 입력하세요.">
                    <input type="submit" value="작성">
                </form>
            </div>
            <div class="promotion-item__comment__content">
                <ul>
                    <%
                        List<Comment> commentList = (List<Comment>) request.getAttribute("commentList");
                        if (commentList == null) {
                    %>
                    <%
                    } else {
                        for (Comment comment : commentList) {
                    %>
                    <li class="comment__item">
                        <%=comment.getCommentContents()%>
                    </li>
                    <%
                            }
                        }
                    %>
                </ul>
            </div>
        </div>
    </div>
</div>
</body>
</html>