package nth.sky.VideoRecording.common;

import java.io.File;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class FTPupload {
    /**  
     *   
     * @param path 上传到ftp服务器哪个路径下     
     * @param addr 地址  
     * @param port 端口号  
     * @param username 用户名  
     * @param password 密码  
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
    		   String fileName = videoID;	       //获取文件名
    		   String fileType = ".mp4";//文件类型
    		   File folder = new File(path);
    		   if(!folder.exists()){
    			   folder.mkdirs();
    		   }
    		   System.out.println(fileType); 
    		   File file2 = new File(path, fileName+fileType); //新建一个文件    new Date().getTime()+ fileType
    		   try {
    			    file.getFileItem().write(file2); //将上传的文件写入新建的文件中
    		   } catch (Exception e) {
    			    e.printStackTrace();
    		   }
    		   //存储封面
    		   String fileType1 = ".jpg";//文件类型
    		   System.out.println(fileType1); 
    		   File file3 = new File(path, fileName+fileType1); //新建一个文件    new Date().getTime()+ fileType
    		   try {
    			    file1.getFileItem().write(file3); //将上传的文件写入新建的文件中
    		   } catch (Exception e) {
    			    e.printStackTrace();
    		   }
    		   System.out.println("存储成功");;
    		}else{
    			System.out.println("文件不存在！");;
    		}
    	}
}
