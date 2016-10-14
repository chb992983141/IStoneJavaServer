package nth.sky.notifyInfo.dao;

import java.util.List;

import javax.annotation.Resource;

import nth.sky.notifyInfo.po.UserNotice;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

@Component
public class UserNoticeDao {

	@Resource
	private HibernateTemplate hibernateTemplate;
	
	@SuppressWarnings("unchecked")
	public List<UserNotice> queryNoticeInfo(String userID){
		String str = "from UserNotice u where u.userID = ?";
		return hibernateTemplate.find(str, userID);	
	}
	
	public UserNotice queryNoticeInfo(String userID,int userNoticeID){
		String str = "from UserNotice u where u.userID = ? and u.userNoticeID = ?";
		return (UserNotice) hibernateTemplate.find(str, new Object[]{userID,userNoticeID}).get(0);
	}
	
	public String deleteNoticeInfo(UserNotice userNotice) throws DataAccessException{
		try{
			hibernateTemplate.delete(userNotice);
		}catch(DataAccessException e){
			return "false";
		}
		return "success";
	}
	public String deleteAllNoticeInfo(String userID)throws DataAccessException{
		try{
			String str = "delete UserNotice u where u.userID = ?";
			hibernateTemplate.bulkUpdate(str, userID);
		}catch(DataAccessException e){
			return "false";
		}
		return "success";
	}
	public String addNoticeInfo(UserNotice userNotice)throws DataAccessException{
		try{
			hibernateTemplate.save(userNotice);
		}catch(DataAccessException e){
			return "false";
		}
		return "success";	
	
	}
	
}
