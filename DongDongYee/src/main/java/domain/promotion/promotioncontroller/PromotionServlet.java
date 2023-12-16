package domain.promotion.promotioncontroller;

import domain.comment.Comment;
import domain.comment.CommentService;
import domain.promotion.Promotion;
import domain.promotion.PromotionService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/promotion")
public class PromotionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final PromotionService promotionService = new PromotionService();
    private final CommentService commentService = new CommentService();

    public PromotionServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        Promotion promotion = new Promotion(Long.parseLong(request.getParameter("id")));
//        TODO: service 구현 후 주석 제거
//        promotion = promotionService.read(promotion);
//        FIXME: 테스트용 comment
        Comment comment1 = new Comment("1", promotion.getPromotionID(), "HaHa 나다.");
        Comment comment2 = new Comment("2", promotion.getPromotionID(), "Hello World");
        Comment comment3 = new Comment("3", promotion.getPromotionID(), "End of Comment");
        List<Comment> commentList = new ArrayList<>();
        commentList.add(comment1);
        commentList.add(comment2);
        commentList.add(comment3);
//        TODO: service 구현 후 주석 제거
//        commentList = commentService.read(comment);
        request.setCharacterEncoding("UTF-8");
        request.setAttribute("promotionItem", promotion);
        request.setAttribute("commentList", commentList);
        request.getRequestDispatcher("PromotionItem.jsp?id=" + promotion.getPromotionID()).forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        Promotion promotion = new Promotion();
        promotion.setUserID(request.getParameter("userID"));
        promotion.setPromotionName(request.getParameter("promotionName"));
        promotion.setPromotionContents(request.getParameter("promotionContents"));
        promotion.setPromotionClub(request.getParameter("promotionClub"));
//        TODO: service 구현 후 주석 제거
//        promotion = service.publish(promotion);
        response.sendRedirect("promotion?id=" + promotion.getPromotionID());
    }
}