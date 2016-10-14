package nth.sky.video.service;

import java.util.List;

import javax.annotation.Resource;

import nth.sky.notifyInfo.dao.NUserDao;
import nth.sky.user.po.User;
import nth.sky.video.dao.VideoInfoDao;
import nth.sky.video.po.Video;
import nth.sky.video.po.VideoInfo;

import org.springframework.stereotype.Component;

@Component
public class VideoInfoService {
	@Resource
	private VideoInfoDao videoInfoDao = new VideoInfoDao();
	@Resource
	private NUserDao nuserDao = new NUserDao();
	/*set,get方法*/
	public VideoInfoDao getVideoInfoDao() {
		return videoInfoDao;
	}
	public void setVideoInfoDao(VideoInfoDao videoInfoDao) {
		this.videoInfoDao = videoInfoDao;
	}

	public NUserDao getNuserDao() {
		return nuserDao;
	}
	public void setNuserDao(NUserDao nuserDao) {
		this.nuserDao = nuserDao;
	}
	/*方法开始*/
	/*publishVideo*/
	public boolean publishVideo(Video video){
		System.out.println("+++++ publishVideo service +++++");
		return videoInfoDao.addVideo(video);
		 
	}
	/*deleteVideo*/
	public boolean deleteVideo(Video video){
		System.out.println("+++++ deleteVideo service +++++");
		return videoInfoDao.deleteVideo(video);
	}	
	/*getAttentionVideo*/
    @SuppressWarnings("rawtypes")
	public List getAttentionVideo(User user) {
		System.out.println("+++++ getAttentionVideo service ++++");
		return videoInfoDao.queryVideoByUserID(user);
	}
	/*getVideo*/
	public Video  getVideo(Video video) {
		System.out.println("+++++ getVideo service +++++");
		return videoInfoDao.queryVideoByVideoID(video);
		
	}
	/*getVideoInfo*/
	public VideoInfo  getVideoInfo(Video video) {
		System.out.println("+++++ getVideo service +++++");
		VideoInfo Rvideo = new VideoInfo();
		Video Getvideo = videoInfoDao.queryVideoByVideoID(video);
		Rvideo = Getvideo;
		String publishUserID = Getvideo.getPublishUserID();
		String str = nuserDao.queryHeadByID(publishUserID).getHeadPortraitAddress();
		if(str != null){
			Rvideo.setHeadPortraitAddress(str);
		  }
		return Rvideo;
		
	}
	/*showVideo*/
	public Video showVideo(User user) {
		System.out.println("+++++ showVideo service +++++");
		Video vi = new Video();
		vi.setPublishUserID(user.getUserID());
		return videoInfoDao.queryVideoByPublishUserID(vi);
	}
	
	/*getCityVideo*/
	@SuppressWarnings({ "rawtypes"})
	public List queryVideoByCity(Video video,User user) {

		System.out.println("++++  getCityVideo server  +++++");
		
		if(video.getCurrentLocation().isEmpty()){
			video.setCurrentLocation(videoInfoDao.queryCityByUserID(user));
			return videoInfoDao.queryVideoByCity(video);
		    
		}
		else{
			return videoInfoDao.queryVideoByCity(video);
		}
		
	}

}
