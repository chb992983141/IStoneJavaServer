package nth.sky.VideoRecording.action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.util.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nth.sky.VideoRecording.common.FTPupload;
import nth.sky.VideoRecording.common.VideoRecordingUtil;
import nth.sky.VideoRecording.po.BackgroundMusic;
import nth.sky.VideoRecording.po.Rstate;
import nth.sky.VideoRecording.po.VideoVo;
import nth.sky.VideoRecording.service.VRAdminService;
import nth.sky.VideoRecording.service.BackgroundMusicService;
import nth.sky.VideoRecording.service.VRVideoService;
import nth.sky.common.commonController;
import nth.sky.notifyInfo.po.Admin;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Controller
public class VideoRecordingAction {
	@Resource
	private VRVideoService VRvideoService;
	@Resource
	private BackgroundMusicService backgroundMusicService;
	@Resource
	private VRAdminService VRadminService;
	commonController key=new commonController();
	FTPupload ftpUpload =  new FTPupload();
	
	
	
	//---------------------video--------------------------
	@RequestMapping("/saveVideo.do")
	@ResponseBody
//	public void saveVideo(HttpServletRequest request, HttpServletResponse response,@RequestParam("appKey")  String appKey) throws JsonParseException, JsonMappingException, IOException {
	public void saveVideo(HttpServletRequest request, HttpServletResponse response,@RequestParam("file0") CommonsMultipartFile file,@RequestParam("file1") CommonsMultipartFile file1,@RequestParam("form") String Json, @RequestParam("appKey")  String appKey) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		System.out.println("saveVideoAction()");
//		System.out.println(Json);
		Gson gson = new Gson();
		String RJson = null;
		Rstate rstate = new Rstate();
		if(appKey.equals(key.appKeyForJava)){
			System.out.println("��Կ��ȷ��ִ�иò���");
			//jsonת��Ϊ������
			Type listType = new TypeToken<VideoVo>(){}.getType(); 
			VideoVo videoVo = new VideoVo();
			videoVo  = gson.fromJson(Json,listType);
			System.out.println(videoVo.getPublishUserID());
			
			//--��Ƶ��Ϣ��ȡ������--
			String currentDate = VideoRecordingUtil.getCurrentDate();

			//����VideoID
			String uuid = VideoRecordingUtil.getUUID();
			String videoID =currentDate +"-"+uuid;
			String storagePath ="C:\\ftp\\Video\\"+currentDate;
//			String storagePath ="ftp://59.68.29.64/Video/"+currentDate;
			String videostoragePath ="ftp://59.68.29.64/Video/"+videoID+".mp4";
			String coverstoragePath ="ftp://59.68.29.64/Video/"+videoID+".jpg";
					
			String videoTitle=(videoVo.getVideoTitle());
			String publishUserID=(videoVo.getPublishUserID());
			Timestamp publishTime=(videoVo.getPublishTime());
			String currentLocation=(videoVo.getCurrentLocation());
			
//			ftpUpload.connect("", "59.68.29.64", 21, "FTAdmin", "root");
//			ftpUpload.upload(file, file1, storagePath, videoID);
//		**********�����ϴ�***********
			if (!file.isEmpty()) {
				
				   String path = storagePath; 
//				   System.out.println(path);
				   String fileName = videoID;	       //��ȡ�ļ���
				   String fileType = ".mp4";//�ļ�����
				   File folder = new File(path);
				   if(!folder.exists()){
					   folder.mkdirs();
				   }
				    
				   File file2 = new File(path, fileName+fileType); //�½�һ���ļ�    new Date().getTime()+ fileType
				   try {
					    file.getFileItem().write(file2); //���ϴ����ļ�д���½����ļ���
					    System.out.println(path);
					    System.out.println(fileType);
				   } catch (Exception e) {
					    e.printStackTrace();
				   }
				   //�洢����
				   String fileType1 = ".jpg";//�ļ�����
				   
				   File file3 = new File(path, fileName+fileType1); //�½�һ���ļ�    new Date().getTime()+ fileType
				   try {
					    file1.getFileItem().write(file3); //���ϴ����ļ�д���½����ļ���
					    System.out.println(fileType1); 
				   } catch (Exception e) {
					    e.printStackTrace();
				   }
				   System.out.println("�洢�ɹ�");;
				}else{
					System.out.println("�ļ������ڣ�");;
				}
//****************************************************	
//*******************��������****************************
//			String videoTitle = "����";
//			String publishUserID = "179666806";
//			Timestamp publishTime = null;
//			String currentLocation ="����";
//****************************************************
			VRvideoService.saveVideo(coverstoragePath,videoID,videostoragePath, videoTitle, publishUserID, publishTime, currentLocation);
			rstate.setState("success");
			RJson = gson.toJson(rstate);
			out.println(RJson);
		}
		else{
			System.out.println("��Կ����,��ֹ���ʣ�");
			rstate.setState("fail");
			RJson = gson.toJson(rstate);
			out.println(RJson);
		}
   }
   
   
