package nth.sky.video.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nth.sky.video.po.Video;
import nth.sky.video.service.VideoService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Controller
public class getVideoAction {
	@Resource
	private VideoService videoService;
	
	@ResponseBody
	public void getVideo(HttpServletRequest request, HttpServletResponse response,@RequestParam("Video") String json,@RequestParam String appKey) throws IOException{
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		Gson gson = new Gson();
		Type listType = new TypeToken<Video>(){}.getType(); 
		Video video = new Video(); 
		video = gson.fromJson(json,listType);
		
		System.out.println("++++++here action+++");
		String RJson=new Gson().toJson(videoService.getVideo(video));
		out.println(RJson);
	}

	public VideoService getVideoService() {
		return videoService;
	}

	public void setVideoService(VideoService videoService) {
		this.videoService = videoService;
	}
	

}
