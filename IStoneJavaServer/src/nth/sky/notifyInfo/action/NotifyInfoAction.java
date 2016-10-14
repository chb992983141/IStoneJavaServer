package nth.sky.notifyInfo.action;



import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nth.sky.common.commonController;
import nth.sky.notifyInfo.po.Admin;
import nth.sky.notifyInfo.po.FBNotice;
import nth.sky.notifyInfo.po.QuerySysInfoByState;
import nth.sky.notifyInfo.po.Report;
import nth.sky.notifyInfo.po.State;
import nth.sky.notifyInfo.po.SysNotice;
import nth.sky.notifyInfo.po.UserNotice;
import nth.sky.notifyInfo.service.AdminService;
import nth.sky.notifyInfo.service.FBNoticeService;
import nth.sky.notifyInfo.service.ReportService;
import nth.sky.notifyInfo.service.SysNoticeService;
import nth.sky.notifyInfo.service.UserNoticeService;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;



@Component
@Controller
public class NotifyInfoAction {

	@Resource
	private FBNoticeService fbNoticeService ;
	
	@Resource
	private ReportService reportService ;
	
	@Resource
	private SysNoticeService sysNoticeService ;
	
	@Resource
	private UserNoticeService userNoticeService;
	
	@Resource
	private AdminService adminService ;
	
	commonController key = new commonController();
	
	@RequestMapping("/addUserFB.do")
	@ResponseBody
	public String addUserFB(@RequestParam("form") String json,@RequestParam("appKey") String appKey) throws ParseException, JsonGenerationException, JsonMappingException, IOException {
	   
	    State state = new State();
	    Gson gson = new Gson();
		if(appKey.equals(key.appKeyForJava)){
			UUID id= java.util.UUID.randomUUID();
			String str = id.toString();
			Type listType = new TypeToken<FBNotice>(){}.getType(); 
			FBNotice fbNotice = new FBNotice();
		    fbNotice  = gson.fromJson(json,listType);
		    fbNotice.setFeedbackID(str);
		    if(fbNoticeService.addUserFB(fbNotice).equals("success")){
		    	state.setState(1);
		    }else{
		    	state.setState(0);
		    }
			return gson.toJson(state);
		}else{
			state.setState(0);
			return gson.toJson(state);
		}
	}

	
	@RequestMapping("/queryUserFB.do")
	@ResponseBody
	public String queryUserFB(HttpServletRequest request) throws JsonGenerationException, JsonMappingException, IOException{
		Admin admin = new Admin();
		admin.setAdminID("123123");
		List<FBNotice> list =new ArrayList<FBNotice>();
		list = fbNoticeService.queryUserFB(admin);
		request.setAttribute("fbNotice", list);
		return "/information";
	}
	@RequestMapping("/showUserFB.do")
	@ResponseBody
	public void showUserFB(HttpServletRequest request, HttpServletResponse response,@RequestParam("fbNotice") String fbNotice) throws IOException{
		Admin admin = new Admin();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		admin.setAdminID("123123");
		Gson gson = new Gson();
		Type listType = new TypeToken<FBNotice>(){}.getType(); 
		FBNotice fbNotice1 = new FBNotice();
		fbNotice1  = gson.fromJson(fbNotice,listType);
		String RJson =  gson.toJson(fbNoticeService.queryUserFB(fbNotice1, admin));
		out.println(RJson);
	}
	@RequestMapping("/deleteUserFB.do")
	@ResponseBody
	public String deleteUserFB(@RequestParam("fbNotice") String fbNotice){
		Admin admin = new Admin();
		admin.setAdminID("123123");
		Gson gson = new Gson();
		Type listType = new TypeToken<FBNotice>(){}.getType(); 
		FBNotice fbNotice1 = new FBNotice();
		fbNotice1  = gson.fromJson(fbNotice,listType);
		State state = new State();
		 if(fbNoticeService.deleteUserFB(fbNotice1, admin).equals("success")){
		    	state.setState(1);
		    }else{
		    	state.setState(0);
		    }
		return gson.toJson(state);
	}
	
	
	
	
	/*public String queryCity(){
		User user = new User();
		user.setCity("ÄÏ¾©ÊÐ");
		System.out.println(fbNoticeService.queryCity(user).toString());
		return null;
	}*/
	
	@RequestMapping("/addUserReport.do")
	@ResponseBody
	public String addReport(@RequestParam("form") String json,@RequestParam("appKey") String appKey) throws ParseException, JsonGenerationException, JsonMappingException, IOException {
		Gson gson = new Gson();
		State state = new State();
		if(key.appKeyForJava.equals(appKey)){
			Type listType = new TypeToken<Report>(){}.getType(); 
			Report report = new Report(); 
			report  = gson.fromJson(json,listType);
		    if(reportService.addReport(report).equals("success")){
		    	state.setState(1);
		    }else{
		    	state.setState(0);
		    }
			return gson.toJson(state);
		}else{
			state.setState(0);
			return gson.toJson(state);
		}

	}
	
