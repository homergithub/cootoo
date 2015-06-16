package com.cootoo.common.imported;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import com.cootoo.common.util.ExcelUtil;
import com.cootoo.metamanagement.domain.UnitLocation;

public class UnitLocationImporter extends ExcelUtil<UnitLocation>{

	public static final int LOCATION_ID_COLUMN = 0;
	public static final int UNIT_NAME_COLUMN = 1;
	public static final int PARENT_NODE_COLUMN = 2;
	public static final int UNIT_TYPE_COLUMN = 3;
	public static final int ORG_ID_COLUMN = 4;
	public static final int UNIT_SIZE_COLUMN = 5;
	public static final int SEX_COLUMN = 6;
	
	public static final int BEGIN_DATA_ROW = 1;
	
	
	@Override
	protected UnitLocation readCell(Row row) {
		UnitLocation unitLocation = new UnitLocation();
		int numOfCells = row.getLastCellNum();

		for (int k = 0; k < numOfCells; k++) {
			//获取单元格
			Cell cell = row.getCell(k);
			
			if(k==LOCATION_ID_COLUMN){
				String locationID = getStringCellValue(cell);
				unitLocation.setLocationID(locationID);
			}else if(k==UNIT_NAME_COLUMN){
				String unitName = getStringCellValue(cell);
				unitLocation.setUnitName(unitName);
			}else if(k==PARENT_NODE_COLUMN){
				String parentNode = getStringCellValue(cell);
				unitLocation.setParentNode(parentNode);
			}else if(k==UNIT_TYPE_COLUMN){
				String unitType = getStringCellValue(cell);
				unitLocation.setUnitType(unitType);
			}else if(k==ORG_ID_COLUMN){
				String orgID = getStringCellValue(cell);
				unitLocation.setOrgID(orgID);
			}else if(k==UNIT_SIZE_COLUMN){
				String size = getStringCellValue(cell);
				Integer unitSize = null;
				if(size!=null && !"".equals(size)){
					unitSize=Integer.parseInt(size);
				}
				unitLocation.setUnitSize(unitSize);
			}else if(k==SEX_COLUMN){
				String sex = getStringCellValue(cell);
				unitLocation.setSex(sex);
			}
		}
		
		return unitLocation;
	}

	@Override
	protected List<UnitLocation> readRow(Sheet sheet) {
		List<UnitLocation> unitLocations = new ArrayList<UnitLocation>();
		int numOfRows = sheet.getLastRowNum();
		for (int j = BEGIN_DATA_ROW; j <= numOfRows; j++) {
			//获取行
			Row row = sheet.getRow(j);
			UnitLocation unitLocation = readCell(row);
			unitLocations.add(unitLocation);
		}		
		return unitLocations;
	}

}
