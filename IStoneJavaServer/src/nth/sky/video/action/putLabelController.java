package nth.sky.video.action;

import java.lang.reflect.Type;
import java.text.ParseException;

import javax.annotation.Resource;

import nth.sky.common.commonController;
import nth.sky.video.po.Label;
import nth.sky.video.po.Video;
import nth.sky.video.service.VideoOperateService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Controller
public class putLabelController {
	@Resource
	private VideoOperateService videoOperateService;

	@RequestMapping("/putLabel.do")
	@ResponseBody
	//public String putLabel(Video video,Label label,@RequestParam String appKey) throws ParseException{
	public String putLabel(@RequestParam("Video") String json,@RequestParam("Label") String json1,@RequestParam String appKey) throws ParseException{
		commonController key=new commonController();
		/*json类型转换*/
		Gson gson = new Gson();
		/*video*/
		Type listType = new TypeToken<Video>(){}.getType(); 
		Video video = new Video(); 
		video = gson.fromJson(json,listType);
		/*label*/
		Type listType1 = new TypeToken<Label>(){}.getType(); 
		Label label = new Label(); 
		label = gson.fromJson(json1,listType1);
		if(appKey.equals(key.appKeyForJava)){
			System.out.println("秘钥正确,欢迎您!");
			return new Gson().toJson(videoOperateService.putLabel(video,label));
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
