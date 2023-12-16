package domain.rating.ratingcontroller;

import java.util.ArrayList;
import java.util.Collections;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import domain.rating.*;


@WebServlet("/RatingPostServlet")
public class RatingPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 	RatingService ratingService = new RatingService();

    public RatingPostServlet() {
        super();
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		HttpSession session=request.getSession();
		String club = request.getParameter("club");
		
//		if(club!=null) {
//			ArrayList<Rating> searchratingList=(ArrayList<Rating>)ratingService.getRatingsByPromotionName(club);
//			Collections.reverse(searchratingList);
//			session.setAttribute("ratingList", searchratingList);
//	        request.getRequestDispatcher("/Rating_list.jsp").forward(request, response);
//			
//		}
//
//		else{
			
		ArrayList<Rating> ratingList = (ArrayList<Rating>) ratingService.getAllRatings();
  
    	Collections.reverse(ratingList);
        
		session.setAttribute("ratingList", ratingList);

        request.getRequestDispatcher("/Rating_list.jsp").forward(request, response);
		
//	}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession session=request.getSession();
			

			request.setCharacterEncoding("utf-8");
			String userID = (String)session.getAttribute("userID");
		  
		  String ratingName = request.getParameter("RatingName");
	      String ratingClub = request.getParameter("RatingClub");
	      String ratingPlay = request.getParameter("RatingPlay");
	      String ratingGood = request.getParameter("RatingGood");
	      String ratingBad = request.getParameter("RatingBad");
	      
	      Rating rating=new Rating();
	      
	      rating.setUserID(userID);
	      rating.setRatingName(ratingName);
	      rating.setRatingClub(ratingClub);
	      rating.setRatingPlay(ratingPlay);
	      rating.setRatingGood(ratingGood);
	      rating.setRatingBad(ratingBad);
	      
		  ratingService.publish(rating);
  }
}
