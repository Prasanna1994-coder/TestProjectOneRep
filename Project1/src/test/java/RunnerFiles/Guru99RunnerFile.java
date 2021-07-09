package RunnerFiles;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class) 
@CucumberOptions(features= {"src/test/java/Features/Guru99Feature.feature"} , glue = {"StepDefinition"} , tags= {"@AcceptAlert"})
public class Guru99RunnerFile {

}
