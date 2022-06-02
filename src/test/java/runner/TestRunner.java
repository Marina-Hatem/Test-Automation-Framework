package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//run the features from this path
//glue is in the steps package
//run the report in a pretty html format in this folder
@CucumberOptions(features = "src/test/java/feautures",
glue= {"steps"}, 
plugin = {"pretty", "html:target/cucumber-html-report"})
public class TestRunner extends AbstractTestNGCucumberTests
{
	
	
	
}
