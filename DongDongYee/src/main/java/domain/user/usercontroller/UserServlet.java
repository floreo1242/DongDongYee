package domain.user.usercontroller;

import domain.user.User;
import domain.user.UserService;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Profile")
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final UserService userService = new UserService();

    public UserServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        if (session.getAttribute("userID") == null) {
            response.sendRedirect("Login.jsp");
            return;
        }
        User user = userService.read(session.getAttribute("userID").toString());
        request.setAttribute("user", user);
        request.getRequestDispatcher("Profile.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        if (session.getAttribute("userID") == null) {
            response.sendRedirect("Login.jsp");
            return;
        }
        String userPassword = userService.findUserPasswordByUserId(session.getAttribute("userID").toString());
        String password = request.getParameter("password");
        if (password.equals(userPassword)) {
            userService.delete(session.getAttribute("userID").toString());
            response.sendRedirect("Login.jsp");
        } else {
            response.sendRedirect("Profile");
        }
    }
}