package nth.sky.notifyInfo.service;

import java.util.List;

import javax.annotation.Resource;

import nth.sky.notifyInfo.dao.FBNoticeDao;
import nth.sky.notifyInfo.po.Admin;
import nth.sky.notifyInfo.po.FBNotice;
import org.springframework.stereotype.Component;


@Component
public class FBNoticeService {

	@Resource
	public FBNoticeDao fbNoticeDao = new FBNoticeDao();
	
	public FBNoticeDao getFbNoticeDao() {
		return fbNoticeDao;
	}
	public void setFbNoticeDao(FBNoticeDao fbNoticeDao) {
		this.fbNoticeDao = fbNoticeDao;
	}
	public String addUserFB(FBNotice fbNotice){
		
		return fbNoticeDao.addUserFB(fbNotice);
		
	}
	public List<FBNotice> queryUserFB(Admin admin){
		
		return fbNoticeDao.queryUserFB();	
	}
	
	public FBNotice queryUserFB(FBNotice fbNotice,Admin admin){
		return fbNoticeDao.queryUserFB(fbNotice.getFeedbackID());
	}
	public String deleteUserFB(FBNotice fbNotice,Admin admin){
		return fbNoticeDao.deleteUserFB(fbNotice.getFeedbackID());
		
	}
	/*public List<User> queryCity(User user){
		return fbNoticeDao.queryUser(user.getCity());
	}*/
}