	@RequestMapping("/queryUserReport.do")
	//@ResponseBody
	public String queryUserReport(HttpServletRequest request) throws JsonGenerationException, JsonMappingException, IOException{
		Admin admin = new Admin();
		admin.setAdminID("123123");
		List<Report> report = new ArrayList<Report>();
		report = reportService.queryUserReport(admin);
		request.setAttribute("report",report);
	    return "/videoView";
	}
	
	@RequestMapping("/showUserReport.do")
	@ResponseBody
	public void showUserReport(HttpServletRequest request, HttpServletResponse response,@RequestParam("report") String report) throws IOException{
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		Admin admin = new Admin();
		admin.setAdminID("123123");
		Gson gson = new Gson();
		Type listType = new TypeToken<Report>(){}.getType(); 
		Report report1 = new Report();
		report1  = gson.fromJson(report,listType);
		String RJson =gson.toJson(reportService.queryUserReport(report1, admin));
		out.println(RJson);
	}
	
	@RequestMapping("/deleteUserReport.do")
	@ResponseBody
	public String deleteUserReport(@RequestParam("report") String report){
		Admin admin = new Admin();
		admin.setAdminID("123123");
		Gson gson = new Gson();
		Type listType = new TypeToken<Report>(){}.getType(); 
		Report report1 = new Report();
		report1  = gson.fromJson(report,listType);
		State state = new State();
		 if(reportService.deleteUserReport(report1, admin).equals("success")){
		    	state.setState(1);
		    }else{
		    	state.setState(0);
		    }
		return gson.toJson(state);
	}
	
	@RequestMapping("/publishSysInfo.do")
	@ResponseBody
	public String publishSysInfo(@RequestParam("sysNotice") String sysNotice){
		Admin admin = new Admin();
		admin.setAdminID("2012213542");
		Gson gson = new Gson();
		Type listType = new TypeToken<SysNotice>(){}.getType(); 
		SysNotice sysNotice1 = new SysNotice();
		sysNotice1  = gson.fromJson(sysNotice,listType);
	    State state = new State();
	    if(sysNoticeService.publishSysInfo(admin, sysNotice1).equals("success")){
	    	state.setState(1);
	    }else{
	    	state.setState(0);
	    }
		return gson.toJson(state);
		
	}
	
	@RequestMapping("/querySysInfoByAdmin.do")
	public String querySysInfoByAdmin(HttpServletRequest request){
		SysNotice sysNotice = new SysNotice();
		sysNoticeService.querySysInfoByState(sysNotice);
		request.setAttribute("sysNotice", sysNotice);
		return "/information";
	}
	
	
	@RequestMapping("/querySysInfoByState.do")
	@ResponseBody
	public void querySysInfoByState(HttpServletRequest request, HttpServletResponse response,@RequestParam("form") String json,@RequestParam("appKey") String appKey) throws IOException{
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		Gson gson = new Gson();
		if(key.appKeyForJava.equals(appKey)){
			Type listType = new TypeToken<SysNotice>(){}.getType(); 
			SysNotice sysNotice = new SysNotice();
			sysNotice = gson.fromJson(json,listType);
			List<QuerySysInfoByState> list = new  ArrayList<QuerySysInfoByState>();
			List<SysNotice> list2 = sysNoticeService.querySysInfoByState(sysNotice);
			  for(int i=0;i<list2.size();i++){
			        SysNotice objects=list2.get(i);
			        QuerySysInfoByState query = new QuerySysInfoByState();
			        query.setPublisher(objects.getPublisher());
			        query.setSysNotice(objects.getSysNotice());
			        query.setSysNoticeID(objects.getSysNoticeID());
			        list.add(query);
			        }
			String RJson= gson.toJson(list);
			out.println(RJson);
		}
		
	}

	@RequestMapping("/querySysInfoByID.do")
	@ResponseBody
	public void querySysInfoByID(HttpServletRequest request, HttpServletResponse response,@RequestParam("sysNotice") String sysNotice) throws IOException{
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		Gson gson = new Gson();
		Type listType = new TypeToken<SysNotice>(){}.getType(); 
		SysNotice sysNotice1 = new SysNotice();
		sysNotice1  = gson.fromJson(sysNotice,listType);
		String RJson = gson.toJson(sysNoticeService.querySysInfoByID(sysNotice1));
		out.println(RJson);
		
	}
	
	@RequestMapping("/updateSysInfoCondition.do")
	@ResponseBody
    public String updateSysInfoCondition(@RequestParam("sysNotice") String sysNotice){
		Admin admin = new Admin();
		admin.setAdminID("2012213542");
		Gson gson = new Gson();
		Type listType = new TypeToken<SysNotice>(){}.getType(); 
		SysNotice sysNotice1 = new SysNotice();
		sysNotice1  = gson.fromJson(sysNotice,listType);
	    State state = new State();
	    if(sysNoticeService.updateSysInfoCondition(admin, sysNotice1).equals("success")){
	    	state.setState(1);
	    }else{
	    	state.setState(0);
	    }
		return gson.toJson(state);
    }
 	
	
	@RequestMapping("/queryNoticeInfo.do")
	@ResponseBody
	public void queryNoticeInfo(HttpServletRequest request, HttpServletResponse response,@RequestParam("form") String json,@RequestParam("appKey") String appKey) throws IOException{
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		Gson gson = new Gson();
		if(appKey.equals(key.appKeyForJava)){
			Type listType = new TypeToken<UserNotice>(){}.getType(); 
			UserNotice userNotice = new UserNotice();
			userNotice  = gson.fromJson(json,listType);
			String RJson = gson.toJson(userNoticeService.queryNoticeInfo(userNotice));
			out.println(RJson);
		}
	}
	
