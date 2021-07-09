package PageObjects;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FrameHandlePageObject {
	
	private WebDriver driver;
	private String url = "https://ui.cogmento.com/";
	//private String driverPath = "E:\\ImportantBackup\\Selenium_jar\\NewChromeDriver\\chromedriver_win32_ver90\\chromedriver.exe";
	
	public FrameHandlePageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		//System.setProperty("webdriver.chrome.driver", driverPath);
	}
	
	@FindBy(xpath = "//*[@name=\"email\"]")
	private WebElement UserName;
	
	@FindBy(xpath = "//*[@name=\"password\"]")
	private WebElement PassWord;
	
	@FindBy(xpath = "//*[text()=\"Login\"]")
	private WebElement SubmitButton;
	
	public FrameHandlePageObject LaunchApplication () {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(url);
		return this;
	}
	
	public FrameHandlePageObject EnterUserName(String getUserName) {
		UserName.sendKeys(getUserName);
		return this;
	}
	
	public FrameHandlePageObject EnterPassWord (String getPassWord) {
		PassWord.sendKeys(getPassWord);
		return this;
	}
	
	public FrameHandlePageObject ClickOnSubmitButton() {
		SubmitButton.click();
		return this;
	}
}