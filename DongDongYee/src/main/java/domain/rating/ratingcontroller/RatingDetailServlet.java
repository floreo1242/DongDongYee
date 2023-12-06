package domain.rating.ratingcontroller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import domain.rating.*;
import java.sql.*;


@WebServlet("/RatingDetailServlet")
public class RatingDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RatingDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        //db에 있는 rating 객체 모두를 배열로 반환하는 getRating함수
 		RatingService ratingService = new RatingService();
		ArrayList<Rating> ratingList=ratingService.getRatings();

        request.setAttribute("ratingList", ratingList);

        request.getRequestDispatcher("/Rating_detail.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
	     
	}
}
