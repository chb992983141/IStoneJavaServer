package nth.sky.user.po;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/***********************************************************************
 * Module:  User.java
 * Author:  уей╓
 * Purpose: Defines the Class User
 ***********************************************************************/
@Entity
@Table(schema="istone",name="t_user")
public class User {
	@Id
   private String userID;
   
   private String nickName;
   
   private int cityID;
   
   private String city;
   
   private String associationQQ;
   
   private String gender;
   
   private String headPortraitAddress;
   
   private boolean userState;
   
   private String userActivity;
   
   private int attentionNumber;
   
   private int fansNumber;
   
   private int collectionNumber;
   
   private String notes;
   
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
public int getCityID() {
	return cityID;
}
public void setCityID(int cityID) {
	this.cityID = cityID;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getAssociationQQ() {
	return associationQQ;
}
public void setAssociationQQ(String associationQQ) {
	this.associationQQ = associationQQ;
}

public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getHeadPortraitAddress() {
	return headPortraitAddress;
}
public void setHeadPortraitAddress(String headPortraitAddress) {
	this.headPortraitAddress = headPortraitAddress;
}
public boolean isUserState() {
	return userState;
}
public void setUserState(boolean userState) {
	this.userState = userState;
}
public String getUserActivity() {
	return userActivity;
}
public void setUserActivity(String userActivity) {
	this.userActivity = userActivity;
}
public int getAttentionNumber() {
	return attentionNumber;
}
public void setAttentionNumber(int attentionNumber) {
	this.attentionNumber = attentionNumber;
}
public int getFansNumber() {
	return fansNumber;
}
public void setFansNumber(int fansNumber) {
	this.fansNumber = fansNumber;
}
public int getCollectionNumber() {
	return collectionNumber;
}
public void setCollectionNumber(int collectionNumber) {
	this.collectionNumber = collectionNumber;
}
public String getNotes() {
	return notes;
}
public void setNotes(String notes) {
	this.notes = notes;
}

}