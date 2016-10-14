package nth.sky.VideoRecording.po;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_backgroundmusic",catalog="istone")
public class BackgroundMusic {
	@Id
   private String BackgroundMusicID;
   private String BackgroundMusicName;
   private String StoragePath;
   private String Notes;
public String getBackgroundMusicID() {
	return BackgroundMusicID;
}
public void setBackgroundMusicID(String backgroundMusicID) {
	BackgroundMusicID = backgroundMusicID;
}
public String getBackgroundMusicName() {
	return BackgroundMusicName;
}
public void setBackgroundMusicName(String backgroundMusicName) {
	BackgroundMusicName = backgroundMusicName;
}
public String getStoragePath() {
	return StoragePath;
}
public void setStoragePath(String storagePath) {
	StoragePath = storagePath;
}
public String getNotes() {
	return Notes;
}
public void setNotes(String notes) {
	Notes = notes;
}
   

}