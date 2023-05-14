package stepDefinitions;

import io.cucumber.java.en.And;
import net.thucydides.core.annotations.Steps;
import pages.ToutPage;

public class ToutPageDefinitions {
	@Steps
	ToutPage toutPage;
	
	@And("User is on Checkout page")
	public void verifyOnCheckoutPage() {
		toutPage.verifyCheckoutPage();
	}
}
