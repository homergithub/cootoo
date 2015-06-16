package com.cootoo.common.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.cootoo.common.exception.DataFormatException;

/**
 * 子类可以通过抛出DataFormatException异常的子类，在对于的service层捕获即可
 * @author Homer
 * @param <T>
 */
public abstract class ExcelUtil<T> {

	private final static Logger logger = Logger.getLogger(ExcelUtil.class);
	
	private int BEGIN_DATA_ROW = 1;
	
	public  List<List<T>> readExcel(Workbook workBook) throws DataFormatException{
		List<List<T>> object = new ArrayList<List<T>>();
		int numOfSheets = workBook.getNumberOfSheets();
		for (int i = 0; i < numOfSheets; i++) {
			//获取sheet
			Sheet sheet = workBook.getSheetAt(i);
			List<T> table = readRow(sheet);	
			object.add(table);
		}
		return object;
	}
	
		
	protected abstract T readCell(Row row) throws DataFormatException;
	
	protected abstract List<T> readRow(Sheet sheet) throws DataFormatException;
	
	
	protected static String getStringCellValue(Cell cell) {
		
		if (cell == null) {
            return null;
        }
		
        String strCell = "";
        switch (cell.getCellType()) {
        case Cell.CELL_TYPE_STRING:
            strCell = cell.getStringCellValue();
            break;
        case Cell.CELL_TYPE_NUMERIC:
            strCell = String.valueOf(cell.getNumericCellValue());
            break;
        case Cell.CELL_TYPE_BOOLEAN:
            strCell = String.valueOf(cell.getBooleanCellValue());
            break;
        case Cell.CELL_TYPE_BLANK:
            strCell = "";
            break;
        default:
            strCell = "";
            break;
        }
        
        
        return strCell;
    }




	protected int getBEGIN_DATA_ROW() {
		return BEGIN_DATA_ROW;
	}




	protected void setBEGIN_DATA_ROW(int bEGIN_DATA_ROW) {
		BEGIN_DATA_ROW = bEGIN_DATA_ROW;
	}
	
	
	public static Workbook buildWorkbook(MultipartFile file,String fileName){
		
		Workbook workBook = null;	
		try {
			if(fileName.contains("xlsx")){
				workBook = new XSSFWorkbook(file.getInputStream());			
			}else{
				workBook = new HSSFWorkbook(file.getInputStream());
			}	
		}catch (IOException e) {
			logger.error(e.getMessage(), e);
		}
		
		return workBook;
		
	}
	
	
	
	
	
	
	
	
	
}
