package nth.sky.user.dao;

import nth.sky.user.po.Attention;
import nth.sky.user.po.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

/***********************************************************************
 * Module:  AttentionDao.java
 * Author:  张胜
 * Purpose: Defines the Class AttentionDao
 ***********************************************************************/
@Repository
public class AttentionDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	//user1为关注者 ，user2为被关注者；
   public Attention queryAttentionByID(User user1, User user2) {  
	   try{
		   
		   return (Attention) hibernateTemplate.find("from Attention a where "+"a.attentionID='"+user1.getUserID()+"' and a.interestedID='"+user2.getUserID()+"'").get(0);
		   
	   }catch(Exception e){
		   return null;
	   }
   }
  
    public HibernateTemplate getHibernateTemplate() {
    	return hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
    	this.hibernateTemplate = hibernateTemplate;
    }

	public boolean addAttention(Attention attention) {
    	  	boolean b;
    	  	if( b=hibernateTemplate.save(attention) != null){
    	  		return b;
   	   }
   	   return false;
	}
   
	public boolean deleteAttention(Attention attention) {
   		  try{
   			  hibernateTemplate.delete(attention);
   		  }catch(Exception e){
   			  return false;
   		  }
		  return true;
   }

}