package com.cootoo.common.imported;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import com.cootoo.common.util.ExcelUtil;
import com.cootoo.metamanagement.domain.Card;

public class CardImporter extends ExcelUtil<Card> {


	public static final int CARD_MAC_ID_COLUMN = 0;
	public static final int CARD_NAME_COLUMN = 1;
	public static final int CARD_IS_LIVE_COLUMN = 2;
	public static final int CARD_TYPE_ID_COLUMN = 3;
	public static final int ORG_ID_COLUMN = 4;
	
	public static final int BEGIN_DATA_ROW = 1;
	
	@Override
	protected Card readCell(Row row){
		
		Card card = new Card();
		int numOfCells = row.getLastCellNum();
		
		for (int k = 0; k < numOfCells; k++) {
			//获取单元格
			Cell cell = row.getCell(k);
			
			if(k==CARD_MAC_ID_COLUMN){
				String cardMacID = getStringCellValue(cell);
				card.setCardMacID(cardMacID);
			}else if(k==CARD_NAME_COLUMN){
				String cardName = getStringCellValue(cell);
				Integer intCardName = null;
				if(cardName!=null){
					intCardName = Integer.parseInt(cardName);
				}
				card.setCardName(intCardName);
			}else if(k==CARD_IS_LIVE_COLUMN){
				String cardIsLive = getStringCellValue(cell);
				card.setCardIsLive(cardIsLive);
			}else if(k==CARD_TYPE_ID_COLUMN){
				String cardTypeID = getStringCellValue(cell);
				Integer intCardType = null;
				if(cardTypeID != null){
					intCardType = Integer.parseInt(cardTypeID);
				}
				card.setCardTypeID(intCardType);
			}else if(k==ORG_ID_COLUMN){
				String orgID = getStringCellValue(cell);
				card.setOrgID(orgID);
			}
		}
			
		return card;
		
	
	}

	@Override
	protected List<Card> readRow(Sheet sheet){
		List<Card> cards = new ArrayList<Card>();
		int numOfRows = sheet.getLastRowNum();
		for (int j = BEGIN_DATA_ROW; j <= numOfRows; j++) {
			//获取行
			Row row = sheet.getRow(j);
			Card card = readCell(row);
			cards.add(card);
		}		
		return cards;
	}

}