/*	@RequestMapping("/deleteVideo.do")
	@ResponseBody
    public String deleteVideo(@RequestParam("Json") String Json ,String appKey) {
		System.out.println(Json);
		String RJson = null;
		Rstate rstate = new Rstate();
		DeleteVideoVo deleteVideoVo = new DeleteVideoVo();
		
		Gson gson = new Gson();
		Type listType = new TypeToken<DeleteVideoVo>(){}.getType(); 
		
		if(appKey.equals(key.appKeyForJava)){
	    deleteVideoVo  = gson.fromJson(Json,listType);
	   
	    String videoID = deleteVideoVo.getVideoID();
	    System.out.println(videoID);
	    VRvideoService.deleteVideo(deleteVideoVo.getVideoID());
	    rstate.setState("success");
	    RJson = gson.toJson(rstate);
      return RJson;   
		}
		else{
			rstate.setState("fail");
	    	RJson = gson.toJson(rstate);
			return RJson;
		}
   }*/
	
	//------------------------BackgroundMusic------------------------
	@RequestMapping("/queryAllBackgroundMusic.do")
		@ResponseBody
    public String queryAllBackgroundMusic(@RequestParam("key") String appKey) {
		List<BackgroundMusic> AllBackgroundMusic = backgroundMusicService.queryAllBackgroundMusic("ddd");
		for(int i = 0;i<AllBackgroundMusic.size();i++){
		System.out.println(AllBackgroundMusic.get(i).getBackgroundMusicID());
		System.out.println(AllBackgroundMusic.get(i).getBackgroundMusicName());
		System.out.println(AllBackgroundMusic.get(i).getStoragePath());
		}
		System.out.println("queryAllBackgroundMusic.action");
		System.out.println("-------------------------");   
	      return "'state':'success'";
	   }

	@RequestMapping("/queryBackgroundMusic.do")
	@ResponseBody
    public String queryBackgroundMusic(@RequestParam("Json") String Json,String appKey) throws JsonParseException, JsonMappingException, IOException {
		BackgroundMusic backgroundMusic=new BackgroundMusic();
		//Jsonת��ΪVo����
		System.out.println(Json);
		ObjectMapper mapper = new ObjectMapper();
		backgroundMusic = mapper.readValue(Json, BackgroundMusic.class);
		System.out.println(backgroundMusic.getBackgroundMusicID());
		
		List<BackgroundMusic> BackgroundMusic = backgroundMusicService.queryBackgroundMusic(backgroundMusic,"ddd");
		for(int i = 0;i<BackgroundMusic.size();i++){
			System.out.println(BackgroundMusic.get(i).getBackgroundMusicID());
			System.out.println(BackgroundMusic.get(i).getBackgroundMusicName());
			System.out.println(BackgroundMusic.get(i).getStoragePath());
			}
		return null;
   }
	
  // ����Ա��ӱ������֣���Ϣ�������ݿ�
	@RequestMapping("/addBackgroundMusic.do")
	@ResponseBody
    public String addBackgroundMusic(@RequestParam("file") CommonsMultipartFile file,@RequestParam String adminID,@RequestParam String passWord,String appKey) {
		Admin admin = new Admin();
		admin.setAdminID(adminID);
		admin.setPassWord(passWord);
		if(VRadminService.queryAdmin(admin)){
			BackgroundMusic backgroundMusic = new BackgroundMusic();
			//jsonת����backgroundMusic����
			
/*			�ļ��洢
			if (!file.isEmpty()) {
			
			   String path = storagePath; 
			   System.out.println(path);
			   String fileName = videoID;	       //��ȡ�ļ���
			   String fileType = ".mp3";//�ļ�����
			   System.out.println(fileType); 
			   File file2 = new File(path, fileName+fileType); //�½�һ���ļ�    new Date().getTime()+ fileType
			   try {
				    file.getFileItem().write(file2); //���ϴ����ļ�д���½����ļ���
			   } catch (Exception e) {
				    e.printStackTrace();
			   }
			   System.out.println("�洢�ɹ�");;
			}else{
				System.out.println("�ļ������ڣ�");;
			}*/
			backgroundMusicService.addBackgroundMusic(backgroundMusic);
		}
		else
			return "cannot deal!";
		
      return "addsuccess";
   }
	
	// ����Ա��ӱ������֣���Ϣ�������ݿ�
		@RequestMapping("/deleteBackgroundMusic.do")
		@ResponseBody
    public String deleteBackgroundMusic(@RequestParam String adminID,@RequestParam String passWord,@RequestParam String backgroundMusicID,String appKey) {
			Admin admin = new Admin();
			admin.setAdminID(adminID);
			admin.setPassWord(passWord);
			if(VRadminService.queryAdmin(admin)){
				BackgroundMusic backgroundMusic = new BackgroundMusic();
				//jsonת����backgroundMusic����
				backgroundMusicService.deleteBackgroundMusic(backgroundMusic);
			}
			else
				return "cannot deal!";
			
	      return "addsuccess";
	   }
   
	public VRVideoService getVideoService() {
		return VRvideoService;
	}

	public void setVideoService(VRVideoService videoService) {
		this.VRvideoService = videoService;
	}
	
	public BackgroundMusicService getBackgroundMusicService() {
		return backgroundMusicService;
	}

	public void setBackgroundMusicService(
			BackgroundMusicService backgroundMusicService) {
		this.backgroundMusicService = backgroundMusicService;
	}

	public VRAdminService getAdminService() {
		return VRadminService;
	}

	public void setAdminService(VRAdminService adminService) {
		this.VRadminService = adminService;
	}
	
}
