package nth.sky.notifyInfo.dao;

import java.util.List;

import javax.annotation.Resource;

import nth.sky.notifyInfo.po.Report;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

@Component
public class ReportDao {
	@Resource
	private HibernateTemplate hibernateTemplate;
	public String addReport(Report report) throws DataAccessException {
		try{
		hibernateTemplate.save(report);
	
}catch(DataAccessException e){
	return "false";
}
	return "success";
}
	@SuppressWarnings("unchecked")
	public List<Report> queryUserReport(){
		String str = "from Report";
		return hibernateTemplate.find(str);	
	}

    public Report queryUserReport(int reportSID){
    	String str = "from Report u where u.reportSID = ?";
       return (Report) hibernateTemplate.find(str, reportSID).get(0);
	}
    
    public String deleteUserReport(int reportSID) throws DataAccessException{
    	try{
    		Report report = new Report();
    		report.setReportSID(reportSID);
        	hibernateTemplate.delete(report);
    	}catch(DataAccessException e){
    		return "false";
    	}
    	return "success";
    }
}
