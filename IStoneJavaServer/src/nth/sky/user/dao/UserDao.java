package nth.sky.user.dao;
/***********************************************************************
 * Module:  UserDao.java
 * Author:  уей╓
 * Purpose: Defines the Class UserDao
 ***********************************************************************/

import java.util.List;


import nth.sky.user.po.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
		@Autowired
		private HibernateTemplate hibernateTemplate;
	
		public HibernateTemplate getHibernateTemplate() {
			return hibernateTemplate;
		}

		public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
			this.hibernateTemplate = hibernateTemplate;
		}

		public boolean addUser(User user) {
			boolean b; 
			if( b=hibernateTemplate.save(user) != null){
				return b;
			}
			System.out.println("win");
			return false;
		}
   
		public boolean updateUser(User user) {  
			try{
				hibernateTemplate.update(user);   
				}catch(Exception e){
				return false;
			}
			return true;
		}  
  
		public User queryUserByID(User user) {
			
				
			System.out.println("from User u where u.userID='"+user.getUserID()+"'");
			String hql = "from User u where u.userID=?";
			if (hibernateTemplate.find(hql,user.getUserID()).isEmpty()){
				return null;
			}
			return (User) hibernateTemplate.find(hql,user.getUserID()).get(0);
		}
   
		@SuppressWarnings("unchecked")
		public List<User> queryUserByName(User user) {
			try{
				return (List<User>)hibernateTemplate.find("from User u where u.nickName like'%"+user.getNickName()+"%'");
			}catch(Exception e){
				return null;
			} 
		}

}