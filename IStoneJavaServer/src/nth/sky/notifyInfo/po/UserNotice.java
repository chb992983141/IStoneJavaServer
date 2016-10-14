package nth.sky.notifyInfo.po;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(schema="istone",name="T_UserNotice")
public class UserNotice extends QueryNoticeInfo{
   @Id
   private int userNoticeID;
   
   private String userNotice;

   private String noticeType;

   private boolean noticeState = true;

   private String userID;

   private String nickName;

   private String notes;
   
/*  private String headPortraitAddress;

public String getHeadPortraitAddress() {
	return headPortraitAddress;
}
public void setHeadPortraitAddress(String headPortraitAddress) {
	this.headPortraitAddress = headPortraitAddress;
}*/
public int getUserNoticeID() {
	return userNoticeID;
}
public void setUserNoticeID(int userNoticeID) {
	this.userNoticeID = userNoticeID;
}
public String getUserNotice() {
	return userNotice;
}
public void setUserNotice(String userNotice) {
	this.userNotice = userNotice;
}
public String getNoticeType() {
	return noticeType;
}
public void setNoticeType(String noticeType) {
	this.noticeType = noticeType;
}

public boolean isNoticeState() {
	return noticeState;
}
public void setNoticeState(boolean noticeState) {
	this.noticeState = noticeState;
}
public String getUserID() {
	return userID;
}
public void setUserID(String userID) {
	this.userID = userID;
}
public String getNickName() {
	return nickName;
}
public void setNickName(String nickName) {
	this.nickName = nickName;
}
public String getNotes() {
	return notes;
}
public void setNotes(String notes) {
	this.notes = notes;
}
}

