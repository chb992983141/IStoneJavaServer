package nth.sky.video.po;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(schema="istone",name="t_putlable")
public class PutLabel {
	@Id
   private int putLableSID;
   private String videoID;
   private String lableID;
   private String lableName;
   private Timestamp putLableTime;
   private int lableMount;
   private String notes;
public int getPutLableSID() {
	return putLableSID;
}
public void setPutLableSID(int putLableSID) {
	this.putLableSID = putLableSID;
}
public String getVideoID() {
	return videoID;
}
public void setVideoID(String videoID) {
	this.videoID = videoID;
}
public String getLableID() {
	return lableID;
}
public void setLableID(String lableID) {
	this.lableID = lableID;
}
public String getLableName() {
	return lableName;
}
public void setLableName(String lableName) {
	this.lableName = lableName;
}
public Timestamp getPutLableTime() {
	return putLableTime;
}
public void setPutLableTime(Timestamp putLableTime) {
	this.putLableTime = putLableTime;
}
public int getLableMount() {
	return lableMount;
}
public void setLableMount(int lableMount) {
	this.lableMount = lableMount;
}
public String getNotes() {
	return notes;
}
public void setNotes(String notes) {
	this.notes = notes;
}

}