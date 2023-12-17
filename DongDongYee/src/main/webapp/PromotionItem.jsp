<%@ page import="domain.promotion.Promotion" %>
<%@ page import="domain.comment.Comment" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Promotion promotion = (Promotion) request.getAttribute("promotionItem");
    String sessionUserID = session.getAttribute("userID").toString();
    String promotionName = promotion.getPromotionName();
    String promotionClub = promotion.getPromotionClub();
    String promotionID = promotion.getPromotionID().toString();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd HH:mm");
    String promotionTime = simpleDateFormat.format(promotion.getPromotionTime());
%>
<html>
<head>
    <link href="./css/globals.css" type="text/css" rel="stylesheet">
    <link href="css/PostItem.css" type="text/css" rel="stylesheet">
    <title><%=promotionName%>
    </title>
</head>
<body>
<jsp:include page="Header.jsp"/>
<div class="item__wrapper">
    <div class="item__title-bar">
        <h1 class="item__title"><%=promotionName%>
        </h1>
        <button class="item__button"
                onclick="window.location.href='ratinglist?club=<%=promotionClub%>'"><%=promotionClub%> 후기 보러가기
        </button>
    </div>
    <div class="item__info">
        <%=promotion.getUserNickname()%> | <%=promotionTime%>
        <%if (sessionUserID.equals(promotion.getUserID())) {%>
        <div class="item__modify">
            <a href="promotionUpdate?id=<%=promotionID%>">수정</a>
            <a href="promotionDelete?id=<%=promotionID%>"
               onclick="return confirm('정말로 삭제하시겠습니까?')">삭제</a>
        </div>
        <%}%>
    </div>
    <hr>
    <div class="item__main">
        <pre><%=promotion.getPromotionContents()%></pre>
    </div>
    <hr>
    <div class="item__footer">
        <div class="item__comment">
            <div class="item__comment__form-wrapper">
                <form action="CommentServlet" class="item__comment__form" method="post">
                    <input type="hidden" name="userID" value="<%=sessionUserID%>">
                    <input type="hidden" name="promotionID" value="<%=promotionID%>">
                    <div>
                        <input type="text" name="comment" placeholder="댓글을 입력하세요.">
                        <input type="submit" value="작성">
                    </div>
                </form>
            </div>
            <div class="item__comment__content">
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
                        <div>
                            <%=comment.getCommentContents()%>
                            <%if (comment.getUserID().equals(sessionUserID)) {%>
                            <a href="CommentDelete?commentID=<%=comment.getCommentID()%>&&promotionID=<%=promotionID%>"
                               onclick="return confirm('정말로 삭제하시겠습니까?')">삭제</a>
                            <%}%>
                        </div>
                        <div>
                            <%=comment.getUserNickname()%> | <%=simpleDateFormat.format(comment.getCommentTime())%>
                        </div>
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