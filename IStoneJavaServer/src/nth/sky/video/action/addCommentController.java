package nth.sky.video.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.text.ParseException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nth.sky.common.commonController;
import nth.sky.user.po.User;
import nth.sky.video.po.Comment;
import nth.sky.video.po.Video;
import nth.sky.video.service.VideoOperateService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Controller
public class addCommentController {
	@Resource
	private VideoOperateService videoOperateService;

	@RequestMapping("/addComment.do")
	@ResponseBody
	//public String addComment( User user,Video video,Comment comment,@RequestParam("appKey") String appKey) throws ParseException{
	public void addComment(HttpServletRequest request, HttpServletResponse response,@RequestParam("User") String json,@RequestParam("Video") String json1,
			@RequestParam("Comment") String json11,@RequestParam("app") String appKey) throws ParseException, IOException{
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		commonController key=new commonController();
		/*json类型转换*/
		/*user*/
		Gson gson = new Gson();
		Type listType = new TypeToken<User>(){}.getType(); 
		User user = new User(); 
		user = gson.fromJson(json,listType);
		/*video*/
		Type listType1 = new TypeToken<Video>(){}.getType(); 
		Video video = new Video(); 
		video = gson.fromJson(json1,listType1);
		/*comment*/
		Type listType11 = new TypeToken<Comment>(){}.getType(); 
		Comment comment = new Comment(); 
		comment = gson.fromJson(json11,listType11);
		
		if(appKey.equals(key.appKeyForJava)){
			System.out.println("秘钥正确,欢迎您!");
			String RJson=new Gson().toJson(videoOperateService.addComment(user,video,comment));
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
