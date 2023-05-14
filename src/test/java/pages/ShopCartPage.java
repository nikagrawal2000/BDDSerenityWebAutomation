package pages;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import commonActions.CommonActions;
import net.thucydides.core.annotations.Step;

public class ShopCartPage extends CommonActions {

	public static By btn_CartPage = By.xpath("//*[contains(text(),'Proceed To Checkout')]");
	public static By txt_CartDesc = By.xpath("//*[@class='cart_description']//a");
	public static By txt_CartPrice = By.xpath("//*[@class='cart_price']//p");
	public static WebElement itemDetails;
	public static WebElement itemPrice;

	@Step("Click Cart Link")
	public void navigateToCartPage() {
		waitForVisibilityOfElement(btn_CartPage);
	}

	@Step("Verify Cart Description")
	public void verifyCartDescription(String value) {
		List<WebElement> ele = findElements(txt_CartDesc);
		for (WebElement a : ele) {
			if (a.getText().toLowerCase().trim().contains(value.toLowerCase().trim())) {
				itemDetails = a;
				assertTrue("found matching cart description", true);
				break;
			}
		}
		if (itemDetails == null) {
			assertFalse("matching cart description not found", false);
		}
	}

	@Step("Verify Cart Price")
	public void verifyCartPrice(String value) {
		List<WebElement> ele = findElements(txt_CartPrice);
		for (WebElement a : ele) {
			if (a.getText().toLowerCase().trim().contains(value.toLowerCase().trim())) {
				itemPrice = a;
				assertTrue("found matching price", true);
				break;
			}
		}
		if (itemPrice == null) {
			assertFalse("matching cart price not found", false);
		}
	}

	@Step("Click Checkout button")
	public void clickCheckoutButton() {
		click(btn_CartPage);
	}

}
