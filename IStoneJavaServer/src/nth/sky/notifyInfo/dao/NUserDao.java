package nth.sky.notifyInfo.dao;

import java.util.List;

import javax.annotation.Resource;

import nth.sky.user.po.User;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;
@Component
public class NUserDao {

	@Resource
	private HibernateTemplate hibernateTemplate;
	
	public User queryHeadByID(String userID){
		String str = "from User u where u.userID = ?";
		return (User) hibernateTemplate.find(str,userID).get(0);
	}
	@SuppressWarnings("unchecked")
	public List<User> queryAllUser(){
		String str = "from User";
		return hibernateTemplate.find(str);
	}
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
}
