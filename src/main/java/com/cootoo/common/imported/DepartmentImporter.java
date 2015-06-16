package com.cootoo.common.imported;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import com.cootoo.common.util.ExcelUtil;
import com.cootoo.metamanagement.domain.Department;

public class DepartmentImporter extends ExcelUtil<Department> {

	
	public static final int DEPARTMENT_ID_COLUMN = 0;
	public static final int DEPARTMENT_NAME_COLUMN = 1;
	public static final int DEPARTMENT_PID_COLUMN = 2;
	public static final int DEPARTMENT_TYPE_COLUMN = 3;
	public static final int DEPARTMENT_POSITION_COLUMN = 4;
	public static final int DEPARTMENT_DESCRIPTION_COLUMN = 5;
	public static final int ORG_ID_COLUMN = 6;
	
	public static final int BEGIN_DATA_ROW = 1;
	
	
	@Override
	protected Department readCell(Row row){
		Department depart = new Department();
		int numOfCells = row.getLastCellNum();
		
		for (int k = 0; k < numOfCells; k++) {
			//获取单元格
			Cell cell = row.getCell(k);
		
			if(k==DEPARTMENT_ID_COLUMN){
				String departID = getStringCellValue(cell);
				depart.setDepartmentID(departID);
			}else if(k==DEPARTMENT_NAME_COLUMN){
				String departName = getStringCellValue(cell);
				depart.setDepartmentName(departName);
			}else if(k==DEPARTMENT_PID_COLUMN){
				String departPID = getStringCellValue(cell);
				depart.setDepartmentPID(departPID);
			}else if(k==DEPARTMENT_TYPE_COLUMN){
				String departType = getStringCellValue(cell);
				Integer intDartType = null;
				if(departType!=null){
					intDartType = Integer.parseInt(departType);
				}
				depart.setDepartmentType(intDartType);
			}else if(k==DEPARTMENT_POSITION_COLUMN){
				String departPos = getStringCellValue(cell);
				depart.setDepartmentPosition(departPos);
			}else if(k==DEPARTMENT_DESCRIPTION_COLUMN){
				String departDesc = getStringCellValue(cell);
				depart.setDepartmentDescription(departDesc);
			}else if(k==ORG_ID_COLUMN){
				String orgID = getStringCellValue(cell);			
				depart.setOrgID(orgID);
			}		

		}	

		return depart;	
	}

	@Override
	protected List<Department> readRow(Sheet sheet){
		List<Department> departs = new ArrayList<Department>();
		int numOfRows = sheet.getLastRowNum();
		for (int j = BEGIN_DATA_ROW; j <= numOfRows; j++) {
			//获取行
			Row row = sheet.getRow(j);
			Department depart = readCell(row);
			departs.add(depart);
		}		
		return departs;
	}

}
