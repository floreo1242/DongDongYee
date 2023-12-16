package domain.user.usercontroller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.user.User;
import domain.user.UserService;

@WebServlet("/domain.user.usercontroller.JoinServlet")
public class JoinServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private User user = new User();
    private UserService service = new UserService();

    public JoinServlet() {
        super();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        user.setUserID(request.getParameter("id"));
        user.setUserPassword(request.getParameter("password"));
        user.setUserEmail(request.getParameter("email"));
        user.setUserNickname(request.getParameter("nickname"));
        service.join(user);
    }
}