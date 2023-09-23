package utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {
	private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();
	private DriverManager() {
		
	}
	public static synchronized WebDriver getDriver() {
		return DRIVER.get();
	}
	
	public static synchronized void quitDiver() {
		if(DRIVER.get()!=null) {
			getDriver().close();
			DRIVER.remove();
		}
	}
	public static synchronized void setDriver(String browserName) {
		switch (browserName) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
//			options.addArguments("--headless=new");
			options.addArguments("--start-maximized");
			DRIVER.set(new ChromeDriver(options));
			break;

		default:
			break;
		}
	}
	public static synchronized void setBrowsertimeouts() {
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
		getDriver().manage().timeouts().scriptTimeout(Duration.ofSeconds(50));
	}
	public static synchronized void maximizeBroswer() {
		getDriver().manage().window().maximize();
	}
	
	
}
