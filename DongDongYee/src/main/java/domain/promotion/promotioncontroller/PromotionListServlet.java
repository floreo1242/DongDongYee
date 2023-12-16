package domain.promotion.promotioncontroller;

import domain.promotion.Promotion;

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

    public PromotionListServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
//        세션 검사
        if (session.getAttribute("userID") == null) {
            response.sendRedirect("Login.jsp");
            return;
        }
        String query = request.getParameter("search");
        List<Promotion> promotionList = new ArrayList<>();
        // FIXME: 테스트용 임시 boardList
        promotionList.add(new Promotion(1L, "제목", "내용", "동아리"));
        promotionList.add(new Promotion(2L, "제목", "내용", "동아리"));
        promotionList.add(new Promotion(3L, "제목", "내용", "동아리"));
        promotionList.add(new Promotion(4L, "제목", "내용", "동아리"));
        // TODO: 게시글리스트 불러와서 boardList에 저장
        request.setAttribute("promotionList", promotionList);
        request.getRequestDispatcher("Promotion.jsp").forward(request, response);
    }
}