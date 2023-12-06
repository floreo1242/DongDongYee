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
		
		//db에 있는 rating 객체 모두를 배열로 반환하는 getRating함수
 		RatingService ratingService = new RatingService();
		ArrayList<Rating> ratingList=ratingService.getRatings();

        request.setAttribute("ratingList", ratingList);
        request.getRequestDispatcher("/Rating_list.jsp").forward(request, response);
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
	      
		  // 객체 rating에 설정된 변수들을 db에 저장해주는 기능을 하는 saveRating
		  RatingService ratingService = new RatingService();
    	  ratingService.saveRating(rating);

	}
}
