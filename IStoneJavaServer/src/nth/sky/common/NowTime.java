package nth.sky.common;

import java.text.SimpleDateFormat;
import java.util.Date;
/*设置系统时间的生成*/
public class NowTime {
		public static void main(String[] args) { 
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		Date date = new Date();
		System.out.println(df.format(date));// new Date()为获取当前系统时间
		}
}
