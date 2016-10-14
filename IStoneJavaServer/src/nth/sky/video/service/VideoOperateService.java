package nth.sky.video.service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import nth.sky.common.PageBean;
import nth.sky.notifyInfo.dao.NUserDao;
import nth.sky.notifyInfo.po.Report;
import nth.sky.user.po.User;
import nth.sky.video.dao.VideoOperateDao;
import nth.sky.video.po.Collection;
import nth.sky.video.po.Comment;
import nth.sky.video.po.Label;
import nth.sky.video.po.Praise;
import nth.sky.video.po.PutLabel;
import nth.sky.video.po.Video;
import nth.sky.video.po.VideoInfo;

import org.springframework.stereotype.Component;

import com.google.gson.JsonElement;

@Component
public class VideoOperateService {
	@Resource
	private VideoOperateDao videoOperateDao = new VideoOperateDao();
	@Resource
	private NUserDao nuserDao = new NUserDao();

	private Collection collection;
	/*get,set方法*/

	public VideoOperateDao getVideoOperateDao() {
		return videoOperateDao;
	}
	public NUserDao getNuserDao() {
		return nuserDao;
	}
	public void setNuserDao(NUserDao nuserDao) {
		this.nuserDao = nuserDao;
	}
	public void setVideoOperateDao(VideoOperateDao videoOperateDao) {
		this.videoOperateDao = videoOperateDao;
	}
	
	public Collection getCollection() {
		return collection;
	}
	public void setCollection(Collection collection) {
		this.collection = collection;
	}
	/*方法
	 * 从此
	 * 次开
	 * 始*/
	/*collectVideo*/
	public boolean collectVideo(User user,Video video) throws ParseException{
		System.out.println("+++++++++ collectVideo service ++++++");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date  date =  df.parse(df.format(new Date()));
		Timestamp time = new Timestamp(date.getTime()); 
		
		Collection co = new Collection();
		co.setCollectionID(user.getUserID());
		co.setCollectionNickName(videoOperateDao.queryUserByID(user));
		co.setVideoID(video.getVideoID());
		if(videoOperateDao.queryCollectionTable(user, video)){
			co.setCollectionTime(time);
			user.setCollectionNumber(videoOperateDao.queryUserByID1(user)+1);
			video.setCollectionAmount(videoOperateDao.queryUserByID11(video)+1);
			
			return videoOperateDao.addCollect(user,video,co);
		}
		return false ;
	}
	
	/*取消收藏
	 * cancelCollect*/
	public boolean cancelCollect(User user, Video video) {
		System.out.println("+++++ cancelCollect service +++++");
		Collection co = new Collection();
		co.setCollectionID(user.getUserID());
		co.setVideoID(video.getVideoID());
		if(videoOperateDao.queryUserByID1(user)>0){
			user.setCollectionNumber(videoOperateDao.queryUserByID1(user)-1);
		}
		if(videoOperateDao.queryUserByID11(video)>0){
			video.setCollectionAmount(videoOperateDao.queryUserByID11(video)-1);
		}
		return videoOperateDao.deleteCollect(user, video, co);
	}
	
	/*点赞
	 * putPrise*/
	public boolean putPraise(User user, Video video) throws ParseException {
		System.out.println("+++++ putPrise service +++++");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date  date =  df.parse(df.format(new Date()));
		Timestamp time = new Timestamp(date.getTime()); 
		
		Praise pr = new Praise();
		pr.setPraiseID(user.getUserID());
		pr.setPraiseNickName(videoOperateDao.queryUserByID(user));
		pr.setVideoID(video.getVideoID());
		if(videoOperateDao.queryPraiseTable(user, video)){
			pr.setPraiseTime(time);
			video.setPraiseAmount(videoOperateDao.queryPraiseAmountByVideoID(video)+1);
			return videoOperateDao.addPraise(user,video,pr);
		}
		return false;	
	}
	
	/*取消赞
	 * cancelPraise*/
	public boolean cancelPraise(User user, Video video) {
		System.out.println("+++++ cancelPraise service +++++");
		Praise pr = new Praise();
		pr.setPraiseID(user.getUserID());
		pr.setVideoID(video.getVideoID());
		if(videoOperateDao.queryPraiseAmountByVideoID(video)>0){
			video.setPraiseAmount(videoOperateDao.queryPraiseAmountByVideoID(video)-1);
		}
		return videoOperateDao.deletePraise(user, video, pr);
	}
	
	/*举报视频
	 * videoReport*/
	public boolean videoReport(User user, Video video) throws ParseException {
		System.out.println("+++++ videoReport service +++++");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date  date =  df.parse(df.format(new Date()));
		Timestamp time = new Timestamp(date.getTime());
		
		Report re = new Report();
		re.setVideoID(video.getVideoID());
		re.setInformerID(user.getUserID());
		re.setReportTime(time);
		re.setInformerNickName(videoOperateDao.queryUserByID(user));
		re.setNotes(user.getNotes());
		if(videoOperateDao.queryReportTable(user, video)){
			return videoOperateDao.addReport(re);
		}
		return false;
	}
	
