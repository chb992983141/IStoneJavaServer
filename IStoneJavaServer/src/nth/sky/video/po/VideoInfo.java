package nth.sky.video.po;

import java.sql.Timestamp;

public class VideoInfo {
	
	   private String videoID;
	   private String videoTitle;
	   private String coverAddress;
	   private String categoryID;
	   private String publishUserID;
	   private String publishUserNickName;
	   private String categoryName;
	   private String currentLocation;
	   private String storagePath;
	   private Timestamp publishTime;
	   private int wathAmount;
	   private int shareAmount;
	   private int praiseAmount;
	   private int commentAmount;
	   private int collectionAmount;
	   private Boolean auditState;
	   private String notes;
	   private String headPortraitAddress;
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
	public String getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(String categoryID) {
		this.categoryID = categoryID;
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
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getCurrentLocation() {
		return currentLocation;
	}
	public void setCurrentLocation(String currentLocation) {
		this.currentLocation = currentLocation;
	}
	public String getStoragePath() {
		return storagePath;
	}
	public void setStoragePath(String storagePath) {
		this.storagePath = storagePath;
	}
	public Timestamp getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(Timestamp publishTime) {
		this.publishTime = publishTime;
	}
	public int getWathAmount() {
		return wathAmount;
	}
	public void setWathAmount(int wathAmount) {
		this.wathAmount = wathAmount;
	}
	public int getShareAmount() {
		return shareAmount;
	}
	public void setShareAmount(int shareAmount) {
		this.shareAmount = shareAmount;
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
	public int getCollectionAmount() {
		return collectionAmount;
	}
	public void setCollectionAmount(int collectionAmount) {
		this.collectionAmount = collectionAmount;
	}
	public Boolean getAuditState() {
		return auditState;
	}
	public void setAuditState(Boolean auditState) {
		this.auditState = auditState;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public String getHeadPortraitAddress() {
		return headPortraitAddress;
	}
	public void setHeadPortraitAddress(String headPortraitAddress) {
		this.headPortraitAddress = headPortraitAddress;
	}
	   
}
