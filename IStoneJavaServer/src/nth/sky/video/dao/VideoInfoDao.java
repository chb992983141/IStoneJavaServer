package nth.sky.video.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import nth.sky.user.po.User;
import nth.sky.video.po.Video;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

@Component
public class VideoInfoDao {
	@Resource
	private HibernateTemplate hibernateTemplate;
	/*get ,set方法*/
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	/*方法开始*/
	/*
	 * 上传视频
	 * addVideo*/
	public boolean addVideo(Video video){
		System.out.println("+++++ addVideo dao +++++");
		hibernateTemplate.save(video);
		return true;
	}
	
	/*删除视频
	 * delateVideo*/
	public boolean deleteVideo(Video video) {
		System.out.println("+++++ deleteVideo dao +++++");
		hibernateTemplate.delete(video);
		return true;
		
	}
	
	/*查看视频
	 * queryVideoByVideoID*/
	public Video  queryVideoByVideoID(Video video) {
		System.out.println("+++++ queryVideoByVideoID +++++");
		System.out.println(video.getVideoID());
		String str ="from Video v where v.videoID = ?";
		if(hibernateTemplate.find(str, video.getVideoID()).isEmpty()){
			System.out.println("videoid 不存在");
			return null;
		}
		return (Video) hibernateTemplate.find(str, video.getVideoID()).get(0);
		
	}
	
	/*
	 * 发布人
	 * queryVideoByUserID*/
	public Video queryVideoByPublishUserID(Video vi) {
		System.out.println("+++++ queryVideoByUserID +++++");
		String str ="from Video v where v.publishUserID = ?";
		return (Video)hibernateTemplate.find(str, vi.getPublishUserID()).get(0);
	}

	/*
	 * 用户
	 * queryVideoByUserID*/
	@SuppressWarnings("rawtypes")
	public List queryVideoByUserID(User vi) {
		System.out.println("+++++ queryVideoByUserID ++++");
		String str ="from User u where u.userID = ?";
		return (List) hibernateTemplate.find(str, vi.getUserID()).get(0);
	}
	
	/*城市
	 * GPS定位
	 * queryVideoByCityID*/
	@SuppressWarnings("unchecked")
	public List<Video> queryVideoByCity(Video video) {
		System.out.println("++++  queryVideoByCity  +++++");
		String str ="from Video c where c.currentLocation = ?";
		return (List<Video>) hibernateTemplate.find(str,video.getCurrentLocation()).get(0);
	}
	
	/*城市
	 * 用户默认
	 * queryCityByUserID*/
	public String queryCityByUserID(User user){
		System.out.println("+++++  queryCityByUserID   +++++");
		String str ="from User u where u.userID=?";
		User user1 =   (User) hibernateTemplate.find(str,user.getUserID()).get(0);
		return user1.getCity();
	}
}
