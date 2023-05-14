package pages;

import org.openqa.selenium.By;

import commonActions.CommonActions;
import net.thucydides.core.annotations.Step;

public class ShopCartPage extends CommonActions {
	
	public static By btn_CartPage = By.xpath("//*[contains(text(),'Proceed To Checkout')]");
	public static By txt_CartDesc = By.xpath("//*[@class='cart_description']//a");
	public static By txt_CartPrice = By.xpath("//*[@class='cart_price']//p");
	
	 @Step("Click Cart Link")
	    public void navigateToCartPage() {
		 waitForVisibilityOfElement(btn_CartPage);
	    }
	 
	 @Step("Verify Cart Description")
	 	public void verifyCartDescription(String value) {
		 verifyTextContains(txt_CartDesc, value);
	 }
	 
	 @Step("Verify Cart Price")
	 	public void verifyCartPrice(String value) {
		 verifyTextContains(txt_CartPrice, value);
	 }
	 
	 @Step("Click Checkout button")
	 	public void clickCheckoutButton() {
		 click(btn_CartPage);
	 }

}
