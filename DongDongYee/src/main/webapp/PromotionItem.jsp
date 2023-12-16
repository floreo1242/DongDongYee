<%@ page import="domain.promotion.Promotion" %>
<%@ page import="domain.comment.Comment" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Promotion promotion = (Promotion) request.getAttribute("promotionItem");
    String sessionUserID = session.getAttribute("userID").toString();
    String promotionName = promotion.getPromotionName();
    String promotionID = promotion.getPromotionID().toString();
%>
<html>
<head>
    <link href="./css/globals.css" type="text/css" rel="stylesheet">
    <title><%=promotionName%>
    </title>
</head>
<body>
<jsp:include page="Header.jsp"/>
<div class="promotion-item__wrapper">
    <div class="promotion-item__title-bar">
        <h1 class="promotion-item__title"><%=promotionName%>
        </h1>
        <button class="promotion-item__button" onclick="window.location.href='ratinglist?club=<%=promotion.getPromotionClub()%>'">평가 보러가기</button>
    </div>
    <div class="promotion-item__info">
        <%=promotion.getUserNickname()%> | <%=promotion.getPromotionTime()%>
        <%if (sessionUserID.equals(promotion.getUserID())) {%>
        <div class="promotion-item__modify">
            <a href="promotionUpdate?id=<%=promotionID%>">수정</a>
            <a href="promotionDelete?id=<%=promotionID%>"
               onclick="return confirm('정말로 삭제하시겠습니까?')">삭제</a>

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
                    <input type="hidden" name="promotionID" value="<%=promotionID%>">
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
<jsp:include page="Footer.jsp"/>
</body>
</html>