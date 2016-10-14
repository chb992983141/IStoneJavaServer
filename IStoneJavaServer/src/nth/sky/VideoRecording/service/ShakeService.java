package nth.sky.VideoRecording.service;

import java.util.List;
import java.util.Random;

import javax.annotation.Resource;

import nth.sky.VideoRecording.common.VideoRecordingUtil;
import nth.sky.VideoRecording.dao.ShakeDao;
import nth.sky.VideoRecording.po.ShakeVideo;
import nth.sky.notifyInfo.dao.NUserDao;
import nth.sky.user.po.User;
import nth.sky.video.po.Video;

import org.springframework.stereotype.Component;

@Component
public class ShakeService {
	@Resource
	ShakeDao shakeDao = new ShakeDao();
	@Resource 
	NUserDao nuserDao= new NUserDao(); 
	
	
	public ShakeVideo getARandomVideo(){
		List<Video> allVideo = shakeDao.queryAllVideo();
		int size = allVideo.size();
		int randomNum = new Random().nextInt(size);
		Video randomVideo = allVideo.get(randomNum);
		
		ShakeVideo shakeVideo = new ShakeVideo();
		User headAddress = (User) nuserDao.queryHeadByID(randomVideo.getPublishUserID());
		shakeVideo = VideoRecordingUtil.VideoToShakeVideo(headAddress.getHeadPortraitAddress(),randomVideo, shakeVideo);
		
		return shakeVideo;
	}
	
	

	public ShakeDao getShakeDao() {
		return shakeDao;
	}

	public void setShakeDao(ShakeDao shakeDao) {
		this.shakeDao = shakeDao;
	}



	public NUserDao getNuserDao() {
		return nuserDao;
	}



	public void setNuserDao(NUserDao nuserDao) {
		this.nuserDao = nuserDao;
	}
	
}
