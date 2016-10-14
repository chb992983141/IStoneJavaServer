package nth.sky.notifyInfo.po;


import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(schema="istone",name="T_SysNotice")
public class SysNotice {

   @Id
   private String sysNoticeID;

   private String sysNotice;

   private String publisherID;
  
   private String publisher;
  
   private Timestamp deadline;

   private boolean sysNoticeState = true;

   private String Notes;

public String getSysNoticeID() {
	return sysNoticeID;
}

public void setSysNoticeID(String sysNoticeID) {
	this.sysNoticeID = sysNoticeID;
}

public String getSysNotice() {
	return sysNotice;
}

public void setSysNotice(String sysNotice) {
	this.sysNotice = sysNotice;
}

public String getPublisherID() {
	return publisherID;
}

public void setPublisherID(String publisherID) {
	this.publisherID = publisherID;
}

public String getPublisher() {
	return publisher;
}

public void setPublisher(String publisher) {
	this.publisher = publisher;
}

public Timestamp getDeadline() {
	return deadline;
}

public void setDeadline(Timestamp deadline) {
	this.deadline = deadline;
}

public boolean isSysNoticeState() {
	return sysNoticeState;
}

public void setSysNoticeState(boolean sysNoticeState) {
	this.sysNoticeState = sysNoticeState;
}

public String getNotes() {
	return Notes;
}

public void setNotes(String notes) {
	Notes = notes;
}



/*public SysNotice(String sysNoticeID, String sysNotice, String publisherID) {
	super();
	SysNoticeID = sysNoticeID;
	SysNotice = sysNotice;
	PublisherID = publisherID;
}

public static void main(String arg[]){
	SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
	Calendar cal=Calendar.getInstance();

	cal.set(Calendar.YEAR, 2014);

		cal.set(Calendar.MONTH, 7);

		cal.set(Calendar.DAY_OF_MONTH, 29);

		cal.add(Calendar.DATE, -4);

		Date date=cal.getTime();

		cal.add(Calendar.DATE, 4);

		date=cal.getTime();

	JSONObject json =  JSONObject.fromObject(new SysNotice("10000023","系统将于7月30日早上6点到9点进行维护，届时耽误您的使用，敬请谅解","2012213542"));
	System.out.println(json.toString());

}
*/
}