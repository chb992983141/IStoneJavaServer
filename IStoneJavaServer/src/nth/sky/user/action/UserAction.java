package nth.sky.user.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nth.sky.common.commonController;
import nth.sky.user.po.NewUserName;
import nth.sky.user.po.User;
import nth.sky.user.po.User_state;
import nth.sky.user.service.AttentionService;
import nth.sky.user.service.CityService;
import nth.sky.user.service.UserService;
import nth.sky.video.po.NewUser;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
@Controller
public class UserAction {
	@Resource
	UserService userService=new UserService();
	@Resource
	AttentionService attentionService = new AttentionService();
	@Resource
	CityService cityService = new CityService();


	commonController key=new commonController();
	
	@RequestMapping("/addUser.do")
	@ResponseBody
	 public void addUser(HttpServletRequest request, HttpServletResponse response,@RequestParam("user") String json, @RequestParam("appKey") String appKey) throws IOException {
		String RJson=null;
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		System.out.println("successe");
		System.out.println(json);
		System.out.println(appKey);
		
		if(appKey.equals(key.appKeyForJava)){
			Gson gson= new Gson();
			Type listType = new TypeToken<User>(){}.getType(); 
		    User user  = gson.fromJson(json,listType);
		    
		    System.out.println(user.getUserID());
		    System.out.println(user.getCity());
		    User checkUser=userService.getUserInfo(user);
//		    System.out.println(checkUser.getCityID());
		    if(checkUser==null){
		    	int cityID=cityService.getCityID(user).getCityID();
//		    	int cityID=111;
		    	System.out.println(cityID);
		    	user.setCityID(cityID);
				userService.addUser(user);
				RJson = gson.toJson(userService.getUserInfo(user));
				out.println(RJson);
			}
		    RJson = gson.toJson(checkUser);
		    out.println(RJson);
		}
	   }
	   
	  @RequestMapping("/updateUserInfo.do")
	  @ResponseBody
	   public User_state updateUserInfo(@RequestParam("user") String json, @RequestParam("appKey") String appKey) {
		  User_state state= new User_state();
			if(appKey.equals(key.appKeyForJava)){
				Gson gson= new Gson();
				Type listType = new TypeToken<User>(){}.getType(); 
			    User user  = gson.fromJson(json,listType);
			     if(userService.updateUserInfo(user)){
			    	 state.setState(true);
			    	 return state;
			     }
			     return state;
			}
		    return state;
	   }
	   
	  @RequestMapping("/showUserInfo.do")
	  @ResponseBody
	   public void showUserInfo(HttpServletRequest request, HttpServletResponse response,@RequestParam("user") String json, @RequestParam("appKey") String appKey) throws IOException {
		  response.setContentType("text/html;charset=UTF-8");
		  PrintWriter out = response.getWriter();
		  System.out.println("success");
		  if(appKey.equals(key.appKeyForJava)){
				Gson gson= new Gson();
				Type listType = new TypeToken<NewUser>(){}.getType(); 
			    NewUser nuser  = gson.fromJson(json,listType);
			    User user = new User();
			    user.setUserID(nuser.getUserId());
				User u= userService.showUserInfo(user);
				String RJson=gson.toJson(u);
				out.println(RJson);
			}
	   }
	   
	  @RequestMapping("/getUserInfo.do")
	  @ResponseBody
	   public void getUserInfo(HttpServletRequest request, HttpServletResponse response,@RequestParam("user") String json, @RequestParam("appKey") String appKey) throws IOException {
		  response.setContentType("text/html;charset=UTF-8");
		  PrintWriter out = response.getWriter();
		  System.out.println("success");
		  if(appKey.equals(key.appKeyForJava)){
				Gson gson= new Gson();
				Type listType = new TypeToken<NewUser>(){}.getType(); 
				NewUser nuser  = gson.fromJson(json,listType);
			    User user = new User();
			    user.setUserID(nuser.getUserId());
			    String RJson = gson.toJson(userService.getUserInfo(user));
				out.println(RJson);
			}
	   }
	   
	  @RequestMapping("/queryUser.do")
	  @ResponseBody
	   public void queryUser(HttpServletRequest request, HttpServletResponse response,@RequestParam("user") String json, @RequestParam("appKey") String appKey) throws IOException {
		  System.out.println(json);
		  response.setContentType("text/html;charset=UTF-8");
		  PrintWriter out = response.getWriter();
		  System.out.println("success");
		  if(appKey.equals(key.appKeyForJava)){
				Gson gson= new Gson();
				Type listType = new TypeToken<NewUserName>(){}.getType(); 
			    NewUserName nuser  = gson.fromJson(json,listType);
			    User user = new User();
			    user.setNickName(nuser.getNickName());
			    System.out.println("****************************queryUser**************************");
			    System.out.println(user.getNickName());
			    String RJson=gson.toJson(userService.queryUser(user));
				out.println(RJson);
			}
	   }
	   
	  @RequestMapping("/attendUser.do")
	  @ResponseBody
	   public User_state attendUser(@RequestParam("user") String json, @RequestParam("user1") String json2, @RequestParam("appKey") String appKey) {
		  User_state state= new User_state();
			if(appKey.equals(key.appKeyForJava)){
				Gson gson= new Gson();
				Type listType = new TypeToken<User>(){}.getType(); 
			    User user1  = gson.fromJson(json,listType);
			    User user2  = gson.fromJson(json2,listType);
			     if(attentionService.attendUser(user1, user2)){
			    	 state.setState(true);
			    	 return state;
			     }
			     return state;
			}
		    return state;
	   }
	   
	  @RequestMapping("/cancelAttention.do")
	  @ResponseBody
	   public User_state cancelAttention(@RequestParam("user") String json, @RequestParam("user1") String json2, @RequestParam("appKey") String appKey) {
		  User_state state= new User_state();
		  System.out.println("success");
			if(appKey.equals(key.appKeyForJava)){
				Gson gson= new Gson();
				Type listType = new TypeToken<User>(){}.getType(); 
			    User user1  = gson.fromJson(json,listType);
			    User user2  = gson.fromJson(json2,listType);
			     if(attentionService.cancelAttention(user1, user2)){
			    	 state.setState(true);
			    	 return state;
			     }
			     return state;
			}
		    return state;
	   }
	  
		public UserService getUserService() {
			return userService;
		}

		public void setUserService(UserService userService) {
			this.userService = userService;
		}

		public AttentionService getAttentionService() {
			return attentionService;
		}

		public void setAttentionService(AttentionService attentionService) {
			this.attentionService = attentionService;
		}

		public CityService getCityService() {
			return cityService;
		}

		public void setCityService(CityService cityService) {
			this.cityService = cityService;
		}

		public commonController getKey() {
			return key;
		}

		public void setKey(commonController key) {
			this.key = key;
		}
		
}
