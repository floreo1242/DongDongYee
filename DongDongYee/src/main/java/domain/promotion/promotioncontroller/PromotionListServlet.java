package domain.promotion.promotioncontroller;

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
import javax.servlet.http.HttpSession;

@WebServlet("/promotionlist")
public class PromotionListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final PromotionService promotionService = new PromotionService();

    public PromotionListServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
//        뒤로가기 시 업데이트를 위해 캐시 사용 안함
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Expires", "0");
        HttpSession session = request.getSession();
//        세션 검사
        if (session.getAttribute("userID") == null) {
            response.sendRedirect("Login.jsp");
            return;
        }
        String query = request.getParameter("search");
        List<Promotion> promotionList = promotionService.getAllPromotions();
        if (query != null && !query.isEmpty()) {
//            검색어가 있으면
            List<Promotion> filteredPromotions = new ArrayList<>();
            for (Promotion promotion : promotionList) {
                if (promotion.getPromotionName().toLowerCase().contains(query)) {
                    filteredPromotions.add(promotion);
                }
            }
            promotionList = filteredPromotions;
        }
        request.setAttribute("promotionList", promotionList);
        request.getRequestDispatcher("Promotion.jsp").forward(request, response);
    }
}