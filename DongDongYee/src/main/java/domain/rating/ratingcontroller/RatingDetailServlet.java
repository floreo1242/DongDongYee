package domain.rating.ratingcontroller;

import java.util.ArrayList;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.rating.*;
import java.sql.*;
import java.lang.Long;



@WebServlet("/RatingDetailServlet")
public class RatingDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 	RatingService ratingService = new RatingService();

    public RatingDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");

		HttpSession session=request.getSession();
		request.setCharacterEncoding("utf-8");
		/* String userID = (String)session.getAttribute("userID"); */   	
		long ratingID = Long.parseLong(request.getParameter("ratingID"));

		Rating rating = ratingService.read(ratingID);
		request.setAttribute("rating", rating);
        request.getRequestDispatcher("/Rating_detail.jsp").forward(request, response);    	
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
	     
	}
}
