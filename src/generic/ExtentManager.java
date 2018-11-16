package generic;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentManager implements IAutoConst
{
 public static ExtentReports report;
 
 public static ExtentReports getInstance()
 {
  if(report==null)
  {
   return createInstance(REPORTPATH);
  }
  else
  {
   return report;
  }
 }

public static ExtentReports createInstance(String filename)
{ 
 ExtentHtmlReporter htmlReport=new ExtentHtmlReporter(filename);
 htmlReport.config().setDocumentTitle("QA Automation Result");
 htmlReport.config().setReportName("Execution_Report");
 
 report=new ExtentReports();
 htmlReport.setAppendExisting(true); 
 report.attachReporter(htmlReport);
 report.setSystemInfo("OS", "Windows 7");
 report.setSystemInfo("User", "Ankith Raj");
 
 return report;	
}
}
