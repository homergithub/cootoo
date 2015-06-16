package com.cootoo.common.action;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cootoo.common.util.DownLoadUtil;
import com.cootoo.metamanagement.action.UnitLocationManagementAction;

@RequestMapping(value="/commonAction/")
@Controller
public class FileDownLoadAction {

	private final Logger logger = Logger.getLogger(UnitLocationManagementAction.class);
	
	@RequestMapping(value="downloadModel",method=RequestMethod.GET)
	public void downloadModel(HttpServletRequest request,HttpServletResponse response){
			
		String downloadFileName = request.getParameter("fileName");
		String fileName = request.getSession().getServletContext().getRealPath("/") + "download/" + downloadFileName;
	         
	    long fileLength = new File(fileName).length();   
	     
	    try {
	    	downloadFileName = new String(downloadFileName.getBytes("utf-8"), "ISO8859-1");
		} catch (UnsupportedEncodingException e) {
			logger.error(e.getMessage(), e);
		}
	    response.setContentType("application/x-msdownload;");   
	    response.setHeader("Content-disposition", "attachment; filename=" + downloadFileName);   
	    response.setHeader("Content-Length", String.valueOf(fileLength));
	    
	    try {
			DownLoadUtil.downloadFile(response.getOutputStream(), fileName);
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}
		
	}
	
	
	
	
}
