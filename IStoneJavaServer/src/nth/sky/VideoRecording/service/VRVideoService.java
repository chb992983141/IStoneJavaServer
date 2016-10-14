package nth.sky.VideoRecording.service;

import java.sql.Timestamp;
import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import nth.sky.VideoRecording.dao.VRVideoDao;
import nth.sky.VideoRecording.po.VideoVo;
import nth.sky.video.po.Video;
@Component
public class VRVideoService {
	@Resource
	private VRVideoDao VRvideoDao = new VRVideoDao();
	   public String saveVideo(String coverAddress,String videoID,String storagePath,String videoTitle,String publishUserID,Timestamp publishTime,String currentLocation) {
			System.out.println("VideoService.savaVideo()");
			Video video = new Video();
			video.setCoverAddress(coverAddress);
			video.setVideoID(videoID);
			video.setStoragePath(storagePath);
			video.setVideoTitle(videoTitle);
			video.setPublishUserID(publishUserID);
			video.setPublishTime(publishTime);
			video.setCurrentLocation(currentLocation);
			VRvideoDao.addVideo(video);
	      return null;
	   }
   
	public String addVideoVo(VideoVo videoVo) {
		System.out.println("VideoDao.add()");
		VRvideoDao.addVideoVo(videoVo);
      return null;
   }
  // ------------------Delete---------------------------
   public String deleteVideo(String videoID) {
	   System.out.println("VideoService.deleteVideo()");
	   Video video = new Video();
	   video.setVideoID(videoID);
	   VRvideoDao.deleteVideo(video);
	      return null;
	   }

   
   public VRVideoDao getVideoDao() {
	return VRvideoDao;
}

public void setVideoDao(VRVideoDao videoDao) {
	this.VRvideoDao = videoDao;
}

}