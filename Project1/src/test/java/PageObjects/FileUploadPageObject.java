package PageObjects;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FileUploadPageObject {
	
	WebDriver driver;
	private String driverPath = "E:\\ImportantBackup\\Selenium_jar\\NewChromeDriver\\chromedriver_win32_ver90\\chromedriver.exe";
	private String url = "http://demo.automationtesting.in/FileUpload.html";
	
	public FileUploadPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		System.setProperty("webdriver.chrome.driver", driverPath);
	}
	
	@FindBy(xpath = "//*[@id=\"input-4\"]")
	private WebElement BrowseButton;
	
	public FileUploadPageObject LaunchApplication() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(url);
		return this;
	}
	
	public FileUploadPageObject UploadAFile(String file) {
		BrowseButton.sendKeys(file);
		return this;
	}
}
