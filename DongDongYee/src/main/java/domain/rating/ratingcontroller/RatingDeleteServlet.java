package domain.rating.ratingcontroller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.rating.RatingService;


@WebServlet("/RatingDeleteServlet")
public class RatingDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 	RatingService ratingService = new RatingService();

   
    public RatingDeleteServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		 long ratingID = Long.parseLong(request.getParameter("ratingID"));
		 ratingService.delete(ratingID);
	     response.sendRedirect("Rating_list.jsp");
	}
}
