package nth.sky.video.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import nth.sky.notifyInfo.po.Report;
import nth.sky.user.po.Attention;
import nth.sky.user.po.User;
import nth.sky.video.po.Collection;
import nth.sky.video.po.Comment;
import nth.sky.video.po.Label;
import nth.sky.video.po.Praise;
import nth.sky.video.po.PutLabel;
import nth.sky.video.po.Video;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

@Component
public class VideoOperateDao {
	@Resource
	private HibernateTemplate hibernateTemplate;

	/*get,set方法*/
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	/*方法
	 * 从此
	 * 处开
	 * 始*/
	/*根据userID,找到昵称
	 * getNickName*/
	public String queryUserByID(User user){
		String query = "from User u where u.userID=?";
		User user1 = (User) hibernateTemplate.find(query,user.getUserID()).get(0);
		return user1.getNickName();
	}
	/*根据commentSID,判断是否是第一条评论,是的话就给回复;否则就不能回复
	 * queryCommentByCommentSID*/
	public int queryCommentByCommentSID(Comment cSID){
		
		String str = "from Comment c where c.commentSID =?";
		Comment co = (Comment)hibernateTemplate.find(str,cSID).get(0);
		int numberSID = co.getReferenceCommentSID();
		if(numberSID == 1){
			return co.getCommentSID();
			
		}
		if(numberSID != 1){
			return co.getReferenceCommentSID();
		}
		/*不是第一条评论,就返回0*/
		return 0;
	}
	/*根据userID,得到收藏数
	 * getCollectionNumber*/
	public int queryUserByID1(User user){
		String query = "from User u where u.userID=?";
		User user11 = new User();
		 user11 = (User) hibernateTemplate.find(query,user.getUserID()).get(0);
		return user11.getCollectionNumber();
	}
	/*得到收藏视频数
	 * getCollectionAmount*/
	public int queryUserByID11(Video video){
		String query = "from Video v where v.videoID=?";
		Video video12 = (Video) hibernateTemplate.find(query,video.getVideoID()).get(0);
		return video12.getCollectionAmount();
	}
	/*查询收藏视频表
	 * queryCollectionTable*/
	public boolean queryCollectionTable(User user,Video video){
		String query = "from Collection co where co.collectionID=? and co.videoID=?";
		if(hibernateTemplate.find(query,user.getUserID(),video.getVideoID()).isEmpty()){
			return true;
		}		
		hibernateTemplate.find(query,user.getUserID(),video.getVideoID()).get(0);
		return false;
	}
	/*添加收藏记录
	 * addCollect*/
	public boolean addCollect(User user,Video video,Collection collection){
		System.out.println("+++++ addCollect dao+++++");

		hibernateTemplate.save(collection);
		String hql = "update User u set u.collectionNumber = ? where u.userID=?";
		hibernateTemplate.bulkUpdate(hql,new Object[]{user.getCollectionNumber(),user.getUserID()});
		String hql1 = "update Video v set v.collectionAmount = ? where v.videoID=?";
		hibernateTemplate.bulkUpdate(hql1,new Object[]{video.getCollectionAmount(),video.getVideoID()});
		
		return true;
	}
	/*删除收藏记录
	 * deleteCollect*/
	public boolean deleteCollect(User user,Video video,Collection collection){
		String hql = "update User u set u.collectionNumber = ? where u.userID=?";
		hibernateTemplate.bulkUpdate(hql,new Object[]{user.getCollectionNumber(),user.getUserID()});
		String hql1 = "update Video v set v.collectionAmount = ? where v.videoID=?";
		hibernateTemplate.bulkUpdate(hql1,new Object[]{video.getCollectionAmount(),video.getVideoID()});

		String str = "delete Collection c where c.collectionID = ? and c.videoID = ?";
		hibernateTemplate.bulkUpdate(str,new Object[]{collection.getCollectionID(),collection.getVideoID()});
		
		return true;
	}
	
