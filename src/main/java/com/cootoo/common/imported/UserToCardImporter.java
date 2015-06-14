package com.cootoo.common.imported;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import com.cootoo.common.exception.DataFormatException;
import com.cootoo.common.util.ExcelUtil;
import com.cootoo.metamanagement.domain.UserToCard;

public class UserToCardImporter extends ExcelUtil<UserToCard> {

	public static final int PEOPLE_ID_COLUMN = 0;
	public static final int CARD_MAC_ID_COLUMN = 1;
	
	public static final int BEGIN_DATA_ROW = 1;
	@Override
	protected UserToCard readCell(Row row) throws DataFormatException {
		UserToCard userToCard = new UserToCard();
		int numOfCells = row.getLastCellNum();

		for (int k = 0; k < numOfCells; k++) {
			//获取单元格
			Cell cell = row.getCell(k);
				if(k==PEOPLE_ID_COLUMN){
					String peopleID = getStringCellValue(cell);
					userToCard.setPeopleID(peopleID);
				}else if(k==CARD_MAC_ID_COLUMN){
					String cardMacID = getStringCellValue(cell);
					userToCard.setCardMacID(cardMacID);
				}
			}
		
		return userToCard;
	}

	@Override
	protected List<UserToCard> readRow(Sheet sheet) throws DataFormatException {
		List<UserToCard> userToCard = new ArrayList<UserToCard>();
		int numOfRows = sheet.getLastRowNum();
		for (int j = BEGIN_DATA_ROW; j <= numOfRows; j++) {
			//获取行
			Row row = sheet.getRow(j);
			UserToCard userCard = readCell(row);
			userToCard.add(userCard);
		}		
		return userToCard;
	}

}
