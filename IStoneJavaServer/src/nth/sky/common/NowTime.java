package nth.sky.common;

import java.text.SimpleDateFormat;
import java.util.Date;
/*����ϵͳʱ�������*/
public class NowTime {
		public static void main(String[] args) { 
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
		Date date = new Date();
		System.out.println(df.format(date));// new Date()Ϊ��ȡ��ǰϵͳʱ��
		}
}
