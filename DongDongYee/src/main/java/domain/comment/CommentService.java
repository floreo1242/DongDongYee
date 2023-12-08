package domain.comment;

import domain.user.UserService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommentService {
    private final UserService userService = new UserService();
    private Connection conn; //db 접근 객체
    private PreparedStatement pstmt;
    private ResultSet rs; // db 결과를 담는 객체

    public CommentService() {
        try {
            String dbURL = "jdbc:mysql://localhost:3306/dongdongdb"; //mySQL 서버의 BBS DB 접근 경로
            String dbID = "dong"; //계정
            String dbPassword = "0000"; //비밀번호
            Class.forName("com.mysql.cj.jdbc.Driver"); //mysql에 접속을 도와주는 라이브러리
            conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Comment publish(Comment request) {
        request.setUserNickname(userService.findUserNicknameByUserId(request.getUserID()));
        String sql = "INSERT INTO DD_COMMENT (UserID, PromotionID, UserNickname, CommentContents) VALUES (?, ?, ?, ?)";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, request.getUserID());
            pstmt.setLong(2, request.getPromotionID());
            pstmt.setString(3, request.getUserNickname());
            pstmt.setString(4, request.getCommentContents());
            pstmt.executeUpdate();

            ResultSet generatedKeys = pstmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                request.setCommentID(generatedKeys.getLong(1));
            }

            sql = "SELECT CommentTime FROM DD_Comment WHERE CommentID = ?";
            PreparedStatement pstmt2 = conn.prepareStatement(sql);
            pstmt2.setLong(1, request.getCommentID());
            rs = pstmt2.executeQuery();
            if (rs.next()) {
                request.setCommentTime(rs.getTimestamp("CommentTime"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return request;
    }

    public List<Comment> read(Long promotionId) {
        List<Comment> comments = new ArrayList<>();

        String sql = "SELECT * FROM DD_COMMENT WHERE PromotionID = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, promotionId);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Comment comment = new Comment();
                comment.setCommentID(rs.getLong("CommentID"));
                comment.setUserID(rs.getString("UserID"));
                comment.setPromotionID(rs.getLong("PromotionID"));
                comment.setUserNickname(rs.getString("UserNickname"));
                comment.setCommentContents(rs.getString("CommentContents"));
                comment.setCommentTime(rs.getTimestamp("CommentTime"));

                comments.add(comment);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return comments;
    }
}