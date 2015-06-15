package com.cootoo.common.imported;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import com.cootoo.common.exception.SexColumnFormatException;
import com.cootoo.common.util.ExcelUtil;
import com.cootoo.metamanagement.domain.People;



public class PeopleImporter extends ExcelUtil<People> {

	public static final int PEOPLE_ID_COLUMN = 0;
	public static final int PEOPLE_NAME_COLUMN = 1;
	public static final int PEOPLE_SEX_COLUMN = 2;
	public static final int PEOPLE_TEL_COLUMN = 3;
	
	public static final int PEOPLE_TYPE_COLUMN = 4;
	public static final int PEOPLE_SIGN_COLUMN = 5;
	public static final int PEOPLE_DEPART_COLUMN = 6;
	public static final int PEOPLE_IS_ALLOCATED_COLUMN = 7;
	public static final int PEOPLE_MARK_COLUMN = 8;
	
	
	
	public static final int BEGIN_DATA_ROW = 1;
	
	@Override
	public List<People> readRow(Sheet sheet) throws SexColumnFormatException {
		List<People> peoples = new ArrayList<People>();
		int numOfRows = sheet.getLastRowNum();
		for (int j = BEGIN_DATA_ROW; j <= numOfRows; j++) {
			//获取行
			Row row = sheet.getRow(j);
			People people = readCell(row);
			peoples.add(people);
		}		
		return peoples;
	}
	
	@Override
	public People readCell(Row row) throws SexColumnFormatException {
		People people = new People();
		int numOfCells = row.getLastCellNum();
		
		for (int k = 0; k < numOfCells; k++) {
			//获取单元格
			Cell cell = row.getCell(k);
			
				if(k==PEOPLE_ID_COLUMN){
					String peopleID = getStringCellValue(cell);
					people.setPeopleID(peopleID);
				}else if(k==PEOPLE_NAME_COLUMN){
					String peopleName = getStringCellValue(cell);
					people.setPeopleName(peopleName);
				}else if(k==PEOPLE_SEX_COLUMN){
					String sex = getStringCellValue(cell);
					if(sex.equals("男")||sex.equals("女")){
						throw new SexColumnFormatException();
					}
					people.setSex(sex);
				}else if(k==PEOPLE_TEL_COLUMN){
					String tel = getStringCellValue(cell);
					people.setPeopleTel(tel);
				}else if(k==PEOPLE_TYPE_COLUMN){
					String typeStr = getStringCellValue(cell);
					Integer intType = null;
					if(typeStr!=null && !"".equals(typeStr)){
						intType = Integer.parseInt(typeStr);
					}
					people.setUserTypeID(intType);
				}else if(k==PEOPLE_SIGN_COLUMN){
					String signStr = getStringCellValue(cell);
					Integer intSign = null;
					if(signStr!=null && !"".equals(signStr)){
						intSign = Integer.parseInt(signStr);
					}
					people.setPeopleSignID(intSign);
				}else if(k==PEOPLE_DEPART_COLUMN){
					String depart = getStringCellValue(cell);
					people.setDepartmentID(depart);
				}else if(k==PEOPLE_IS_ALLOCATED_COLUMN){
					String isAllocated = getStringCellValue(cell);
					people.setIsAllocated(isAllocated);
				}else if(k==PEOPLE_MARK_COLUMN){
					//String userMark = getStringCellValue(cell);
					//people.setUserMark(userMark);
				}
			}

		return people;
	}

	

}
