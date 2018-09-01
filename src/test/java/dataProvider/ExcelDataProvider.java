package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	XSSFWorkbook wb;
	
	public ExcelDataProvider(){
		File f = new File("C:\\AutomationProject\\workspace\\com.automation.hybrid\\ApplicationTestData\\YahooData.xlsx\\");
		
		try {
			FileInputStream fis = new FileInputStream(f);
		    wb =new XSSFWorkbook(fis);
			
		} catch (Exception e) {
			System.out.println("Exception is "+e.getMessage());
		}
	}
	
		public String getData(int sheetIndex,int row,int column)
		{
			String data = wb.getSheetAt(sheetIndex).getRow(row).getCell(column).getStringCellValue();
			return data;
		}
	
}
