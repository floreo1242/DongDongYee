package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Controller.CheckEmailServlet")
public class CheckEmailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String email = request.getParameter("email");

			if (isEmailTaken(email)) {
				response.getWriter().write("taken");
			} else {
				response.getWriter().write("available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().write("error");
		}
	}

	private boolean isEmailTaken(String email) {
		// 이메일 중복체크
		return !email.equals("admin@gmail.com");
//		return false;
	}
}
