package nth.sky.video.po;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(schema="istone",name="t_Praise")
public class Share {
	@Id
   private int shareSID;
   private String sharePlatform;
   private String shareID;
   private String shareNickName;
   private String videoID;
   private Timestamp shareTime;
   private String notes;
public int getShareSID() {
	return shareSID;
}
public void setShareSID(int shareSID) {
	this.shareSID = shareSID;
}
public String getSharePlatform() {
	return sharePlatform;
}
public void setSharePlatform(String sharePlatform) {
	this.sharePlatform = sharePlatform;
}
public String getShareID() {
	return shareID;
}
public void setShareID(String shareID) {
	this.shareID = shareID;
}
public String getShareNickName() {
	return shareNickName;
}
public void setShareNickName(String shareNickName) {
	this.shareNickName = shareNickName;
}
public String getVideoID() {
	return videoID;
}
public void setVideoID(String videoID) {
	this.videoID = videoID;
}
public Timestamp getShareTime() {
	return shareTime;
}
public void setShareTime(Timestamp shareTime) {
	this.shareTime = shareTime;
}
public String getNotes() {
	return notes;
}
public void setNotes(String notes) {
	this.notes = notes;
}

}