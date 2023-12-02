package domain.promotion.promotioncontroller;

import domain.promotion.PromotionReadDTO;
import domain.promotion.PromotionService;
import domain.promotion.PromotionPublishDTO;

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
        PromotionReadDTO promotionReadDTO = new PromotionReadDTO(Long.parseLong(request.getParameter("promotionID")));
//        TODO: service 구현 후 주석 제거
//        service.read(post);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PromotionPublishDTO promotionPublishDTO = new PromotionPublishDTO();
//         TODO: promotionID 로직 구현
//         post.setPromotionID();
        promotionPublishDTO.setUserID(request.getParameter("userID"));
        promotionPublishDTO.setPromotionName(request.getParameter("promotionName"));
        promotionPublishDTO.setPromotionContents(request.getParameter("promotionContents"));
        promotionPublishDTO.setPromotionClub(request.getParameter("promotionClub"));
//        TODO: service 구현 후 주석 제거
//        service.publish(post);
    }
}