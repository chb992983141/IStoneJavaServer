package nth.sky.video.action;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

import nth.sky.video.po.Video;
import nth.sky.video.service.VideoInfoService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ServletContextAware;
import com.google.gson.Gson;
import nth.sky.common.*;
@Controller
public class publishVideoController implements ServletContextAware{
	@Resource
	private VideoInfoService videoInfoService;
	
	public void setServletContext(ServletContext context) {
	}
	
	@RequestMapping("/publishVideo.do")
	@ResponseBody
	public String publishVideo(Video video,@RequestParam("appKey")String appKey/*,@RequestParam CommonsMultipartFile file*/){
		commonController key=new commonController();
		if(appKey.equals(key.appKeyForJava)){
			System.out.println("��Կ��ȷ,��ӭ��!");
			return new Gson().toJson(videoInfoService.publishVideo(video));
		}
	/*	if (!file.isEmpty()) {
			String path = "D:\\txt";
			System.out.println("�㱣����ļ�·���ǣ�"+path);
			String fileType = ".mp4";
			String newFileName=java.util.UUID.randomUUID().toString();
			System.out.println("��Ƶ���ļ���Ϊ��"+newFileName+".mp4");
			File file2 = new File(path,newFileName + fileType); //�½�һ���ļ�
			try {
				file.getFileItem().write(file2); //���ϴ����ļ�д���½����ļ���
				} catch (Exception e) {
					e.printStackTrace();
			   }
			return new Gson().toJson(videoInfoService.publishVideo(video));
			}else*/
				return "false";
	}
	public VideoInfoService getVideoInfoService() {
		return videoInfoService;
	}

	public void setVideoInfoService(VideoInfoService videoInfoService) {
		this.videoInfoService = videoInfoService;
	}

}
