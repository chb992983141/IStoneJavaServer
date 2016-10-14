package nth.sky.notifyInfo.po;



import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema="istone",name="T_Report")
public class Report {
 
   @Id
   private int reportSID;

   private String informerID;

   private String informerNickName;

   private String videoID;

   private Timestamp reportTime;

   private String notes;

public int getReportSID() {
	return reportSID;
}

public void setReportSID(int reportSID) {
	this.reportSID = reportSID;
}

public String getInformerID() {
	return informerID;
}

public void setInformerID(String informerID) {
	this.informerID = informerID;
}

public String getInformerNickName() {
	return informerNickName;
}

public void setInformerNickName(String informerNickName) {
	this.informerNickName = informerNickName;
}

public String getVideoID() {
	return videoID;
}

public void setVideoID(String videoID) {
	this.videoID = videoID;
}

public Timestamp getReportTime() {
	return reportTime;
}

public void setReportTime(Timestamp reportTime) {
	this.reportTime = reportTime;
}

public String getNotes() {
	return notes;
}

public void setNotes(String notes) {
	this.notes = notes;
}


}