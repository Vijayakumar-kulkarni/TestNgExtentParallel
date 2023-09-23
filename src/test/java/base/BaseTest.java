package base;

import java.lang.reflect.Method;
import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import utilities.ConfigFileReader;
import utilities.DriverManager;
import utilities.UtilityClass;

public class BaseTest{
	public WebDriver driver;
	public String browserName;
	public String baseUrl;
	public ConfigFileReader configFileReader;
	
	public BaseTest() {
		configFileReader = new ConfigFileReader();
		browserName = configFileReader.getBrowserName();
	}
	@BeforeSuite
	public void setTestNamesTobeRetried(ITestContext ctx) {
		
	}
	@BeforeMethod
	public void init(ITestResult res) {
		DriverManager.setDriver(browserName);
		DriverManager.setBrowsertimeouts();
//		DriverManager.maximizeBroswer();
	}
	@BeforeMethod(enabled = true)
	public void setTestName(Method m, ITestContext context, Object[] testData) {
		if(testData.length>0){
			UtilityClass.testName.set(m.getName()+"_"+testData[0]);
		}else{
			UtilityClass.testName.set(m.getName());
		}
	}
	@AfterMethod
	public void tearDown(ITestResult res) {
			try {
				Thread.sleep(100);
//				DriverManager.getDriver().close();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}
	public void launchApplication(String baseUrl) {
		driver.get(baseUrl);
	}
	
	@AfterSuite
	public void afterSuiteMethod(ITestContext context) {

	}
}
