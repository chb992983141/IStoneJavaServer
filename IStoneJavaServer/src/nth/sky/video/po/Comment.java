package nth.sky.video.po;


import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(schema="istone",name="t_Comment")
public class Comment {
	@Id
   private int commentSID;
   private String commentatorID;
   private String commentatorNickName;
   private String commentContent;
   private String videoID;
   private int referenceCommentSID;
   private Timestamp commentTime;
   private String notes;
public int getCommentSID() {
	return commentSID;
}
public void setCommentSID(int commentSID) {
	this.commentSID = commentSID;
}
public String getCommentatorID() {
	return commentatorID;
}
public void setCommentatorID(String commentatorID) {
	this.commentatorID = commentatorID;
}
public String getCommentatorNickName() {
	return commentatorNickName;
}
public void setCommentatorNickName(String commentatorNickName) {
	this.commentatorNickName = commentatorNickName;
}
public String getCommentContent() {
	return commentContent;
}
public void setCommentContent(String commentContent) {
	this.commentContent = commentContent;
}
public String getVideoID() {
	return videoID;
}
public void setVideoID(String videoID) {
	this.videoID = videoID;
}

public int getReferenceCommentSID() {
	return referenceCommentSID;
}
public void setReferenceCommentSID(int referenceCommentSID) {
	this.referenceCommentSID = referenceCommentSID;
}
public Timestamp getCommentTime() {
	return commentTime;
}
public void setCommentTime(Timestamp commentTime) {
	this.commentTime = commentTime;
}
public String getNotes() {
	return notes;
}
public void setNotes(String notes) {
	this.notes = notes;
}

}