package PageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Guru99PageObject {
	WebDriver driver;
	private String driverPath = "E:\\ImportantBackup\\Selenium_jar\\NewChromeDriver\\chromedriver_win32_ver90\\chromedriver.exe";
	private String url = "http://demo.guru99.com/test/delete_customer.php";
	private Alert AlertButton;
	
	public Guru99PageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		System.setProperty("webdriver.chrome.driver", driverPath);
	}	
	
	@FindBy(xpath = "//*[@name=\"cusid\"]")
	private WebElement CustomerIdTextBox;
	
	@FindBy(xpath = "//*[@name=\"submit\"]")
	private WebElement SubmitButton;
	
	public Guru99PageObject LaunchGuru99Application() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(url);
		return this;
	}
	
	//Below line of code will cause error to execute
	//Alert AlertButton = driver.switchTo().alert();
	
	public Guru99PageObject EnterCustomerId(String customerId) {
		CustomerIdTextBox.sendKeys(customerId);
		return this;
	}
	
	public Guru99PageObject ClickOnSubmitButton() {
		SubmitButton.click();
		return this;
	}
	
	public Guru99PageObject AlertAccept() {
		AlertButton = driver.switchTo().alert();
		AlertButton.accept();
		//driver.switchTo().alert().accept();
		return this;
	}
	
	public Guru99PageObject AlertDismiss() {
		driver.switchTo().alert().dismiss();
		return this;
	}
	
	public boolean VerifyTheAlertMessage(String message) {
		//return (AlertButton.getText().equals(message));
		return driver.switchTo().alert().getText().equals(message);
	}
}
