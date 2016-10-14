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

	/*get,set����*/
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	/*����
	 * �Ӵ�
	 * ����
	 * ʼ*/
	/*����userID,�ҵ��ǳ�
	 * getNickName*/
	public String queryUserByID(User user){
		String query = "from User u where u.userID=?";
		User user1 = (User) hibernateTemplate.find(query,user.getUserID()).get(0);
		return user1.getNickName();
	}
	/*����commentSID,�ж��Ƿ��ǵ�һ������,�ǵĻ��͸��ظ�;����Ͳ��ܻظ�
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
		/*���ǵ�һ������,�ͷ���0*/
		return 0;
	}
	/*����userID,�õ��ղ���
	 * getCollectionNumber*/
	public int queryUserByID1(User user){
		String query = "from User u where u.userID=?";
		User user11 = new User();
		 user11 = (User) hibernateTemplate.find(query,user.getUserID()).get(0);
		return user11.getCollectionNumber();
	}
	/*�õ��ղ���Ƶ��
	 * getCollectionAmount*/
	public int queryUserByID11(Video video){
		String query = "from Video v where v.videoID=?";
		Video video12 = (Video) hibernateTemplate.find(query,video.getVideoID()).get(0);
		return video12.getCollectionAmount();
	}
	/*��ѯ�ղ���Ƶ��
	 * queryCollectionTable*/
	public boolean queryCollectionTable(User user,Video video){
		String query = "from Collection co where co.collectionID=? and co.videoID=?";
		if(hibernateTemplate.find(query,user.getUserID(),video.getVideoID()).isEmpty()){
			return true;
		}		
		hibernateTemplate.find(query,user.getUserID(),video.getVideoID()).get(0);
		return false;
	}
	/*����ղؼ�¼
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
	/*ɾ���ղؼ�¼
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
	
	/*ͨ��VideoID��ѯ������
	 * queryPraiseAmountByVideoID*/
	public int queryPraiseAmountByVideoID(Video video){
		String str = "from Video v where v.videoID=?";
		Video videoPrise = (Video)hibernateTemplate.find(str,video.getVideoID()).get(0);
		return videoPrise.getPraiseAmount();
	}
	/*��ѯ���ޱ�
	 * queryPraiseTable*/
	public boolean queryPraiseTable(User user,Video video){
		String query = "from Praise pr where pr.praiseID=? and pr.videoID=?";
		if(hibernateTemplate.find(query,user.getUserID(),video.getVideoID()).isEmpty()){
			return true;
		}		
		hibernateTemplate.find(query,user.getUserID(),video.getVideoID()).get(0);
		return false;
	}
	/*����
	 * addPraise*/
	public boolean addPraise(User user, Video video, Praise praise) {
		System.out.println("+++++ addPraise dao +++++");
		hibernateTemplate.save(praise);
		String hql = "update Video vi set vi.praiseAmount = ? where vi.videoID=?";
		hibernateTemplate.bulkUpdate(hql,new Object[]{video.getPraiseAmount(),video.getVideoID()});
	
		return true;
	}

	/*ȡ����
	 * deletePraise*/
	public boolean deletePraise(User user, Video video, Praise praise) {
		String hql1 = "update Video v set v.praiseAmount = ? where v.videoID=?";
		hibernateTemplate.bulkUpdate(hql1,new Object[]{video.getPraiseAmount(),video.getVideoID()});
		String str = "delete Praise p where p.praiseID = ? and p.videoID = ?";
		hibernateTemplate.bulkUpdate(str,new Object[]{praise.getPraiseID(),praise.getVideoID()});
		
		return true;
	}
	/*��ѯ�ٱ���
	 * queryReportTable*/
	public boolean queryReportTable(User user,Video video){
		String query = "from Report r where r.informerID=? and r.videoID=?";
		if(hibernateTemplate.find(query,user.getUserID(),video.getVideoID()).isEmpty()){
			return true;
		}		
		hibernateTemplate.find(query,user.getUserID(),video.getVideoID()).get(0);
		return false;
	}
	
	/*�ٱ�
	 * addReport*/
	public boolean addReport( Report report) {
		hibernateTemplate.save(report);
		return true;
	}

	/*ͨ��VideoID��ѯ��Ƶ����
	 * queryVideoCommentAmount*/
	public int queryVideoCommentAmount(Video video){
		String str = "from Video v where v.videoID =?";
		Video video123 = (Video) hibernateTemplate.find(str,video.getVideoID()).get(0);
		return video123.getCommentAmount();
	}
	/*�������
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
	/*�ظ�����
	 * referenceComment*/
	public boolean referenceComment(Video video,
			Comment referencecomment) {
		hibernateTemplate.save(referencecomment);
		String hql1 = "update Video v set v.commentAmount = ? where v.videoID=?";
		hibernateTemplate.bulkUpdate(hql1,new Object[]{video.getCommentAmount(),video.getVideoID()});
		
		return true;
	}

	/*��ѯ���۱�
	 * queryVideoComment*/
	@SuppressWarnings("unchecked")
	public List<Comment> queryVideoComment(Video video) {
		
		String str = "from Comment c where c.videoID =?";
		
		return hibernateTemplate.find(str,video.getVideoID());
	}

	/*ͨ��VideoID��ѯ������Ƶ����
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
	
	
	/*ͨ��LabelID��ѯ��ǩ
	 * queryLabelNameByLabelID*/
	public Label queryLabelNameByLabelID(Label label){
		String str = "from Label l where l.labelID=?";
		Label la = (Label)hibernateTemplate.find(str,label.getLabelID()).get(0);
		return la;
	}

	/*��ѯ��ǩ��Ŀ
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
	
	/*���ǩ
	 * addLabel*/
	/*�������ֻ����putlabel�������һ����¼*/
	public boolean addLabel(PutLabel putlabel) {
		hibernateTemplate.saveOrUpdate(putlabel);
		return true;
	}

	/*���´��ǩ����,ͳ�Ʊ�ǩ��Ϣ
	 * updateLabel*/
	/*����������ǵ�putlabel�������������ǩ��ʱ������ֻ������mount��+1������Ҳ���Ǹ���*/
	public boolean updateLabel(PutLabel putl,Video video) {
		String hql = "update PutLabel p set p.lableMount = ? where p.lableID=? and p.videoID=?";
		hibernateTemplate.bulkUpdate(hql,new Object[]{putl.getLableMount(),putl.getLableID(),video.getVideoID()});	
		return true;
	}

	
	/*ɾ������
	 * deleteComment*/
	public boolean deleteComment(Video video, Comment comment) {
		String str = "delete Comment co where co.commentSID = ? and co.videoID = ?";
		hibernateTemplate.bulkUpdate(str,new Object[]{comment.getCommentSID(),video.getVideoID()});
		String hql1 = "update Video v set v.commentAmount = ? where v.videoID=?";
		hibernateTemplate.bulkUpdate(hql1,new Object[]{video.getCommentAmount(),video.getVideoID()});
		
		return true;
	}
	/*��ҳ����*/
	/*queryVideoListInHot*/
	public List<?> queryVideoListInHot() {
		String str = "from Video as v";
		
		return hibernateTemplate.find(str);
	}

	/*����userID=����ע��ID,�ҵ���ע��
	 * IDqueryAttentionIDByUserID*/
	@SuppressWarnings("unchecked")
	public List<String> queryAttentionIDByUserID(User user){
		System.out.println(user.getUserID());
		String str = "from Attention a where a.interestedID = ?";
		if(hibernateTemplate.find(str,user.getUserID()).isEmpty()){
			System.out.println("û�к��ѣ�");
			return null;
		}
		List<Attention> at =hibernateTemplate.find(str,user.getUserID());
		List<String> list = new ArrayList<String>();
		for(int i=0;i<at.size();i++){
			list.add(i, at.get(i).getAttentionID());
		}
		return list;
	}

	/*��ѯ������Ƶ�б�
	 * queryVideoListInFriend*/
	public List<Video> queryVideoListInFriend(Video video) {
		String str = "from Video v where v.publishUserID =?";
		
		return hibernateTemplate.find(str,video.getPublishUserID());
	}

	public List<?> queryVideoCategoryName() {
		String str = "from ViedoCategory as v";
		return hibernateTemplate.find(str);
	}

	/*�鿴ȷ��ר���ڵ���Ƶ�б�
	 * showSpecialVideoList*/
	public List<?> showSpecialVideoList(Video video) {
		String str = "from Video v where v.categoryID = ?";
		
		return hibernateTemplate.find(str,video.getCategoryID());
	}

}
