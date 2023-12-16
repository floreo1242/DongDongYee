package domain.comment.commentcontroller;

import domain.comment.CommentService;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CommentDelete")
public class CommentDeleteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final CommentService commentService = new CommentService();

    public CommentDeleteServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        Long commentID = Long.parseLong(request.getParameter("commentID"));
        commentService.delete(commentID);
        response.sendRedirect("promotion?id=" + request.getParameter("promotionID"));
    }
}