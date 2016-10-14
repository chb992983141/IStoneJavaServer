package nth.sky.video.action;

import java.lang.reflect.Type;
import java.text.ParseException;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import nth.sky.common.commonController;
import nth.sky.user.po.User;
import nth.sky.video.po.Video;
import nth.sky.video.service.*;

@Controller
public class collectVideoController {
	@Resource
	private VideoOperateService VideoOperateService;

	@RequestMapping("/collectVideo.do")
	@ResponseBody
	//public String collectVideo(String Json,User user,Video video,String appKey) throws ParseException{
	public String collectVideo(@RequestParam("User") String json,@RequestParam("Video") String json1,@RequestParam String appKey) throws ParseException{
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
		video = gson.fromJson(json1,listType1);
		if(appKey.equals(key.appKeyForJava)){
			System.out.println("秘钥正确,欢迎您!");
			return new Gson().toJson(VideoOperateService.collectVideo(user,video));
		}
		return "false";
	}
	
	
	public VideoOperateService getVideoOperateService() {
		return VideoOperateService;
	}

	public void setVideoOperateService(VideoOperateService videoOperateService) {
		VideoOperateService = videoOperateService;
	}
	
}
