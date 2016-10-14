package nth.sky.VideoRecording.dao;

import java.util.List;

import javax.annotation.Resource;
import nth.sky.video.po.Video;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

@Component
public class ShakeDao {
	@Resource
	private HibernateTemplate hibernateTemplate;
	
	@SuppressWarnings("unchecked")
	public List<Video> queryAllVideo(){
		String hql = "from Video ";
		return hibernateTemplate.find(hql);
	}
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

}
