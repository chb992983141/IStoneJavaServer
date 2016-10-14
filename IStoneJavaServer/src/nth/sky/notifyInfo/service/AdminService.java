package nth.sky.notifyInfo.service;

import javax.annotation.Resource;

import nth.sky.notifyInfo.dao.AdminDao;
import nth.sky.notifyInfo.po.Admin;

import org.springframework.stereotype.Component;

@Component
public class AdminService {

	@Resource
	private AdminDao adminDao = new AdminDao();
	
	public AdminDao getAdminDao() {
		return adminDao;
	}

	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}

	public String denglu(Admin admin){
		return adminDao.denglu(admin);
	}
}
