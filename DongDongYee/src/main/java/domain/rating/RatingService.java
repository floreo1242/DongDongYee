package domain.rating;

import domain.user.UserService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RatingService {
    private final UserService userService = new UserService();
    private Connection conn; //db 접근 객체
    private PreparedStatement pstmt;
    private ResultSet rs; // db 결과를 담는 객체
    public RatingService(){
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
}
