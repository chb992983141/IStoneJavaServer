package nth.sky.video.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nth.sky.common.PageFromJson;
import nth.sky.common.commonController;
import nth.sky.user.po.User;
import nth.sky.video.po.NewUser;
import nth.sky.video.service.VideoOperateService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Controller
public class showVideoListInFriend {
	@Resource
	private VideoOperateService videoOperateService=new VideoOperateService();

	@RequestMapping("/showVideoListInFriend.do")
	@ResponseBody
	//public String showVideoListInFriend(int page,User user,@RequestParam String appKey){
	public void showVideoListInFriend(HttpServletRequest request, HttpServletResponse response,@RequestParam("page") String pageJson,@RequestParam("userId") String json,@RequestParam String appKey) throws IOException{	
//	public void showVideoListInFriend(HttpServletRequest request, HttpServletResponse response) throws IOException{
	commonController key=new commonController();
	PageFromJson util  = new PageFromJson();
	response.setContentType("text/html;charset=UTF-8");
	PrintWriter out = response.getWriter();
	int page = util.getPage(pageJson);
//	int page =1;
		/*json类型转换*/
		Gson gson = new Gson();
		NewUser newUser=new NewUser();
//		newUser.setUserId("07DBF0E6C0418CFE6518BC24D4624287");
//		String appKey = "NewThread_Sky";
		Type listType = new TypeToken<NewUser>(){}.getType(); 
		newUser  = gson.fromJson(json,listType);
		System.out.println(newUser.getUserId());
		User user = new User(); 
		user.setUserID(newUser.getUserId());
		if(appKey.equals(key.appKeyForJava)){
			System.out.println("秘钥正确,欢迎您!");
			String RJson= new Gson().toJson(videoOperateService.showVideoListInFriend(page,user));
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
