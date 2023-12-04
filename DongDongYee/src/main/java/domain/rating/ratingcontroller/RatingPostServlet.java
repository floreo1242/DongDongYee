package domain.rating.ratingcontroller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import domain.rating.*;
import java.sql.*;


@WebServlet("/RatingPostServlet")
public class RatingPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RatingPostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  String ratingName = request.getParameter("RatingName");
	      String ratingClub = request.getParameter("RatingClub");
	      String ratingPlay = request.getParameter("RatingPlay");
	      String ratingGood = request.getParameter("RatingGood");
	      String ratingBad = request.getParameter("RatingBad");
	      
	      Rating rating=new Rating();
	      
	      rating.setRatingName(ratingName);
	      rating.setRatingClub(ratingClub);
	      rating.setRatingPlay(ratingPlay);
	      rating.setRatingGood(ratingGood);
	      rating.setRatingBad(ratingBad);
	      

	}
}
