package stepDefinitions;
 
import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import pages.DashboardPage;
import pages.LoginPage;
 
public class LoginPageDefinitions {
     
 
    @Steps
    LoginPage loginPage;
 
    @Steps
    DashboardPage dashPage;
 
    @Given("User is on Home page")
    public void openApplication() {
        loginPage.open();
        System.out.println("Page is opened");
    }
 
    @When("User enters username as {string}")
    public void enterUsername(String userName) {
        System.out.println("Enter Username");
        loginPage.inputUserName(userName);
    }
 
    @When("User enters password as {string}")
    public void enterPassword(String passWord) {
        loginPage.inputPassword(passWord);
 
        loginPage.clickLogin();
    }
 
    @Then("User should be able to login successfully")
    public void clickOnLoginButton() {
        dashPage.loginVerify();
    }
 
    @Then("User should be able to see error message {string}")
    public void unsucessfulLogin(String expectedErrorMessage) throws InterruptedException {
         
        String actualErrorMessage = loginPage.errorMessage();
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
    }
 
}