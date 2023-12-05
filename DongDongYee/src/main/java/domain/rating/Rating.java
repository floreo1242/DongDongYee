package domain.rating;

public class Rating {
	private long ratingId;  
    private String userId;  
    private String ratingName;  
    private String ratingClub;  
    private String ratingPlay;  
    private String ratingGood;  
    private String ratingBad;

    public Rating() {
    	
    }
    
    public void setRatingName(String RatingName) {
    	ratingName=RatingName;
    }
    public void setRatingClub(String RatingClub) {
    	ratingClub=RatingClub;
    }
    public void setRatingPlay(String RatingPlay) {
    	ratingPlay=RatingPlay;
    }
    public void setRatingGood(String RatingGood) {
    	ratingGood=RatingGood;
    }
    public void setRatingBad(String RatingBad) {
    	ratingBad=RatingBad;
    }
    
    public String getRatingName() {
    	return ratingName;
    }
    
    public String getRatingClub() {
    	return ratingClub;
    }
    
    public String getRatingPlay() {
    	return ratingPlay;
    }
    
    public String getRatingGood() {
    	return ratingGood;
    }
    
    public String getRatingBad() {
    	return ratingBad;
    }
    
  
}