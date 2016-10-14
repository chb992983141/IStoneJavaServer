package nth.sky.video.po;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class NewVideo {
	@Id
	private String videoId;

	public String getVideoId() {
		return videoId;
	}

	public void setVideoId(String videoId) {
		this.videoId = videoId;
	}

}
