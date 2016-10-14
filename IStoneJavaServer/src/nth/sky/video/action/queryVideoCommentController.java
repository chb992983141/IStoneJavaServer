package nth.sky.video.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nth.sky.common.commonController;
import nth.sky.video.po.Video;
import nth.sky.video.service.VideoOperateService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Controller
public class queryVideoCommentController {
	@Resource
	private VideoOperateService videoOperateService;

	@RequestMapping("/queryVideoComment.do")
	//public String queryVideoComment(Video video,@RequestParam String appKey){
	public void queryVideoComment(HttpServletRequest request, HttpServletResponse response,@RequestParam("Video") String json,@RequestParam String appKey) throws IOException{
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		commonController key=new commonController();
		/*json类型转换*/
		Gson gson = new Gson();
		Type listType = new TypeToken<Video>(){}.getType(); 
		Video video = new Video(); 
		video = gson.fromJson(json,listType);
		if(appKey.equals(key.appKeyForJava)){
			System.out.println("秘钥正确,欢迎您!");
			String RJson = new Gson().toJson(videoOperateService.queryVideoComment(video));
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
