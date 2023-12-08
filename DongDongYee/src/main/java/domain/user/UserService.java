package domain.user;

import domain.comment.Comment;
import domain.promotion.Promotion;
import domain.rating.Rating;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserService {
    private Connection conn; //db 접근 객체
    private PreparedStatement pstmt;
    private ResultSet rs; // db 결과를 담는 객체

    public UserService() {
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

    public int login(String userID, String userPassword) {
        String SQL = "SELECT UserPassword FROM DD_USER WHERE UserID = ?";
        try {
            pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1, userID); //sql Injection 공격 방어 수단 : 1번째 물음표에 userID 입력
            rs = pstmt.executeQuery(); // 쿼리 실행
            if (rs.next()) {
                if (rs.getString(1).equals(userPassword)) // rs.getString(1) : select된 첫번째 컬럼
                    return 1; //로그인 성공
                else
                    return 0; // 비밀번호 틀림
            }
            return -1; // 아이디 없음
        } catch (Exception e) {
            e.printStackTrace();

        }
        return -2; //DB 오류
    }

    public int isEmailTaken(String email) {
        String checkEmailSQL = "SELECT COUNT(*) FROM DD_USER WHERE UserEmail = ?";
        return isTaken(email, checkEmailSQL);
    }

    public int isIdTaken(String id) {
        String checkIdSQL = "SELECT COUNT(*) FROM DD_USER WHERE UserId = ?";
        return isTaken(id, checkIdSQL);
    }

    public int isNickNameTaken(String nickName) {
        String checkNickNameSQL = "SELECT COUNT(*) FROM DD_USER WHERE UserNickname = ?";
        return isTaken(nickName, checkNickNameSQL);
    }

    public int isTaken(String tryName, String trySQL) {
        try {
            PreparedStatement checkStmt = conn.prepareStatement(trySQL);
            checkStmt.setString(1, tryName);
            ResultSet rsName = checkStmt.executeQuery();
            if (rsName.next()) {
                if (rsName.getInt(1) > 0) {
                    return 1; // 중복되면 1 반환
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return -2; // DB 오류
        }
        return -1;
    }

    public int join(User user) {
        //등록
        String joinSQL = "INSERT INTO DD_USER VALUES(?, ?, ?, ?)";
        try {
            pstmt = conn.prepareStatement(joinSQL);
            pstmt.setString(1, user.getUserID());
            pstmt.setString(2, user.getUserPassword());
            pstmt.setString(3, user.getUserEmail());
            pstmt.setString(4, user.getUserNickname());
            return pstmt.executeUpdate(); // 0이상 값이 return된 경우 성공
        } catch (Exception e) {
            e.printStackTrace();

        }
        return -1; //DB 오류
    }

    public String findUserNicknameByUserId(String userId) {
        String userNickname = null;
        String sql = "SELECT UserNickname FROM DD_USER WHERE UserID = ?";

        // try-with-resources를 사용하여 자동 리소스 해제
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, userId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    userNickname = rs.getString("UserNickname");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userNickname;
    }

    public User read(String userId) {
        User user = null;
        String sql = "SELECT * FROM DD_USER WHERE UserID = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, userId);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    user = new User();
                    user.setUserID(rs.getString("UserID"));
                    user.setUserEmail(rs.getString("UserEmail"));
                    user.setUserNickname(rs.getString("UserNickname"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public void delete(String id) {
        deleteComments(id);
        deleteRatings(id);
        deletePromotions(id);

        String sql = "DELETE FROM DD_User WHERE UserID = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteComments(String id) {
        String sql = "DELETE FROM DD_COMMENT WHERE UserID = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, id);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteRatings(String id) {
        String sql = "DELETE FROM DD_Ratings WHERE UserID = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, id);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deletePromotions(String userId) {
        String findPromotionsSql = "SELECT PromotionID FROM DD_Promotion WHERE UserID = ?";
        List<Long> promotionIds = new ArrayList<>();

        try (PreparedStatement pstmt = conn.prepareStatement(findPromotionsSql)) {
            pstmt.setString(1, userId);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    promotionIds.add(rs.getLong("PromotionID"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }

        String deleteCommentsSql = "DELETE FROM DD_COMMENT WHERE PromotionID = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(deleteCommentsSql)) {
            for (Long promotionId : promotionIds) {
                pstmt.setLong(1, promotionId);
                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }

        String deletePromotionsSql = "DELETE FROM DD_Promotion WHERE UserID = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(deletePromotionsSql)) {
            pstmt.setString(1, userId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Promotion> getPromotionsByUserId(String userId) {
        List<Promotion> promotions = new ArrayList<>();
        String sql = "SELECT * FROM DD_Promotion WHERE UserID = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, userId);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Promotion promotion = new Promotion();
                // 각 필드를 설정합니다 (예시)
                promotion.setPromotionID(rs.getLong("PromotionID"));
                promotion.setUserID(rs.getString("UserID"));
                promotion.setUserNickname(rs.getString("UserNickname"));
                promotion.setPromotionName(rs.getString("PromotionName"));
                promotion.setPromotionContents(rs.getString("PromotionContents"));
                promotion.setPromotionClub(rs.getString("PromotionClub"));
                promotion.setPromotionTime(rs.getTimestamp("PromotionTime"));

                promotions.add(promotion);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return promotions;
    }

    public List<Comment> getCommentsByUserId(String userId) {
        List<Comment> comments = new ArrayList<>();
        String sql = "SELECT * FROM DD_COMMENT WHERE UserID = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, userId);
            rs = pstmt.executeQuery();

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
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return comments;
    }
}