	/*通过VideoID查询点赞数
	 * queryPraiseAmountByVideoID*/
	public int queryPraiseAmountByVideoID(Video video){
		String str = "from Video v where v.videoID=?";
		Video videoPrise = (Video)hibernateTemplate.find(str,video.getVideoID()).get(0);
		return videoPrise.getPraiseAmount();
	}
	/*查询点赞表
	 * queryPraiseTable*/
	public boolean queryPraiseTable(User user,Video video){
		String query = "from Praise pr where pr.praiseID=? and pr.videoID=?";
		if(hibernateTemplate.find(query,user.getUserID(),video.getVideoID()).isEmpty()){
			return true;
		}		
		hibernateTemplate.find(query,user.getUserID(),video.getVideoID()).get(0);
		return false;
	}
	/*点赞
	 * addPraise*/
	public boolean addPraise(User user, Video video, Praise praise) {
		System.out.println("+++++ addPraise dao +++++");
		hibernateTemplate.save(praise);
		String hql = "update Video vi set vi.praiseAmount = ? where vi.videoID=?";
		hibernateTemplate.bulkUpdate(hql,new Object[]{video.getPraiseAmount(),video.getVideoID()});
	
		return true;
	}

	/*取消赞
	 * deletePraise*/
	public boolean deletePraise(User user, Video video, Praise praise) {
		String hql1 = "update Video v set v.praiseAmount = ? where v.videoID=?";
		hibernateTemplate.bulkUpdate(hql1,new Object[]{video.getPraiseAmount(),video.getVideoID()});
		String str = "delete Praise p where p.praiseID = ? and p.videoID = ?";
		hibernateTemplate.bulkUpdate(str,new Object[]{praise.getPraiseID(),praise.getVideoID()});
		
		return true;
	}
	/*查询举报表
	 * queryReportTable*/
	public boolean queryReportTable(User user,Video video){
		String query = "from Report r where r.informerID=? and r.videoID=?";
		if(hibernateTemplate.find(query,user.getUserID(),video.getVideoID()).isEmpty()){
			return true;
		}		
		hibernateTemplate.find(query,user.getUserID(),video.getVideoID()).get(0);
		return false;
	}
	
	/*举报
	 * addReport*/
	public boolean addReport( Report report) {
		hibernateTemplate.save(report);
		return true;
	}

	/*通过VideoID查询视频评论
	 * queryVideoCommentAmount*/
	public int queryVideoCommentAmount(Video video){
		String str = "from Video v where v.videoID =?";
		Video video123 = (Video) hibernateTemplate.find(str,video.getVideoID()).get(0);
		return video123.getCommentAmount();
	}
	/*添加评论
	 * addComment*/
	public boolean addComment(Comment comment,Video video) {
		hibernateTemplate.save(comment);
		String hql1 = "update Video v set v.commentAmount = ? where v.videoID=?";
		hibernateTemplate.bulkUpdate(hql1,new Object[]{video.getCommentAmount(),video.getVideoID()});
		
		return true;
	}

	/*queryReferenceCommentSID*/
	/*public int queryReferenceCommentSID(User user0,Video video){
		String query = "from Comment c where c.commentatorID=? and c.videoID=?";
		Comment comment = (Comment)hibernateTemplate.find(query,user0.getUserID(),video.getVideoID()).get(0);
		return comment.getCommentSID();
	}*/
	/*回复评论
	 * referenceComment*/
	public boolean referenceComment(Video video,
			Comment referencecomment) {
		hibernateTemplate.save(referencecomment);
		String hql1 = "update Video v set v.commentAmount = ? where v.videoID=?";
		hibernateTemplate.bulkUpdate(hql1,new Object[]{video.getCommentAmount(),video.getVideoID()});
		
		return true;
	}

	/*查询评论表
	 * queryVideoComment*/
	@SuppressWarnings("unchecked")
	public List<Comment> queryVideoComment(Video video) {
		
		String str = "from Comment c where c.videoID =?";
		
		return hibernateTemplate.find(str,video.getVideoID());
	}

