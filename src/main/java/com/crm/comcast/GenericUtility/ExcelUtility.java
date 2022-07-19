package com.crm.comcast.GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * its developed using Apache POi libraries , which used to handle Microsoft Excel sheet
 * @author Aishwarya
 *
 */

public class ExcelUtility {
	/**
	 *  its used read the data from excel base don below arguments 
	 * @param sheetName
	 * @param rowNum
	 * @param celNum
	 * @return Data
	 * @throws Throwable 
	 * @throws Throwable
	 */
	public String GetDataFromExcel(String Sheetname,int Rownum,int Cellnum) throws Throwable
	{
		FileInputStream file=new FileInputStream(IConstants.EXCELPATH);
		Workbook book= WorkbookFactory.create(file);
		Sheet sh=book.getSheet(Sheetname);
		Row rw=sh.getRow(Rownum);
		Cell cl=rw.getCell(Cellnum);
		DataFormatter format=new DataFormatter();
		String data=format.formatCellValue(cl);
		book.close();
		
		//String value=cl.getStringCellValue();
		return data;
	}
	/**
	 * this method is used to write data to excelsheet
	 * @param Sheetname
	 * @param Rownum
	 * @param Cellnum
	 * @param Value
	 * @throws Throwable
	 */
	public void SetDataInExcel(String Sheetname,int Rownum,int Cellnum,String Value) throws Throwable
	{
		FileInputStream file=new FileInputStream(IConstants.EXCELPATH);
		Workbook book=WorkbookFactory.create(file);
		Sheet sh=book.getSheet(Sheetname);
		Row rw=sh.getRow(Rownum);
		Cell cl=rw.createCell(Cellnum);
		cl.setCellValue(Value);
		
		DataFormatter format=new DataFormatter();
		format.formatCellValue(cl);
		FileOutputStream out=new FileOutputStream(IConstants.EXCELPATH);
		book.write(out);
		out.flush();
		book.close();
	}
	/**
	 * 
	 * @param Sheetname
	 * @return
	 * @throws Throwable
	 */
	public int GetRowCount(String Sheetname) throws Throwable
	{
		FileInputStream file=new FileInputStream(IConstants.EXCELPATH);
		Workbook book=WorkbookFactory.create(file);
		Sheet sh=book.getSheet(Sheetname);
		int Rownum=sh.getLastRowNum();
		book.close();
		return Rownum;
	}



}
