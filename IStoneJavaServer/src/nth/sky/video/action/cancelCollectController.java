package nth.sky.video.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
public class cancelCollectController {
	@Resource
	private VideoOperateService videoOperateService;

	@RequestMapping("/cancelCollect.do")
	@ResponseBody
	//public String cancelCollect(User user,Video video,@RequestParam String appKey){
	public void cancelCollect(HttpServletRequest request, HttpServletResponse response,@RequestParam("User") String json,@RequestParam("Video") String json1,@RequestParam("app") String appKey) throws IOException{
		commonController key=new commonController();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		/*json类型转换*/
		/*user*/
		Gson gson = new Gson();
		Type listType = new TypeToken<User>(){}.getType(); 
		User user = new User(); 
		user  = gson.fromJson(json,listType);
		/*video*/
		Type listType1 = new TypeToken<Video>(){}.getType(); 
		Video video = new Video(); 
		user  = gson.fromJson(json,listType1);
		if(appKey.equals(key.appKeyForJava)){
			System.out.println("秘钥正确,欢迎您!");
			String RJson=new Gson().toJson(videoOperateService.cancelCollect(user,video));
			out.println(RJson);
		}
	}

	public VideoOperateService getVideoOperateService() {
		return videoOperateService;
	}

	public void setVideoOperateService(VideoOperateService videoOperateService) {
		this.videoOperateService = videoOperateService;
	}
	
	
}
