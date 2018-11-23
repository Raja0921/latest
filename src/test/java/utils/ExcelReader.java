package utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.NumberToTextConverter;

public class ExcelReader {

    public List<Map<String, String>> getData(String scenarioName,String excelFilePath, String sheetName, List<String> parameterList)
            throws InvalidFormatException, IOException {
        Sheet sheet = getSheetByName(excelFilePath, sheetName);
        if(sheet==null){
        	throw new IOException(excelFilePath + "@" +  sheetName +  " is not valid in feature file: " + FeatureOverride.currentFeatureFile);
        }
        return readSheet(sheet, parameterList,scenarioName);
    }

    public List<Map<String, String>> getData(String scenarioName, String excelFilePath, int sheetNumber, List<String> parameterList)
            throws InvalidFormatException, IOException {
        Sheet sheet = getSheetByIndex(excelFilePath, sheetNumber);
        return readSheet(sheet, parameterList, scenarioName);
    }

    private Sheet getSheetByName(String excelFilePath, String sheetName) throws IOException, InvalidFormatException {
        Sheet sheet = getWorkBook(excelFilePath).getSheet(sheetName);
        return sheet;
    }

    private Sheet getSheetByIndex(String excelFilePath, int sheetNumber) throws IOException, InvalidFormatException {
        Sheet sheet = getWorkBook(excelFilePath).getSheetAt(sheetNumber);
        return sheet;
    }

    private Workbook getWorkBook(String excelFilePath) throws IOException, InvalidFormatException {
        return WorkbookFactory.create(new File(excelFilePath));
    }

    private List<Map<String, String>> readSheet(Sheet sheet, List<String> parameterList, String scenarioName) throws InvalidFormatException {
    		
    	
        Row row;
        int totalRow = sheet.getPhysicalNumberOfRows();
        int setCurrentRow = 0;
        int setEndRow = totalRow;
        boolean isScenarioNameFound = false;
        
        //get row number where scenario starts
        if (scenarioName!=null){
        	for(int rowNum=0; rowNum<totalRow; rowNum++){
        		String cellValue=null;
        		if(sheet.getRow(rowNum).getCell(0)!=null){        			
        			cellValue = sheet.getRow(rowNum).getCell(0).getStringCellValue().trim();
        		}
        		
        		if(isScenarioNameFound){
        			if(cellValue!=null){
        				setEndRow = rowNum;
        				break;
        			}
        		}
        		else if(cellValue!=null && cellValue.equalsIgnoreCase(scenarioName)){
        			setCurrentRow = rowNum;
        			isScenarioNameFound = true;
        		}        		
        	}
        	if(!isScenarioNameFound){
        		throw new InvalidFormatException("Scenario name \"" + scenarioName + "\" not found in excel");
        	}
        }

        
        
        List<Map<String, String>> excelRows = new ArrayList<Map<String, String>>();
        int headerRowNumber = 0;//getHeaderRowNumber(sheet);
        if (headerRowNumber != -1) {
            int totalColumn = sheet.getRow(setCurrentRow).getLastCellNum();            
            ArrayList<Integer> colInScope = new ArrayList<Integer>();
            ArrayList<String> excelCols = new ArrayList<String>();
            
            for (int currentRow = setCurrentRow; currentRow <setEndRow; currentRow++) {
            	if(currentRow==setCurrentRow){ //to get the index of cols which are used in feature file
            		//change for any combination of col
            		for(int colNum=0;colNum<totalColumn;colNum++){
            			excelCols.add(sheet.getRow(currentRow).getCell(colNum).getStringCellValue().toLowerCase());
            		}
            		for(int colNum=0; colNum<parameterList.size(); colNum++){
            			int  colIndex = excelCols.indexOf(parameterList.get(colNum).toLowerCase());
            			if(colIndex<0){
            				throw new InvalidFormatException("Parameter name \"" + parameterList.get(colNum) + "\" not found in excel");
            			}
            			colInScope.add(colIndex);
            		}
            		
            	}
            	else{
            		if(System.getProperty("environment")!=null && scenarioName!=null){
            			if(sheet.getRow(currentRow)!=null && sheet.getRow(currentRow).getCell(1)!=null){
            				if(!sheet.getRow(currentRow).getCell(1).getStringCellValue().equalsIgnoreCase(System.getProperty("environment"))){
                				continue; // does not match the environment so moving to next row
                			}
            			}else continue;            		
            			
            		}
            		row = getRow(sheet, sheet.getFirstRowNum() + currentRow);
                    LinkedHashMap<String, String> columnMapdata = new LinkedHashMap<String, String>();
                    for(int itemNum=0; itemNum<colInScope.size(); itemNum++){
                    	columnMapdata.putAll(getCellValue(sheet, row, colInScope.get(itemNum),setCurrentRow));
                    	
                    }
                    
                    excelRows.add(columnMapdata);
            	}
              
            }
        }
        return excelRows;
    }


