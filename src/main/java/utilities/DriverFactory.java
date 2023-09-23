package utilities;
import org.openqa.selenium.WebDriver;

public class DriverFactory {
	//Thread local helps us to achieve the parallelism 
	private static ThreadLocal<WebDriver> tlWebDriver = new ThreadLocal<WebDriver>();
	
	public static synchronized WebDriver getWebDriver() {
		return tlWebDriver.get();
	}
	
	public static synchronized void setUpDriver(WebDriver driver) {
		tlWebDriver.set(driver);
	}
	public static synchronized void closeDriver() {
		if(tlWebDriver.get()!=null)
			tlWebDriver.get().close();
	}

}
