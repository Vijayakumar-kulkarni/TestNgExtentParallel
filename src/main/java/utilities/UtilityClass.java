package utilities;

import java.io.File;
import java.lang.reflect.Method;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class UtilityClass {
	public static ExtentReports extent;
	public static ThreadLocal<String> testName = new ThreadLocal<>();
	
	public static synchronized String getTestName(Object[] testData, Method m) {
		if(testData.length>0)
			testName.set(m.getName()+"_"+testData[0]);
		else 
			testName.set(m.getName());
		
		return testName.get();
	}
	
	public static synchronized ExtentReports getExtentReport(String reportName) {
		String path = System.getProperty("user.dir")+"\\reports\\"+reportName+".html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setDocumentTitle("TesNG Extent Report - DOCUMENT TITLE");
		reporter.config().setReportName("Automation Report-Version 1");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		return extent;
	}
	
	public static synchronized void createScreenshot(String screenshotPath, WebDriver driver) 
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		try {
			File src = ts.getScreenshotAs(OutputType.FILE);
			File target = new File(screenshotPath);
			FileUtils.copyFile(src, target);
		} catch (Exception e) {
		}
	}
	
	public static synchronized String getBase64ScreenShot(String screenshotName, WebDriver driver) {
		TakesScreenshot ts = (TakesScreenshot)driver;
		String targetPath = System.getProperty("user.dir") + "\\base64screenShots\\" + screenshotName + ".png";
		try {
			String base64Img = ts.getScreenshotAs(OutputType.BASE64);
			File src = OutputType.FILE.convertFromBase64Png(base64Img);
			File target = new File(targetPath);
			FileUtils.copyFile(src, target);
		} catch (Exception e) {
		}
		return targetPath;
	}
}
