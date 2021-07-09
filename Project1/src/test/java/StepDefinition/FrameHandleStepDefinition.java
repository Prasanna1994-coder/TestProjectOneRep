package StepDefinition;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObjects.FrameHandlePageObject;
import PageObjects.PageObjectManager;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;

public class FrameHandleStepDefinition {
	
	PageObjectManager pageObjectManager = new PageObjectManager(new ChromeDriver());
	FrameHandlePageObject frameHandlePageObject = pageObjectManager.getFrameHandlePageObject();
	
	@When("^I launch frame handle application$")
    public void i_launch_frame_handle_application() throws Throwable {
        frameHandlePageObject.LaunchApplication();
    }

    @And("^I enter \"([^\"]*)\" and \"([^\"]*)\" in the login page$")
    public void i_enter_something_and_something_in_the_login_page(String userid, String password) throws Throwable {
        frameHandlePageObject.EnterUserName(userid).EnterPassWord(password);
    }

    @And("^I click on submit button in frame handler site$")
    public void i_click_on_submit_button_in_frame_handler_site() throws Throwable {
        frameHandlePageObject.ClickOnSubmitButton();
    }
}
