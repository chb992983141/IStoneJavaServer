package nth.sky.user.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import nth.sky.user.dao.UserDao;
import nth.sky.user.po.User;

	/***********************************************************************
	 * Module:  UserService.java
	 * Author:  уей╓
	 * Purpose: Defines the Class UserService
	 ***********************************************************************/
@Component
public class UserService {
	@Resource	
	UserDao userDao = new UserDao();
	
   public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

public boolean addUser(User user) {
      return userDao.addUser(user);
   }
   
   public boolean updateUserInfo(User user) {
	   return userDao.updateUser(user);
   }
   
   public User showUserInfo(User user) {
      return userDao.queryUserByID(user);
   }
   
   public User getUserInfo(User user) {
	   return userDao.queryUserByID(user);
   }
   
   public List<User> queryUser(User user) {
      return userDao.queryUserByName(user);
   }
}
