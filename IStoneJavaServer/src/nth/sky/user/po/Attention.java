package nth.sky.user.po;

/***********************************************************************
 * Module:  Attention.java
 * Author:  уей╓
 * Purpose: Defines the Class Attention
 ***********************************************************************/


import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity	
@Table(schema="istone",name="t_attention")
public class Attention {
	@Id
   private int attentionSID;
   
   private String attentionID;
   
   private String attentionNickName;
   
   private String interestedID;
   
   private String interestedNickName;
   
   private Timestamp attentionTime;
   
   private String notes;
   
public int getAttentionSID() {
	return attentionSID;
}
public void setAttentionSID(int attentionSID) {
	this.attentionSID = attentionSID;
}
public String getAttentionID() {
	return attentionID;
}
public void setAttentionID(String attentionID) {
	this.attentionID = attentionID;
}
public String getAttentionNickName() {
	return attentionNickName;
}
public void setAttentionNickName(String attentionNickName) {
	this.attentionNickName = attentionNickName;
}
public String getInterestedID() {
	return interestedID;
}
public void setInterestedID(String interestedID) {
	this.interestedID = interestedID;
}
public String getInterestedNickName() {
	return interestedNickName;
}
public void setInterestedNickName(String interestedNickName) {
	this.interestedNickName = interestedNickName;
}

public Timestamp getAttentionTime() {
	return attentionTime;
}
public void setAttentionTime(Timestamp attentionTime) {
	this.attentionTime = attentionTime;
}
public String getNotes() {
	return notes;
}
public void setNotes(String notes) {
	this.notes = notes;
}

}
