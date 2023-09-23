package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import base.BaseTest;
import utilities.DriverManager;
import utilities.UtilityClass;

public class ITestListenerImpl extends BaseTest implements ITestListener {
	private ExtentReports extent;
//    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	private ThreadLocal<ExtentTest> extentTest;	
	@Override
	public void onFinish(ITestContext context) {
//	     extent.flush();
	}
	@Override
	public void onStart(ITestContext context) {
//		extent = UtilityClass.getExtentReport(context.getSuite().getName().toString());
		extent = (ExtentReports)context.getSuite().getAttribute("extent");
		extentTest = (ThreadLocal<ExtentTest>)context.getSuite().getAttribute("extentTest");
	}
	@Override
	public void onTestStart(ITestResult result) {
		if(!result.wasRetried())
//			extentTest.set(extent.createTest(result.getMethod().getMethodName()));
			extentTest.set(extent.createTest(UtilityClass.testName.get()));
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		extentTest.get().log(Status.PASS, UtilityClass.testName.get()+" SUCCESS");
		  try 
		  { 
			  String screenShotPath = System.getProperty("user.dir") + "\\screenShots\\" + 
						result.getMethod().getMethodName() + ".png";
			  UtilityClass.createScreenshot(screenShotPath, DriverManager.getDriver());
			  extentTest.get().addScreenCaptureFromPath(screenShotPath);
		  		
		  } catch (Exception e) { 
		  		e.printStackTrace(); 
		  }
	}
	@Override
	public void onTestFailure(ITestResult result) {
		extentTest.get().log(Status.FAIL, UtilityClass.testName.get()+" FAIL");
		try {
			String screenShotPath = System.getProperty("user.dir") + "\\screenShots\\" + 
									result.getMethod().getMethodName() + ".png";
			UtilityClass.createScreenshot(screenShotPath, DriverManager.getDriver());
			extentTest.get().addScreenCaptureFromPath(screenShotPath);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void onTestSkipped(ITestResult result) {
		extentTest.get().log(Status.SKIP, UtilityClass.testName.get()+ " is SKIPPED" +
				result.getStatus());
		
		if(result.wasRetried())
		{
			System.out.println("WAS RETRIED METHOD : "+ result.getMethod().getMethodName());
//			extent.removeTest(result.getMethod().getMethodName());
			extent.removeTest(UtilityClass.testName.get());
		}
	}
	
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}
}
