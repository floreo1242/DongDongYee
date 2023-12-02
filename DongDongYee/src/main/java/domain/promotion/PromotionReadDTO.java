package domain.promotion;

public class PromotionReadDTO {
    private Long promotionID;

    public PromotionReadDTO() {
    }

    public PromotionReadDTO(Long promotionID) {
        this.promotionID = promotionID;
    }

    public Long getPromotionID() {
        return promotionID;
    }

    public void setPromotionID(Long promotionID) {
        this.promotionID = promotionID;
    }
}
