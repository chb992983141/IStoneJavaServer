package nth.sky.VideoRecording.service;

import java.util.*;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import nth.sky.VideoRecording.dao.BackgroundMusicDao;
import nth.sky.VideoRecording.po.BackgroundMusic;
@Component
public class BackgroundMusicService {
@Resource
	BackgroundMusicDao backgroundMusicDao = new BackgroundMusicDao(); 
  
		public List<BackgroundMusic> queryAllBackgroundMusic(String appKey) {
		System.out.println("queryAllBackgroundMusic.Service");
		return backgroundMusicDao.queryAllBackgroundMusic(appKey);
	   }
	   
	   public List<BackgroundMusic> queryBackgroundMusic(BackgroundMusic backgroundMusic,String appKey) {
		   System.out.println("queryBackgroundMusic.Service");
		   return backgroundMusicDao.queryBackgroundMusic(backgroundMusic.getBackgroundMusicID(),appKey);
	   }

	   public String addBackgroundMusic(BackgroundMusic backgroundMusic) {
		   backgroundMusicDao.addBackgroundMusic(backgroundMusic);
	      return null;
	   }
	   
	   public String deleteBackgroundMusic(BackgroundMusic backgroundMusic) {
		   backgroundMusicDao.deleteBackgroundMusic(backgroundMusic);
	      return null;
	   }
	   
		public BackgroundMusicDao getBackgroundMusicDao() {
			return backgroundMusicDao;
		}

		public void setBackgroundMusicDao(BackgroundMusicDao backgroundMusicDao) {
			this.backgroundMusicDao = backgroundMusicDao;
		}
	   
}
