package nth.sky.notifyInfo.service;

import java.util.List;

import javax.annotation.Resource;

import nth.sky.notifyInfo.dao.ReportDao;
import nth.sky.notifyInfo.po.Admin;
import nth.sky.notifyInfo.po.Report;

import org.springframework.stereotype.Component;

@Component
public class ReportService {
	
	@Resource
	public ReportDao reportDao = new ReportDao();
	public String addReport(Report report){
		
		return reportDao.addReport(report);
		
	}
public ReportDao getReportDao() {
		return reportDao;
	}
	public void setReportDao(ReportDao reportDao) {
		this.reportDao = reportDao;
	}
public List<Report> queryUserReport(Admin admin){
		
		return reportDao.queryUserReport();	
	}
	
	public Report queryUserReport(Report report,Admin admin){
		return reportDao.queryUserReport(report.getReportSID());
	}
	public String deleteUserReport(Report report,Admin admin){
		return reportDao.deleteUserReport(report.getReportSID());
		
	}
	
}
