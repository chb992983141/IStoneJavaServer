package nth.sky.video.dao;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Controller;

import nth.sky.video.po.Video;

@Controller
public class VideoDao {
	@Resource
	private HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	
	
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public Video queryVideoByVideoID(Video video) {
		System.out.println("++++++hhhhhh++++++");
		String str = "from Video v where v.videoID = ?";
		return (Video)hibernateTemplate.find(str, video).get(0);
	}

}