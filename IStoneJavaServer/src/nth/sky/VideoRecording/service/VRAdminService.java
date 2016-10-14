package nth.sky.VideoRecording.service;

import javax.annotation.Resource;

import nth.sky.VideoRecording.dao.VRAdminDao;
import nth.sky.notifyInfo.po.Admin;

import org.springframework.stereotype.Component;

@Component
public class VRAdminService {
	@Resource
	private VRAdminDao VRadminDao = new VRAdminDao();
	
	public boolean queryAdmin(Admin admin){
		System.out.println("queryAdmin.Service");
		return VRadminDao.queryAdmin(admin);
	}
	
	
	

	public VRAdminDao getAdminDao() {
		return VRadminDao;
	}

	public void setAdminDao(VRAdminDao adminDao) {
		this.VRadminDao = adminDao;
	}

}
