package domain.rating;

import domain.promotion.Promotion;
import domain.user.UserService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RatingService {
    private final UserService userService = new UserService();
    private Connection conn; //db 접근 객체
    private PreparedStatement pstmt;
    private ResultSet rs; // db 결과를 담는 객체

    public RatingService() {
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

    public Rating read(Long id) {
        Rating rating = null;
        String sql = "SELECT * FROM DD_RATING WHERE RatingID = ?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setLong(1, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                rating = new Rating();
                setRatingResponse(rating, rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return rating;
    }

    private void setRatingResponse(Rating rating, ResultSet rs) throws SQLException {
        rating.setRatingID(rs.getLong("RatingID"));
        rating.setUserID(rs.getString("UserID"));
        rating.setUserNickname(rs.getString("UserNickname"));
        rating.setRatingName(rs.getString("RatingName"));
        rating.setRatingClub(rs.getString("RatingClub"));
        rating.setRatingPlay(rs.getString("RatingPlay"));
        rating.setRatingGood(rs.getString("RatingGood"));
        rating.setRatingBad(rs.getString("RatingBad"));
        rating.setRatingTime(rs.getTimestamp("RatingTime"));
    }

    public Rating publish(Rating rating) {
        String nickname = userService.findUserNicknameByUserId(rating.getUserID());
        String sql = "INSERT INTO DD_RATING (UserID, UserNickname, RatingName, RatingClub, RatingPlay, RatingGood, RatingBad) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, rating.getUserID());
            pstmt.setString(2, nickname);
            pstmt.setString(3, rating.getRatingName());
            pstmt.setString(4, rating.getRatingClub());
            pstmt.setString(5, rating.getRatingPlay());
            pstmt.setString(6, rating.getRatingGood());
            pstmt.setString(7, rating.getRatingBad());
            pstmt.executeUpdate();

            ResultSet generatedKeys = pstmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                rating.setRatingID(generatedKeys.getLong(1));
            }

            sql = "SELECT RatingTime FROM DD_RATING WHERE RatingID = ?";
            PreparedStatement pstmt2 = conn.prepareStatement(sql);
            pstmt2.setLong(1, rating.getRatingID());
            rs = pstmt2.executeQuery();
            if (rs.next()) {
                rating.setRatingTime(rs.getTimestamp("RatingTime"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rating;
    }

    public List<Rating> getAllRatings() {
        List<Rating> ratings = new ArrayList<>();

        String sql = "SELECT * FROM DD_RATING";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Rating rating = new Rating();
                setRatingResponse(rating, rs);

                ratings.add(rating);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ratings;
    }

    public void update(Rating rating) {
        String sql = "UPDATE DD_RATING SET RatingName=?, RatingClub=?, RatingPlay=?, RatingGood=?, RatingBad=? WHERE RatingID=?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, rating.getRatingName());
            pstmt.setString(2, rating.getRatingClub());
            pstmt.setString(3, rating.getRatingPlay());
            pstmt.setString(4, rating.getRatingGood());
            pstmt.setString(5, rating.getRatingBad());
            pstmt.setLong(6, rating.getRatingID());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(Long id) {
        String sql = "DELETE FROM DD_Rating WHERE RatingID = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Rating> getRatingsByPromotionName(String promotionName) {
        List<Rating> ratings = new ArrayList<>();
        String sql = "SELECT * FROM DD_RATING WHERE RatingClub = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, promotionName);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Rating rating = new Rating();
                rating.setRatingID(rs.getLong("RatingID"));
                rating.setUserID(rs.getString("UserID"));
                rating.setUserNickname(rs.getString("UserNickname"));
                rating.setRatingName(rs.getString("RatingName"));
                rating.setRatingClub(rs.getString("RatingClub"));
                rating.setRatingPlay(rs.getString("RatingPlay"));
                rating.setRatingGood(rs.getString("RatingGood"));
                rating.setRatingBad(rs.getString("RatingBad"));
                rating.setRatingTime(rs.getTimestamp("RatingTime"));

                ratings.add(rating);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ratings;
    }
}