	@RequestMapping("/showNoticeInfo.do")
	@ResponseBody
	public void showNoticeInfo(HttpServletRequest request, HttpServletResponse response,@RequestParam("form") String json,@RequestParam("appKey") String appKey) throws IOException{
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		Gson gson = new Gson();
		if(appKey.equals(key.appKeyForJava)){
		Type listType = new TypeToken<UserNotice>(){}.getType(); 
		UserNotice userNotice = new UserNotice();
		userNotice  = gson.fromJson(json,listType);
		String RJson = gson.toJson(userNoticeService.showNoticeInfo(userNotice));
		out.println(RJson);
		}
	}
	
	@RequestMapping("/deleteNoticeInfo.do")
	@ResponseBody
	public String deleteNoticeInfo(@RequestParam("form") String json,@RequestParam("appKey") String appKey){
		Gson gson = new Gson();
		if(appKey.equals(key.appKeyForJava)){
		Type listType = new TypeToken<UserNotice>(){}.getType(); 
		UserNotice userNotice = new UserNotice();
		userNotice  = gson.fromJson(json,listType);
		State state = new State();
	    if(userNoticeService.deleteNoticeInfo(userNotice).equals("success")){
	    	state.setState(1);
	    }else{
	    	state.setState(0);
	    }
		return gson.toJson(state);
		}
		return null;
	}
	
	@RequestMapping("/deleteAllNoticeInfo.do")
	@ResponseBody
	public String deleteAllNoticeInfo(@RequestParam("form") String json,@RequestParam("appKey") String appKey){
		Gson gson = new Gson();
		if(appKey.equals(key.appKeyForJava)){
		Type listType = new TypeToken<UserNotice>(){}.getType(); 
		UserNotice userNotice = new UserNotice();
		userNotice  = gson.fromJson(json,listType);
		State state = new State();
		  if(userNoticeService.deleteAllNoticeInfo(userNotice).equals("success")){
		    	state.setState(1);
		    }else{
		    	state.setState(0);
		    }
		return gson.toJson(state);
		}
		return null;
	}
	@RequestMapping("/addNoticeInfo.do")
	@ResponseBody
	public String addNoticeInfo(@RequestParam("form") String json,@RequestParam("appKey") String appKey){
		Gson gson = new Gson();
		if(appKey.equals(key.appKeyForJava)){
		Type listType = new TypeToken<UserNotice>(){}.getType(); 
		UserNotice userNotice = new UserNotice();
		userNotice  = gson.fromJson(json,listType);
		State state = new State();
		 if(userNoticeService.addNoticeInfo(userNotice).equals("success")){
		    	state.setState(1);
		    }else{
		    	state.setState(0);
		    }
		return gson.toJson(state);
		}
		return null;
	}
	
	@RequestMapping("/denglu.do")
	public String denglu(String adminID,String passWord,HttpServletRequest request){
		Admin admin = new Admin();
		admin.setAdminID(adminID);
		admin.setPassWord(passWord);
		new Gson();
		List<Report> report = new ArrayList<Report>();
		report = reportService.queryUserReport(admin);
		request.setAttribute("report", report);
		 if(adminService.denglu(admin).equals("success")){
			    request.setAttribute("state", 1);
			    request.setAttribute("report", report);
		    	//state.setState(1);
		    	return "/videoView";
		    }else{
		    	//state.setState(0);
		    	return "/index";
		    }
	}
	public FBNoticeService getFbNoticeService() {
		return fbNoticeService;
	}

	public void setFbNoticeService(FBNoticeService fbNoticeService) {
		this.fbNoticeService = fbNoticeService;
	}
	
	public ReportService getReportService() {
		return reportService;
	}


	public void setReportService(ReportService reportService) {
		this.reportService = reportService;
	}


	public SysNoticeService getSysNoticeService() {
		return sysNoticeService;
	}


	public void setSysNoticeService(SysNoticeService sysNoticeService) {
		this.sysNoticeService = sysNoticeService;
	}


	public UserNoticeService getUserNoticeService() {
		return userNoticeService;
	}


	public void setUserNoticeService(UserNoticeService userNoticeService) {
		this.userNoticeService = userNoticeService;
	}


	public AdminService getAdminService() {
		return adminService;
	}


	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}


	public commonController getKey() {
		return key;
	}


	public void setKey(commonController key) {
		this.key = key;
	}
	
}
