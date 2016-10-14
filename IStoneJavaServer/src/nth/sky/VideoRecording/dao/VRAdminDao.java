package nth.sky.VideoRecording.dao;

import javax.annotation.Resource;

import nth.sky.notifyInfo.po.Admin;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

@Component
public class VRAdminDao {
	@Resource
	private HibernateTemplate hibernateTemplate;
	
	public boolean queryAdmin(Admin admin){
		System.out.println("queryAdmin.Dao");
		String hql = "from Admin u where u.AdminID = ? and u.PassWord=?";
		return !hibernateTemplate.find(hql,admin.getAdminID(),admin.getPassWord()).isEmpty();//查询到有记录返回True
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	

}
