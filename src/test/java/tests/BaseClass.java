package tests;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.qtpselenium.hybrid.util.ExtentManager;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
 

public class BaseClass extends ExtentReportDemo{
	
	AppiumDriver<MobileElement> driver;
	public static ArrayList<String> sTestTimeStampArray = new ArrayList();
	public static HashMap<String, String> sTestTimeStampMap = new HashMap<>();
	public static ArrayList<String> sTestTimeStampSampleArray = new ArrayList();
	DesiredCapabilities capabilities = new DesiredCapabilities();
	//URL url=null;


	public static String path = "";
	public static ArrayList<String> sFailedTestNameArray = new ArrayList();
	public static ArrayList<String> sTestNameArray = new ArrayList();

	public static String sSuiteTestName = null;
	public static String sTestClassNameFullPath = null;
	public static String sTestClassName = null;
	public static String sTestMethodName = null;
	File app = null;
	public String sAppPath = null;

	public static String sProduction_Org = null;
	public static String sOSName = null;
	public static String sDeviceType = null;
	public static String sSelectConfigPropFile = null;
	public static String sSalesforceServerVersion = null;
	public static String sBuildNo = null;
	public static String sTestName = null;
	public static String sOrgType = null;
	public static String sUDID = null;
	public static String sAndroidDeviceName = null;
	public static String sURL = null;
	public static String sIosDeviceName = null;
	public static String sXcode_SigninID = null;
	public static String sXcode_OrgID = null;
	public static String sAutomation_Name = null;
	public static String sUpdate_BundleID = null;
	public static String sApp_BundleID = null;
	public static String sNo_Reset = null;
	public static String sApp_Name = null;
	public static String sIOSPlatformVersion = null;
	public static String sAndroidPlatformVersion = null;
	public static String sOAUTHUrl = null;
	public static String SClientId = null;
	public static String sClientSecret = null;
	public static String sCreateURL = null;
	public static String sBaseTimeStamp = null;
	public static long lInitTimeStartMilliSec;
	public static long lInitTimeEndMilliSec;
	public static String sRun_From_Jenkins_Build = null;
	public static String sWinAppId = null;
	public static String sSyncGatewayUrl = null;
	public static String sSyncGatewayUrlAlias = null;
	// Relative File Paths
		public static String sDirPath = System.getProperty("user.dir").replace("\\", "/");
		public static String sResources = sDirPath + "/resources";
		public static String sConfigPropertiesExcelFile = sResources + "/Tests.xlsx";
		public static String sTestDataFile = sResources + "/TestData.xlsx";
		public static String sConfigFile = sResources + "/select_config_file.properties";// sResources+"//config_local.properties";
		public static String sDataFile = sDirPath + "/../Executable/data.properties";
		public static String sXmlFilePath = sDirPath + "/suites/failedSuite/failedTests.xml";// "/auto/SVMX_Catalyst/fsaautomation/suites/failedSuite/failedTests.xml";
		public static String sSahiExecShellFile = sDirPath + "/../Executable/sahiExecutable.sh";
		public static String sStartSahiShellFile = sDirPath + "/../Executable/startSahi.sh";
		public static String sSahiExecBatFile = sDirPath + "/../Executable/sahiExecutable.bat";
		public static String sStartSahiBatFileWin = sDirPath + "/../Executable/startSahi.bat";
		public static String sUninstallWinBatFile = sDirPath + "/../Executable/unInstallWindowsApp.bat";
		public static String sInstallWinBatFile = sDirPath + "/../Executable/installWindowsApp.bat";
		public static String sWinApplFile = sResources + "/FSARN_1.0.6.0_DebugBundle_Test/FSARN_1.0.6.0_x86_DebugBundle.appxbundle";
		public static String sSahiRelativePath = sDirPath + "/../../sahi_pro";
		public static String sSahiResultCommonFilePath = sDirPath + "/../Executable/sahiResultCommon.txt";
		public static String sSimpleResultExcelFile = sDirPath + "/ExtentReports/" + "/resultSummary.xlsx";
		public static String sWizardFilePath = sDirPath + "/resources/Wizards.txt";
		public static String sPerfResultExcelFile = sDirPath + "/ExtentReports/" + "/perfSummary.xlsx";
		// Execution legends
		public static String sRunningSymbol = ">>";
		public static String sCompletedSymbol = "^^";
		public static String sRetrySymbol = "<<";
		public static String sRetryState = "";
		public static Integer iTestCount = 0;
		public static Integer iTestPassCount = 0;
		public static Integer iTestFailCount = 0;
		public static String sGoAppBuildNo = "";
		public static String sFsaAppBuildNo = "";
		public static String sBaseExecOS = System.getProperty("os.name");
		public static Integer iBaseCounter = 0;
		public static boolean bBaseLibFailureFlag = false;
		/**
		 * Get the time difference in minutes
		 * 
		 * @param lInitTimeStart
		 * @param lInitTimeEnd
		 * @return
		 */
		public long getDateDiffInMin(long lInitTimeStart, long lInitTimeEnd) {

			long diffInMillies = Math.abs(lInitTimeStart - lInitTimeEnd);
			long sDiff = TimeUnit.MINUTES.convert(diffInMillies, TimeUnit.MILLISECONDS);
			return sDiff;
		}

