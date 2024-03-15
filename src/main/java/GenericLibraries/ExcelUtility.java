package GenericLibraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility 
{
	private Workbook wb;
	DataFormatter df;
/**
 * This method contains reusable methods to read from excel
 * @author 91889
 */
public void excelInit(String excelpath)
{
	FileInputStream fis=null;
	
	try
	{
		fis=new FileInputStream(excelpath);
	}
	catch(FileNotFoundException e)
	{
		e.printStackTrace();
	}
	try
	{
		wb=WorkbookFactory.create(fis);
	}
	catch(EncryptedDocumentException | IOException e)
	{
		e.printStackTrace();
	}
	df=new DataFormatter();
}
/**
 * This method fetches single data from excel
 * @param sheetName
 * @param rowNum
 * @param cellNum
 * @return
 */
public String readFromExcel(String excelpath,String sheetName,int rowNum,int cellNum)
{
	String data=df.formatCellValue(wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum));
	return data;
}	
public Map<String,String >readFromExcel(String sheetName,String expectedTestName)
{

			Sheet sh = wb.getSheet(sheetName);
			Map<String, String> map = new HashMap<String, String>() ;
	for (int i = 0; i<= sh.getLastRowNum() ; i++)
	{
			if (df. formatCellValue (sh.getRow (i).getCell (1)).equals (expectedTestName) )
			{
			for (int j=i;j<=sh.getLastRowNum(); j++)
		{
					
			String key = df. formatCellValue(sh.getRow(j).getCell (2)) ;
			String value = df. formatCellValue(sh. getRow(j).getCell(3));
			Map.put(key, value);
			if(key.equals("#####"))
			break;
}
break;	
}
	}
	System.out.println(map);
	return map;
}
public void updateTestStatus(String sheetname,String expectedTestNme,String status,String excelpath)
{
	Sheet sh=wb.getSheet(sheetname);
	
for(int i=0;i<=sh.getLastRowNum();i++)
	{
	if(df.formatCellValue(sh.getRow(i).getCell(1).equals(expectedTestName)))
	{
		Cell cell=sh.getRow(i).createCell(4);
		cell.setCellValue(status);
		break;
	}
	}
FileOutputStream fos=null;
try
{
	fos=new FileOutputStream(excelpath);
}
catch(FileNotFoundException e)
{
	e.printStackTrace();
}
try
{
	wb.write(fos);
	
}
catch(IOException e)
{
	e.printStackTrace();
}
	}


public void closeExcel()
{
	try
	{
		wb.close();
	
	}
	catch(IOException e)
	{
		e.printStackTrace();
	}
}
}
