package domain.promotion.promotioncontroller;

import domain.promotion.Promotion;
import domain.promotion.PromotionService;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/promotionDelete")
public class PromotionDeleteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final PromotionService promotionService = new PromotionService();

    public PromotionDeleteServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        if (session.getAttribute("userID") == null) {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().println("<script>alert('세션이 만료되었습니다. 다시 로그인 해주세요.'); window.location.href='Login.jsp';</script>");
            return;
        }
        promotionService.delete(Long.parseLong(request.getParameter("id")));
        response.sendRedirect("promotionlist");
    }
}