package tests;
 
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
 
import javax.annotation.Nullable;
 
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
 
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.remote.MobileCapabilityType;
import junit.framework.Assert;
 
 
public class AndroidAppTest {
               
                static AppiumDriver<MobileElement> driver  ;
 
               
   // static AppiumDriver<MobileElement> driver;
 
                public static void main(String args[]) {
                                System.out.println("Test started");
                               
                               
                                try {
                                                System.currentTimeMillis();
 
                                                checkLoginScreen();
                                                System.currentTimeMillis();
 
                                               
                                }catch(Exception exp) {
                                                exp.getCause();
                                }
                                System.out.println("Test ended");
 
                               
                }
                public void addPhoto() {
        //xcrun instruments -s device = list all simulators
        //xcrun simctl addphoto C2C451F0-9D33-4872-8615-4DE41D1A1017 /Users/Aleksei/Documents/test2.png
        try {
            String[] cmd = {"xcrun", "simctl", "addphoto", "00008030-001024301ADA802E", "/Users/pratima.chinthala/Documents/connect/download.png"};
            Process process = Runtime.getRuntime().exec(cmd);
            BufferedReader bufferedReader = new BufferedReader(new
                    InputStreamReader(process.getErrorStream()));
 
            String lsString;
            String output = "";
            while ((lsString = bufferedReader.readLine()) != null) {
                output += lsString;
            }
            System.out.println(output);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
               
               
               
               
               
                                      @Test
                                                public static void checkLoginScreen() throws Exception
                                                {
                                                                /*DesiredCapabilities cap=new DesiredCapabilities();
                                                                System.out.println(" begin capa Started");
                               
                                                                //cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus_5_API_R");
                                                                cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
                                                                cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13.2");
                                                                //cap.setCapability(MobileCapabilityType.APP, "/Users/pratima.chinthala/Documents/connect/ios/build/connect/Build/Products/Debug-iphonesimulator/connect.app");
                                                    cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
                                                                cap.setCapability(MobileCapabilityType.UDID, "4590A4F3-7C93-4328-8D7E-4226EECDEBB1");
                                                                System.out.println("MobileCapabilityType.DEVICE_NAME");
                               
                                                                URL url=new URL("https://127.0.0.1:4723/wd/hub");
                                                                //driver =new AppiumDriver<MobileElement>(url, cap);
                                                                IOSDriver<MobileElement> driver =new IOSDriver<MobileElement>(new URL("https://127.0.0.1:4723/wd/hub"),cap);
                                                                driver.findElement(By.name("Login In")).isDisplayed();
                                                                System.out.println(driver.findElement(By.name("Login In")));
                                                                System.out.println("Started");
                                                                */
                                                               
                                                                   
                               /*
                                                        DesiredCapabilities capabilities = new DesiredCapabilities();
                                                        capabilities.setCapability("appium-version", "1.17.0");
                                                        capabilities.setCapability("platformVersion", "13.2.2");
                                                        capabilities.setCapability("platformName", "ios");
                                                        capabilities.setCapability("automationName", "XCUITest");
                                                        capabilities.setCapability("udid", "00008030-001024301ADA802E");
                                                       // capabilities.setCapability("udid", "D24F5442-27E4-4064-A8DB-6A0F4C3585A6");
                                                        capabilities.setCapability("autoGrantPermissions", true);
                                                        capabilities.setCapability("permissions", "{\"com.servicemaxinc.WebDriverAgentRunner\": {\"camera\": \"YES\"}}");
 
 
                                                        capabilities.setCapability("updatedWDABundleId", "com.servicemaxinc.WebDriverAgentRunner");
                                                        capabilities.setCapability("startIWDP", "true");
                                                        capabilities.setCapability("noReset", "false");
                                                      // capabilities.setCapability("wdaEventloopIdleDelay","5");
                                                      // capabilities.setCapability("waitForQuiescence","false");
                               
                               
                                                       //capabilities.setCapability("autoWebview", false);
                                                        capabilities.setCapability("deviceName", "Pratima iPhone");
                                                                      //  capabilities.setCapability("deviceName", "iPhone 11 Simulator");
                               
                                                        //capabilities.setCapability("updatedWDABundleID", "com.servicemaxinc.WebDriverAgentRunner");
                                                        //caps1.setCapability("startIWDP", true);
                                                      capabilities.setCapability("xcodeOrgID", "VP29PT4S86");
                                                       capabilities.setCapability("xcodeSigningId", "Apple Development:Servicmax FSA (6DFUZHHYAX)");
                               
                                                        // Set job name
                               
                                                       String appPath = "/Users/pratima.chinthala/Documents/connect/ios/build/connect/Build/Products/Debug-iphoneos/connect.app";
                                                                       
                                                                        //String appPath= "/Users/pratima.chinthala/Documents/connect/ios/build/connect/Build/Products/Debug-iphonesimulator/connect.app";
                                                                     // String appPath= "/Users/pratima.chinthala/Documents/connect/connect.ipa";
                                                        assert appPath != null: "Path to iOS app is not set";
                                                        System.out.println("iOS App path: "+ appPath);
                                                        capabilities.setCapability("app", appPath);
                                                        AppiumDriver driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
                                                        */
                                                       /* Set<String> contextHandles =driver.getContextHandles();
                                                        *
                                                        
                                                        for(String s:contextHandles)
                                                        {
                                                               System.out.println("context" +s);
                                                               if(s.contains("WEBVIEW_")) {
                                                                               System.out.println("inside if condition");
                               
                                                                              
                                                                               ((AppiumDriver)driver).context(s);
                                                                               System.out.println("after if condition");
                               
                                                                       // driver.findElement(By.id("username")).click();
                                                                        driver.findElement(By.id("username")).sendKeys("jj@svmx.com");
                                                                       // driver.findElement(By.id("password")).click();
                                                                        driver.findElement(By.id("password")).sendKeys("test");
                               
                                                               }
                                                        }
                               
                                                        driver.findElement(By.id("username")).sendKeys("jj@svmx.com");
                                */
                                    	  DesiredCapabilities capabilities = new DesiredCapabilities();
                                          capabilities.setCapability("appium-version", "1.17.0");
                                          capabilities.setCapability("platformVersion", "8.0.0");
                                          capabilities.setCapability("platformName", "Android");
                                         // capabilities.setCapability("automationName", "XCUITest");
                                          capabilities.setCapability("appPackage", "com.servicemaxinc.connect");
                                          capabilities.setCapability("appActivity", "com.servicemaxinc.connect.QRCodeInitial");
       
                                          capabilities.setCapability("udid", "52007fdec0317533");
                                          capabilities.setCapability("autoGrantPermissions","true");
                                         // capabilities.setCapability("udid", "D24F5442-27E4-4064-A8DB-6A0F4C3585A6");
                                         
                                          capabilities.setCapability("deviceName", "device");
                 
                 
                                          // Set job name
                 
                                         String appPath = "/Users/pratima.chinthala/Documents/connect/Connect.apk";
                                                         
                                                          //String appPath= "/Users/pratima.chinthala/Documents/connect/ios/build/connect/Build/Products/Debug-iphonesimulator/connect.app";
                                                       // String appPath= "/Users/pratima.chinthala/Documents/connect/connect.ipa";
                                          assert appPath != null: "Path to iOS app is not set";
                                          System.out.println("iOS App path: "+ appPath);
                                          capabilities.setCapability("app", appPath);
                                          URL url=new URL("http://127.0.0.1:4723/wd/hub");
                                           driver = new AppiumDriver<MobileElement>(url, capabilities);
                 
                                    	  
                                    	  
                                                                driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS); 
                                                                driver.findElement(By.id("com.servicemaxinc.connect:id/toolbarScan")).click();
                                                              //  driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"login window gear\"]")).click();
                                                                
                                                                WebDriverWait wait = new WebDriverWait(driver, 10);
                                            try {
                                                wait.until(ExpectedConditions.alertIsPresent());
                                                driver.switchTo().alert().accept();
                                            } catch (Exception e) {
                                                System.err.println("   no alert visible after 10 sec.");
                                            }
                                                                AndroidAppTest appt=new AndroidAppTest();
                                                                appt.addPhoto();
                               
                                                driver.manage().timeouts().implicitlyWait(120,TimeUnit.SECONDS);           
 
                                                       
                                                        Set<String> contexts = driver.getContextHandles();
                               
                                                        // made sure we have web view content
                                                        // assertThat(contexts.size(), greaterThan(1));
                                                        for (String context : contexts) {
                                                             System.out.println(contexts);
                                                            if (context.contains("WEBVIEW_")) {
                               
                                                                driver.context((String) contexts.toArray()[1]);
                                                                                System.out.println("Current view "+contexts.toArray()[1]);
                                                                                driver.manage().timeouts().implicitlyWait(45,TimeUnit.SECONDS);           
                                                                                driver.findElement(By.id("username")).click();
                                                                        driver.findElement(By.id("username")).sendKeys("jj@svmx.com");
                                                                        driver.findElement(By.id("password")).sendKeys("1CustomerApp");
                                                                        driver.findElement(By.id("Login")).click();
                                                                System.out.println("Login SuccessFull");
                                                                                driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);           
                                                                                driver.findElement(By.id("oaapprove")).click();
                                                                                driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
                                                                driver.context((String) contexts.toArray()[0]);
                                                                System.out.println("Switching from WebView to Native View "+contexts.toArray()[0]);
                                                                WebElement text=driver.findElement(MobileBy.AccessibilityId("Hello, Joseph!"));
                                                                System.out.println(text.isDisplayed());
                                                                org.testng.Assert.assertEquals(text.getText(), "Hello, Joseph!");
                               
                                                                WebElement overview=driver.findElement(MobileBy.AccessibilityId("Overview, tab, 1 of 5"));
                                                                WebElement assets=driver.findElement(MobileBy.AccessibilityId("Assets, tab, 2 of 5"));
                                                                WebElement requests=driver.findElement(MobileBy.AccessibilityId("Requests, tab, 3 of 5"));
                                                                WebElement alerts=driver.findElement(MobileBy.AccessibilityId("Alerts, tab, 4 of 5"));
                                                                WebElement profile=driver.findElement(MobileBy.AccessibilityId("Profile, tab, 5 of 5"));
                                                                System.out.println("Printing the Tabs Name " +overview.getAttribute("name") +assets.getAttribute("name")+requests.getAttribute("name")+alerts.getAttribute("name")+profile.getAttribute("name"));
                                                                                driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);           
                               
                                                                                //driver.findElement(By.xpath("(//XCUIElementTypeOther[@name=\"Hello, Joseph! Tuesday, April 7\"])[9]/XCUIElementTypeOther[2]/XCUIElementTypeOther")).click();
                                                                                    driver.findElement(By.xpath("//XCUIElementTypeApplication[@name=\"Connect\"]/XCUIElementTypeWindow[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[4]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther")).click();
                                                                                    driver.findElement(By.xpath("//XCUIElementTypeOther[@name=\"Next\"]")).click();
                                                                                driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);           
                                                                                driver.findElement(By.xpath("//XCUIElementTypeOther[@name=\"(Optional) Instructions for the technician:\"]/XCUIElementTypeOther/XCUIElementTypeTextView")).sendKeys("Optional Text to technician");
                                                                                driver.hideKeyboard();
                                                                                driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);           
                                                                                    driver.findElement(By.xpath("//XCUIElementTypeOther[@name=\"Next\"]")).click();
                                                                                driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);           
                                                                                //WebElement service=driver.findElement(MobileBy.AccessibilityId("Serivce: Depot Repair"));
                                                                                //service.click();
                                                                                //driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);       
                                                                                    driver.findElement(By.xpath("//XCUIElementTypeOther[@name=\"Next\"]")).click();
                                                                                driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);           
                                                                                driver.findElement(By.xpath("//XCUIElementTypeOther[@name=\"Problem Description\"]/XCUIElementTypeOther/XCUIElementTypeTextView")).sendKeys("Problem Description");
                                                                                driver.hideKeyboard();
                               
                                                                                driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);           
                                                                                    driver.findElement(By.xpath("//XCUIElementTypeOther[@name=\"Next\"]")).click();
                                                                                driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);           
                               
                                                                                    driver.findElement(By.xpath("(//XCUIElementTypeOther[@name=\"Monday\"])[2]"));
                                                                                driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);           
                                                                                    driver.findElement(By.xpath("//XCUIElementTypeOther[@name=\"Next\"]")).click();
                                                                                driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);           
                                                                                    driver.findElement(By.xpath("//XCUIElementTypeOther[@name=\"Next\"]")).click();
                                                                               
                                                                                driver.manage().timeouts().implicitlyWait(80,TimeUnit.SECONDS);           
                                                                                driver.findElement(By.xpath("//XCUIElementTypeOther[@name=\"Submit Request\"]")).click();
                                                                                driver.manage().timeouts().implicitlyWait(90,TimeUnit.SECONDS);           
                                                                                driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\" Service Request Submitted:\"]")).click();
                                                                               
                                                                               
                               
                               
                               
                               
                                                                                    //driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Overview, tab, 1 of 5\"]")).click();
                                                                                    //System.out.println(driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Overview, tab, 1 of 5\"]")).isDisplayed());
                                                                    
                                                                                                                break;
                                                                                                               
                                                                                                               
                                                                                                               
                                                            }
                                                           
                                                        }
                                                      
                                                        
                                                        
                                                                System.out.println("Test method Ended");
                               
                                                       
                                                }
                                                               
                      
                    //    driver.findElement(By.xpath("//XCUIElementTypeOther[@name=\\\"Login | Salesforce\\\"]/XCUIElementTypeSecureTextField")).click();
 
                      //  driver.findElement(By.xpath("//XCUIElementTypeOther[@name=\\\"Login | Salesforce\\\"]/XCUIElementTypeSecureTextField")).sendKeys("1CustomerApp");
                       // driver.findElement(By.xpath("//*[@name='Log In']")).click();
                /*@Nullable
                private String getWebContext(AppiumDriver driver) {
                               
                        ArrayList<String> contexts=new ArrayList(driver.getContextHandles());
                        for(String context:contexts) {
                               if(!context.equals("NATIVE_APP")) {
                                               return context;
                               }
                        }
                        return null;
                       
                               }
                       
}
*/
}

 
    