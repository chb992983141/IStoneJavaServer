package nth.sky.VideoRecording.common;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import nth.sky.VideoRecording.po.ShakeVideo;
import nth.sky.video.po.Video;

public class VideoRecordingUtil {
	
	public static String getCurrentDate(){
	Calendar ca = Calendar.getInstance();
    int year = ca.get(Calendar.YEAR);//获取年份
    String year_f = String.valueOf(year);
    int month=ca.get(Calendar.MONTH)+1;//获取月份
    String month_f = String.valueOf(month);
    int day=ca.get(Calendar.DATE);//获取日
    String day_f = String.valueOf(day);
    //年月日格式化
    String yearFormat = "0000";
    String otherFormat = "00";
    year_f=yearFormat.substring(0, 4-year_f.length())+year_f;
    month_f=otherFormat.substring(0, 2-month_f.length())+month_f;
    day_f=otherFormat.substring(0, 2-day_f.length())+day_f;
    String currentDate = year_f + month_f + day_f;
    return currentDate;
}
	
	public static Timestamp getSysTime(){
		Date date = new Date();       
		Timestamp currentTime = new Timestamp(date.getTime());
		return  currentTime;
	}
	
		
	public static String getUUID(){
	    UUID uuid = UUID.randomUUID(); 
		String uuidTS = uuid.toString();
		return uuidTS;
	}
	
	public static ShakeVideo VideoToShakeVideo(String headPortraitAddress,Video randomVideo,ShakeVideo shakeVideo){
		
		shakeVideo.setCommentAmount(randomVideo.getCommentAmount());
		shakeVideo.setCoverAddress(randomVideo.getCoverAddress());
		shakeVideo.setCurrentLocation(randomVideo.getCurrentLocation());
		shakeVideo.setPraiseAmount(randomVideo.getPraiseAmount());
		shakeVideo.setPublishTime(randomVideo.getPublishTime());
		shakeVideo.setPublishUserID(randomVideo.getPublishUserID());
		shakeVideo.setPublishUserNickName(randomVideo.getPublishUserNickName());
		shakeVideo.setStoragePath(randomVideo.getStoragePath());
		shakeVideo.setVideoID(randomVideo.getVideoID());
		shakeVideo.setVideoTitle(randomVideo.getVideoTitle());
		shakeVideo.setHeadPortraitAddress(headPortraitAddress);
		
		return shakeVideo;
	}
}
