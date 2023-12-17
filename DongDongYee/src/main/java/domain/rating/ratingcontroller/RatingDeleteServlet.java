package domain.rating.ratingcontroller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.rating.RatingService;


@WebServlet("/RatingDeleteServlet")
public class RatingDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 	RatingService ratingService = new RatingService();

   
    public RatingDeleteServlet() {
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
		ratingService.delete(Long.parseLong(request.getParameter("id")));
		response.sendRedirect("ratinglist");
	}
}
