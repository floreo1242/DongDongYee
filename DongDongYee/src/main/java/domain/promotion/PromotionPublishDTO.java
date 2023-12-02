package domain.promotion;

public class PromotionPublishDTO {
    private Long promotionID;
    private String userID;
    private String promotionName;
    private String promotionContents;
    private String promotionClub;

    public PromotionPublishDTO() { }

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
}
