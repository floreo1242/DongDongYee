package domain.user.usercontroller;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import domain.user.*;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    private UserService userService = new UserService();

    
    public LoginServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("UserID"); //사용자 입력값 
        String userPassword = request.getParameter("UserPassword"); //사용자 입력값
        int loginValid=userService.login(userId,userPassword);

        if (loginValid==1)  //db저장 값 user.getpassword
        {
            HttpSession session = request.getSession();
            session.setAttribute("userId", userId);
            response.sendRedirect("./webapp/welcome.jsp");
        }
        else if(loginValid==0){
            response.setContentType("text/html; charset=UTF-8");
            response.getWriter().println("<script>alert('아이디 또는 비밀번호가 잘못되었습니다.'); history.go(-1);</script>");
        }
        else  {
            response.setContentType("text/html; charset=UTF-8");
            response.getWriter().println("<script>alert('회원가입을 다시 해주세요.'); history.go(-1);</script>");
        }

	}
}
