package nth.sky.video.po;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(schema="istone",name="t_Praise")
public class Praise {
	@Id
	   private int praiseSID;
	   private String praiseID;
	   private String praiseNickName;
	   private String videoID;
	   private Timestamp praiseTime;
	   private String notes;
	public int getPraiseSID() {
		return praiseSID;
	}
	public void setPraiseSID(int praiseSID) {
		this.praiseSID = praiseSID;
	}
	public String getPraiseID() {
		return praiseID;
	}
	public void setPraiseID(String praiseID) {
		this.praiseID = praiseID;
	}
	public String getPraiseNickName() {
		return praiseNickName;
	}
	public void setPraiseNickName(String praiseNickName) {
		this.praiseNickName = praiseNickName;
	}
	public String getVideoID() {
		return videoID;
	}
	public void setVideoID(String videoID) {
		this.videoID = videoID;
	}
	public Timestamp getPraiseTime() {
		return praiseTime;
	}
	public void setPraiseTime(Timestamp praiseTime) {
		this.praiseTime = praiseTime;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}

}

