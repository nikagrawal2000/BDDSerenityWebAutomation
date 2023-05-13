package runner;

import org.junit.runner.RunWith; 
import io.cucumber.junit.CucumberOptions; 
import net.serenitybdd.cucumber.CucumberWithSerenity; 
 
@RunWith(CucumberWithSerenity.class) 
@CucumberOptions(plugin = { "pretty" }, monochrome = true, dryRun = true,
features = "src/test/resources/features/LoginPage.feature", 
 glue="stepDefinitions") 
 
public class SerenityRunnerTest {   
} 