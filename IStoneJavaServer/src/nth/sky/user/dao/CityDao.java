package nth.sky.user.dao;

import nth.sky.user.po.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CityDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	public City queryCityByName(String city){
			 City cityDef = new City();
			 String hql="from City c where c.city=?";
			 if(hibernateTemplate.find(hql,city).isEmpty()){
				 cityDef.setCityID(111);
				 return cityDef;
			 }
			 return (City)hibernateTemplate.find(hql,city).get(0);
	}
	
}
