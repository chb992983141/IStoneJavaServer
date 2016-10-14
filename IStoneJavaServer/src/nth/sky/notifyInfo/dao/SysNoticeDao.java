package nth.sky.notifyInfo.dao;

import java.util.List;

import javax.annotation.Resource;

import nth.sky.notifyInfo.po.SysNotice;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

@Component
public class SysNoticeDao {
	@Resource
	private HibernateTemplate hibernateTemplate;
	
	public String addSysNoticeInfo(SysNotice sysNotice) throws DataAccessException {
		try{
		hibernateTemplate.save(sysNotice);
	
}catch(DataAccessException e){
	return "false";
}
	return "success";
}
	 @SuppressWarnings("unchecked")
	public List<SysNotice> querySysInfoByState(boolean sysNoticeState){
	    	String str = "from SysNotice u where u.sysNoticeState = ?";
	       return hibernateTemplate.find(str, sysNoticeState);
		}
	 public SysNotice querySysInfoByID(String sysNoticeID){
		 String str = "from SysNotice u where u.sysNoticeID = ?";
		 return (SysNotice) hibernateTemplate.find(str, sysNoticeID).get(0);
	 }
	 public String updateSysInfoCondition(String sysNoticeID){
		 String str = "update SysNotice u set u.sysNoticeState = false where u.sysNoticeID=?";
		 System.out.println(hibernateTemplate.bulkUpdate(str, sysNoticeID));
		 return "success";
	 }
}
