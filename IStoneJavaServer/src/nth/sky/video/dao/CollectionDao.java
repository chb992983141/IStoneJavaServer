package nth.sky.video.dao;

import javax.annotation.Resource;

import nth.sky.user.po.User;
import nth.sky.video.po.Collection;
import nth.sky.video.po.Video;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

@Component
//extends HibernateDaoSupport
public  class CollectionDao{
	@Resource
	private HibernateTemplate hibernateTemplate;
	
	 /**
	  * ע��mySessionFactory
	  */
	/* @Autowired@Qualifier("sessionFactory") //*****ע��*****//*
	 protected SessionFactory sessionFactory;
	 @PostConstruct //*****beanʵ����ʱִ�и÷���*******//*
	 protected void injectSessionFactory(){
	  super.setSessionFactory(sessionFactory);
	 }
	*/
	public String  addCollect(User user, Video video, Collection collection){
		System.out.println("+++++���Ѿ���DAO��++++");
		//hibernateTemplate.save(collection);
		//hibernateTemplate.save(video);
		/*Session session = sessionFactory.openSession();
		session.save(user);
        session.close();*/
		hibernateTemplate.save(user);
		return "success";
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public User showUser(String nickName) {
		System.out.println("+++++++show   dao+++++");
		/**//**
		 * hql�ļ�����ʽ��ִ�в�ѯ���ݿ���������ض�����б�
		 * ����hql������ӷ�ʽ
		 */
	/*	Session session = this.getSession();
		String hql = "select * from User where City="+city+"";
		Query query = session.createQuery(hql);// ����SQL������ʽ
		query.list();// ���س־û���list
*/	
		/*
		String hql = "from User u where u.nickName="+nickName+"";
		//s=getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(hql);
		hibernateTemplate.find(hql);
		System.out.println(hql);*/		
		String str = "from User u where u.nickName = ?";
	   //System.out.println(((User)hibernateTemplate.find(str, nickName).get(0)).getCityID());
	    
	   //JSONObject json = new JSONObject();	
	   //json.put("user", new Gson().toJson(hibernateTemplate.find(str, nickName)));
	   // System.out.println(json.toString());	
	   //return ((User)hibernateTemplate.find(str, nickName).get(0)).getGender();
	   //JSONObject json = new JSONObject();	
	   // return  new Gson().toJson(hibernateTemplate.find(str, nickName));
	    return (User)hibernateTemplate.find(str, nickName).get(0);
	}

}
