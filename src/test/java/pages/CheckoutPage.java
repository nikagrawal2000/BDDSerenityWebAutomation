package pages;

import org.openqa.selenium.By;

import commonActions.CommonActions;
import net.thucydides.core.annotations.Step;

public class CheckoutPage extends CommonActions {
	public static By txt_Checkout = By.className("active");

	 @Step("Verify on Checkout Page")
	 public void verifyCheckoutPage() {
	     verifyText(txt_Checkout, "Checkout");
	    }
}
