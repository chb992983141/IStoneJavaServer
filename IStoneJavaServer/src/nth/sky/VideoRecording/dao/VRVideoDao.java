package nth.sky.VideoRecording.dao;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;
import nth.sky.VideoRecording.po.VideoVo;
import nth.sky.video.po.Video;

//@Repository
@Component
public class VRVideoDao {
	@Resource
	private HibernateTemplate hibernateTemplate;
  //Video
	public String addVideo(Video video) {
		System.out.println("VideoDao.add()");
		hibernateTemplate.save(video);
      return null;
   }
	//VideoVo
	public String addVideoVo(VideoVo videoVo) {
		System.out.println("VideoDao.add()");
		hibernateTemplate.save(videoVo);
      return null;
   }
   //----------------DeleteVideo
   public String deleteVideo(Video video) {
	   System.out.println("VideoDao.delete()");
	   hibernateTemplate.delete(video);
	   System.out.println("VideoDao.delete(),complete!");
      return null;
   }

   public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

}
