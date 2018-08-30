package readExcel;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile 
{

	public static String readDatafromExcel_CI(String sheetname, int rownum, int colnum) throws Exception 
	{
		File file = new File(".\\lib\\TataAIGTestData.xlsx");
		FileInputStream fileInputStream = new FileInputStream(file);
		@SuppressWarnings("resource")
		XSSFWorkbook hssfWorkbook = new XSSFWorkbook(fileInputStream);
		XSSFSheet sheet = hssfWorkbook.getSheet(sheetname);
		XSSFCell cell = sheet.getRow(rownum).getCell(colnum);
		DataFormatter df = new DataFormatter();
		String data = df.formatCellValue(cell);
        return data;

	}
	
	
	
}
