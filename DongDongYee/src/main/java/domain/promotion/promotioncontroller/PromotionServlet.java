package domain.promotion.promotioncontroller;

import domain.promotion.Promotion;
import domain.promotion.PromotionService;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/domain.promotion.postcontroller.JoinServlet")
public class PromotionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final PromotionService service = new PromotionService();

    public PromotionServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        Promotion promotion = new Promotion(Long.parseLong(request.getParameter("promotionID")));
//        TODO: service 구현 후 주석 제거
//        service.read(post);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        Promotion promotion = new Promotion();
//         TODO: promotionID 로직 구현
//         post.setPromotionID();
        promotion.setUserID(request.getParameter("userID"));
        promotion.setPromotionName(request.getParameter("promotionName"));
        promotion.setPromotionContents(request.getParameter("promotionContents"));
        promotion.setPromotionClub(request.getParameter("promotionClub"));
//        TODO: service 구현 후 주석 제거
//        service.publish(post);
    }
}