package nth.sky.video.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nth.sky.VideoRecording.po.BackgroundMusic;
import nth.sky.common.commonController;
import nth.sky.video.po.NewVideo;
import nth.sky.video.po.Video;
import nth.sky.video.service.VideoInfoService;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Controller
public class getVideoController {
	@Resource
	private VideoInfoService videoInfoService;

	@RequestMapping("/getVideo.do")
	@ResponseBody
	//public String getVideo(Video video,@RequestParam String appKey){
	public void getVideo(HttpServletRequest request, HttpServletResponse response,@RequestParam("videoId") String json,@RequestParam String appKey) throws IOException{
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		System.out.println(json);
		Gson gson = new Gson();
		Type listType = new TypeToken<NewVideo>(){}.getType(); 
		Video video = new Video(); 	
		NewVideo Nvideo = new NewVideo();
		Nvideo = gson.fromJson(json,listType);
		video.setVideoID(Nvideo.getVideoId());
		System.out.println(video.getVideoID());
	
		commonController key=new commonController();
		if(appKey.equals(key.appKeyForJava)){
			System.out.println("ÃØÔ¿ÕýÈ·,»¶Ó­Äú!");
			String RJson=new Gson().toJson(videoInfoService.getVideoInfo(video));
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
