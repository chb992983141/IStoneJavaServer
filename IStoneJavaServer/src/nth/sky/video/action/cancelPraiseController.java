package nth.sky.video.action;

import java.lang.reflect.Type;

import javax.annotation.Resource;

import nth.sky.common.commonController;
import nth.sky.user.po.User;
import nth.sky.video.po.Video;
import nth.sky.video.service.VideoOperateService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Controller
public class cancelPraiseController {
	@Resource
	private VideoOperateService videoOperateService;

	@RequestMapping("/cancelPraise.do")
	@ResponseBody
	//public String cancelPraise(User user,Video video,@RequestParam String appKey){
	public String cancelPraise(@RequestParam("User") String json,@RequestParam("Video") String json1,@RequestParam String appKey){
		commonController key=new commonController();
		/*json类型转换*/
		Gson gson = new Gson();
		/*user*/
		Type listType = new TypeToken<User>(){}.getType(); 
		User user = new User(); 
		user = gson.fromJson(json,listType);
		/*video*/
		Type listType1 = new TypeToken<Video>(){}.getType(); 
		Video video = new Video(); 
		video = gson.fromJson(json,listType1);
		
		if(appKey.equals(key.appKeyForJava)){
			System.out.println("秘钥正确,欢迎您!");
			return new Gson().toJson(videoOperateService.cancelPraise(user,video));
		}
		return "false";
	}

	public VideoOperateService getVideoOperateService() {
		return videoOperateService;
	}

	public void setVideoOperateService(VideoOperateService videoOperateService) {
		this.videoOperateService = videoOperateService;
	}


}
