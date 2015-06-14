package com.cootoo.common.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.log4j.Logger;

public class DownLoadUtil {

	private final static Logger logger = Logger.getLogger(DownLoadUtil.class);

	private DownLoadUtil(){
		super();
	}
	public static void downloadFile(OutputStream os,String fileName){
		
		BufferedInputStream bis = null;   
        BufferedOutputStream bos = null;  
		
        try {
        	
			bis = new BufferedInputStream(new FileInputStream(fileName));
			bos = new BufferedOutputStream(os);   
            byte[] buff = new byte[2048];   
            int bytesRead;   
            while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {   
                bos.write(buff, 0, bytesRead);   
            }   

		} catch (FileNotFoundException e) {
			logger.error(e.getMessage(), e);
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}finally{		
			try {
				if (bis != null){
					bis.close();
				}
				if (bos != null)   {
					bos.close();
				}              
			} catch (IOException e) {
				logger.error(e.getMessage(), e);
			}         
		}
			
	}
	
}
