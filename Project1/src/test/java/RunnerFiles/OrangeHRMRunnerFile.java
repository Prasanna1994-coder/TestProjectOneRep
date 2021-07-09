package RunnerFiles;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class) 
@CucumberOptions(features= {"src/test/java/Features/OrangeHRM.feature"} , glue = {"StepDefinition"}, tags = {"@OrangeTest2"})
public class OrangeHRMRunnerFile {

}
