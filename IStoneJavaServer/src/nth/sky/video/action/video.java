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
		System.out.println(appkey+"="+"��Կ");
		
		System.out.println("+++++�ղ�һ����Ƶ��ʼ+++++");
		videoOperateService.collectVideo(user,video,collection);
	}
	else 
		System.out.println("��Կ����ȷ����ȷ�Ϻ�����");
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
