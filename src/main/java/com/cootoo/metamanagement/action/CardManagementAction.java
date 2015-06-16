package com.cootoo.metamanagement.action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.cootoo.common.util.DateUtil;
import com.cootoo.metamanagement.domain.Card;
import com.cootoo.metamanagement.service.CardManagementService;

@RequestMapping(value="/cardManagement/")
@Controller
public class CardManagementAction{

	@Autowired
	private CardManagementService cardManagementServiceImpl;
	
	@RequestMapping(value="addCard",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> addCard(HttpServletRequest request){
		
		List<Card> cardList = new ArrayList<Card>();
		String cardMacID = request.getParameter("cardMacID");
		String cardIsLive = request.getParameter("cardIsLive");
		String strCardTypeID = request.getParameter("cardTypeID");
		Integer cardTypeID = null;
		if(null != strCardTypeID && !"".equals(strCardTypeID)){
			cardTypeID = Integer.parseInt(strCardTypeID);
		}
		String strCardName = request.getParameter("cardName");
		Integer cardName = null;
		if(null != strCardName && !"".equals(strCardName)){
			cardName = Integer.parseInt(strCardName);
		}
		String orgID = request.getParameter("orgID");
		Card card = new Card(cardMacID, cardName, cardIsLive, DateUtil.dateFormat(new Date(), "yyyy-MM-dd HH:mm:ss"), cardTypeID, orgID);
		cardList.add(card);
		Map<String, Object> result = cardManagementServiceImpl.addCard(cardList);
		return result;
	}
	
	
	@RequestMapping(value="importCard",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> importCard(HttpServletRequest request){

		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		MultipartFile file = multipartRequest.getFile("file");
	
		Map<String, Object> result = cardManagementServiceImpl.addCard(file);
		return result;
	 }
	

	@RequestMapping(value="deleteCard",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> deleteCard(HttpServletRequest request){
		
		String strCardIDs = request.getParameter("cardIDs");
		List<String> cardIDList = Arrays.asList(strCardIDs.split(","));
		Map<String, Object> result = cardManagementServiceImpl.deleteCard(cardIDList);
		return result;
	}
	
	@RequestMapping(value="modifyCard",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> modifyCard(HttpServletRequest request){
		
		String cardMacID = request.getParameter("cardMacID");
		String cardIsLive = request.getParameter("cardIsLive");
		String strCardTypeID = request.getParameter("cardTypeID");
		Integer cardTypeID = null;
		if(null != strCardTypeID && !"".equals(strCardTypeID)){
			cardTypeID = Integer.parseInt(strCardTypeID);
		}
		String strCardName = request.getParameter("cardName");
		Integer cardName = null;
		if(null != strCardName && !"".equals(strCardName)){
			cardName = Integer.parseInt(strCardName);
		}
		String orgID = request.getParameter("orgID");
		Card card = new Card(cardMacID, cardName, cardIsLive, DateUtil.dateFormat(new Date(), "yyyy-MM-dd HH:mm:ss"), cardTypeID, orgID);
		Map<String, Object> result = cardManagementServiceImpl.modifyCard(card);
		return result;
	}
	
	
	@RequestMapping(value="getCardType",method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> getCardType(HttpServletRequest request){
		Map<String, Object> result = cardManagementServiceImpl.getCardType();
		return result;
	}
	
	
	
	
}
