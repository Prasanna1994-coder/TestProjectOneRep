package StepDefinition;
import org.openqa.selenium.chrome.ChromeDriver;
import PageObjects.FileUploadPageObject;
import PageObjects.PageObjectManager;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;

public class FileUploadStepDefinition {
	
	PageObjectManager pageObjectManager = new PageObjectManager(new ChromeDriver());
	FileUploadPageObject fileUploadPageObject = pageObjectManager.getFileUploadPageObject();
	
	 @When("^I launch demo automation application$")
	    public void i_launch_demo_automation_application() throws Throwable {
	        fileUploadPageObject.LaunchApplication();
	    }

	    @And("^I upload a demo file from local$")
	    public void i_upload_a_demo_file_from_local() throws Throwable {
	        fileUploadPageObject.UploadAFile("E:\\ImportantBackup\\Learning\\Text_Q.py");
	    }
}