	/*视频分享
	 * videoShare*/
	public JsonElement videoShare(User user, Video video) {
		System.out.println("+++++ videoShare service +++++");
		/*还没有页面和
		 * 数据与此方法
		 * 进行对应*/
		return null;
	}
	
	/*新增视频评论
	 * addComment*/
	/*数据库里面默认referenceCommentSID=1*/
	public boolean addComment(User user, Video video, Comment comment) throws ParseException {
		System.out.println("+++++ addComment service +++++");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date  date =  df.parse(df.format(new Date()));
		Timestamp time = new Timestamp(date.getTime()); 
		
		comment.setCommentatorID(user.getUserID());
		comment.setCommentatorNickName(videoOperateDao.queryUserByID(user));
		comment.setCommentTime(time);
		comment.setVideoID(video.getVideoID());
		comment.setReferenceCommentSID(1);
		video.setCommentAmount(videoOperateDao.queryVideoCommentAmount(video)+1);
		
		return videoOperateDao.addComment(comment,video);
	}
	
	/*回复视频评论
	 * referenceComment*/
	public boolean referenceComment(Comment cSID, User user, Video video,
			Comment referencecomment) throws ParseException {
	
		System.out.println("+++++ referenceComment service +++++");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date  date =  df.parse(df.format(new Date()));
		Timestamp time = new Timestamp(date.getTime());
		System.out.println(videoOperateDao.queryCommentByCommentSID(cSID));
		if(videoOperateDao.queryCommentByCommentSID(cSID)!=0){			
			referencecomment.setCommentTime(time);
			referencecomment.setCommentatorID(user.getUserID());
			referencecomment.setVideoID(video.getVideoID());
			referencecomment.setCommentatorNickName(videoOperateDao.queryUserByID(user));
			referencecomment.setReferenceCommentSID(videoOperateDao.queryCommentByCommentSID(cSID));			
			video.setCommentAmount(videoOperateDao.queryVideoCommentAmount(video)+1);
			return videoOperateDao.referenceComment(video,referencecomment);
			}
		return false;
		
	}
	
	/*查询视频评论
	 * queryVideoComment*/
	public List<Comment> queryVideoComment(Video video) {
		System.out.println("+++++ queryVideoComment service +++++");
		
		return videoOperateDao.queryVideoComment(video);
	}
	
	/*视频点赞
	 * putLabel*/
	/*第一次点赞,点赞量为1,后面点赞量的时候,根据putlabel表里面有没有labelID判断*/
	public boolean putLabel(Video video, Label label) throws ParseException {
		System.out.println("+++++ putLabel service +++++");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date  date =  df.parse(df.format(new Date()));
		Timestamp time = new Timestamp(date.getTime());
		PutLabel putl = new PutLabel();
		if(videoOperateDao.queryLabelAmoutByLabelID(label,video)==0){
		putl.setPutLableTime(time);
		putl.setLableName(videoOperateDao.queryLabelNameByLabelID(label).getLabelName());
		putl.setLableMount(1);
		putl.setVideoID(video.getVideoID());
		putl.setLableID(label.getLabelID());
		return videoOperateDao.addLabel(putl);
		}
		else{
		putl.setLableName(videoOperateDao.queryLabelNameByLabelID(label).getLabelName());
		putl.setLableMount(videoOperateDao.queryLabelAmoutByLabelID(label,video)+1);
		putl.setVideoID(video.getVideoID());
		putl.setLableID(label.getLabelID());
		return videoOperateDao.updateLabel(putl,video);
		}
		
	}
	
	/*删除视频评论    
	 * deleteComment*/
	public boolean deleteComment(User user, Video video, Comment comment) {
		System.out.println("+++++ deleteComment service +++++");
		if(videoOperateDao.queryPublishUserIDByVideoID(video).equals(user.getUserID())){
			video.setCommentAmount(videoOperateDao.queryVideoCommentAmount(video)-1);
			return videoOperateDao.deleteComment(video,comment);
		}
		/*不是视频的发布人，不能删除评论*/
		return false;
	}
	
	/*主页热门视频列表
	 * showVideoListInHot*/
	public PageBean showVideoListInHot(int page) {
		System.out.println("+++++ showVideoListInHot service +++++");
		

		List list = new ArrayList();//最终的list
		
		List list2 = new ArrayList();//中间list
		
		List<Video> list3 = new ArrayList<Video>();
		
		list3 = (List<Video>) videoOperateDao.queryVideoListInHot();
		for(int i=0;i<list3.size();i++){
			Video objects = (Video) list3.get(i);
			VideoInfo query = new VideoInfo();
			query = objects;
			String publishUserID = list3.get(i).getPublishUserID();
			String str = nuserDao.queryHeadByID(publishUserID).getHeadPortraitAddress();
			if(str != null){
				  query.setHeadPortraitAddress(str);
			  }
			list.add(query);
		}
		
		if(list.size()<((page-1)*10+1)){
			showVideoListInHot(page-1);
		}
		
		if(list.size()>10){
			if(list.size()>(page*10)){
				for(int i=0;i<10;i++){
					list2.add(list.get((page-1)*10+i));
				}
			}else{
				for(int i=0;i<list.size()-((page-1)*10);i++){
					list2.add(list.get((page-1)*10+i));
				}
			}
		}else{
			list2 = list;
		}
				
		
		PageBean pageBean = new PageBean(list2,list2.size(),list2.size()%10==0?list2.size()/10:list2.size()/10+1,page,10);
		
		return pageBean;
	}
	