	/*通过VideoID查询发布视频的人
	 * queryPublishUserIDByVideoID*/
	public String queryPublishUserIDByVideoID(Video video){
		String str = "from Video v where v.videoID =?";
		Video vid = (Video)hibernateTemplate.find(str,video.getVideoID()).get(0);
	
		return vid.getPublishUserID();
	}
	public String queryPublishUserIDByVideoID(String videoID){
		String str = "from Video v where v.videoID =?";
		Video vid = (Video)hibernateTemplate.find(str,videoID).get(0);
	
		return vid.getPublishUserID();
	}
	
	
	/*通过LabelID查询标签
	 * queryLabelNameByLabelID*/
	public Label queryLabelNameByLabelID(Label label){
		String str = "from Label l where l.labelID=?";
		Label la = (Label)hibernateTemplate.find(str,label.getLabelID()).get(0);
		return la;
	}

	/*查询标签数目
	 * queryLabelAmoutByLabelID*/
	public int queryLabelAmoutByLabelID(Label label,Video video){
		String str = "from PutLabel pl where pl.lableID = ? and pl.videoID =?";
		if(hibernateTemplate.find(str,label.getLabelID(),video.getVideoID()).isEmpty())
		{
			return 0;
		}
		PutLabel pu = (PutLabel)hibernateTemplate.find(str,label.getLabelID(),video.getVideoID()).get(0);
		return pu.getLableMount();
	}
	
	/*打标签
	 * addLabel*/
	/*这个方法只是往putlabel表里面加一条记录*/
	public boolean addLabel(PutLabel putlabel) {
		hibernateTemplate.saveOrUpdate(putlabel);
		return true;
	}

	/*更新打标签功能,统计标签信息
	 * updateLabel*/
	/*这个方法，是当putlabel表里面有这个标签的时候，我们只是做对mount的+1操作，也就是更新*/
	public boolean updateLabel(PutLabel putl,Video video) {
		String hql = "update PutLabel p set p.lableMount = ? where p.lableID=? and p.videoID=?";
		hibernateTemplate.bulkUpdate(hql,new Object[]{putl.getLableMount(),putl.getLableID(),video.getVideoID()});	
		return true;
	}

	
	/*删除评论
	 * deleteComment*/
	public boolean deleteComment(Video video, Comment comment) {
		String str = "delete Comment co where co.commentSID = ? and co.videoID = ?";
		hibernateTemplate.bulkUpdate(str,new Object[]{comment.getCommentSID(),video.getVideoID()});
		String hql1 = "update Video v set v.commentAmount = ? where v.videoID=?";
		hibernateTemplate.bulkUpdate(hql1,new Object[]{video.getCommentAmount(),video.getVideoID()});
		
		return true;
	}
	/*分页功能*/
	/*queryVideoListInHot*/
	public List<?> queryVideoListInHot() {
		String str = "from Video as v";
		
		return hibernateTemplate.find(str);
	}

	/*根据userID=被关注人ID,找到关注人
	 * IDqueryAttentionIDByUserID*/
	@SuppressWarnings("unchecked")
	public List<String> queryAttentionIDByUserID(User user){
		System.out.println(user.getUserID());
		String str = "from Attention a where a.interestedID = ?";
		if(hibernateTemplate.find(str,user.getUserID()).isEmpty()){
			System.out.println("没有好友！");
			return null;
		}
		List<Attention> at =hibernateTemplate.find(str,user.getUserID());
		List<String> list = new ArrayList<String>();
		for(int i=0;i<at.size();i++){
			list.add(i, at.get(i).getAttentionID());
		}
		return list;
	}

	/*查询好友视频列表
	 * queryVideoListInFriend*/
	public List<Video> queryVideoListInFriend(Video video) {
		String str = "from Video v where v.publishUserID =?";
		
		return hibernateTemplate.find(str,video.getPublishUserID());
	}

	public List<?> queryVideoCategoryName() {
		String str = "from ViedoCategory as v";
		return hibernateTemplate.find(str);
	}

	/*查看确定专题内的视频列表
	 * showSpecialVideoList*/
	public List<?> showSpecialVideoList(Video video) {
		String str = "from Video v where v.categoryID = ?";
		
		return hibernateTemplate.find(str,video.getCategoryID());
	}

}
