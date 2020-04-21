package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;

public class CommonUtility {
	public CommonUtility(AppiumDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	AppiumDriver driver = null;
	private WebElement pheleSearchListItem;
	public static String sAppBundleID = BaseClass.sApp_BundleID;
	
	
	@FindBy(xpath = "//span[text()='Search']")
	private WebElement elesearchButton;

	public WebElement getElesearchButton() {
		return elesearchButton;

	}
	 public void createExcelReport(ArrayList<String> sTestNameArray) {
	    	try {
	    		String[][] data = new String[sTestNameArray.size()][2];
	    		XSSFWorkbook workbook = new XSSFWorkbook();
	    		XSSFSheet spreadsheet = workbook.createSheet("result");
	    		// spreadsheet.createRow(0).createCell(0).setCellValue("TestName");
	    		FileOutputStream fos = new FileOutputStream(BaseClass.sSimpleResultExcelFile);
	    		System.out.println(": Result Summary :");
	    		// Write all the test results in the excel format

	    		// Create header column names
	    		Row rowTitle = spreadsheet.createRow(0);
	    		String[] sHeaderName = { "Time", "Scenario Name", "Method Name", "Status", "Failure Reason", "|", "CONCATENATE(\"Pass = \",Q1)", "CONCATENATE(\"Fail = \",S1)", "COUNTIF(G:G,\" Pass \")", "COUNTIF(G:G,\" Fail \")" };

	    		for (int j = 0, k = 0; j < sHeaderName.length; j++, k++) {

	    			if (sHeaderName[j].contains("CONCATENATE") || sHeaderName[j].contains("COUNTIF")) {
	    				rowTitle.createCell(k).setCellFormula(sHeaderName[j]);
	    			} else {
	    				rowTitle.createCell(k).setCellValue(sHeaderName[j]);
	    			}

	    			rowTitle.createCell(k + 1).setCellValue(" | ");
	    			k++;
	    		}

	    		// Add the result data
	    		for (int i = 0; i < sTestNameArray.size(); i++) {
	    			String[] sTestNameSplit = sTestNameArray.get(i).split("~~");
	    			int rowNo = i + 1;
	    			Row row = spreadsheet.createRow(rowNo);
	    			String strPrintLog = "";
	    			for (int j = 0, k = 0; j < sTestNameSplit.length; j++, k++) {

	    				row.createCell(k).setCellValue(sTestNameSplit[j]);
	    				row.createCell(k + 1).setCellValue(" | ");
	    				k++;
	    				// System.out.println(" : "+sTestNameSplit[j]);
	    				strPrintLog += sTestNameSplit[j] + " : ";
	    			}
	    			System.out.println(strPrintLog);
	    		}

	    		workbook.write(fos);
	    		fos.close();
	    		//workbook.close();
	    	} catch (Exception e) {
	    		System.out.println("Create Excel report error " + e);
	    	}
	    }


	/**
	 * Read the excel data based on the column name
	 * @param sFilePath
	 * @param sSheetName
	 * @param sColumnName
	 * @return
	 * @throws IOException
	 */
	public static String readExcelData(String sFilePath, String sSheetName, String sColumnName) throws IOException {
		String sData = null;
		FileInputStream fis = new FileInputStream(sFilePath);
		
		try {
	
			Workbook wb = (Workbook) WorkbookFactory.create(fis);
			Sheet sht = wb.getSheet(sSheetName);
			int iRowNum = sht.getLastRowNum();
			int k = 0;
			for (int i = 0; i < iRowNum; i++) {
				
				//if (sht.getRow(i).getCell(0).toString().equals(sTestCaseID)) {
					int iCellNum = sht.getRow(i).getLastCellNum();
					
					for(int j=0;j<iCellNum;j++)
					{
						if(sht.getRow(i).getCell(j).getStringCellValue().equals(sColumnName))
							{sData = sht.getRow(i+1).getCell(j).toString();
							break;
							}
							
					}
					
				
				//}
			}
			//wb.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		fis.close();
		return sData;
	}

	

	/**
	 * Set the config values in properties file
	 * @param sFile
	 * @param sKey
	 * @param sValue
	 */
	public static void setConfigValue(String sFile, String sKey, String sValue) {
		Properties prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream(new File(sFile));
			prop.load(fis);
			fis.close();
	
			FileOutputStream fos = new FileOutputStream(new File(sFile));
			prop.setProperty(sKey, sValue);
			prop.store(fos, "Updating folder path");
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Get the config value form properties file
	 * @param sFile
	 * @param sKey
	 * @return
	 */
	public static String getConfigValue(String sFile, String sKey) {
		Properties prop = new Properties();
		String sValue = null;
		try {
			InputStream input = new FileInputStream(sFile);
			prop.load(input);
			sValue = prop.getProperty(sKey);
	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sValue;
	}
	
	/**
	 * Shell file to execute sahi via testrunner
	 * @param sSahiFile
	 * @throws IOException
	 */

	
	/**
	 * Shell File to start sahi
	 * @throws Exception
	 */
	
	}
	

