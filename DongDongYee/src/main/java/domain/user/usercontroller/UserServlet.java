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
            response.setContentType("text/html;");
            response.getWriter().println("<script>alert('세션이 만료되었습니다. 다시 로그인 해주세요.'); window.location.href='Login.jsp';</script>");
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
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().println("<script>alert('세션이 만료되었습니다. 다시 로그인 해주세요.'); window.location.href='Login.jsp';</script>");
            return;
        }
        String userPassword = userService.findUserPasswordByUserId(session.getAttribute("userID").toString());
        String password = request.getParameter("password");
        if (password.equals(userPassword)) {
            userService.delete(session.getAttribute("userID").toString());
            session.removeAttribute("userID");
            response.getWriter().println("<script>alert('회원 탈퇴가 완료되었습니다.')</script>");
            response.sendRedirect("/");
        } else {
            response.getWriter().println("<script>alert('비밀번호가 일치하지 않습니다.')</script>");
            response.sendRedirect("Profile");
        }
    }
}