package com.cootoo.common.imported;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import com.cootoo.common.exception.DataFormatException;
import com.cootoo.common.util.ExcelUtil;
import com.cootoo.metamanagement.domain.ManagerCard;

public class ManagerCardImporter extends ExcelUtil<ManagerCard> {


	
	public static final int MANAGER_CARD_ID_COLUMN = 0;
	public static final int MANAGER_CARD_NAME_COLUMN = 1;
	public static final int MANAGER_TYPE_COLUMN = 2;
	public static final int ORG_ID_COLUMN = 3;
	
	public static final int BEGIN_DATA_ROW = 1;
	
	
	@Override
	protected ManagerCard readCell(Row row) throws DataFormatException {
		ManagerCard managerCard = new ManagerCard();
		int numOfCells = row.getLastCellNum();
		
		for (int k = 0; k < numOfCells; k++) {
			//获取单元格
			Cell cell = row.getCell(k);
			
				if(k==MANAGER_CARD_ID_COLUMN){
					String cardID = getStringCellValue(cell);
					managerCard.setManagerCardID(cardID);
				}else if(k==MANAGER_CARD_NAME_COLUMN){
					String cardName = getStringCellValue(cell);
					managerCard.setManagerCardName(cardName);
				}else if(k==MANAGER_TYPE_COLUMN){
					String type = getStringCellValue(cell);
					managerCard.setManagerType(type);
				}else if(k==ORG_ID_COLUMN){
					String orgID = getStringCellValue(cell);
					Integer intOrgID = null;
					if(orgID != null){
						intOrgID = Integer.parseInt(orgID);
					}
					managerCard.setOrgID(intOrgID);
				}
		}
		
		return managerCard;
	}

	@Override
	protected List<ManagerCard> readRow(Sheet sheet) throws DataFormatException {
		List<ManagerCard> manageCards = new ArrayList<ManagerCard>();
		int numOfRows = sheet.getLastRowNum();
		for (int j = BEGIN_DATA_ROW; j <= numOfRows; j++) {
			//获取行
			Row row = sheet.getRow(j);
			ManagerCard card = readCell(row);
			manageCards.add(card);
		}		
		return manageCards;
	}

}
