package domain.comment.commentcontroller;

import domain.comment.Comment;
import domain.comment.CommentService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CommentServlet")
public class CommentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final CommentService service = new CommentService();
    public CommentServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        Long promotionID = Long.parseLong(request.getParameter("promotionID"));
        Comment comment = new Comment(request.getParameter("userID"), promotionID, request.getParameter("comment"));
//        TODO: Service 구현
//        comment = service.publish(comment);
        response.sendRedirect("promotion?id=" + promotionID);
    }
}