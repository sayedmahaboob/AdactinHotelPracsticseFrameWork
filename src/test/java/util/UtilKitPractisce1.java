package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class UtilKitPractisce1 {
	static FileInputStream fis1;
	public static HashMap<String,String> getDatafromExcel(String testCase){
		try {
			fis1=new FileInputStream("src\\test\\resources\\testdata\\excel\\MasterTestData.xlsx");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		XSSFWorkbook wb=null;
		try {
			wb=new XSSFWorkbook(fis1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		XSSFSheet ws=null;
		 ws=wb.getSheet("regression");
		 ArrayList<Row> TestcaseRows=getTestcaseData(ws,testCase);
		 HashMap<String,String> testData= new HashMap<String,String>();
		 for(int i=0;i<TestcaseRows.size();i++) {
			int noOfcells =TestcaseRows.get(i).getLastCellNum();
			for(int j=1;j<noOfcells;j++) {
				testData.put(TestcaseRows.get(0).getCell(j).getStringCellValue(),
						TestcaseRows.get(1).getCell(j).getStringCellValue());
			}
			 
		 }
		return testData;
		
	}
	private static ArrayList<Row> getTestcaseData(XSSFSheet ws, String testCase) {
		ArrayList<Row> allTestRows	=new ArrayList<Row>();
		for(int i=0;i<=ws.getLastRowNum();i++) {
			if(ws.getRow(i)!=null) {
				allTestRows.add(ws.getRow(i));
			}
		}
		ArrayList<Row> TestcaseRows	=new ArrayList<Row>();
		for(int i=0;i<allTestRows.size();i++) {
			if(allTestRows.get(i).getCell(0).getStringCellValue().equalsIgnoreCase(testCase)) {
				TestcaseRows.add(allTestRows.get(i));
			}
		}
		
		return TestcaseRows ;
		
		
	}

}
