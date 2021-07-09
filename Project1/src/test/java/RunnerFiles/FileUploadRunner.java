package RunnerFiles;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class) 
@CucumberOptions(features= {"src/test/java/Features/FileUpload.feature"} , glue = {"StepDefinition"} , plugin = {"pretty","html:target/cucmber-reports"} , monochrome = true)
public class FileUploadRunner {

}
