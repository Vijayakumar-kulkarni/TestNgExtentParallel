package utilities;

import java.util.HashMap;
import java.util.Map;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentUtility {
	public static final ExtentReports extentReports = new ExtentReports();
	public static Map<Integer, ExtentTest> extentTestMap = new HashMap<>();
	
	public synchronized static ExtentReports getExtentReport(String path) {
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Automated Extent Report");
		reporter.config().setDocumentTitle("Extent Reports of Automation Test");
		extentReports.attachReporter(reporter);
		extentReports.setSystemInfo("Vijay", "Test Extent Report");
		return extentReports;
	}
}
