package pages;

import org.openqa.selenium.By;

import commonActions.CommonActions;
import net.thucydides.core.annotations.Step;
 
public class LoginPage extends CommonActions {
	
	public static By input_Username = By.cssSelector("input[data-qa='login-email']");
	public static By input_Password = By.cssSelector("input[placeholder='Password']");
	public static By link_Signin = By.cssSelector("a[href='/login']");
	public static By btn_Login = By.cssSelector("button[data-qa='login-button']");
	public static By txt_Login = By.cssSelector("div[class='login-form'] h2");
 
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
    public String errorMessage() {
        String actualErrorMessage = $(By.xpath("//*[@id='app']/div[1]/div/div[1]/div/div[2]/div[2]/div/div[1]/div[1]/p")).getText();
        return actualErrorMessage;
    }
 
}