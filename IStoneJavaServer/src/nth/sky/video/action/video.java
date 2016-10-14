package nth.sky.video.action;

import javax.annotation.Resource;

import nth.sky.video.service.VideoOperateService;

import org.springframework.stereotype.Controller;

@Controller

public class video {
	@Resource
	
	private VideoOperateService videoOperateService;
/*	@RequestMapping(value="/collectvideo.do")
	public void collectVideo(User user,Video video,
			Collection collection,String appkey){
	if(appkey.equalsIgnoreCase("NewThread_Sky")){
		System.out.println(appkey+"="+"秘钥");
		
		System.out.println("+++++收藏一个视频开始+++++");
		videoOperateService.collectVideo(user,video,collection);
	}
	else 
		System.out.println("秘钥不正确。请确认后重试");
	}*/
/*	@RequestMapping(value="/query.do")
	@ResponseBody
	public String showUser(String nickName){
		System.out.println("++++++++++show user+++++++");
		videoOperateService.showUser(nickName);
		//System.out.println(new Gson().toJson(videoOperateService.showUser(nickName)));
	    return new Gson().toJson(videoOperateService.showUser(nickName));
	}*/
	public VideoOperateService getVideoOperateService() {
		return videoOperateService;
	}

	public void setVideoOperateService(VideoOperateService videoOperateService) {
		this.videoOperateService = videoOperateService;
	}

}
