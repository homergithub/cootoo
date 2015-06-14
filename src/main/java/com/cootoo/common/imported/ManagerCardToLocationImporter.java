package com.cootoo.common.imported;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import com.cootoo.common.exception.DataFormatException;
import com.cootoo.common.util.ExcelUtil;
import com.cootoo.metamanagement.domain.ManagerCardToLocation;

public class ManagerCardToLocationImporter extends ExcelUtil<ManagerCardToLocation> {

	
	public static final int MANAGER_CARD_ID_COLUMN = 0;
	public static final int LOCATION_ID_COLUMN = 1;

	
	public static final int BEGIN_DATA_ROW = 1;

	
	
	@Override
	protected ManagerCardToLocation readCell(Row row)
			throws DataFormatException {
		ManagerCardToLocation managerCardToLocation = new ManagerCardToLocation();
		int numOfCells = row.getLastCellNum();
		
		for (int k = 0; k < numOfCells; k++) {
			//获取单元格
			Cell cell = row.getCell(k);
			
				if(k==MANAGER_CARD_ID_COLUMN){
					String cardID = getStringCellValue(cell);
					managerCardToLocation.setManagerCardID(cardID);
				}else if(k==LOCATION_ID_COLUMN){
					String locationID = getStringCellValue(cell);
					managerCardToLocation.setLocationID(locationID);
				}
			}	
		
		return managerCardToLocation;
	}

	@Override
	protected List<ManagerCardToLocation> readRow(Sheet sheet)
			throws DataFormatException {
		List<ManagerCardToLocation> manageCardToLocations = new ArrayList<ManagerCardToLocation>();
		int numOfRows = sheet.getLastRowNum();
		for (int j = BEGIN_DATA_ROW; j <= numOfRows; j++) {
			//获取行
			Row row = sheet.getRow(j);
			ManagerCardToLocation managerCardToLocation = readCell(row);
			manageCardToLocations.add(managerCardToLocation);
		}		
		return manageCardToLocations;
	}

}
