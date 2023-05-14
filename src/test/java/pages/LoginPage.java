package pages;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;

import commonActions.CommonActions;
import net.thucydides.core.annotations.Step;
 
public class LoginPage extends CommonActions {
	
	public static By input_Username = By.cssSelector("input[data-qa='login-email']");
	public static By input_Password = By.cssSelector("input[placeholder='Password']");
	public static By link_Signin = By.cssSelector("a[href='/login']");
	public static By btn_Login = By.cssSelector("button[data-qa='login-button']");
	public static By txt_Login = By.cssSelector("div[class='login-form'] h2");
	public static By txt_InvalidLogin = By.xpath("//p[contains(text(),'Your email or password is incorrect!')]");
 
    @Step("Enter Username")
    public void inputUserName(String Username) {
    	sendText(input_Username, Username);
    }
 
    @Step("Enter Password")
    public void inputPassword(String passWord) {
    	sendText(input_Password, passWord);
    }
 
    @Step("Click Submit Button")
    public void clickLogin() {
    	click(btn_Login);
    }
    
    @Step("Click Login Link")
    public void navigateToLoginPage() {
    	click(link_Signin);
    	verifyText(txt_Login, "Login to your account");
    }
 
    @Step("Error Message on unsuccessful login")
    public void verifyerrorMessage(String errorMsg) {
       waitForVisibilityOfElement(txt_InvalidLogin);
       assertTrue("Invalid login error message is displayed",getDriver().findElement(txt_InvalidLogin).isDisplayed());
    }
 
}