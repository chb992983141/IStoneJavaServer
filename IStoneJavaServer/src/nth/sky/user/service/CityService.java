package nth.sky.user.service;

import javax.annotation.Resource;


import nth.sky.user.dao.CityDao;
import nth.sky.user.po.City;
import nth.sky.user.po.User;

import org.springframework.stereotype.Component;

@Component
public class CityService {
	@Resource
	CityDao cityDao = new CityDao();
	
	public City getCityID(User user){
		return cityDao.queryCityByName(user.getCity());
	}

	public CityDao getCityDao() {
		return cityDao;
	}

	public void setCityDao(CityDao cityDao) {
		this.cityDao = cityDao;
	}
}
