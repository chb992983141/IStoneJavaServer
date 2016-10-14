package nth.sky.video.action;

import java.lang.reflect.Type;
import java.text.ParseException;

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
public class referenceCommentController {
	@Resource
	private VideoOperateService videoOperateService;

	/*user0 = 第一个评论人的ID
	user1 = 回复第一个评论人的人的ID*/
	@RequestMapping("/referenceComment.do")
	
	//public String referenceComment(int cSID,User user,Video video,Comment referencecomment,
			//@RequestParam String appKey) throws ParseException{
	public String referenceComment(@RequestParam("Comment") String json,@RequestParam("User") String json1,
			@RequestParam("Video") String json11,@RequestParam("Comment") String json111,
						@RequestParam String appKey) throws ParseException{
		commonController key=new commonController();
		/*json类型转换*/
		Gson gson = new Gson();
		/*Comment cSID*/
		Type listType = new TypeToken<Comment>(){}.getType(); 
		Comment cSID = new Comment(); 
		cSID  = gson.fromJson(json,listType);
		/*User*/
		Type listType1 = new TypeToken<User>(){}.getType(); 
		User user = new User(); 
		user = gson.fromJson(json1,listType1);
		/*video*/
		Type listType11 = new TypeToken<Video>(){}.getType(); 
		Video video = new Video(); 
		video = gson.fromJson(json11,listType11);
		/*comment */
		Type listType111 = new TypeToken<Comment>(){}.getType(); 
		Comment referencecomment = new Comment(); 
		referencecomment  = gson.fromJson(json111,listType111);
		
		if(appKey.equals(key.appKeyForJava)){
			System.out.println("秘钥正确,欢迎您!");
			return new Gson().toJson(videoOperateService.referenceComment(cSID,user,video,referencecomment));
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
