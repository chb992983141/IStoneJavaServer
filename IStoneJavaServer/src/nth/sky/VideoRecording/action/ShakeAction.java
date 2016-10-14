package nth.sky.VideoRecording.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nth.sky.VideoRecording.po.ShakeVideo;
import nth.sky.VideoRecording.service.ShakeService;
import nth.sky.common.commonController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

@Controller
public class ShakeAction {
	@Resource
	ShakeService shakeService = new ShakeService();
	commonController key=new commonController();

	@RequestMapping("/shake.do")
	@ResponseBody
	public void shakeVideo(HttpServletRequest request, HttpServletResponse response,@RequestParam String appKey) throws IOException{
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		if(appKey.equals(key.appKeyForJava)){
		ShakeVideo theShakeVideo = shakeService.getARandomVideo();
		Gson gson = new Gson();
		String RJson;
		RJson = gson.toJson(theShakeVideo);
		System.out.println(RJson);
		out.println(RJson);
		}
	}

	public ShakeService getShakeService() {
		return shakeService;
	}
	public void setShakeService(ShakeService shakeService) {
		this.shakeService = shakeService;
	}
	
	
}
