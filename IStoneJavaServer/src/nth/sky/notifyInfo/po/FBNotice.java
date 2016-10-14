package nth.sky.notifyInfo.po;

import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema="istone",name="T_FBNotice")
public class FBNotice {
  @Id
  private String feedbackID;

  private String feedback;
  //@Temporal(value=TemporalType.TIMESTAMP)   
  private Timestamp feedbackTime;
 
  private String phone;

  private String mail;

  private String qq;
  
  private String notes;


public String getFeedbackID() {
	return feedbackID;
}

public void setFeedbackID(String feedbackID) {
	this.feedbackID = feedbackID;
}

public String getFeedback() {
	return feedback;
}

public void setFeedback(String feedback) {
	this.feedback = feedback;
}

public String getPhone() {
	return phone;
}

public void setPhone(String phone) {
	this.phone = phone;
}

public String getMail() {
	return mail;
}

public void setMail(String mail) {
	this.mail = mail;
}


public String getQq() {
	return qq;
}

public void setQq(String qq) {
	this.qq = qq;
}


public Timestamp getFeedbackTime() {
	return feedbackTime;
}

public void setFeedbackTime(Timestamp feedbackTime) {
	this.feedbackTime = feedbackTime;
}

public String getNotes() {
	return notes;
}

public void setNotes(String notes) {
	this.notes = notes;
}

}