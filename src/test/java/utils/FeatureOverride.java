package utils;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

public class FeatureOverride {
	
	public static String currentFeatureFile;

    private static List<String> setExcelDataToFeature(File featureFile)
            throws InvalidFormatException, IOException {
    	currentFeatureFile = featureFile.getPath();
        List<String> fileData = new ArrayList<String>();
        try (BufferedReader buffReader = new BufferedReader(
                new InputStreamReader(new BufferedInputStream(new FileInputStream(featureFile)), "UTF-8"))) {
            String data;
            List<Map<String, String>> excelData = null;
            String scenarioName = null;
            List<String> parameterList = new ArrayList<String>();
            boolean foundHashTag = false;
            boolean featureData = false;
            boolean exampleData = false;
            while ((data = buffReader.readLine()) != null) {
                String sheetName = null;
                String excelFilePath = null;
                if(data.trim().startsWith("Scenario")){
                	parameterList = new ArrayList<String>();   
                	scenarioName = data.substring(data.indexOf(":")+1).trim();
                }
                
                if(exampleData && data.trim().startsWith("|")){
                	String[] tmpParamArray = data.trim().split("\\|");
                	for(int itemIndex=1; itemIndex<tmpParamArray.length; itemIndex++){
                		parameterList.add(tmpParamArray[itemIndex].trim());
                	}
               	
                	exampleData=false;
                }
                
                if(data.trim().startsWith("Examples")){
                	exampleData = true;             	
                }
                
                
//                Pattern pattern = Pattern.compile("<\\w+>");
//        		Matcher matcher = pattern.matcher(data);
//        		while(matcher.find()) {
//        			String tempParm = matcher.group();
//        			parameterList.add(tempParm.substring(1, tempParm.length()-1));                    
//                }
//                
                if (data.trim().contains("##@data")) {
                    excelFilePath = data.substring(StringUtils.ordinalIndexOf(data, "@", 2)+1, data.lastIndexOf("@"));
                    sheetName = data.substring(data.lastIndexOf("@")+1, data.length());
                    foundHashTag = true;                    
                    fileData.add(data);
                }
                if (data.trim().contains("##@externaldata")) {
                    excelFilePath = data.substring(StringUtils.ordinalIndexOf(data, "@", 2)+1, data.lastIndexOf("@"));
                    sheetName = data.substring(data.lastIndexOf("@")+1, data.length());
                    foundHashTag = true;
                    scenarioName=null;
                    fileData.add(data);
                } if (foundHashTag) {
                    excelData = new ExcelReader().getData(scenarioName,excelFilePath, sheetName, parameterList);
//                    String columnHeader = "";

//                    for (Entry<String, String> map : excelData.get(0).entrySet()) {
//                        columnHeader = columnHeader + "|" + map.getKey();
//                    }
//                   
//                    fileData.add(columnHeader + "|");

                    for (int rowNumber = 0; rowNumber < excelData.size(); rowNumber++) {
                        String cellData = "";
                        for (Entry<String, String> mapData : excelData.get(rowNumber).entrySet()) {
                            cellData = cellData + "|" + mapData.getValue();
                        }
                        fileData.add(cellData + "|");
                    }
                    foundHashTag = false;
                    featureData = true;
                    continue;
                }
                if(data.startsWith("|")||data.endsWith("|")){
                    if(featureData){
                        continue;
                    } else{
                        fileData.add(data);
                        continue;
                    }
                } else {
                    featureData = false;
                }
                fileData.add(data);
            }
        }
        return fileData; 
    }

    private static List<File> listOfFeatureFiles(File folder) {
        List<File> featureFiles = new ArrayList<File>();
        for (File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                featureFiles.addAll(listOfFeatureFiles(fileEntry));
            } else {
                if (fileEntry.isFile() && fileEntry.getName().endsWith(".feature")) {
                    featureFiles.add(fileEntry);
                }
            }
        }
        return featureFiles;
    }

    public static void overrideFeatureFiles(String featuresDirectoryPath)
            throws IOException, InvalidFormatException {
        List<File> listOfFeatureFiles = listOfFeatureFiles(new File(featuresDirectoryPath));
        for (File featureFile : listOfFeatureFiles) {
            List<String> featureWithExcelData = setExcelDataToFeature(featureFile);
            try (BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(new FileOutputStream(featureFile), "UTF-8"));) {
                for (String string : featureWithExcelData) {
                    writer.write(string);
                    writer.write("\n");
                }
            }
        }
    }
}