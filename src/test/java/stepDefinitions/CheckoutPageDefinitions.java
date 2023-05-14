package stepDefinitions;

import io.cucumber.java.en.And;
import net.thucydides.core.annotations.Steps;
import pages.CheckoutPage;

public class CheckoutPageDefinitions {
	@Steps
	CheckoutPage checkoutPage;
	
	@And("User is on Checkout page")
	public void verifyOnCheckoutPage() {
		checkoutPage.verifyCheckoutPage();
	}
}
