package domain.promotion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PromotionService {
    private Connection conn; //db 접근 객체
    private PreparedStatement pstmt;
    private ResultSet rs; // db 결과를 담는 객체

    public PromotionService() {
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

    public Promotion read(Long Id) {
        Promotion promotion = null;
        String sql = "SELECT * FROM DD_Promotion WHERE PromotionID = ?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setLong(1, Id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                promotion = new Promotion();
                setPromotionResponse(promotion, rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return promotion;
    }

    public Promotion publish(Promotion promotion) {
        String sql = "INSERT INTO DD_Promotion (UserID, PromotionName, PromotionContents, PromotionClub) VALUES (?, ?, ?, ?)";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, promotion.getUserID());
            pstmt.setString(2, promotion.getPromotionName());
            pstmt.setString(3, promotion.getPromotionContents());
            pstmt.setString(4, promotion.getPromotionClub());

            ResultSet generatedKeys = pstmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                promotion.setPromotionID(generatedKeys.getLong(1));
            }

            sql = "SELECT PromotionTime FROM DD_Promotion WHERE PromotionID = ?";
            PreparedStatement pstmt2 = conn.prepareStatement(sql);
            pstmt2.setLong(1, promotion.getPromotionID());
            rs = pstmt2.executeQuery();
            if (rs.next()) {
                promotion.setPromotionTime(rs.getTimestamp("PromotionTime"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return promotion;
    }

    public List<Promotion> getAllPromotions() {
        List<Promotion> promotions = new ArrayList<>();

        String sql = "SELECT * FROM DD_Promotion";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Promotion promotion = new Promotion();
                setPromotionResponse(promotion, rs);

                promotions.add(promotion);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return promotions;
    }

    public void setPromotionResponse(Promotion promotion, ResultSet rs) throws SQLException {
        promotion.setPromotionID(rs.getLong("PromotionID"));
        promotion.setUserID(rs.getString("UserID"));
        promotion.setPromotionName(rs.getString("PromotionName"));
        promotion.setPromotionContents(rs.getString("PromotionContents"));
        promotion.setPromotionClub(rs.getString("PromotionClub"));
        promotion.setPromotionTime(rs.getTimestamp("PromotionTime"));
    }
}
