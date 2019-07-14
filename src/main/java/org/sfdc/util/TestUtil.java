package org.sfdc.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestUtil {

	public static long PAGELOAD_TIMEOUT=30;
	public static long IMPLICIT_WAIT=20;
	
		
	public static String TEST_DATAFILE_PATH="C://Users/vinodha.s/workspace/POC/api/src/main/java/org/sfdc/testdata/Details.xlsx";
	
	static XSSFWorkbook workbook;
	static XSSFSheet dataSheet;
	
	public static Object[][] getTestData()
	{
		FileInputStream file =null;
		try{
			
			file=new FileInputStream(TEST_DATAFILE_PATH);
		}catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		
		try{
			workbook = new XSSFWorkbook(file);
			dataSheet= workbook.getSheetAt(0);
								
		
		}catch(IOException e)
		{
			e.printStackTrace();
		}
		
		
		Object[][] inputdata=new Object[dataSheet.getLastRowNum()][dataSheet.getRow(0).getLastCellNum()];
		for(int i=0; i<dataSheet.getLastRowNum();i++)
		{
			for(int j=0;j<dataSheet.getRow(i).getLastCellNum();j++)
			{
				inputdata[i][j]=dataSheet.getRow(i+1).getCell(j).toString();
			}
		}
		return inputdata;
	}
	
	
	
	private Properties properties;
	private final String propertyFilePath= "configs//Configuration.properties";

	
	public void configFileReader(){
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}		
	}
	
}


