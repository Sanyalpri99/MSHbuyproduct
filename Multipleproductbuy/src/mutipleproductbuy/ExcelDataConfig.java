package mutipleproductbuy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataConfig {
	
	XSSFWorkbook wb;
	XSSFSheet Sheet1;

	public ExcelDataConfig(String excelpath) throws FileNotFoundException {


	File scr=new File(excelpath);
	FileInputStream fis=new FileInputStream(scr);

	try {
	wb=new XSSFWorkbook(fis);
	} catch (Exception e) {

	System.out.println(e.getMessage());
	}

	}

	public String getData(int sheetNumber, int row,int column )
	{
	Sheet1=wb.getSheetAt(sheetNumber);
	String data=Sheet1.getRow(row).getCell(column).getStringCellValue();
	return data;


	}


	public int getRowCount(int sheetIndex) {

	int row=wb.getSheetAt(sheetIndex).getLastRowNum();
	row=row+1;
	return row;
}
}