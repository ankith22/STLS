package generic;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

@Listeners(CustomListener.class)
abstract public class BaseTest implements IAutoConst
{
 static
 {
  System.setProperty(CHROME_KEY, CHROME_VALUE);
 }

public WebDriver driver;
public ExtentReports report;

@BeforeSuite
public void startReport()
{
 report=new ExtentReports();
 ExtentHtmlReporter htmlReport=new ExtentHtmlReporter(REPORTPATH);
 htmlReport.setAppendExisting(true); 

 report.attachReporter(htmlReport);
 report.setSystemInfo("OS", "Windows 7");
 report.setSystemInfo("User", "Ankith Raj");
 htmlReport.config().setDocumentTitle("QA Automation Result");
 htmlReport.config().setReportName("Execution_Report");
}

@AfterSuite
public void publishReport()
{
 report.flush();
}

@Parameters({"node","browser"})
@BeforeMethod(alwaysRun=true)
public void openApp(String node, String browser) throws Exception
{
 URL whichSystem=new URL(node);
 DesiredCapabilities whichBrowser=new DesiredCapabilities();
 whichBrowser.setBrowserName(browser);
 driver=new RemoteWebDriver(whichSystem, whichBrowser);
 driver.manage().window().maximize();
 String val = Property.getValue(CONFIG, "ITO");
 long ITO=Integer.parseInt(val);
 driver.manage().timeouts().implicitlyWait(ITO, TimeUnit.SECONDS);
 String url = Property.getValue(CONFIG, "URL");
 driver.get(url);
}

@AfterMethod(alwaysRun=true)
public void closeApp(ITestResult result)
{
 driver.quit();
 try
 {
  String testName = result.getName();
  System.out.println(testName);
  ExtentTest test = report.createTest(testName);
  
  if(result.getStatus()==ITestResult.SUCCESS)
  {
   test.pass("This test is passed");   
  }
  else
  {
   test.fail("This test is failed");
  } 
 }
 catch(Exception e)  {	  
 } 
 
}
}
