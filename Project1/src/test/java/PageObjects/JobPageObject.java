package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JobPageObject {
	
	WebDriver driver;
	Actions action;
	
	public JobPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[@id=\"menu_admin_Job\"]")
	private WebElement Job;
	
	@FindBy(xpath = "//*[@id=\"menu_admin_viewJobTitleList\"]")
	private WebElement JobTitles;
	
	@FindBy(xpath = "//*[@id=\"btnAdd\"]")
	private WebElement AddButton;
	
	@FindBy(xpath = "//*[@id=\"jobTitle_jobTitle\"]")
	private WebElement JobTitleTextBox;
	
	@FindBy(xpath = "//*[@id=\"jobTitle_jobDescription\"]")
	private WebElement JobDescriptionTextBox;
	
	@FindBy(xpath = "//*[@id=\"jobTitle_note\"]")
	private WebElement NotesTextBox;
	
	@FindBy(xpath = "//*[@id=\"btnSave\"]")
	private WebElement SaveButton;
	
	private Actions MoveAction() {
		return action = new Actions(driver);
	}
	
	public JobPageObject MoveToJob() {
		MoveAction().moveToElement(Job).perform();
		return this;
	}
	
	public JobPageObject MoveToJobTitle() {
		MoveAction().moveToElement(JobTitles).perform();
		return this;
	}
	
	public JobPageObject ClickOnJobTitle() {
		JobTitles.click();
		return this;
	}

	public JobPageObject ClickOnAddButton() {
		AddButton.click();
		return this;
	}
	
	public JobPageObject EnterJobTitle(String jobTitle) {
		if(JobTitleTextBox.isEnabled())
			JobTitleTextBox.sendKeys(jobTitle);
		return this;
	}
	
	public JobPageObject EnterJobDescription(String jobDescription) throws InterruptedException {
		if(JobDescriptionTextBox.isEnabled()) {
			JobDescriptionTextBox.wait(10);
			JobDescriptionTextBox.sendKeys(jobDescription);
		}
		return this;
	}
	
	public JobPageObject EnterNotes(String notes) {
		if(NotesTextBox.isEnabled())
			NotesTextBox.sendKeys(notes);
		return this;
	}
	
	public JobPageObject ClickOnSaveButton() {
		if(SaveButton.isEnabled())
			SaveButton.click();
		return this;
	}
}
