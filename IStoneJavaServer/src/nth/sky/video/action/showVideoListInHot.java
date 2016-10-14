package nth.sky.video.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nth.sky.common.PageFromJson;
import nth.sky.common.commonController;
import nth.sky.video.service.VideoOperateService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

@Controller
public class showVideoListInHot {
	@Resource
	private VideoOperateService videoOperateService;

	@RequestMapping("/showVideoListInHot.do")
	@ResponseBody
	public void showVideoListInHot(HttpServletRequest request, HttpServletResponse response,@RequestParam("page") String pageJson,@RequestParam String appKey) throws IOException{	
		commonController key=new commonController();
		PageFromJson util  = new PageFromJson();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		int page = util.getPage(pageJson);
		//int page = 1;
		if(appKey.equals(key.appKeyForJava)){
			System.out.println("ÃØÔ¿ÕýÈ·,»¶Ó­Äú!");
//			System.out.println(new Gson().toJson(videoOperateService.showVideoListInHot(page)));
			String RJson =  new Gson().toJson(videoOperateService.showVideoListInHot(page));
			out.println(RJson);
		}
//		return "false";
	}
	
	public VideoOperateService getVideoOperateService() {
		return videoOperateService;
	}

	public void setVideoOperateService(VideoOperateService videoOperateService) {
		this.videoOperateService = videoOperateService;
	}
	
	
}
