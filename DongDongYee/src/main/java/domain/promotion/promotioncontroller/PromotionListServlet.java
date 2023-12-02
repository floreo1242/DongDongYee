package domain.promotion.promotioncontroller;

import domain.promotion.PromotionListDTO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PromotionListServlet")
public class PromotionListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public PromotionListServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        List<PromotionListDTO> boardList = new ArrayList<>();
        // FIXME: 테스트용 임시 boardList
        boardList.add(new PromotionListDTO(1L, "제목", "내용", "동아리"));
        int page = Integer.parseInt(request.getParameter("page"));
        // TODO: 게시글리스트 불러와서 boardList에 저장
        request.setAttribute("boardList", boardList);
        request.getRequestDispatcher("Promotion.jsp").forward(request, response);
    }
}