    private int getHeaderRowNumber(Sheet sheet) {
        Row row;
        int totalRow = sheet.getLastRowNum();
        for (int currentRow = 0; currentRow <= totalRow + 1; currentRow++) {
            row = getRow(sheet, currentRow);
            if (row != null) {
                int totalColumn = row.getLastCellNum();
                for (int currentColumn = 0; currentColumn < totalColumn; currentColumn++) {
                    Cell cell;
                    cell = row.getCell(currentColumn, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
                        return row.getRowNum();

                    } else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                        return row.getRowNum();

                    } else if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
                        return row.getRowNum();
                    } else if (cell.getCellType() == Cell.CELL_TYPE_ERROR) {
                        return row.getRowNum();
                    }
                }
            }
        }
        return (-1);
    }

    private Row getRow(Sheet sheet, int rowNumber) {
        return sheet.getRow(rowNumber);
    }

    private LinkedHashMap<String, String> getCellValue(Sheet sheet, Row row, int currentColumn, int headerRow) {
        LinkedHashMap<String, String> columnMapdata = new LinkedHashMap<String, String>();
        Cell cell;
        if (row == null) {
            if (sheet.getRow(headerRow).getCell(currentColumn, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
                    .getCellType() != Cell.CELL_TYPE_BLANK) {
                String columnHeaderName = sheet.getRow(headerRow).getCell(currentColumn)
                        .getStringCellValue();
                columnMapdata.put(columnHeaderName, "");
            }
        } else {
            cell = row.getCell(currentColumn, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
            if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
                if (sheet.getRow(headerRow).getCell(cell.getColumnIndex(), Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
                        .getCellType() != Cell.CELL_TYPE_BLANK) {
                    String columnHeaderName = sheet.getRow(headerRow).getCell(cell.getColumnIndex())
                            .getStringCellValue();
                    columnMapdata.put(columnHeaderName, cell.getStringCellValue());
                }
            } else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                if (sheet.getRow(headerRow).getCell(cell.getColumnIndex(), Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
                        .getCellType() != Cell.CELL_TYPE_BLANK) {
                    String columnHeaderName = sheet.getRow(headerRow).getCell(cell.getColumnIndex())
                            .getStringCellValue();
                    columnMapdata.put(columnHeaderName, NumberToTextConverter.toText(cell.getNumericCellValue()));
                }
            } else if (cell.getCellType() == Cell.CELL_TYPE_BLANK) {
                if (sheet.getRow(headerRow).getCell(cell.getColumnIndex(), Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
                        .getCellType() != Cell.CELL_TYPE_BLANK) {
                    String columnHeaderName = sheet.getRow(headerRow).getCell(cell.getColumnIndex())
                            .getStringCellValue();
                    columnMapdata.put(columnHeaderName, "");
                }
            } else if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
                if (sheet.getRow(headerRow).getCell(cell.getColumnIndex(), Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
                        .getCellType() != Cell.CELL_TYPE_BLANK) {
                    String columnHeaderName = sheet.getRow(headerRow).getCell(cell.getColumnIndex())
                            .getStringCellValue();
                    columnMapdata.put(columnHeaderName, Boolean.toString(cell.getBooleanCellValue()));
                }
            } else if (cell.getCellType() == Cell.CELL_TYPE_ERROR) {
                if (sheet.getRow(headerRow).getCell(cell.getColumnIndex(), Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
                        .getCellType() != Cell.CELL_TYPE_BLANK) {
                    String columnHeaderName = sheet.getRow(headerRow).getCell(cell.getColumnIndex())
                            .getStringCellValue();
                    columnMapdata.put(columnHeaderName, Byte.toString(cell.getErrorCellValue()));
                }
            }
        }
        return columnMapdata;
    }
}