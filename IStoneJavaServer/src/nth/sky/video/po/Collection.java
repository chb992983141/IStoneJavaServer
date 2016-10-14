package nth.sky.video.po;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="t_Collection",catalog="istone")
public class Collection {
	@Id
   private int collectionSID;
   private String collectionID;
   private String collectionNickName;
   private String videoID;
   private Timestamp collectionTime;
   private String notes;
   
public int getCollectionSID() {
	return collectionSID;
}
public void setCollectionSID(int collectionSID) {
	this.collectionSID = collectionSID;
}
public String getCollectionID() {
	return collectionID;
}
public void setCollectionID(String collectionID) {
	this.collectionID = collectionID;
}
public String getCollectionNickName() {
	return collectionNickName;
}
public void setCollectionNickName(String collectionNickName) {
	this.collectionNickName = collectionNickName;
}
public String getVideoID() {
	return videoID;
}
public void setVideoID(String videoID) {
	this.videoID = videoID;
}
public Timestamp getCollectionTime() {
	return collectionTime;
}
public void setCollectionTime(Timestamp collectionTime) {
	this.collectionTime = collectionTime;
}
public String getNotes() {
	return notes;
}
public void setNotes(String notes) {
	this.notes = notes;
}

}