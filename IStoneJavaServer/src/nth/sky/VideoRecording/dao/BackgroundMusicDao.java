package nth.sky.VideoRecording.dao;

import java.util.*;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import nth.sky.VideoRecording.po.BackgroundMusic;
@Component
public class BackgroundMusicDao {
	@Resource
	private HibernateTemplate hibernateTemplate;
	   //-------------------------BackgroundMusic------------------
	   @SuppressWarnings("unchecked")
	public List<BackgroundMusic> queryAllBackgroundMusic(String appKey) {
		   System.out.println("queryAllBackgroundMusic.Dao");
		   String hql ="from BackgroundMusic";
		   return hibernateTemplate.find(hql);
		   }
	   
   @SuppressWarnings("unchecked")
public List<BackgroundMusic> queryBackgroundMusic(String backgroundMusicID,String appKey) {
	   System.out.println("queryBackgroundMusic.Dao");
	   String hql ="from BackgroundMusic u where u.BackgroundMusicID = ?";
	   return  hibernateTemplate.find(hql,backgroundMusicID);
	   
   }
   
   
   public String addBackgroundMusic(BackgroundMusic backgroundMusic) {
      hibernateTemplate.save(backgroundMusic);
	   return null;
   }
   
   public String deleteBackgroundMusic(BackgroundMusic backgroundMusic) {
	      hibernateTemplate.delete(backgroundMusic);
		   return null;
	   }
   
   
public HibernateTemplate getHibernateTemplate() {
	return hibernateTemplate;
}
public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
	this.hibernateTemplate = hibernateTemplate;
}

   
}
