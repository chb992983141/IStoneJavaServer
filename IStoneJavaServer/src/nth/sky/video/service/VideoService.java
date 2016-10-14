package nth.sky.video.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import nth.sky.video.dao.VideoDao;
import nth.sky.video.po.Video;

@Component
public class VideoService {
	
	@Resource
	private VideoDao videoDao = new VideoDao();

	public Video getVideo(Video video) {
		System.out.println("+++++++  here service+++++++");
		//videoDao.queryVideoByVideoID(video);
		return videoDao.queryVideoByVideoID(video);
	}


	public VideoDao getVideoDao() {
		return videoDao;
	}

	public void setVideoDao(VideoDao videoDao) {
		this.videoDao = videoDao;
	}
	
}