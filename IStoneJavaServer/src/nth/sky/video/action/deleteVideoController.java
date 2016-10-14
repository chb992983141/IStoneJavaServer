package nth.sky.video.action;

import java.lang.reflect.Type;

import javax.annotation.Resource;

import nth.sky.common.commonController;
import nth.sky.video.po.Video;
import nth.sky.video.service.VideoInfoService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Controller
public class deleteVideoController {
	@Resource
	private VideoInfoService videoInfoService;
	@RequestMapping("/deleteVideo.do")
	//public String deleteVideo(Video video,@RequestParam String appKey){
	public String deleteVideo(@RequestParam("Video") String json,@RequestParam String appKey){
		Gson gson = new Gson();
		Type listType = new TypeToken<Video>(){}.getType(); 
		Video video = new Video(); 
		video = gson.fromJson(json,listType);
		
		commonController key=new commonController();
		if(appKey.equals(key.appKeyForJava)){
			System.out.println("ÃØÔ¿ÕýÈ·,»¶Ó­Äú!");
			return new Gson().toJson(videoInfoService.deleteVideo(video));
		}
		return "false";
	}
	
	
	public VideoInfoService getVideoInfoService() {
		return videoInfoService;
	}

	public void setVideoInfoService(VideoInfoService videoInfoService) {
		this.videoInfoService = videoInfoService;
	}
	

}
