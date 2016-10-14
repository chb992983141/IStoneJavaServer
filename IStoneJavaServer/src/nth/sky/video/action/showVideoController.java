package nth.sky.video.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nth.sky.common.commonController;
import nth.sky.user.po.User;
import nth.sky.video.service.VideoInfoService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
@Controller
public class showVideoController {
	@Resource
	private VideoInfoService videoInfoService;
	@RequestMapping("/showVideo.do")
	@ResponseBody
	//public String showVideo(@RequestParam("userID") String user,@RequestParam String appKey){
	public void showVideo(HttpServletRequest request, HttpServletResponse response,@RequestParam("User") String json,@RequestParam String appKey) throws IOException{
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		Gson gson = new Gson();
		Type listType = new TypeToken<User>(){}.getType(); 
		User user = new User(); 
		user = gson.fromJson(json,listType);
		
		commonController key=new commonController();
		if(appKey.equals(key.appKeyForJava)){
			System.out.println("ÃØÔ¿ÕýÈ·,»¶Ó­Äú!");
			String RJson=new Gson().toJson(videoInfoService.showVideo(user));
			out.println(RJson);
		}
	}
	
	
	public VideoInfoService getVideoInfoService() {
		return videoInfoService;
	}

	public void setVideoInfoService(VideoInfoService videoInfoService) {
		this.videoInfoService = videoInfoService;
	}
	
}
