package pages;

import org.openqa.selenium.By;
import org.junit.Assert;
import net.serenitybdd.core.pages.PageObject;
 
public class DashboardPage extends PageObject{
 
    public void loginVerify() {           
        String dashboardTitle = $(By.xpath("//*[@id='app']/div[1]/div[1]/header/div[1]/div[1]/span/h6")).getText();                   
        Assert.assertTrue(dashboardTitle.contains("Dashboard"));
    }    
} 