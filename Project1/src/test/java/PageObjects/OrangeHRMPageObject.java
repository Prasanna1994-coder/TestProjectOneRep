package PageObjects;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHRMPageObject {
	
	WebDriver driver;
	private String driverPath = "E:\\ImportantBackup\\Selenium_jar\\NewChromeDriver\\chromedriver_win32_ver90\\chromedriver.exe";
	private String url = "https://opensource-demo.orangehrmlive.com/index.php/auth/login";
	private Actions actionToMove;

	public OrangeHRMPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		System.setProperty("webdriver.chrome.driver", driverPath);
	}
		
	
	@FindBy(xpath="//*[@id=\"txtUsername\"]")
	private WebElement LoginName;
	
	@FindBy(xpath="//*[@id=\"txtPassword\"]")
	private WebElement PassWord;
	
	@FindBy(xpath="//*[@name=\"Submit\"]")
	private WebElement Submit;
	
	@FindBy(xpath="//*[@id=\"menu_admin_viewAdminModule\"]")
	private WebElement AdminMenu;
	
	@FindBy(xpath="//*[@id=\"menu_admin_viewAdminModule\"]/following::ul//li/a[@id=\"menu_admin_UserManagement\"]")
	private WebElement UserManagementMenu;
	
	@FindBy(xpath="//*[@id=\"menu_admin_viewAdminModule\"]/following::ul//li/a[@id=\"menu_admin_UserManagement\"]/following::ul/li/a[@id=\"menu_admin_viewSystemUsers\"]")
	private WebElement UsersMenu;
	
	public OrangeHRMPageObject LaunchApplication() {
		//driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(url);
		return this;
	}
		
	public OrangeHRMPageObject EnterLoginName (String loginId) {
		LoginName.sendKeys(loginId);
		return this;
	}

	public OrangeHRMPageObject EnterPassword (String passKey) {
		PassWord.sendKeys(passKey);
		return this;
	}
	
	public OrangeHRMPageObject ClickOnSubmitButton () {
		Submit.click();
		return this;
	}
	
	public boolean VerifyPageTitle(String expectedTitle) {
		return driver.getTitle().equalsIgnoreCase(expectedTitle);
	}
	
	public OrangeHRMPageObject MoveToAdmin() {
		actionToMove = new Actions(driver);
		actionToMove.moveToElement(AdminMenu).perform();
		return this;
	}
	
	public OrangeHRMPageObject MoveToUserManagement() {
		actionToMove = new Actions(driver);
		actionToMove.moveToElement(UserManagementMenu).perform();
		return this;
	}
	
	public OrangeHRMPageObject MoveToUsers() {
		actionToMove = new Actions(driver);
		actionToMove.moveToElement(UsersMenu).perform();
		return this;
	}
	
	public OrangeHRMPageObject ClickOnUsers() {
		UsersMenu.click();
		return this;
	}
}