	/*主页好友视频列表
	 * showVideoListInFriend*/
	public PageBean showVideoListInFriend(int page, User user) {
		System.out.println("+++++ showVideoListInFriend service +++++");
		
		System.out.println("查询好友的userId:"+user.getUserID());
		List<Video> video = new ArrayList<Video>();
		/*上传人ID就是关注人ID*/
		List<String> li = new ArrayList<String>();
//		Video video1 = new Video();//不注释这句list中所有的元素都会变成和最后一个一样
		if(videoOperateDao.queryAttentionIDByUserID(user)==null){
			System.out.println("去找个好友吧！");
			return null;
		}
		li.addAll(videoOperateDao.queryAttentionIDByUserID(user));
		for(int k=0;k<li.size();k++){
			Video video1 = new Video();
//			System.out.println(li.get(k));
			video1.setPublishUserID(li.get(k));
			video.add(video1);//add对象是存对对象的引用
		}
		
//		System.out.println("video的大小"+video.size());
//		for(int i = 0;i<video.size();i++){
//			System.out.println("video");
//			System.out.println(video.get(i).getPublishUserID());
//		}

		List list = new ArrayList();
		List list1 = new ArrayList();
		List list2 = new ArrayList();
//		List<Video> temp = new ArrayList<Video>();
		
		List<Video> list3 = new ArrayList<Video>();

		for(int i = 0;i<video.size();i++){
		List<Video> temp = new ArrayList<Video>();
//		System.out.println(video.get(i).getPublishUserID());
		temp = videoOperateDao.queryVideoListInFriend(video.get(i));//返回video类型的List
		list1.addAll(temp);
		}
//		System.out.println("list1的大小"+list1.size());
		System.out.println("******************好友视频列表****************");
		for(int i= 0;i<list1.size();i++){
			Video vi=(Video)list1.get(i);
		System.out.println(vi.getVideoID());	
		}
		//list1(Video类型) list<VideoInfo> 添加HeadPortraitAddress到返回属性中
		list3 = list1;
		for(int i=0;i<list3.size();i++){
			Video objects = (Video) list3.get(i);
			VideoInfo query = new VideoInfo();
			query = objects;
			String publishUserID = list3.get(i).getPublishUserID();
			String str = nuserDao.queryHeadByID(publishUserID).getHeadPortraitAddress();
			if(str != null){
				  query.setHeadPortraitAddress(str);
			  }
			list.add(query);
		}
		
		
		if(list.size()<((page-1)*10+1)){
			showVideoListInFriend(page-1, null);
		}
		
		if(list.size()>10){
			if(list.size()>(page*10)){
				for(int i=0;i<10;i++){
					list2.add(list.get((page-1)*10+i));
				}
			}else{
				for(int i=0;i<list.size()-((page-1)*10);i++){
					list2.add(list.get((page-1)*10+i));
				}
			}
		}else{
			list2 = list;
		}

		PageBean pageBean = new PageBean(list2,list2.size(),list2.size()%10==0?list2.size()/10:list2.size()/10+1,page,10);
		
		return pageBean;
	}
	
	/*查看专题封面内容
	 * showSpecialList*/
	public List showSpecialList() {
		System.out.println("+++++ showSpecialList service +++++");
				
		return videoOperateDao.queryVideoCategoryName();
	}
	
	/*查看确定专题内的视频列表
	 * showSpecialVideoList*/
	public PageBean showSpecialVideoList(int page,
			Video video) {
		System.out.println("+++++ showSpecialVideoList service +++++");
List list = new ArrayList();
		
		List list2 = new ArrayList();
		
		list = videoOperateDao.showSpecialVideoList(video);
		
		if(list.size()<((page-1)*10+1)){
			showVideoListInHot(page-1);
		}
		
		if(list.size()>10){
			if(list.size()>(page*10)){
				for(int i=0;i<10;i++){
					list2.add(list.get((page-1)*10+i));
				}
			}else{
				for(int i=0;i<list.size()-((page-1)*10);i++){
					list2.add(list.get((page-1)*10+i));
				}
			}
		}else{
			list2 = list;
		}
		PageBean pageBean = new PageBean(list2,list2.size(),list2.size()%10==0?list2.size()/10:list2.size()/10+1,page,10);
		
		return pageBean;
	}
	
}
