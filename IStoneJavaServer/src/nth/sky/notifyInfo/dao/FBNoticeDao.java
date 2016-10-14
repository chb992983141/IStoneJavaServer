package nth.sky.notifyInfo.dao;

import java.util.List;

import javax.annotation.Resource;

import nth.sky.notifyInfo.po.FBNotice;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;
@Component
public class FBNoticeDao {

	@Resource
	private HibernateTemplate hibernateTemplate;
	
	
	public String addUserFB(FBNotice fbNotice) throws DataAccessException {
			try{
			hibernateTemplate.save(fbNotice);
		
	}catch(DataAccessException e){
		return "false";
	}
		return "success";
	}
	@SuppressWarnings("unchecked")
	public List<FBNotice> queryUserFB(){
		String str = "from FBNotice";
		return hibernateTemplate.find(str);	
	}

    public FBNotice queryUserFB(String feedbackID){
    	String str = "from FBNotice u where u.feedbackID = ?";
       return (FBNotice) hibernateTemplate.find(str, feedbackID).get(0);
	}
    
    public String deleteUserFB(String feedbackID) throws DataAccessException{
    	try{
    		FBNotice fbNotice = new FBNotice();
    	    fbNotice.setFeedbackID(feedbackID);
        	hibernateTemplate.delete(fbNotice);
    	}catch(DataAccessException e){
    		return "false";
    	}
    	return "success";
    }
   /* public List<User> queryUser(String city){
    	String hql = "from User u where u.city = ?";
    	return hibernateTemplate.find(hql,city);
    }*/
}
