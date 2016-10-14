package nth.sky.user.service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import nth.sky.user.dao.AttentionDao;
import nth.sky.user.po.Attention;
import nth.sky.user.po.User;
@Component
public class AttentionService {
	@Resource
	AttentionDao attentionDao= new AttentionDao() ;
	
	public AttentionDao getAttentionDao() {
		return attentionDao;
	}

	public void setAttentionDao(AttentionDao attentionDao) {
		this.attentionDao = attentionDao;
	}

	//user1为关注人，user2为被关注人；
	public boolean attendUser(User user1, User user2) {
	    if(attentionDao.queryAttentionByID(user1, user2)==null){
	    	Attention a=new Attention();
	    	a.setAttentionID(user1.getUserID());
	    	a.setInterestedID(user2.getUserID());
	    	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    	Date date;
	    	try {
	    		date = df.parse(df.format(new Date()));
	    		Timestamp time = new Timestamp(date.getTime());
	    		a.setAttentionTime(time);
	    	} catch (ParseException e) {
	    		// TODO Auto-generated catch block
	    		e.printStackTrace();
	    	}
	    	return attentionDao.addAttention(a);
	    }
	    return true;
	}
	
	//user1为关注人，user2为被关注人；
	public boolean cancelAttention(User user1, User user2) {
		try{
			Attention attention= attentionDao.queryAttentionByID(user1, user2);
			return attentionDao.deleteAttention(attention);
		}catch(Exception e){
			return false ;
		}
	   }
}
