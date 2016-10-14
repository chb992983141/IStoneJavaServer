package nth.sky.notifyInfo.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import nth.sky.notifyInfo.dao.SysNoticeDao;
import nth.sky.notifyInfo.dao.NUserDao;
import nth.sky.notifyInfo.dao.UserNoticeDao;
import nth.sky.notifyInfo.po.Admin;
import nth.sky.notifyInfo.po.SysNotice;
import nth.sky.notifyInfo.po.UserNotice;
import nth.sky.user.po.User;

import org.springframework.stereotype.Component;

@Component
public class SysNoticeService {

	@Resource
	SysNoticeDao sysNoticeDao = new SysNoticeDao();
	@Resource
	UserNoticeDao userNoticeDao =new UserNoticeDao();
	@Resource
	NUserDao nuserDao = new NUserDao();
	
	public SysNoticeDao getSysNoticeDao() {
		return sysNoticeDao;
	}
	public void setSysNoticeDao(SysNoticeDao sysNoticeDao) {
		this.sysNoticeDao = sysNoticeDao;
	}
	public UserNoticeDao getUserNoticeDao() {
		return userNoticeDao;
	}
	public void setUserNoticeDao(UserNoticeDao userNoticeDao) {
		this.userNoticeDao = userNoticeDao;
	}
	public NUserDao getUserDao() {
		return nuserDao;
	}
	public void setUserDao(NUserDao userDao) {
		this.nuserDao = userDao;
	}
	public String publishSysInfo(Admin admin,SysNotice sysNotice){
		if(sysNoticeDao.addSysNoticeInfo(sysNotice).equals("success")){
			List<User> list = new  ArrayList<User>();
			list = nuserDao.queryAllUser();
			UserNotice userNotice = new UserNotice();
	        userNotice.setNoticeType("ϵͳ֪ͨ");
	        userNotice.setUserNotice(sysNotice.getSysNotice());
	        userNotice.setNickName(sysNotice.getPublisher());
			 for(int i=0;i<list.size();i++){
			        String str = list.get(i).getUserID();
			        userNotice.setUserID(str);
			        userNoticeDao.addNoticeInfo(userNotice);
			        }
			 return "success";
		}
		return "false";
	}
	public List<SysNotice> querySysInfoByState(SysNotice sysNotice){
		return sysNoticeDao.querySysInfoByState(sysNotice.isSysNoticeState());
	}
	 public SysNotice querySysInfoByID(SysNotice sysNotice){
		 return sysNoticeDao.querySysInfoByID(sysNotice.getSysNoticeID());
	 }
	 public String updateSysInfoCondition(Admin admin,SysNotice sysNotice){
		 return sysNoticeDao.updateSysInfoCondition(sysNotice.getSysNoticeID());
	 }
}
