package nth.sky.video.po;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema="istone",name="Dic_ViedoCategory")
public class ViedoCategory {
	@Id
	private String viedoCategoryID;
	private String viedoCategory;
	private String notes;
	public String getViedoCategoryID() {
		return viedoCategoryID;
	}
	public void setViedoCategoryID(String viedoCategoryID) {
		this.viedoCategoryID = viedoCategoryID;
	}
	public String getViedoCategory() {
		return viedoCategory;
	}
	public void setViedoCategory(String viedoCategory) {
		this.viedoCategory = viedoCategory;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
}
