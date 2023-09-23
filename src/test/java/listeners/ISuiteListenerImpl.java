package listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import utilities.UtilityClass;

public class ISuiteListenerImpl implements ISuiteListener {
	private ExtentReports extent;
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
    
	public void onStart(ISuite suite) {
		extent = UtilityClass.getExtentReport(suite.getName().toString());
		suite.setAttribute("extent", extent);
		suite.setAttribute("extentTest", extentTest);
	}

	public void onFinish(ISuite suite) {
		extent.flush();	
	}
}
