package StepDefinition;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import PageObjects.JobPageObject;
import PageObjects.OrangeHRMPageObject;
import PageObjects.PageObjectManager;
import PageObjects.UsersPageObject;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class OrangeHRMStepDefinition {
	
	PageObjectManager pageObjectManager = new PageObjectManager(new ChromeDriver());
	OrangeHRMPageObject orangeHRMPageObject = pageObjectManager.getOrangeHRMPage();
	UsersPageObject usersPageObject = pageObjectManager.getUserPageObject();
	JobPageObject jobPageObject = pageObjectManager.getJobPageObject();
	
	
	@When("^I launch the OrangeHRM application$")
    public void i_launch_the_OrangeHRM_application() throws Throwable {
        orangeHRMPageObject.LaunchApplication();
    }

	@When("^I enter the \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_enter_the_and(String userName, String passWord) throws Throwable {
		orangeHRMPageObject.EnterLoginName(userName).EnterPassword(passWord);
	}

	@When("^I click on Submit button$")
	public void i_click_on_button() throws Throwable {
		orangeHRMPageObject.ClickOnSubmitButton();
	}
	
	@When("^I mouse hover to \\\"([^\\\"]*)\\\" option$")
	public void mouse_hover_to_users_options(String option) throws Exception {
		switch(option.toLowerCase()) {
		case "users":
			orangeHRMPageObject.MoveToAdmin().MoveToUserManagement().MoveToUsers();
			break;
		case "job":
			orangeHRMPageObject.MoveToAdmin();
			jobPageObject.MoveToJob().MoveToJobTitle();
			break;
			default:
				throw new Exception("Method is not implemented");
		}
	}
	
	@When("^I click on \\\"([^\\\"]*)\\\" menu$")
	public void click_on_option_menu(String option) {
		if(option.equalsIgnoreCase("user"))
			orangeHRMPageObject.ClickOnUsers();
		else
			jobPageObject.ClickOnJobTitle();
	}
	
	@When("^I enter below employee details$")
	public void enter_the_employee_detail(DataTable tableData) {
		List<Map<String, String>> listData = tableData.asMaps(String.class, String.class);
		for(Map<String,String> cell : listData) {
			usersPageObject.EnterUserName(cell.get("Username"))
			.SelectUserRoleFromDropDown(cell.get("User Role"))
			.EnterEmployee(cell.get("Employee Name"))
			.SelectEmployeeStatus(cell.get("Status"));
		}
	}
	
	@When("^I Click on search button$")
	public void click_on_search_button() {
		usersPageObject.ClickOnSearchButton();
	}
	
	@When("^I add the below job title$")
	public void i_add_the_below_job_titles(DataTable tableData) throws InterruptedException {
		List<Map<String, String>> listData = tableData.asMaps(String.class, String.class);
		for(Map<String, String> cellValues : listData) {
			jobPageObject.ClickOnAddButton().EnterJobTitle(cellValues.get("Title"))
			.EnterJobDescription(cellValues.get("Description")).EnterNotes(cellValues.get("Notes")).ClickOnSaveButton();
		}
	}

	@Then("^I Verify below value is displayed$")
	public void i_check_the_values(DataTable tableData) {
		List<Map<String, String>> listData = tableData.asMaps(String.class, String.class);
		for(Map<String,String> cell : listData) {
			Assert.assertTrue (usersPageObject.VerifyTheUserEntry(new String[] {cell.get("Username"),cell.get("User Role"),cell.get("Employee Name"),cell.get("Status")}));
		}		
	}

	@Then("^I verify the \"([^\"]*)\" page is displayed$")
	public void i_verify_the_page_is_displayed(String pageTitle) throws Throwable {
		Assert.assertTrue(orangeHRMPageObject.VerifyPageTitle(pageTitle), "Page title is not matched");
	}
}