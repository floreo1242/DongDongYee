package domain.promotion;

public class PromotionListDTO {
    private Long promotionID;
    private String promotionName;
    private String promotionContents;
    private String getPromotionClub;

    public PromotionListDTO() { }

    public PromotionListDTO(Long promotionID, String promotionName, String promotionContents, String getPromotionClub) {
        this.promotionID = promotionID;
        this.promotionName = promotionName;
        this.promotionContents = promotionContents;
        this.getPromotionClub = getPromotionClub;
    }

    public Long getPromotionID() { return promotionID; }
    public void setPromotionID(Long promotionID) { this.promotionID = promotionID; }
    public String getPromotionName() { return promotionName; }
    public void setPromotionName(String promotionName) { this.promotionName = promotionName; }
    public String getPromotionContents() { return promotionContents; }
    public void setPromotionContents(String promotionContents) { this.promotionContents = promotionContents; }
    public String getGetPromotionClub() { return getPromotionClub; }
    public void setGetPromotionClub(String getPromotionClub) { this.getPromotionClub = getPromotionClub; }
}
