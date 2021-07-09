package RunnerFiles;


import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class) 
@CucumberOptions(features= {"src/test/java/Features/Feature1.feature"} , glue = {"StepDefinition"}, tags= {"@Test2"})


public class RunnerFile {

}
