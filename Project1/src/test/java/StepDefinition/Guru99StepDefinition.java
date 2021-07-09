package StepDefinition;

import org.testng.Assert;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObjects.Guru99PageObject;
import PageObjects.PageObjectManager;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Guru99StepDefinition {
	
	PageObjectManager pageObjectManager = new PageObjectManager(new ChromeDriver());
	Guru99PageObject guru99PageObject = pageObjectManager.getGuru99PageObject();
	
	 @When("^I launch guru99 application$")
	    public void i_launch_guru99_application() throws Throwable {
	        guru99PageObject.LaunchGuru99Application();
	    }

	    @And("^I enter the \"([^\"]*)\" customerid$")
	    public void i_enter_the_something_customerid(String strArg1) throws Throwable {
	        guru99PageObject.EnterCustomerId(strArg1);
	    }

	    @And("^I click on submit button$")
	    public void i_click_on_submit_button() throws Throwable {
	        guru99PageObject.ClickOnSubmitButton();
	    }

	    @Then("^I verify \"([^\"]*)\" message is displayed and click on \\\"([^\\\"]*)\\\" in the alert window$")
	    public void i_verify_something_message_is_displayed_and_click_on_ok_in_the_alert_window(String strArg1, String optionName) throws Throwable {
	    	Assert.assertTrue(guru99PageObject.VerifyTheAlertMessage(strArg1));
	    	Thread.sleep(3000);
	    	if(optionName.equalsIgnoreCase("ok"))
	    		guru99PageObject.AlertAccept();
	    	else
	    		guru99PageObject.AlertDismiss();
	    }


}
