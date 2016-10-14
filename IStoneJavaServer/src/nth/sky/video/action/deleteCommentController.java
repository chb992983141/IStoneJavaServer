package nth.sky.video.action;

import java.lang.reflect.Type;

import javax.annotation.Resource;

import nth.sky.common.commonController;
import nth.sky.user.po.User;
import nth.sky.video.po.Comment;
import nth.sky.video.po.Video;
import nth.sky.video.service.VideoOperateService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Controller
public class deleteCommentController {
	@Resource
	private VideoOperateService videoOperateService;

	@RequestMapping("/deleteComment.do")
	//public String deleteComment(User user,Video video,Comment comment,String appKey){
	public String deleteComment(@RequestParam("User") String json,@RequestParam("Video") String json1,
			@RequestParam("Comment") String json11,@RequestParam String appKey){
		commonController key=new commonController();
		/*json类型转换*/
		Gson gson = new Gson();
		/*User*/
		Type listType = new TypeToken<User>(){}.getType(); 
		User user = new User(); 
		user = gson.fromJson(json,listType);
		/*Video*/
		Type listType1 = new TypeToken<Video>(){}.getType(); 
		Video video = new Video(); 
		video = gson.fromJson(json1,listType1);
		/*Comment*/
		Type listType11 = new TypeToken<Comment>(){}.getType(); 
		Comment comment = new Comment(); 
		comment  = gson.fromJson(json11,listType11);
		if(appKey.equals(key.appKeyForJava)){
			System.out.println("秘钥正确,欢迎您!");
			return new Gson().toJson(videoOperateService.deleteComment(user,video,comment));
		}		
		return "false";
	}
	public VideoOperateService getVideoOperateService() {
		return videoOperateService;
	}

	public void setVideoOperateService(VideoOperateService videoOperateService) {
		this.videoOperateService = videoOperateService;
	}
	
}
