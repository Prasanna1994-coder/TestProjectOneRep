package PageObjects;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class RegisterPagePageObject {

	WebDriver driver;
	private String driverPath = "E:\\ImportantBackup\\Selenium_jar\\NewChromeDriver\\chromedriver_win32_ver90\\chromedriver.exe";
	private String url = "http://demo.automationtesting.in/Register.html";
	private Select dropDownCommon;
	private Actions action;

	public RegisterPagePageObject() {
		System.setProperty("webdriver.chrome.driver", driverPath);
	}
	
	By FirstNameTextBox = By.xpath("//input[@placeholder=\"First Name\"]");
	By LastNameTextBox = By.xpath("//input[@placeholder=\"Last Name\"]");
	By AddressTextBox  = By.xpath("//*[text()=\"Address\"]/following::div/textarea");
	By EmailAddressTextBox = By.xpath("//*[text()=\"Email address*\"]/following::div//input[@type=\"email\"]");
	By PhoneNumberTextBox = By.xpath("//*[text()=\"Phone*\"]/following::div/input[@type=\"tel\"]");
	By MaleRadioButton = By.xpath("//*[text()=\"Gender*\"]/following::div//input[@type=\"radio\" and @value=\"Male\"]");
	By FemaleRadioButton = By.xpath("//*[text()=\"Gender*\"]/following::div//input[@type=\"radio\" and @value=\"FeMale\"]");
	By CricketCheckBox = By.xpath("//*[text()=\" Cricket \"]/preceding::input[@id=\"checkbox1\"]");
	By MoviesCheckBox = By.xpath("//*[text()=\"Movies \"]/preceding::input[@id=\"checkbox2\"]");
	By HockeyCheckBox = By.xpath("//*[text()=\"Hockey\"]/preceding::input[@id=\"checkbox3\"]");
	By LanguageTextOrMultiLangSelectBox = By.xpath("//*[@id=\"msdd\"]");	
	By LanguagesListValues = By.xpath("//*[@id=\"msdd\"]/following::div//ul//li//a");
	By SkillsText = By.xpath("//*[text()=\"Skills\"]");
	By SkillsDropDown = By.xpath("//*[@id=\"Skills\"]");
	By CountryDropDown = By.xpath("//*[@id=\"countries\"]");
	By SelectCountryDropDown = By.xpath("//*[@id=\"country\"]");
	By YearDropDown = By.xpath("//*[@id=\"yearbox\"]");
	By MonthDropDown = By.xpath("//*[text()=\"Date Of Birth\"]/following-sibling::div[2]/select");
	By DayDropDown = By.xpath("//*[@id=\"daybox\"]");
	By PasswordTextBox = By.xpath("//*[@id=\"firstpassword\"]");
	By ConfirmPasswordTextBox = By.xpath("//*[@id=\"secondpassword\"]");
	By SubmitButton = By.xpath("//*[@id=\"submitbtn\"]");
	By RefreshButton = By.xpath("//*[@value=\"Refresh\"]");
	By SwitchToButton = By.xpath("//*[@id=\"header\"]/nav/div/div[2]/ul/li[4]/a");
	By AlertButton = By.xpath("//*[@href =\"Alerts.html\"]");
	
	public RegisterPagePageObject LaunchApplication() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(url);
		return this;
	}
	
	public RegisterPagePageObject EnterFirstName(String firstName) {
		if(firstName != null)
			driver.findElement(FirstNameTextBox).sendKeys(firstName);
		return this;
	}

	public RegisterPagePageObject EnterLastName(String lastName) {
		if(lastName != null)
			driver.findElement(LastNameTextBox).sendKeys(lastName);
		return this;
	}
	
	public RegisterPagePageObject EnterAddress(String address) {
		if(address != null)
			driver.findElement(AddressTextBox).sendKeys(address);
		return this;
	}
	
	public RegisterPagePageObject EnterEmailAddress(String emailAddress) {
		if(emailAddress != null) {
			driver.findElement(EmailAddressTextBox).clear();
			driver.findElement(EmailAddressTextBox).sendKeys(emailAddress);
		}
		return this;
	}
	
	public RegisterPagePageObject EnterPhoneNumber(String number) {
		if(number != null)
			driver.findElement(PhoneNumberTextBox).sendKeys(number);
		return this;
	}
	
	public RegisterPagePageObject SelectGender(String gender) throws Exception {
		switch(gender.toLowerCase()){
		case "male":
			driver.findElement(MaleRadioButton).click();
			break;
		case "female":
			driver.findElement(FemaleRadioButton).click();
			break;
		default:
			throw new Exception("not a valid gender");
		}
		return this;
	}
	
	public RegisterPagePageObject SelectHobbies(String[] hobbies) throws Exception {
		for(String singleValue : hobbies) {
			switch(singleValue.toLowerCase()) {
			case "cricket":
				driver.findElement(CricketCheckBox).click();
				break;
			case "movies":
				driver.findElement(MoviesCheckBox).click();
				break;
			case "hockey":
				driver.findElement(HockeyCheckBox).click();
				break;
			default:
				throw new Exception("Method not implemented");
			}
		}
		return this;
	}
	
	public RegisterPagePageObject SelectLanguages(String[] languages) {
		driver.findElement(LanguageTextOrMultiLangSelectBox).click();
		List<WebElement> languageElement = driver.findElements(LanguagesListValues);
		for(WebElement element : languageElement) {
			for(String language : languages) {
				if(element.getText().equals(language)) {
					element.click();
				}
			}
		}
		return this;
	}
	
	private RegisterPagePageObject SelectDropDown(By dropDown, String value) {
		dropDownCommon = new Select(driver.findElement(dropDown));
		dropDownCommon.selectByVisibleText(value);
		return this;
	}
	
	public RegisterPagePageObject SelectASkill(String skill) {
		driver.findElement(SkillsText).click();
		SelectDropDown(SkillsDropDown,skill);
		return this;
	}
	
	public RegisterPagePageObject SelectCountry(String country) {
		SelectDropDown(CountryDropDown,country);
		return this;
	}
	
	public RegisterPagePageObject SelectConfirmCountry(String country) {
		SelectDropDown(SelectCountryDropDown,country);
		return this;
	}
	
	public RegisterPagePageObject DateOfBirth(String date,String month,String year) {
		SelectDropDown(DayDropDown,date).SelectDropDown(MonthDropDown,month).SelectDropDown(YearDropDown, year);
		return this;
	}
	
	public RegisterPagePageObject EnterPassword(String password) {
		if(password != null)
			driver.findElement(PasswordTextBox).sendKeys(password);
		return this;
	}
	
	public RegisterPagePageObject EnterConfirmPassword(String confirmPassword) {
		if((confirmPassword != null))
			driver.findElement(ConfirmPasswordTextBox).sendKeys(confirmPassword);
		return this;
	}
	
	public RegisterPagePageObject ClickOnSubmitButton() {
		WebElement Submit = driver.findElement(SubmitButton);
		if(Submit.isEnabled())
			Submit.click();
		return this;
	}
	
	public boolean VerifyCurrentPageTitle(String title) {
		return driver.getTitle().equals(title);
	}
	
	public RegisterPagePageObject ClickOnSwitchToButton() {
		action = new Actions(driver);
		action.moveToElement(driver.findElement(SwitchToButton)).perform();
		return this;
	}
	
	public RegisterPagePageObject ClickOnAlertButton() {
		driver.findElement(AlertButton).click();
		return this;
	}
}