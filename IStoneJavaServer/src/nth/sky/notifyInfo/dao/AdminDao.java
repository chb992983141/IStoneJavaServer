package nth.sky.notifyInfo.dao;

import javax.annotation.Resource;

import nth.sky.notifyInfo.po.Admin;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

@Component
public class AdminDao {

	@Resource
	private HibernateTemplate hibernateTemplate;
	
	public String denglu(Admin admin){
		String str = "from Admin a where a.adminID = ?";
		Admin admin1 = new Admin();
		admin1 = (Admin) hibernateTemplate.find(str,admin.getAdminID()).get(0);
		if(admin1.getPassWord().equals(admin.getPassWord())){
			return "success";
		}
		return "false";
	}
}
