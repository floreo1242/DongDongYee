package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Controller.CheckNicknameServlet")
public class CheckNicknameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String nickname = request.getParameter("nickname");

			if (isEmailTaken(nickname)) {
				response.getWriter().write("taken");
			} else {
				response.getWriter().write("available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().write("error");
		}
	}

	private boolean isEmailTaken(String nickname) {
		// 닉네임 중복체크
		return !nickname.equals("동동이");
//		return false;
	}
}
