package PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class UsersPageObject {
	WebDriver driver;
	Select selectDropDownValue;
	
	@FindBy(xpath="//*[@id=\"searchSystemUser_userName\"]")
	private WebElement UserName;
	
	@FindBy(xpath="//*[@id=\"searchSystemUser_userType\"]")
	private WebElement UserRoleDropDown;
	
	@FindBy(xpath="//*[@id=\"searchSystemUser_employeeName_empName\"]")
	private WebElement EmployeeName;
	
	@FindBy(xpath="//*[@id=\"searchSystemUser_status\"]")
	private WebElement EmployeeStatus;
	
	@FindBy(xpath="//*[@id=\"searchBtn\"]")
	private WebElement SearchButton;
	
	@FindBy(xpath="//*[@id=\"resultTable\"]/thead/following::tbody/tr/td")
	private WebElement ErrorMessage;
	
	@FindBy(xpath="//td[@class=\"left\"]")
	private List<WebElement> rowElements;
	
	public UsersPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public UsersPageObject EnterUserName(String username) {
		UserName.sendKeys(username);
		return this;
	}
	
	public UsersPageObject SelectUserRoleFromDropDown(String dropDownValue) {
		selectDropDownValue = new Select(UserRoleDropDown);
		selectDropDownValue.selectByVisibleText(dropDownValue);
		return this;
	}
	
	public UsersPageObject EnterEmployee(String employeeName) {
		if(EmployeeName.isEnabled())
			EmployeeName.sendKeys(employeeName);
		return this;
	}
	
	public UsersPageObject SelectEmployeeStatus(String status) {
		selectDropDownValue = new Select(EmployeeStatus);
		selectDropDownValue.selectByVisibleText(status);
		return this;
	}
	
	public UsersPageObject ClickOnSearchButton() {
		if(SearchButton.isEnabled() && SearchButton.isDisplayed())
			SearchButton.click();
		return this;
	}
	
	public boolean VerifyErrorMessage(String expectedErrorMessage) {
		return ErrorMessage.getText().equals(expectedErrorMessage);
	}
	
	public boolean VerifyTheUserEntry (String[] values) {
		for(WebElement element : rowElements) {
			for(String value : values) {
				if(element.getText().equals(value))
					return true;
			}	
		}
		return false;
	}
}