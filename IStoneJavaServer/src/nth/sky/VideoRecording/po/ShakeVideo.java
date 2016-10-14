package nth.sky.VideoRecording.po;

import java.sql.Timestamp;

public class ShakeVideo {
	  
	   private String videoID;
	   private String videoTitle;
	   private String coverAddress;
	   private String publishUserID;
	   private String publishUserNickName;
	   private String currentLocation;
	   private Timestamp publishTime;
	   private int praiseAmount;
	   private int commentAmount;
	   private String storagePath;
	   private String headPortraitAddress;
	   
	public String getHeadPortraitAddress() {
		return headPortraitAddress;
	}
	public void setHeadPortraitAddress(String headPortraitAddress) {
		this.headPortraitAddress = headPortraitAddress;
	}
	public String getVideoID() {
		return videoID;
	}
	public void setVideoID(String videoID) {
		this.videoID = videoID;
	}
	public String getVideoTitle() {
		return videoTitle;
	}
	public void setVideoTitle(String videoTitle) {
		this.videoTitle = videoTitle;
	}
	public String getCoverAddress() {
		return coverAddress;
	}
	public void setCoverAddress(String coverAddress) {
		this.coverAddress = coverAddress;
	}
	public String getPublishUserID() {
		return publishUserID;
	}
	public void setPublishUserID(String publishUserID) {
		this.publishUserID = publishUserID;
	}
	public String getPublishUserNickName() {
		return publishUserNickName;
	}
	public void setPublishUserNickName(String publishUserNickName) {
		this.publishUserNickName = publishUserNickName;
	}
	public String getCurrentLocation() {
		return currentLocation;
	}
	public void setCurrentLocation(String currentLocation) {
		this.currentLocation = currentLocation;
	}
	public Timestamp getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(Timestamp publishTime) {
		this.publishTime = publishTime;
	}
	public int getPraiseAmount() {
		return praiseAmount;
	}
	public void setPraiseAmount(int praiseAmount) {
		this.praiseAmount = praiseAmount;
	}
	public int getCommentAmount() {
		return commentAmount;
	}
	public void setCommentAmount(int commentAmount) {
		this.commentAmount = commentAmount;
	}
	public String getStoragePath() {
		return storagePath;
	}
	public void setStoragePath(String storagePath) {
		this.storagePath = storagePath;
	}
	   
	}