		/**
		 * Get the base time stamp on start
		 * 
		 * @return
		 */
		public String getBaseTimeStamp() {
			sBaseTimeStamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));
			// System.out.println(sBaseTimeStamp);
			return sBaseTimeStamp;
		}
		@BeforeSuite
		/**
		 * Start the server logs, mainly for For reporting purpose, does not impact
		 * executions
		 * 
		 * @param context
		 * @throws IOException
		 */
		public void startServerLogs(ITestContext context) throws IOException {
			htmlReporter=new ExtentHtmlReporter("extent.html");
			extent=new ExtentReports();
			extent.attachReporter(htmlReporter);

			// For report and naming purpose, does not impact executions
			sTestName = context.getCurrentXmlTest().getClasses().toString().replaceAll("XmlClass class=", "").replaceAll("\\[\\[", "").replaceAll("\\]\\]", "").replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("com.ge.fsa.tests.", "");
			sSuiteTestName = context.getSuite().getName();

			sSuiteTestName = sSuiteTestName.equalsIgnoreCase("Default suite") ? sTestName : sSuiteTestName;
			System.out.println("[BaseLib] Excuting SUITE : " + sSuiteTestName);
			System.out.println("[BaseLib] Excuting Tests : " + sTestName);
			System.out.println("[BaseLib] Total Tests In This Suite = " + sTestName.split(",").length);
			iTestCount = iTestCount + sTestName.split(",").length;
			System.out.println("[BaseLib] Total Tests Executed So Far = " + iTestCount);
			// Get all jenkins parameters from env
			// Check if jenkins is setting the Select_Config_Properties_For_Build else use
			// local file

			sOrgType = System.getenv("Org_Type") != null ? System.getenv("Org_Type") : "base";
			System.out.println("[BaseLib] Server Org Type = " + sOrgType);

			// Select the appropriate config file On setting USE_PROPERTY_FILE to
			// "config_automation_build" the config_automation_build excel sheet will be
			// used to get data
			sSelectConfigPropFile = System.getenv("Select_Config_Properties_File_Catalyst") != null ? System.getenv("Select_Config_Properties_File_Catalyst").toLowerCase() : CommonUtility.getConfigValue(BaseClass.sConfigFile, "USE_PROPERTY_FILE").toLowerCase();

			System.out.println("[BaseLib] Running On Profile : " + sSelectConfigPropFile);
			System.out.println("[BaseLib] Reading Config Properties From : " + BaseClass.sConfigFile);

			sProduction_Org = System.getenv("Production_Org") != null ? System.getenv("Production_Org") : CommonUtility.readExcelData(BaseClass.sConfigPropertiesExcelFile, sSelectConfigPropFile, "PRODUCTION_ORG").toLowerCase();
			;
			System.out.println("[BaseLib] Production_Org = " + sProduction_Org);

			// Select the OS from Run_On_Platform from jenkins or local
			sOSName = System.getenv("Run_On_Platform") != null ? System.getenv("Run_On_Platform").toLowerCase() : CommonUtility.readExcelData(BaseClass.sConfigPropertiesExcelFile, sSelectConfigPropFile, "PLATFORM_NAME").toLowerCase();// GenericLib.readExcelData(GenericLib.sConfigPropertiesExcelFile,sSelectConfigPropFile,
			// "PLATFORM_NAME").toLowerCase();
			System.out.println("[BaseLib] OS Name = " + sOSName);

			sDeviceType = System.getenv("Device_Type") != null ? System.getenv("Device_Type") : CommonUtility.readExcelData(BaseClass.sConfigPropertiesExcelFile, sSelectConfigPropFile, "DEVICE_TYPE").toLowerCase();
			System.out.println("[BaseLib] Device Type = " + sDeviceType);

			// Get the build number from jenkins
			sBuildNo = System.getenv("BUILD_NUMBER") != null ? System.getenv("BUILD_NUMBER") : "local";
			System.out.println("[BaseLib] BUILD_NUMBER : " + sBuildNo);

			// Get UDID
			sUDID = System.getenv("UDID") != null ? System.getenv("UDID") : CommonUtility.readExcelData(BaseClass.sConfigPropertiesExcelFile, sSelectConfigPropFile, "UDID").toLowerCase();
			System.out.println("[BaseLib] UDID_IOS : " + sUDID);

			sWinAppId = System.getenv("WIN_APP_ID") != null ? System.getenv("WIN_APP_ID") : CommonUtility.readExcelData(BaseClass.sConfigPropertiesExcelFile, sSelectConfigPropFile, "WIN_APP_ID").toLowerCase();
			System.out.println("[BaseLib] WIN_APP_ID : " + sWinAppId);

			sApp_Name = System.getenv("APP_NAME") != null ? System.getenv("APP_NAME") : CommonUtility.readExcelData(BaseClass.sConfigPropertiesExcelFile, sSelectConfigPropFile, "APP_NAME");
			System.out.println("[BaseLib] APP_NAME : " + sApp_Name);

			sAndroidDeviceName = System.getenv("ANDROID_DEVICE_NAME") != null ? System.getenv("ANDROID_DEVICE_NAME") : CommonUtility.readExcelData(BaseClass.sConfigPropertiesExcelFile, sSelectConfigPropFile, "ANDROID_DEVICE_NAME").toLowerCase();
			System.out.println("[BaseLib] ANDROID_DEVICE_NAME : " + sAndroidDeviceName);

			sIOSPlatformVersion = System.getenv("IOS_PLATFORM_VERSION") != null ? System.getenv("IOS_PLATFORM_VERSION") : CommonUtility.readExcelData(BaseClass.sConfigPropertiesExcelFile, sSelectConfigPropFile, "IOS_PLATFORM_VERSION").toLowerCase();
			System.out.println("[BaseLib] IOS_PLATFORM_VERSION : " + sIOSPlatformVersion);

			sAndroidPlatformVersion = System.getenv("ANDROID_PLATFORM_VERSION") != null ? System.getenv("ANDROID_PLATFORM_VERSION") : CommonUtility.readExcelData(BaseClass.sConfigPropertiesExcelFile, sSelectConfigPropFile, "ANDROID_PLATFORM_VERSION").toLowerCase();
			System.out.println("[BaseLib] ANDROID_PLATFORM_VERSION : " + sAndroidPlatformVersion);

			sOAUTHUrl = System.getenv("OAUTH_URL") != null ? System.getenv("OAUTH_URL") : CommonUtility.readExcelData(BaseClass.sConfigPropertiesExcelFile, sSelectConfigPropFile, "OAUTH_URL").toLowerCase();
			System.out.println("[BaseLib] OAUTH_URL : " + sOAUTHUrl);

			SClientId = System.getenv("CLIENT_ID") != null ? System.getenv("CLIENT_ID") : CommonUtility.readExcelData(BaseClass.sConfigPropertiesExcelFile, sSelectConfigPropFile, "CLIENT_ID").toLowerCase();
			System.out.println("[BaseLib] CLIENT_ID : " + SClientId);

			sClientSecret = System.getenv("CLIENT_SECRET") != null ? System.getenv("CLIENT_SECRET") : CommonUtility.readExcelData(BaseClass.sConfigPropertiesExcelFile, sSelectConfigPropFile, "CLIENT_SECRET").toLowerCase();
			System.out.println("[BaseLib] CLIENT_SECRET : " + sClientSecret);

			sCreateURL = System.getenv("CREATE_URL") != null ? System.getenv("CREATE_URL") : CommonUtility.readExcelData(BaseClass.sConfigPropertiesExcelFile, sSelectConfigPropFile, "CREATE_URL").toLowerCase();
			System.out.println("[BaseLib] CREATE_URL : " + sCreateURL);

			sURL = System.getenv("URL") != null ? System.getenv("URL") : CommonUtility.readExcelData(BaseClass.sConfigPropertiesExcelFile, sSelectConfigPropFile, "URL").toLowerCase();
			System.out.println("[BaseLib] URL : " + sURL);

			sIosDeviceName = System.getenv("IOS_DEVICE_NAME") != null ? System.getenv("IOS_DEVICE_NAME") : CommonUtility.readExcelData(BaseClass.sConfigPropertiesExcelFile, sSelectConfigPropFile, "IOS_DEVICE_NAME").toLowerCase();
			System.out.println("[BaseLib] IOS_DEVICE_NAME : " + sIosDeviceName);

			sXcode_SigninID = System.getenv("XCODE_SIGNID") != null ? System.getenv("XCODE_SIGNID") : CommonUtility.readExcelData(BaseClass.sConfigPropertiesExcelFile, sSelectConfigPropFile, "XCODE_SIGNID").toLowerCase();
			System.out.println("[BaseLib] XCODE_SIGNID : " + sXcode_SigninID);

			sXcode_OrgID = System.getenv("XCODE_ORGID") != null ? System.getenv("XCODE_ORGID") : CommonUtility.readExcelData(BaseClass.sConfigPropertiesExcelFile, sSelectConfigPropFile, "XCODE_ORGID").toLowerCase();
			System.out.println("[BaseLib] XCODE_ORGID : " + sXcode_OrgID);

			sAutomation_Name = System.getenv("AUTOMATION_NAME") != null ? System.getenv("AUTOMATION_NAME") : CommonUtility.readExcelData(BaseClass.sConfigPropertiesExcelFile, sSelectConfigPropFile, "AUTOMATION_NAME").toLowerCase();
			System.out.println("[BaseLib] AUTOMATION_NAME : " + sAutomation_Name);

			sUpdate_BundleID = System.getenv("UPDATE_BUNDLEID") != null ? System.getenv("UPDATE_BUNDLEID") : CommonUtility.readExcelData(BaseClass.sConfigPropertiesExcelFile, sSelectConfigPropFile, "UPDATE_BUNDLEID").toLowerCase();
			System.out.println("[BaseLib] UPDATE_BUNDLEID : " + sUpdate_BundleID);

			sApp_BundleID = System.getenv("APP_BUNDLEID") != null ? System.getenv("APP_BUNDLEID") : CommonUtility.readExcelData(BaseClass.sConfigPropertiesExcelFile, sSelectConfigPropFile, "APP_BUNDLEID").toLowerCase();
			System.out.println("[BaseLib] APP_BUNDLEID : " + sApp_BundleID);

			sNo_Reset = System.getenv("NO_RESET") != null ? System.getenv("NO_RESET") : CommonUtility.readExcelData(BaseClass.sConfigPropertiesExcelFile, sSelectConfigPropFile, "NO_RESET").toLowerCase();
			System.out.println("[BaseLib] NO_RESET : " + sNo_Reset);

			sRun_From_Jenkins_Build = System.getenv("Run_From_Jenkins_Build") != null ? System.getenv("Run_From_Jenkins_Build") : "No";
			System.out.println("[BaseLib] Run_From_Jenkins_Build : " + sRun_From_Jenkins_Build);

			sSyncGatewayUrl = System.getenv("Sync_Gateway_Url") != null ? System.getenv("Sync_Gateway_Url") : CommonUtility.readExcelData(BaseClass.sConfigPropertiesExcelFile, sSelectConfigPropFile, "SYNC_GATEWAY_URL").toLowerCase();
			System.out.println("[BaseLib] Sync_Gateway_Url : " + sSyncGatewayUrl);

			System.out.println("[BaseLib] iBaseCounter : " + iBaseCounter);

		}
		

	
	@BeforeTest
	
		/*  DesiredCapabilities capabilities = new DesiredCapabilities();
          capabilities.setCapability("appium-version", "1.17.0");
          capabilities.setCapability("platformVersion", "8.0.0");
          capabilities.setCapability("platformName", "Android");
         // capabilities.setCapability("automationName", "XCUITest");
          capabilities.setCapability("appPackage", "com.servicemaxinc.connect");
          capabilities.setCapability("appActivity", "com.servicemaxinc.connect.QRCodeInitial");

       //   capabilities.setCapability("udid", "52007fdec0317533");
          capabilities.setCapability("udid", "52007fdec0317533");
          String appPath = "/Users/pratima.chinthala/Documents/connect/Connect.apk";
          
          //String appPath= "/Users/pratima.chinthala/Documents/connect/ios/build/connect/Build/Products/Debug-iphonesimulator/connect.app";
       // String appPath= "/Users/pratima.chinthala/Documents/connect/connect.ipa";
assert appPath != null: "Path to iOS app is not set";
System.out.println("iOS App path: "+ appPath);
capabilities.setCapability("app", appPath);
          
          capabilities.setCapability("autoGrantPermissions","true");
         // capabilities.setCapability("udid", "D24F5442-27E4-4064-A8DB-6A0F4C3585A6");
         
          capabilities.setCapability("deviceName", "device");
          try {
			URL url=new URL("http://127.0.0.1:4723/wd/hub");
            driver = new AppiumDriver<MobileElement>(url, capabilities);
            driver = new AndroidDriver<MobileElement>(url, capabilities);
            driver = new IOSDriver<MobileElement>(url, capabilities);



		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getCause());
			System.out.println(e.getMessage());
			e.printStackTrace();


		}
		*/
		public void setAppCapabilities() throws Exception {

			// Create all the required directories
			File file = new File(System.getProperty("user.dir") + "/../Executable");
			try {
				file.mkdir();
			} catch (Exception e) {
				System.out.println("[BaseLib] Exception in creating Executable directory for Sahi " + e);
			}
			File file1 = new File(System.getProperty("user.dir") + "/ExtentReports");
			try {
				file1.mkdir();
			} catch (Exception e) {
				System.out.println("[BaseLib] Exception in creating ExtentReports directory for Reports " + e);
			}
			File fileDir = new File(System.getProperty("user.dir") + "/suites/failedSuite");
			try {
				fileDir.mkdir();
			} catch (Exception e) {
				System.out.println("[BaseLib] Exception in creating failedSuite directory for Reruns " + e);
			}

			// ----------------------------------------------------------------------------

			// Based on OS/Device type set the appropriate capabilities

			/*
			 * service = AppiumDriverLocalService.buildDefaultService(); try
			 * {service.start();}catch(Exception e) {}
			 */
			Boolean no_resetFlag = Boolean.parseBoolean(CommonUtility.readExcelData(BaseClass.sConfigPropertiesExcelFile, sSelectConfigPropFile, "NO_RESET"));
			switch (sOSName) {
			case "android":
				try { // Android Drivers
				sAppPath = BaseClass.sResources + "/" + "/"+ "Connect.apk";
					capabilities = new DesiredCapabilities();
					capabilities.setCapability("app", sAppPath);
					capabilities.setCapability("platformName", sOSName);
					capabilities.setCapability("platformVersion", sAndroidPlatformVersion);
					capabilities.setCapability("deviceName", sAndroidDeviceName);
					

					/*if (sApp_Name.toLowerCase().contains("go")) {
						// Ignore the AutoWebview setting for phone
						System.out.println("Setting AUTO_WEBVIEW to false");
						capabilities.setCapability("autoWebview", false);
						capabilities.setCapability("appPackage", "com.servicemaxinc.fsa");
						capabilities.setCapability("appActivity", "com.servicemaxinc.fsa.MainActivity");
						capabilities.setCapability("ignoreUnimportantViews", true);

					} else {
						capabilities.setCapability("autoWebview", true);
						capabilities.setCapability("appPackage", "com.servicemaxinc.svmxfieldserviceapp");
						capabilities.setCapability("appActivity", "com.servicemaxinc.svmxfieldserviceapp.ServiceMaxMobileAndroid");
					}
					if (no_resetFlag == false) {
						capabilities.setCapability("fullReset", true);

					}
					capabilities.setCapability("noReset", no_resetFlag);
					// capabilities.setCapability("nativeWebTap", true);
					capabilities.setCapability("autoGrantPermissions", true);
					capabilities.setCapability("locationServicesAuthorized", true);
					capabilities.setCapability("locationServicesEnabled", true);
					capabilities.setCapability("clearSystemFiles", true);
					capabilities.setCapability("newCommandTimeout", 5000);
					// capabilities.setCapability("setWebContentsDebuggingEnabled", true);
					capabilities.setCapability("automationName", "uiautomator2");
					capabilities.setCapability("unicodeKeyboard", true);
					capabilities.setCapability("resetKeyboard", true);
					capabilities.setCapability("autoAcceptAlerts", true);
					capabilities.setCapability("locale", "GB");
					capabilities.setCapability("language", "en");
					// capabilities.setCapability("–-session-override", true);
					// capabilities.setCapability("--relaxed-security", true);
					// capabilities.setCapability("--log-level", "error");
					// driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),
					// capabilities);
					 * 
					 */
					/*capabilities.setCapability("appium-version", "1.17.0");
                    capabilities.setCapability("platformVersion", "8.0.0");
                    capabilities.setCapability("platformName", "Android");
                   // capabilities.setCapability("automationName", "XCUITest");
                    capabilities.setCapability("appPackage", "com.servicemaxinc.connect");
                    capabilities.setCapability("appActivity", "com.servicemaxinc.connect.QRCodeInitial");

                    capabilities.setCapability("udid", "52007fdec0317533");
                    capabilities.setCapability("autoGrantPermissions","true");
                   // capabilities.setCapability("udid", "D24F5442-27E4-4064-A8DB-6A0F4C3585A6");
                   
                    capabilities.setCapability("deviceName", "device");

*/
                    // Set job name

                   String appPath = "/Users/pratima.chinthala/Documents/connect/Connect.apk";
                                   
                                    //String appPath= "/Users/pratima.chinthala/Documents/connect/ios/build/connect/Build/Products/Debug-iphonesimulator/connect.app";
                                 // String appPath= "/Users/pratima.chinthala/Documents/connect/connect.ipa";
                    assert appPath != null: "Path to iOS app is not set";
                    System.out.println("Android App path: "+ appPath);
                    capabilities.setCapability("app", appPath);
                
					driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

					Thread.sleep(2000);
				} catch (Exception e) {
					throw e;
				}
				break;

			// ----------------------------------------------------------------------------

			case "ios":

				try { // IOS Drivers

					/*sAppPath = BaseClass.sResources + "/" + "/"+ "Connect.ipa";
					app = new File(sAppPath);
					capabilities = new DesiredCapabilities();
					capabilities.setCapability("platformName", sOSName);
					capabilities.setCapability("platformVersion", sIOSPlatformVersion);
					capabilities.setCapability("deviceName", sIosDeviceName);
					capabilities.setCapability("automationName", sAutomation_Name);
					capabilities.setCapability("app", sAppPath);
					capabilities.setCapability("udid", sUDID);

						// capabilities.setCapability("ignoreUnimportantViews",true);
						// Dont use for Go App
						// capabilities.setCapability("autoAcceptAlerts", true);


					capabilities.setCapability("handlesAlerts", true);
					capabilities.setCapability("xcodeOrgId", sXcode_OrgID);
					capabilities.setCapability("xcodeSigningId", sXcode_SigninID);
					capabilities.setCapability("updatedWDABundleId", sUpdate_BundleID);
					capabilities.setCapability("startIWDP", true);
					capabilities.setCapability("autoGrantPermissions", true);
					capabilities.setCapability("locationServicesAuthorized", true);
					capabilities.setCapability("locationServicesEnabled", true);
					capabilities.setCapability("clearSystemFiles", true);
					capabilities.setCapability("newCommandTimeout", 5000);
					capabilities.setCapability("locale", "en-GB");
					// capabilities.setCapability("–-session-override", true);
					// capabilities.setCapability("--relaxed-security", true);
					// capabilities.setCapability("--log-level", "error");

					// capabilities.setCapability("showXcodeLog", true);
					// Use this capability for fixing slow launch of app
					if (bBaseLibFailureFlag == true) {
						System.out.println("[BaseLib] Baselib Failed Re-installing WebDriver");
						// Using this causes the webdriver ios-deploy to fail
						// capabilities.setCapability("useNewWDA", true);
						bBaseLibFailureFlag = false;
					}
*/
					capabilities.setCapability("appium-version", "1.17.0");
                    capabilities.setCapability("platformVersion", "13.2.2");
                    capabilities.setCapability("platformName", "ios");
                    capabilities.setCapability("automationName", "XCUITest");
                   // capabilities.setCapability("udid", "00008030-001024301ADA802E");
                    capabilities.setCapability("udid", "00008030-001024301ADA802E");
                  //  capabilities.setCapability("autoGrantPermissions", true);
                   // capabilities.setCapability("permissions", "{\"com.servicemaxinc\": {\"camera\": \"YES\"}}");


                   capabilities.setCapability("updatedWDABundleId", "com.servicemaxinc.WebDriverAgentRunner");
                    capabilities.setCapability("startIWDP", "true");
                    capabilities.setCapability("noReset", "true");
                  // capabilities.setCapability("wdaEventloopIdleDelay","5");
                   // capabilities.setCapability("waitForQuiescence","false");


                   //capabilities.setCapability("autoWebview", false);
                    capabilities.setCapability("deviceName", "Pratima iPhone");
                              //      capabilities.setCapability("deviceName", "iPhone 11 Simulator");

                    capabilities.setCapability("updatedWDABundleID", "com.servicemaxinc.WebDriverAgentRunner");
                    //caps1.setCapability("startIWDP", true);
                  capabilities.setCapability("xcodeOrgID", "VP29PT4S86");
                    capabilities.setCapability("xcodeSigningId", "Apple Development:Servicmax FSA (6DFUZHHYAX)");

                    // Set job name

               //    String appPath = "/Users/pratima.chinthala/Documents/connect/ios/build/connect/Build/Products/Debug-iphoneos/connect.app";
                                   
                                    //String appPath= "/Users/pratima.chinthala/Documents/connect/ios/build/connect/Build/Products/Debug-iphonesimulator/connect.app";
                                  String appPath= "/Users/pratima.chinthala/Documents/connect/connect.ipa";
                    assert appPath != null: "Path to iOS app is not set";
                    System.out.println("iOS App path: "+ appPath);
                    capabilities.setCapability("app", appPath);

					driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

					Thread.sleep(2000);
				} catch (Exception e) {
					throw e;
				}

			break;
			
	}


		
	}
	


	@AfterSuite
	public void teardown()
	{
		driver.close();
		extent.flush();

		
	}

}
