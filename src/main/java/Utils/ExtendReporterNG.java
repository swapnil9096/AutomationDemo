package Utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendReporterNG {

	public static ExtentReports getReportObject()
	{
		String path = System.getProperty("user.dir") + "/src/test/resources/Reports/index.html";
		
		ExtentSparkReporter sparker = new ExtentSparkReporter(path);
		
		sparker.config().setReportName("Web Automation Result");
		sparker.config().setDocumentTitle("Test Result");
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(sparker);
		extent.setSystemInfo("Tester", "Swapnil Bobade");
		extent.setSystemInfo("Sprint", "Sprint no : 1 ");
		extent.setSystemInfo("Build", "Build No : 1 ");
		return extent; 
		
	}
}
