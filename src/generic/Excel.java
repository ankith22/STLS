package generic;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel
{
 public static String getCellValue(String apath, String sheet, int row, int cell)
 {
  String v="";
  try
  {
	Workbook wb = WorkbookFactory.create(new FileInputStream(apath)); 
	v=wb.getSheet(sheet).getRow(row).getCell(cell).toString();
  }
  catch(Exception e)
  {
	  
  }
  return v;
 }
 
 public static int getRowCount(String apath, String sheet)
 {
  int rc=0;
  try
  {
	Workbook wb = WorkbookFactory.create(new FileInputStream(apath));  
	rc=wb.getSheet(sheet).getLastRowNum();
  }
  catch(Exception e)
  {
	  
  }
  return rc;
 }
}
