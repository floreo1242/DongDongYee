package domain.rating.ratingcontroller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import domain.rating.*;

import domain.rating.RatingService;

@WebServlet("/RatingModifyServlet")
public class RatingModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 	RatingService ratingService = new RatingService();

   
    public RatingModifyServlet() {
        super();
        // TODO Auto-generated constructor stub
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
        Rating rating = ratingService.read(Long.parseLong(request.getParameter("id")));
        request.setAttribute("rating", rating);
        request.getRequestDispatcher("Rating_post.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        if (session.getAttribute("userID") == null) {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().println("<script>alert('세션이 만료되었습니다. 다시 로그인 해주세요.'); window.location.href='Login.jsp';</script>");
            return;
        }
        Rating rating = new Rating();
        rating.setRatingID(Long.parseLong(request.getParameter("RatingID")));
        rating.setRatingName(request.getParameter("RatingName"));
        rating.setRatingClub(request.getParameter("RatingClub"));
        rating.setRatingPlay(request.getParameter("RatingPlay"));
        rating.setRatingGood(request.getParameter("RatingGood"));
        rating.setRatingBad(request.getParameter("RatingBad"));
        ratingService.update(rating);
        response.sendRedirect("rating?id=" + rating.getRatingID());

	}

}
