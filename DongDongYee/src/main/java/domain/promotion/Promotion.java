package domain.promotion;

import java.sql.Timestamp;

public class Promotion {
    private Long promotionID;
    private String userID;
    private String promotionName;
    private String promotionContents;
    private String promotionClub;
    private Timestamp promotionTime;
    private String userNickname;

    public Promotion() { }
    public Promotion(Long promotionID) { this.promotionID = promotionID; }
    public Promotion(Long promotionID, String promotionName, String promotionContents, String promotionClub) {
        this.promotionID = promotionID;
        this.promotionName = promotionName;
        this.promotionContents = promotionContents;
        this.promotionClub = promotionClub;
    }

    public Long getPromotionID() { return promotionID; }
    public void setPromotionID(Long promotionID) { this.promotionID = promotionID; }
    public String getUserID() { return userID; }
    public void setUserID(String userID) { this.userID = userID; }
    public String getPromotionName() { return promotionName; }
    public void setPromotionName(String promotionName) { this.promotionName = promotionName; }
    public String getPromotionContents() { return promotionContents; }
    public void setPromotionContents(String promotionContents) { this.promotionContents = promotionContents; }
    public String getPromotionClub() { return promotionClub; }
    public void setPromotionClub(String promotionClub) { this.promotionClub = promotionClub; }

    public Timestamp getPromotionTime() { return promotionTime; }

    public void setPromotionTime(Timestamp promotionTime) { this.promotionTime = promotionTime; }

    public String getUserNickname() { return userNickname; }

    public void setUserNickname(String userNickname) { this.userNickname = userNickname; }
}
