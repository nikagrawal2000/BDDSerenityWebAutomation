package pages;

import org.openqa.selenium.By;

import commonActions.CommonActions;
import org.junit.Assert;
 
public class HomePage extends CommonActions{
	public static By link_Home = By.xpath("//a[normalize-space()='Home']");
 
    public void homePageVerify() {           
       verifyVisibilityOfElement(link_Home);
    }    
} 