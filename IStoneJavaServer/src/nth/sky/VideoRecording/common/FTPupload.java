package nth.sky.VideoRecording.common;

import java.io.File;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class FTPupload {
    /**  
     *   
     * @param path �ϴ���ftp�������ĸ�·����     
     * @param addr ��ַ  
     * @param port �˿ں�  
     * @param username �û���  
     * @param password ����  
     * @return  
     * @throws Exception  
     */   
    public static boolean connect(String path,String addr,int port,String username,String password) throws Exception {      
    	FTPClient ftp; 
    	boolean result = false;      
        ftp = new FTPClient();      
        int reply;      
        ftp.connect(addr,port);      
        ftp.login(username,password);      
        ftp.setFileType(FTPClient.BINARY_FILE_TYPE);      
        reply = ftp.getReplyCode();      
        if (!FTPReply.isPositiveCompletion(reply)) {      
            ftp.disconnect();      
            return result;      
        }      
        ftp.changeWorkingDirectory(path);      
        result = true;      
        return result;      
    } 
    
    public static void upload(CommonsMultipartFile file,CommonsMultipartFile file1,String storagePath,String videoID){
    	if (!file.isEmpty()) {
    		
    		   String path = storagePath; 
    		   System.out.println(path);
    		   String fileName = videoID;	       //��ȡ�ļ���
    		   String fileType = ".mp4";//�ļ�����
    		   File folder = new File(path);
    		   if(!folder.exists()){
    			   folder.mkdirs();
    		   }
    		   System.out.println(fileType); 
    		   File file2 = new File(path, fileName+fileType); //�½�һ���ļ�    new Date().getTime()+ fileType
    		   try {
    			    file.getFileItem().write(file2); //���ϴ����ļ�д���½����ļ���
    		   } catch (Exception e) {
    			    e.printStackTrace();
    		   }
    		   //�洢����
    		   String fileType1 = ".jpg";//�ļ�����
    		   System.out.println(fileType1); 
    		   File file3 = new File(path, fileName+fileType1); //�½�һ���ļ�    new Date().getTime()+ fileType
    		   try {
    			    file1.getFileItem().write(file3); //���ϴ����ļ�д���½����ļ���
    		   } catch (Exception e) {
    			    e.printStackTrace();
    		   }
    		   System.out.println("�洢�ɹ�");;
    		}else{
    			System.out.println("�ļ������ڣ�");;
    		}
    	}
}
