package domain.user.usercontroller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.user.UserService;

@WebServlet("/domain.user.usercontroller.CheckIdServlet")
public class CheckIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService service = new UserService();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String id = request.getParameter("id");

			if (service.isIdTaken(id) == 1) {
				response.getWriter().write("taken");
			} else {
				response.getWriter().write("available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().write("error");
		}
	}
}
