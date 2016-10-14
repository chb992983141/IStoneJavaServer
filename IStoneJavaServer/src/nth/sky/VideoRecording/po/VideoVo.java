package nth.sky.VideoRecording.po;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;



public class VideoVo {

	private String publishUserID;
	private String videoTitle;
	private Timestamp publishTime;
	private String currentLocation;
	
	public String getVideoTitle() {
		return videoTitle;
	}
	public void setVideoTitle(String videoTitle) {
		this.videoTitle = videoTitle;
	}
	public String getPublishUserID() {
		return publishUserID;
	}
	public void setPublishUserID(String publishUserID) {
		this.publishUserID = publishUserID;
	}
	public Timestamp getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(Timestamp publishTime) {
		this.publishTime = publishTime;
	}
	public String getCurrentLocation() {
		return currentLocation;
	}
	public void setCurrentLocation(String currentLocation) {
		this.currentLocation = currentLocation;
	}
	
}
