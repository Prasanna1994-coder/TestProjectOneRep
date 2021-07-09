package StepDefinition;
import org.testng.AssertJUnit;
import java.util.List;
import java.util.Map;
import PageObjects.RegisterPagePageObject;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PageOneStepDef {
	RegisterPagePageObject registerPagePageObject;
	@Given("^launch the browser$")
	public void launch_the_browser(){
		registerPagePageObject = new RegisterPagePageObject();
	}
	
	@When("^I launch the application$")
	public void LaunchApplication() {
		registerPagePageObject.LaunchApplication();
	}

	@When("^I Enter the below values in register page$")
	public void i_Enter_the_below_values_in_register_page(DataTable table) throws Throwable {
	  List<Map<String, String>> rows = table.asMaps(String.class, String.class);
	  for(Map<String,String> columns : rows) {
		  String[] multipleHobbies = columns.get("Hobbies").split(",");
		  String[] multipleLanguages = columns.get("Languages").split(",");
		  registerPagePageObject.EnterFirstName(columns.get("Fullname"))
		  .EnterLastName(columns.get("Lastname"))
		  .EnterAddress(columns.get("Address"))
		  .EnterEmailAddress(columns.get("Email-Address"))
		  .EnterPhoneNumber(columns.get("Phone"))
		  .SelectGender(columns.get("Gender"))
		  .SelectHobbies(multipleHobbies)
		  .SelectLanguages(multipleLanguages)
		  .SelectASkill(columns.get("Skills")).SelectCountry(columns.get("Country")).SelectConfirmCountry(columns.get("Confirm Country"))
		  .DateOfBirth(columns.get("Day"), columns.get("Month"), columns.get("Year")).EnterPassword(columns.get("Password")).EnterConfirmPassword(columns.get("Confirm-Password"));
	  }
	}
	
	@When("^I click on Switch To button$")
	public void i_click_on_button(){
		new RegisterPagePageObject().ClickOnSwitchToButton();
	}

	@When("^I click on Alerts under Switch To$")
	public void i_click_on_under(){
		new RegisterPagePageObject().ClickOnAlertButton();
	}
}