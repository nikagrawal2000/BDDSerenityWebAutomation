package pages;

import org.openqa.selenium.By;

import commonActions.CommonActions;
import net.thucydides.core.annotations.Step;
 
public class LoginPage extends CommonActions {
	
	public static By input_Username = By.name("username");
 
    @Step("Enter Username")
    public void inputUserName(String Username) {
    	sendText(input_Username, Username);
    }
 
    @Step("Enter Password")
    public void inputPassword(String passWord) {
        $(By.name("password")).sendKeys((passWord));
    }
 
    @Step("Click Submit Button")
    public void clickLogin() {
        $(By.xpath("//*[@id='app']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
    }
 
    @Step("Error Message on unsuccessful login")
    public String errorMessage() {
        String actualErrorMessage = $(By.xpath("//*[@id='app']/div[1]/div/div[1]/div/div[2]/div[2]/div/div[1]/div[1]/p")).getText();
        return actualErrorMessage;
    }
 
}