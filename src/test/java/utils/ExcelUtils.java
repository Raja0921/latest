package utils;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import utils.ConfigFileReader;


public class ExcelUtils {
    //Main Directory of the project
    public static final String currentDir = System.getProperty("user.dir");
	final static Log log = LogFactory.getLog(ExcelUtils.class.getName());
    
    public static ConfigFileReader configFileReader;

    //Location of Test data excel file
    public static String testDataExcelPath = null;

    //Excel WorkBook
    private static XSSFWorkbook excelWBook;

    //Excel Sheet
    private static XSSFSheet excelWSheet;

    //Excel cell
    private static XSSFCell cell;

    //Excel row
    private static XSSFRow row;

    //Row Number
    public static int rowNumber;

    //Column Number
    public static int columnNumber;

    public static String testDataExcelFileName = "";
    
    public static String testDateExcelsheetName = ""; 
    
    //Setter and Getters of row and columns
    public static void setRowNumber(int pRowNumber) {
        rowNumber = pRowNumber;
    }

    public static int getRowNumber() {
        return rowNumber;
    }

    public static void setColumnNumber(int pColumnNumber) {
        columnNumber = pColumnNumber;
    }

    public static int getColumnNumber() {
        return columnNumber;
    }

    public static void setExcelFileSheet(String sheetName) {
    	
    	configFileReader = new ConfigFileReader();
    	System.out.println("From POM Excel Type to be used id - "+ System.getProperty("custType"));
    	testDataExcelFileName = "";
    	testDataExcelFileName = configFileReader.getExcelName();
    	testDateExcelsheetName = "Demo";
    	testDataExcelPath = currentDir + configFileReader.getExcelPath();
    	log.info(testDataExcelPath + testDataExcelFileName);
        FileInputStream ExcelFile = null;
		try {
			ExcelFile = new FileInputStream(testDataExcelPath + testDataExcelFileName);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
        try {
			excelWBook = new XSSFWorkbook(ExcelFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
        excelWSheet = excelWBook.getSheet(sheetName);
    }

    public static String getCellData(int RowNum, int ColNum) {
    	log.info(RowNum + " - "+ ColNum);
        cell = excelWSheet.getRow(RowNum).getCell(ColNum);
        DataFormatter formatter = new DataFormatter();
        String cellData = formatter.formatCellValue(cell);
        return cellData;
    }

    public static XSSFRow getRowData(int RowNum) throws Exception {
    	log.info("Iteration is " + RowNum);
    	   try {
               row = excelWSheet.getRow(RowNum);
               return row;
           } catch (Exception e) {
               throw (e);
           }
    }

    public static void setCellData(String value, int RowNum, int ColNum) {
        row = excelWSheet.getRow(RowNum);
        cell = row.getCell(ColNum);
        if (cell == null) {
            cell = row.createCell(ColNum);
            cell.setCellValue(value);
        } else {
            cell.setCellValue(value);
        }
        FileOutputStream fileOut = null;
		try {
			fileOut = new FileOutputStream(testDataExcelPath + testDataExcelFileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
        try {
			excelWBook.write(fileOut);
		} catch (IOException e) {
			e.printStackTrace();
		}
        try {
			fileOut.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
        try {
			fileOut.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    
    public void CreateExlFile(String filePath){
		try {
            String filename = filePath ;
            File file = new File (filePath);
            if(!file.exists())
            {
		            HSSFWorkbook workbook = new HSSFWorkbook();
		            SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy_hhmmss");
		    		Date curDate = new Date();
		    		String strDate = sdf.format(curDate);
		            HSSFSheet sheet = workbook.createSheet(strDate);  
		            HSSFRow rowhead = sheet.createRow((short)0);
		            rowhead.createCell(0).setCellValue("No.");
		            rowhead.createCell(1).setCellValue("US#");
		            rowhead.createCell(2).setCellValue("Scenario");
		            rowhead.createCell(3).setCellValue("Feasible");
		            rowhead.createCell(4).setCellValue("Status");
		            rowhead.createCell(5).setCellValue("Comments");
		            rowhead.createCell(6).setCellValue("ALM Test Script ID (If Non Feasible or Partially Automated ");
		            sheet.autoSizeColumn(5);
		            FileOutputStream fileOut = new FileOutputStream(filename);
		            workbook.write(fileOut);
		            fileOut.close();
		            System.out.println("Your excel file has been generated!");
		            log.info(">> Your excel file has been generated!");
            }
            else{
            	System.out.println("Your excel file has been alreay generated!");
            	log.info(">> Your excel file has been alreay generated!");
            }

        } catch ( Exception ex ) {
            System.out.println(ex);
            log.info(">> Error on Excel creation!" + ex);
        }
	}
	
	public void writeExlFile(String scegetName, String scegetStatus, Boolean sceisFailed, String filePath){
	       try
	       {
	           FileInputStream myxls = new FileInputStream(filePath);
	           HSSFWorkbook bddTestResultSheet = new HSSFWorkbook(myxls);
	           HSSFSheet worksheet = bddTestResultSheet.getSheetAt(0);
	           int a = worksheet.getLastRowNum();
	           System.out.println(a);
	           
	           Row row = worksheet.createRow(++a);
	           row.createCell(0).setCellValue(a);
	           worksheet.autoSizeColumn(0);
	           String string = scegetName;
	           String[] parts = string.split(":");
	           row.createCell(1).setCellValue(parts[1].trim());
	           worksheet.autoSizeColumn(1);
	           row.createCell(2).setCellValue(parts[0].trim());	           
	           worksheet.autoSizeColumn(2);
	           
	           if(parts[0].trim().contains("Non Feasible")){
	        	   row.createCell(3).setCellValue("Not feasible to automate");
	        	   row.createCell(4).setCellValue("-");
	        	   row.createCell(5).setCellValue("Manually tested as this is non feasible to automate");
	           }
	           else if(parts[0].trim().contains("Spillover")){
	        	   row.createCell(3).setCellValue("-");
	        	   row.createCell(4).setCellValue("-");
	        	   row.createCell(5).setCellValue("Spillover to Next sprint");
	           }
	           else {
	        	   row.createCell(3).setCellValue("-");
	        	   row.createCell(4).setCellValue(scegetStatus.trim());
	        	   if(parts[0].trim().contains("Partial Automated")){
	        		   row.createCell(5).setCellValue("Only part of the scenario is automated, remaining validation will be done manually to achieve 100%");   
	        	   }
	        	   else{
	        		   row.createCell(5).setCellValue(System.getProperty("Data"));
	        	   }
	           }
	           worksheet.autoSizeColumn(3);
	           worksheet.autoSizeColumn(4);
	           worksheet.autoSizeColumn(5);
	           
	           myxls.close();
	           FileOutputStream output_file =new FileOutputStream(new File(filePath));  
	           //write changes
	           bddTestResultSheet.write(output_file);
	           output_file.close();
	           System.out.println(" is successfully written");
	           log.info(">> is successfully written");
	       }
	catch(Exception e){
	       }
	   }
	
	public static void updateExl(String filePath){
		   try
	       {
			   String tempFileName = System.getProperty("user.dir")+configFileReader.getExcelPath() + configFileReader.getExcelName();
			   FileInputStream inp = new FileInputStream(tempFileName);
			   Workbook wb = WorkbookFactory.create(inp);
			   Sheet sheet = wb.getSheet(configFileReader.getXlSheetName("blue"));
			   
				if(System.getProperty("custType").equalsIgnoreCase("gold")){
					sheet = wb.getSheet(configFileReader.getXlSheetName("gold"));
				}
			 
				Row row = sheet.getRow(Integer.parseInt(System.getProperty("Iteration")));
			   Cell cell = row.getCell(5);
			   if (cell == null)
			       cell = row.createCell(5);
			   cell.setCellType(Cell.CELL_TYPE_STRING);
			   cell.setCellValue(System.getProperty("PayeeName"));
			   
			   Cell cell1 = row.getCell(6);
			   if (cell1 == null)
			       cell1 = row.createCell(6);
			   cell1.setCellType(Cell.CELL_TYPE_STRING);
			   cell1.setCellValue(System.getProperty("PayeeNName"));

			   // Write the output to a file
			   FileOutputStream fileOut = new FileOutputStream(tempFileName);
			   wb.write(fileOut);
			   fileOut.close();
	           System.out.println(" is successfully written");
	           log.info(">> is successfully written");
	       }   catch(Exception e){
	       }
	}
	
	
}
