package Utility;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {
	
	protected static WebDriver driver;
	protected static List<String> sheetData = new ArrayList<String>();
	protected static String currentDirectory = System.getProperty("user.dir");
	
	public void OpenBrowswe()

	{
		WebDriverManager.chromedriver().setup();
		//WebDriverManager.edgedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		options.addArguments("--disable-infobars--");
		driver = new ChromeDriver(options);
		Logfile.info("Chrome open");
	}

	public void closeBrowser() {
		driver.quit();
		Logfile.info("Chrome Closed");
		Logfile.info("Report Updated...");
		
		
	}
}
