package domain.promotion.promotioncontroller;

import domain.promotion.Promotion;
import domain.promotion.PromotionService;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/promotionUpdate")
public class PromotionUpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final PromotionService promotionService = new PromotionService();

    public PromotionUpdateServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
//        Promotion promotion = promotionService.read(Long.parseLong(request.getParameter("id")));
        Promotion promotion = new Promotion();
        promotion.setPromotionID(1L);
        promotion.setPromotionContents("haha");
        request.setCharacterEncoding("UTF-8");
        request.setAttribute("promotion", promotion);
        request.getRequestDispatcher("PromotionWrite.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        Promotion promotion = new Promotion();
        promotion.setPromotionID(Long.parseLong(request.getParameter("promotionID")));
        promotion.setPromotionName(request.getParameter("promotionName"));
        promotion.setPromotionContents(request.getParameter("promotionContents"));
        promotion.setPromotionClub(request.getParameter("promotionClub"));
//        TODO: UserID는 바뀌지 않으므로 null. service에서 id 로 찾아서 나머지만 변경
//        promotion = promotionService.update(promotion);
        response.sendRedirect("promotion?id=" + promotion.getPromotionID());
    }
}