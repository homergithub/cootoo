package com.cootoo.common.imported;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import com.cootoo.common.exception.DataFormatException;
import com.cootoo.common.util.ExcelUtil;
import com.cootoo.dormManagement.domain.UserToLocation;

public class UserToLocationImporter extends ExcelUtil<UserToLocation> {
	
	public static final int PEOPLE_ID_COLUMN = 0;
	public static final int LOCATION_ID_COLUMN = 1;
	public static final int USERLOCATION_LINKTYPE_COLUMN = 2;
	
	public static final int BEGIN_DATA_ROW = 1;
	
	@Override
	protected UserToLocation readCell(Row row) throws DataFormatException {
		UserToLocation userToLocation = new UserToLocation();
		int numOfCells = row.getLastCellNum();

		for (int k = 0; k < numOfCells; k++) {
			//获取单元格
			Cell cell = row.getCell(k);
		
				if(k==PEOPLE_ID_COLUMN){
					String peopleID = getStringCellValue(cell);
					userToLocation.setPeopleID(peopleID);
				}else if(k==LOCATION_ID_COLUMN){
					String locationID = getStringCellValue(cell);
					userToLocation.setLocationID(locationID);
				}else if(k==USERLOCATION_LINKTYPE_COLUMN){
					String userLocationLinkType = getStringCellValue(cell);
					userToLocation.setUserLocationLinkType(userLocationLinkType);
				}
			}
		
		return userToLocation;
	}

	@Override
	protected List<UserToLocation> readRow(Sheet sheet)
			throws DataFormatException {
		List<UserToLocation> userToLocation = new ArrayList<UserToLocation>();
		int numOfRows = sheet.getLastRowNum();
		for (int j = BEGIN_DATA_ROW; j <= numOfRows; j++) {
			//获取行
			Row row = sheet.getRow(j);
			UserToLocation userLocation = readCell(row);
			userToLocation.add(userLocation);
		}		
		return userToLocation;
	}

}
