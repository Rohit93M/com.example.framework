package genericutility;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {

	public static WebDriver driver;
	public static WebDriverUtility webdriverUtils = new WebDriverUtility();
	public static FileUtility fileUtils = new FileUtility();
	public static ExcelUtility excelUtils = new ExcelUtility();

	@BeforeMethod
	public void setUp() throws IOException {

		String browserName = fileUtils.getPropertyKeyValue("browser");
		if (browserName.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (browserName.equals("msedge")) {
			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();
		webdriverUtils.implicitWait(driver);
		driver.get(fileUtils.getPropertyKeyValue("url"));
	}

	@AfterMethod
	public void tearDown() {	
		// driver.manage().window().minimize();
		if (driver != null) {
		driver.quit();
		}
	}

	public void captureScreenshot(String testName, String resultType) throws IOException {
		
		// String timeStamp =LocalDateTime.now().toString().replace(':', '-');
		TakesScreenshot ts = (TakesScreenshot) driver;
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		File destFile = new File("./screenshots/"+testName+"_"+resultType+".png");
		FileUtils.copyFile(srcFile, destFile);	
	}
	
    public void captureElementScreenshot(WebElement element, String testName, String resultType) throws IOException {
    	
        File srcFile = element.getScreenshotAs(OutputType.FILE);
        File destFile = new File("./screenshots/"+ testName+"_"+ resultType+"_element.png");
        FileUtils.copyFile(srcFile, destFile);
    }
}
