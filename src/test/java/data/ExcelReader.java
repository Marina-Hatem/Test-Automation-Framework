package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader 
{
	
	static FileInputStream fis = null;
	
	public FileInputStream getFileInputStream()
	{
		//path of excel data file
		String filePath = System.getProperty("user.dir")+ "/src/test/java/data/UserExcelData.xlsx";
		File srcFile= new File(filePath);
		//give the file input stream the path of the file
		try
			{
				fis = new FileInputStream(srcFile);
			} 
		catch (FileNotFoundException e) 
			{
				System.out.println("Test Data File not found : "+ e.getMessage());
			}
		return fis;
	}
	
	public Object[][] getExcelData() throws IOException
	{
		fis = getFileInputStream();
		//excel file ---> workbook
		//sheet ----> work sheet
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		//get first sheet in the workbook
		XSSFSheet sheet = wb.getSheetAt(0);
		int totalNumberOfRows = sheet.getLastRowNum()+1;
		int totalNumberOfColumns = 4;
		//to get each cell i will need a 2Darray
		String[][] arrayExcelData = new String[totalNumberOfRows][totalNumberOfColumns];
		//for loop to fill the array with each cell of the sheet
		for (int i=0; i< totalNumberOfRows; i++)
		{
			for(int j=0; j<totalNumberOfColumns;j++)
			{
				XSSFRow row = sheet.getRow(i);
				arrayExcelData[i][j]= row.getCell(j).toString();
			}
		}
		wb.close();
		return arrayExcelData;		
	}

}
