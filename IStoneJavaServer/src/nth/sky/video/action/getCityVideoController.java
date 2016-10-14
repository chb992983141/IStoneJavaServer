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
import nth.sky.video.service.VideoInfoService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


@Controller
public class getCityVideoController {
	@Resource
	private VideoInfoService videoInfoService;
	@RequestMapping("/getCityVideo.do")
	@ResponseBody
	//public String getCityVideo(Video video,User user,@RequestParam String appKey) {
	public void getCityVideo(HttpServletRequest request, HttpServletResponse response,@RequestParam("Video") String json,@RequestParam("User") String json1,@RequestParam String appKey) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		Gson gson = new Gson();
		/*video*/
		Type listType = new TypeToken<Video>(){}.getType(); 
		Video video = new Video(); 
		video = gson.fromJson(json1,listType);
		/*user*/
		Type listType1 = new TypeToken<User>(){}.getType(); 
		User user = new User(); 
		user = gson.fromJson(json1,listType1);
		
		commonController key=new commonController();
		if(appKey.equals(key.appKeyForJava)){
			System.out.println("ÃØÔ¿ÕýÈ·,»¶Ó­Äú!");
			String RJson=new Gson().toJson(videoInfoService.queryVideoByCity(video, user));
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
