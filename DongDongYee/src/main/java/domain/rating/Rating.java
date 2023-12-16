package domain.rating;

import java.sql.Timestamp;

public class Rating {
	
	private Long ratingID;
    private String userID;
    private String userNickname;
    private String ratingName;
    private String ratingClub;  
    private String ratingPlay;  
    private String ratingGood;  
    private String ratingBad;
    private Timestamp ratingTime;

    public void setRatingID(Long RatingID) {
    	this.ratingID=RatingID;
    }

    public void setUserID(String UserID) {
    	this.userID=UserID;
    }

    public void setRatingName(String RatingName) {
    	this.ratingName=RatingName;
    }
    public void setRatingClub(String RatingClub) {
    	this.ratingClub=RatingClub;
    }
    public void setRatingPlay(String RatingPlay) {
    	this.ratingPlay=RatingPlay;
    }
    public void setRatingGood(String RatingGood) {
    	this.ratingGood=RatingGood;
    }
    public void setRatingBad(String RatingBad) {
    	this.ratingBad=RatingBad;
    }

     public void setRatingTime(Timestamp RatingTime) {
    	this.ratingTime=RatingTime;
    }
    
    public Long getRatingID() {
    	return ratingID;
    }

    public String getUserID() {
    	return userID;
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

    public Timestamp getRatingTime(){
        return ratingTime;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }
}