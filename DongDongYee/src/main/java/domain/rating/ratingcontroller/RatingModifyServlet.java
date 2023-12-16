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

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String ratingID = request.getParameter("ratingID");
        Rating updatedRating = ratingService.read(Long.parseLong(ratingID));
        
        
        String ratingName = request.getParameter("ratingName");
        String ratingClub = request.getParameter("ratingClub");
        String ratingPlay = request.getParameter("ratingPlay");
        String ratingGood = request.getParameter("ratingGood");
        String ratingBad = request.getParameter("ratingBad");
        
        updatedRating.setRatingName(ratingName);
        updatedRating.setRatingClub(ratingClub);
        updatedRating.setRatingPlay(ratingPlay);
        updatedRating.setRatingGood(ratingGood);
        updatedRating.setRatingBad(ratingBad);
        		    
        ratingService.update(updatedRating);

	}

}
