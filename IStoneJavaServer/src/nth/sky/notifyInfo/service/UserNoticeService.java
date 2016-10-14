package nth.sky.notifyInfo.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import nth.sky.notifyInfo.dao.NUserDao;
import nth.sky.notifyInfo.dao.UserNoticeDao;
import nth.sky.notifyInfo.po.QueryNoticeInfo;
import nth.sky.notifyInfo.po.UserNotice;

import org.springframework.stereotype.Component;

@Component
public class UserNoticeService {

	@Resource
	private UserNoticeDao userNoticeDao = new UserNoticeDao();
	@Resource
	private NUserDao nuserDao = new NUserDao();
	
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
	public List<QueryNoticeInfo> queryNoticeInfo(UserNotice userNotice){
		 List<UserNotice> list = userNoticeDao.queryNoticeInfo(userNotice.getUserID());
		 List<QueryNoticeInfo> list2 = new  ArrayList<QueryNoticeInfo>();
			  for(int i=0;i<list.size();i++){
				  UserNotice objects=list.get(i);
				  QueryNoticeInfo query = new QueryNoticeInfo();
				  System.out.println("success!");
				  query = objects;
				  String str = nuserDao.queryHeadByID(userNotice.getUserID()).getHeadPortraitAddress();
				  if(str != null){
					  query.setHeadPortraitAddress(str);
				  }
			        list2.add(query);
			        }
			  return list2;
	}
	public QueryNoticeInfo showNoticeInfo(UserNotice userNotice){
		UserNotice userNotice1 = new UserNotice();
		userNotice1 = userNoticeDao.queryNoticeInfo(userNotice.getUserID(),userNotice.getUserNoticeID());
		QueryNoticeInfo query = new QueryNoticeInfo();
		query = userNotice1;
		String str = nuserDao.queryHeadByID(userNotice.getUserID()).getHeadPortraitAddress();
		if(str != null){
			query.setHeadPortraitAddress(str);
		}
		return query;
	}
	public String addNoticeInfo(UserNotice userNotice){
		return userNoticeDao.addNoticeInfo(userNotice);
	}
	public String deleteNoticeInfo(UserNotice userNotice){
		return userNoticeDao.deleteNoticeInfo(userNotice);
	}
	public String deleteAllNoticeInfo(UserNotice userNotice){
		return userNoticeDao.deleteAllNoticeInfo(userNotice.getUserID());
	}
}
